package model;

import java.math.BigDecimal;
import java.math.MathContext;

import static model.BinaryOperations.*;
import static model.UnaryOperations.*;

/**
 * The type Calculator.
 * @author  Pilipenko Mihail
 * @version 1.0
 */
public class Calculator {
    private static final String RESULT_UNDEFINED = "Результат неопределен";
    private static final String DIVISION_BY_ZERO = "Деление на ноль невозможно";
    private static final String NEGATIVE_SQRT = "Неверный ввод";
    private BigDecimal memoryValue = BigDecimal.ZERO;
    private BigDecimal percentCoef;

    /**
     * Gets percent coef.
     *
     * @return the percent coef
     */
    public BigDecimal getPercentCoef() {
        return percentCoef;
    }

    /**
     * Calculate big decimal.
     *
     * @param firstValue  the first value
     * @param secondValue the second value
     * @param operation   the operation
     * @return the big decimal
     * @throws DivisionByZeroException the division by zero exception
     * @throws UnexpectedException     the unexpected exception
     */
    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) throws DivisionByZeroException, UnexpectedException {
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
            throw new UnexpectedException("Incorrect binary operation");
        }
        return result;

    }

    /**
     * Calculate big decimal.
     *
     * @param firstValue the first value
     * @param operation  the operation
     * @return the big decimal
     * @throws NegativeSqrtException   the negative sqrt exception
     * @throws DivisionByZeroException the division by zero exception
     * @throws UnexpectedException     the unexpected exception
     */
    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) throws NegativeSqrtException, DivisionByZeroException, UnexpectedException {
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
            throw new UnexpectedException("Incorrect unary operation");
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
     * Percent big decimal.
     *
     * @param firstValue    the first value
     * @param percentValue  the percent value
     * @param lastOperation the last operation
     * @return the big decimal
     * @throws DivisionByZeroException the division by zero exception
     * @throws UnexpectedException     the unexpected exception
     */
    public BigDecimal percent(BigDecimal firstValue, BigDecimal percentValue, BinaryOperations lastOperation) throws DivisionByZeroException, UnexpectedException {
        if (lastOperation == PLUS || lastOperation == BinaryOperations.MINUS) {
            percentCoef = divide(percentValue, new BigDecimal("100")).multiply(firstValue);
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        } else if (lastOperation == BinaryOperations.MULTIPLY || lastOperation == BinaryOperations.DIVIDE) {
            percentCoef = divide(percentValue, new BigDecimal("100"));
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        }
        return firstValue;
    }

    /**
     * Memory minus.
     *
     * @param buffer the buffer
     * @throws DivisionByZeroException the division by zero exception
     * @throws UnexpectedException     the unexpected exception
     */
    public void memoryMinus(BigDecimal buffer) throws DivisionByZeroException, UnexpectedException {
        memoryValue = calculate(memoryValue, buffer, BinaryOperations.MINUS);
    }

    /**
     * Memory plus.
     *
     * @param buffer the buffer
     * @throws DivisionByZeroException the division by zero exception
     * @throws UnexpectedException     the unexpected exception
     */
    public void memoryPlus(BigDecimal buffer) throws DivisionByZeroException, UnexpectedException {
        memoryValue = calculate(memoryValue, buffer, PLUS);
    }

    /**
     * Gets memory value.
     *
     * @return the memory value
     */
    public BigDecimal getMemoryValue() {
        return memoryValue;
    }

    /**
     * Sets memory value.
     *
     * @param currentValue the current value
     */
    public void setMemoryValue(BigDecimal currentValue) {
        memoryValue = currentValue;
    }

    /**
     * Clear memory value.
     */
    public void clearMemoryValue() {
        memoryValue = BigDecimal.ZERO;
    }
}