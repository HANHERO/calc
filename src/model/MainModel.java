package model;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainModel {
    private BigDecimal memoryValue = BigDecimal.ZERO;

    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) {
        BigDecimal result;
        switch (operation) {
            case PLUS:
                result = plus(firstValue, secondValue);
                break;
            case MINUS:
                result = minus(firstValue, secondValue);
                break;
            case DIVIDE:
                result = divide(firstValue, secondValue);
                break;
            case MULTIPLY:
                result = multiply(firstValue, secondValue);
                break;
            default:
                throw new IllegalArgumentException("Operation does not exist " + operation);
        }
        return result;
    }
    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) {
        BigDecimal result;
        switch (operation) {
            case SQUARE:
                result = square(firstValue);
                break;
            case SQRT:
                result = sqrt(firstValue);
                break;
            case ONE_DIVIDED_X:
                result = oneDividedX(firstValue);
                break;
            case NEGATIVE:
                result = negative(firstValue);
                break;
            default:
                throw new IllegalArgumentException("Operation does not exist " + operation);
        }
        return result;
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
        BigDecimal percentCoef;
        if(lastOperation == BinaryOperations.PLUS || lastOperation == BinaryOperations.MINUS) {
            percentCoef = divide(new BigDecimal("100"), percentValue).multiply(firstValue).round(MathContext.DECIMAL128);
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        } else if (lastOperation == BinaryOperations.MULTIPLY || lastOperation == BinaryOperations.DIVIDE){
            firstValue = calculate(firstValue, divide(new BigDecimal("100"), percentValue), lastOperation);
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
    public void clearMemoryValue(){
        memoryValue = BigDecimal.ZERO;
    }
}