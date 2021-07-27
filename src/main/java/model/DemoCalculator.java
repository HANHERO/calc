package model;

import java.math.BigDecimal;

public class DemoCalculator {

    private static final String DIVIDE_BY_ZERO_EXCEPTION_MESSAGE = "Деление на ноль невозможно";
    private static final String INCORRECT_INPUT_EXCEPTION_MESSAGE = "Неверный ввод";
    private static final String OVERFLOW_EXCEPTION_MESSAGE = "Переполнение";
    private static final String UNDEFINED_RESULT_EXCEPTION_MESSAGE = "Результат не определен";

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
        } catch (NegativeSqrtException e) {
            System.out.println();
        } catch (UnexpectedException e) {
            System.out.println();
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }

    }
}
