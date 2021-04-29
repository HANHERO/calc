package model;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainModel {
    public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, BinaryOperations operation) throws DivisionByZeroException {
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
            case PERCENT:
                result = percent(firstValue, secondValue);
                break;
            case MULTIPLY:
                result = multiply(firstValue, secondValue);
                break;
            default:
                throw new IllegalArgumentException("Operation does not exist " + operation);
        }
        return result;
    }
    public BigDecimal calculate(BigDecimal firstValue, UnaryOperations operation) throws DivisionByZeroException {
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
        return divide(firstValue, BigDecimal.ONE);
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

    private BigDecimal percent(BigDecimal firstValue, BigDecimal percentValue) throws DivisionByZeroException {
        if (firstValue == null || percentValue == null) {
            throw new NullPointerException("Parameter is null!");
        }

        firstValue = divide(new BigDecimal("100"), percentValue).multiply(firstValue).round(MathContext.DECIMAL128);
        return firstValue;
    }

}