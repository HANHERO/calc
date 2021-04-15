package model;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainModel {
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
            default:
                result = multiply(firstValue, secondValue);
                break;
        }
        return result;
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

}
