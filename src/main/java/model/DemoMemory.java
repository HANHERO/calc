package model;

import java.math.BigDecimal;
/**
 * The {@code DemoMemory} class
 * demo of directly using memory.
 * @see Memory
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class DemoMemory {
    /**
     * Memory sequence
     * <br> sqrt( 5 * 5 ) MS 3 + 15 M+ sqr( 2 - 24 ) M- MR
     *
     */
    public static void main(String[] args) {
        final String DIVISION_BY_ZERO = "Деление на ноль невозможно";
        final String NEGATIVE_SQRT = "Неверный ввод";
        Calculator calc = new Calculator();
        Memory mem = new Memory();
        BigDecimal result;
        BigDecimal two = new BigDecimal("2");
        BigDecimal five = new BigDecimal("5");
        BigDecimal three = new BigDecimal("3");
        BigDecimal fifteen = new BigDecimal("15");
        BigDecimal twentyFour = new BigDecimal("24");

        try {
            result = calc.calculate(five, five, BinaryOperations.MULTIPLY);
            result = calc.calculate(result, UnaryOperations.SQRT);
            mem.setMemoryValue(result);
            result = calc.calculate(three, fifteen, BinaryOperations.PLUS);
            mem.memoryPlus(result);
            result = calc.calculate(two, mem.getMemoryValue(), BinaryOperations.MINUS);
            result = calc.calculate(result, UnaryOperations.SQUARE);
            mem.memoryMinus(result);
            System.out.println(mem.getMemoryValue());
        } catch (DivisionByZeroException e) {
            System.out.println(DIVISION_BY_ZERO);
        } catch (NegativeSqrtException e){
            System.out.println(NEGATIVE_SQRT);
        }


    }
}
