package model;

import java.math.BigDecimal;
import java.math.MathContext;

import static model.BinaryOperations.*;
import static model.UnaryOperations.*;

/**
 * The {@code Calculator} class
 * Consist main calculator operations such as
 * <ul>
 *  <li>Add (+)</li>
 *  <li>Subtract (-)</li>
 *  <li>Multiply (×)</li>
 *  <li>Divide (÷)</li>
 *  <li>Square (x²)</li>
 *  <li>Square root (√x)</li>
 *  <li>One divided (1/x)</li>
 *  <li>Negate (+/-)</li>
 *  <li>Percent (%)</li>
 * </ul>
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class Calculator {
    /** An exception message if the user divides zero by zero. */
    private static final String RESULT_UNDEFINED = "Результат неопределен";
    /** An exception message if the user divides any number by zero. */
    private static final String DIVISION_BY_ZERO = "Деление на ноль невозможноljknkj";
    /** An exception message if the user takes the root of a negative number. */
    private static final String NEGATIVE_SQRT = "Неверный ввод";
    /** The coefficient of the operation with percents.
     * <br>for example:
     * <br>coefficient in (150 + 17%) equals 25.5
     * <br>coefficient in (150 ÷ 17%) equals 0.17
     * */
    private BigDecimal percentCoef;
    /**One hundred value used for percent.*/
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
    /**
     * Gets percent coef.
     *
     * @return the percent coef
     */
    public BigDecimal getPercentCoef() {
        return percentCoef;
    }
    /**
     * Calculation of a binary operation.
     *
     * @param firstValue  the first value
     * @param secondValue the second value
     * @param operation   the binary operation
     * @return the result of binary operation.
     * @throws DivisionByZeroException the division by zero exception
     */
    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) throws DivisionByZeroException {
        BigDecimal result;
        if (operation.equals(PLUS)) {
            result = plus(firstValue, secondValue);
        } else if (operation.equals(MINUS)) {
            result = minus(firstValue, secondValue);
        } else if (operation.equals(DIVIDE)) {
            result = divide(firstValue, secondValue);
        } else if (operation.equals(MULTIPLY)) {
            result = multiply(firstValue, secondValue);
        } else {
            throw new IllegalArgumentException("Enter binary operation");
        }
        return result;
    }

    /**
     * Calculation of a unary operation.
     *
     * @param firstValue the first value
     * @param operation  the operation
     * @return the result of unary operation.
     * @throws NegativeSqrtException   the negative sqrt exception
     * @throws DivisionByZeroException the division by zero exception
     */
    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) throws NegativeSqrtException, DivisionByZeroException {
        BigDecimal result;
        if (operation.equals(SQUARE)){
            result = square(firstValue);
        }else if(operation.equals(SQRT)){
            result = sqrt(firstValue);
        }else if(operation.equals(ONE_DIVIDED_X)){
            result = oneDividedX(firstValue);
        }else if(operation.equals(NEGATIVE)){
            result = negative(firstValue);
        }else {
            throw new IllegalArgumentException("Unknown operation " + operation);
        }
        return result;
    }

    private BigDecimal negative(BigDecimal firstValue) {
        return firstValue.negate(MathContext.DECIMAL128);
    }

    private BigDecimal oneDividedX(BigDecimal firstValue) throws DivisionByZeroException {
        return divide(BigDecimal.ONE, firstValue);
    }

    private BigDecimal sqrt(BigDecimal firstValue) throws NegativeSqrtException {
        if (firstValue.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeSqrtException(NEGATIVE_SQRT);
        }
        return firstValue.sqrt(MathContext.DECIMAL128);
    }

    private BigDecimal square(BigDecimal firstValue) {
        return firstValue.pow(2, MathContext.DECIMAL128);
    }

    private BigDecimal plus(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.add(secondValue, MathContext.DECIMAL128);
    }

    private BigDecimal minus(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.subtract(secondValue, MathContext.DECIMAL128);
    }

    private BigDecimal multiply(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.multiply(secondValue, MathContext.DECIMAL128);
    }

    private BigDecimal divide(BigDecimal firstValue, BigDecimal secondValue) throws DivisionByZeroException {
        if (!secondValue.equals(BigDecimal.ZERO)) {
            return firstValue.divide(secondValue, MathContext.DECIMAL128);
        } else if (firstValue.equals(BigDecimal.ZERO)){
            throw new DivisionByZeroException(RESULT_UNDEFINED);
        } else {
            throw new DivisionByZeroException(DIVISION_BY_ZERO);
        }
    }

    /**
     * Calculate of operation with percent.
     *
     * @param firstValue    the first value
     * @param percentValue  the percent value
     * @param operation the last operation
     * @return the result of operation with percent.
     * @throws DivisionByZeroException the division by zero exception
     */
    public BigDecimal percent(BigDecimal firstValue, BigDecimal percentValue, BinaryOperations operation) throws DivisionByZeroException {
        if (operation.equals(PLUS) || operation.equals(MINUS)) {
            percentCoef = divide(percentValue, ONE_HUNDRED).multiply(firstValue);
        } else if (operation.equals(MULTIPLY) || operation.equals(DIVIDE)) {
            percentCoef = divide(percentValue, ONE_HUNDRED);
        } else {
            throw new IllegalArgumentException("Unknown operation " + operation);
        }
        return calculate(firstValue, percentCoef, operation);
    }
}