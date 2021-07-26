package model;

import java.math.BigDecimal;

public class DemoCalculator {
    public static void main(String[] args) throws DivisionByZeroException, NegativeSqrtException, UnexpectedException {
        Calculator calc = new Calculator();
        BigDecimal result;
        result = calc.calculate(new BigDecimal("5"), new BigDecimal("3"), BinaryOperations.PLUS);
        result = calc.calculate(result, new BigDecimal("2"), BinaryOperations.DIVIDE);
        result = calc.calculate(result, UnaryOperations.SQRT);
        result = calc.calculate(result, new BigDecimal("4"), BinaryOperations.MINUS);
        System.out.println(result);
    }
}
