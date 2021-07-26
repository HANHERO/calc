package model;

import java.math.BigDecimal;
import java.math.MathContext;

import static model.BinaryOperations.*;
import static model.UnaryOperations.*;

public class Calculator {
    private BigDecimal memoryValue = BigDecimal.ZERO;
    private BigDecimal percentCoef;
    private BigDecimal result;

    public BigDecimal getPercentCoef() {
        return percentCoef;
    }

    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) throws DivisionByZeroException, UnexpectedException {
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

    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) throws NegativeSqrtException, DivisionByZeroException, UnexpectedException {
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
            throw new NegativeSqrtException();
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
        } else {
            throw new DivisionByZeroException();
        }
    }

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

    public void memoryMinus(BigDecimal buffer) throws DivisionByZeroException, UnexpectedException {
        memoryValue = calculate(memoryValue, buffer, BinaryOperations.MINUS);
    }

    public void memoryPlus(BigDecimal buffer) throws DivisionByZeroException, UnexpectedException {
        memoryValue = calculate(memoryValue, buffer, PLUS);
    }

    public BigDecimal getMemoryValue() {
        return memoryValue;
    }

    public void setMemoryValue(BigDecimal currentValue) {
        memoryValue = currentValue;
    }

    public void clearMemoryValue() {
        memoryValue = BigDecimal.ZERO;
    }
}