package model;

import java.math.BigDecimal;
import java.math.BigInteger;
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
     * <br> 2 MS 3 M+ 10 M- MR
     *
     */
    public static void main(String[] args) {
        Memory mem = new Memory();

        BigDecimal two = new BigDecimal(BigInteger.TWO);
        BigDecimal three = new BigDecimal("3");
        BigDecimal ten = new BigDecimal(BigInteger.TEN);

        try {
            mem.setMemoryValue(two);
            mem.memoryPlus(three);
            mem.memoryMinus(ten);
            System.out.println(mem.getMemoryValue());
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }

    }
}
