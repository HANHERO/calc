package model;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainModel {
    private BigDecimal memoryValue = BigDecimal.ZERO;
    private BigDecimal percentCoef;

    public BigDecimal getPercentCoef(){
        return percentCoef;
    }

    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) {
        return switch (operation) {
            case PLUS -> plus(firstValue, secondValue);
            case MINUS -> minus(firstValue, secondValue);
            case DIVIDE -> divide(firstValue, secondValue);
            case MULTIPLY -> multiply(firstValue, secondValue);
        };
    }

    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) {
        return switch (operation) {
            case SQUARE -> square(firstValue);
            case SQRT -> sqrt(firstValue);
            case ONE_DIVIDED_X -> oneDividedX(firstValue);
            case NEGATIVE -> negative(firstValue);
        };
    }

    private BigDecimal negative(BigDecimal firstValue) {
        return firstValue.negate();
    }

    private BigDecimal oneDividedX(BigDecimal firstValue) {
        return divide(BigDecimal.ONE, firstValue);
    }

    private BigDecimal sqrt(BigDecimal firstValue) {
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

    private BigDecimal divide(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.divide(secondValue, MathContext.DECIMAL128);
    }

    public BigDecimal percent(BigDecimal firstValue, BigDecimal percentValue, BinaryOperations lastOperation) {
        if (lastOperation == BinaryOperations.PLUS || lastOperation == BinaryOperations.MINUS) {
            percentCoef = divide(percentValue, new BigDecimal("100")).multiply(firstValue).round(MathContext.DECIMAL128);
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        } else if (lastOperation == BinaryOperations.MULTIPLY || lastOperation == BinaryOperations.DIVIDE) {
            percentCoef = divide(percentValue, new BigDecimal("100"));
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        }
        return firstValue;
    }

    public void memoryMinus(BigDecimal buffer) {
        memoryValue = minus(memoryValue, buffer);
    }

    public void memoryPlus(BigDecimal buffer) {
        memoryValue = plus(memoryValue, buffer);
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