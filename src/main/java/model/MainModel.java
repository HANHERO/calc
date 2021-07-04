package model;

import controllers.OverflowException;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainModel {
    private BigDecimal memoryValue = BigDecimal.ZERO;
    private BigDecimal percentCoef;
    private BigDecimal result;

    public BigDecimal getPercentCoef() {
        return percentCoef;
    }

    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) throws DivisionByZeroException {
        result = switch (operation) {
            case PLUS -> plus(firstValue, secondValue);
            case MINUS -> minus(firstValue, secondValue);
            case DIVIDE -> divide(firstValue, secondValue);
            case MULTIPLY -> multiply(firstValue, secondValue);
        };
        return result;
    }

    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) throws DivisionByZeroException, NegativeSqrtException {
        result = switch (operation) {
            case SQUARE -> square(firstValue);
            case SQRT -> sqrt(firstValue);
            case ONE_DIVIDED_X -> oneDividedX(firstValue);
            case NEGATIVE -> negative(firstValue);
        };
        return result;
    }

    private BigDecimal negative(BigDecimal firstValue) {
        return firstValue.negate();
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
        return firstValue.pow(2);
    }

    private BigDecimal plus(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.add(secondValue);
    }

    private BigDecimal minus(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.subtract(secondValue);
    }

    private BigDecimal multiply(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.multiply(secondValue);
    }

    private BigDecimal divide(BigDecimal firstValue, BigDecimal secondValue) throws DivisionByZeroException {
        BigDecimal result;
        if (!secondValue.equals(BigDecimal.ZERO)){
            result = firstValue.divide(secondValue, MathContext.DECIMAL128);
        } else {
            throw new DivisionByZeroException();
        }
        return result;
    }

    public BigDecimal percent(BigDecimal firstValue, BigDecimal percentValue, BinaryOperations lastOperation) throws DivisionByZeroException {
        if (lastOperation == BinaryOperations.PLUS || lastOperation == BinaryOperations.MINUS) {
            percentCoef = divide(percentValue, new BigDecimal("100")).multiply(firstValue);
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        } else if (lastOperation == BinaryOperations.MULTIPLY || lastOperation == BinaryOperations.DIVIDE) {
            percentCoef = divide(percentValue, new BigDecimal("100"));
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        }
        return firstValue;
    }

    public void memoryMinus(BigDecimal buffer) throws DivisionByZeroException {
        memoryValue = calculate(memoryValue, buffer, BinaryOperations.MINUS);
    }

    public void memoryPlus(BigDecimal buffer) throws DivisionByZeroException {
        memoryValue = calculate(memoryValue, buffer, BinaryOperations.PLUS);
        System.out.println(memoryValue);
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