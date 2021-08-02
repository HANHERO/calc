package model;

import java.math.BigDecimal;

public class DemoCalculator {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        BigDecimal two = new BigDecimal("2");
        BigDecimal three = new BigDecimal("3");
        BigDecimal four = new BigDecimal("4");
        BigDecimal five = new BigDecimal("5");
        BigDecimal result;
        try {
            result = calc.calculate(five, three, BinaryOperations.PLUS);
            result = calc.calculate(result, two, BinaryOperations.DIVIDE);
            result = calc.calculate(result, UnaryOperations.SQRT);
            result = calc.calculate(result, four, BinaryOperations.MINUS);
            System.out.println(result);

        } catch (NegativeSqrtException | DivisionByZeroException | UnexpectedException e) {
            System.out.println(e.getMessage());
        }

    }
}
