package model;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainModel {
    private BigDecimal memoryValue = BigDecimal.ZERO;
    private BigDecimal percentCoef;
    private BigDecimal result;

    public BigDecimal getPercentCoef() {
        return percentCoef;
    }

    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) throws OverflowException {
        result = switch (operation) {
            case PLUS -> plus(firstValue, secondValue);
            case MINUS -> minus(firstValue, secondValue);
            case DIVIDE -> divide(firstValue, secondValue);
            case MULTIPLY -> multiply(firstValue, secondValue);
        };
        if (result.compareTo(new BigDecimal("9.9999999999999994E9999")) > 0 ||
                result.compareTo(new BigDecimal("-9.9999999999999994E9999")) < 0 ||
                (result.compareTo(new BigDecimal("1E-9999")) < 0 && result.compareTo(BigDecimal.ZERO) > 0) ||
                (result.compareTo(new BigDecimal("-1E-9999")) > 0 && result.compareTo(BigDecimal.ZERO) < 0)) {
            throw new OverflowException();
        }
        return result;
    }

    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) throws OverflowException {
        result = switch (operation) {
            case SQUARE -> square(firstValue);
            case SQRT -> sqrt(firstValue);
            case ONE_DIVIDED_X -> oneDividedX(firstValue);
            case NEGATIVE -> negative(firstValue);
        };
        if (result.compareTo(new BigDecimal("9.9999999999999994E9999")) > 0 ||
                result.compareTo(new BigDecimal("-9.9999999999999994E9999")) < 0 ||
                (result.compareTo(new BigDecimal("1E-9999")) < 0 && result.compareTo(BigDecimal.ZERO) > 0) ||
                (result.compareTo(new BigDecimal("-1E-9999")) > 0 && result.compareTo(BigDecimal.ZERO) < 0)) {
            throw new OverflowException();
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
        BigDecimal sqrtResult;
        if (firstValue.compareTo(BigDecimal.ZERO) >= 0) {
            sqrtResult = firstValue.sqrt(MathContext.DECIMAL128);
        } else {
            sqrtResult = new BigDecimal("-1");
        }
        return sqrtResult;
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

    private BigDecimal divide(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.divide(secondValue, MathContext.DECIMAL128);
    }

    public BigDecimal percent(BigDecimal firstValue, BigDecimal percentValue, BinaryOperations lastOperation) throws OverflowException {
        if (lastOperation == BinaryOperations.PLUS || lastOperation == BinaryOperations.MINUS) {
            percentCoef = divide(percentValue, new BigDecimal("100")).multiply(firstValue);
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        } else if (lastOperation == BinaryOperations.MULTIPLY || lastOperation == BinaryOperations.DIVIDE) {
            percentCoef = divide(percentValue, new BigDecimal("100"));
            firstValue = calculate(firstValue, percentCoef, lastOperation);
        }
        return firstValue;
    }

    public void memoryMinus(BigDecimal buffer) throws OverflowException {
        memoryValue = calculate(memoryValue, buffer, BinaryOperations.MINUS);
        System.out.println(memoryValue);
    }

    public void memoryPlus(BigDecimal buffer) throws OverflowException {
        memoryValue = calculate(memoryValue, buffer, BinaryOperations.PLUS);
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