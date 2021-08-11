package model;

import java.math.BigDecimal;

/**
 * The {@code DemoCalculator} class
 * demo of directly using model.
 * @see Calculator
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class DemoCalculator {

    /**
     * Complex example of using model.
     * <br> √( ( 5 + 3 ) ÷ 2 ) - 4 =
     *
     */
    public static void main(String[] args) {
        String input = "√( ( 5 + 3 ) ÷ 2 ) - 4 = ";
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
            System.out.println(input + result);

        } catch (NegativeSqrtException | DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }

    }
}
