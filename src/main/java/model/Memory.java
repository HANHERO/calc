package model;

import java.math.BigDecimal;
import java.math.BigInteger;

import static model.BinaryOperations.PLUS;

/**
 * The {@code MemoryModel} class
 * consist main memory operations such as
 * <ul>
 *  <li>Store (MS)</li>
 *  <li>Clear (MC)</li>
 *  <li>Add (M+)</li>
 *  <li>Subtract (M-)</li>
 *  <li>Recall (MR)</li>
 * </ul>
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class Memory {
    /**Storage for memory.*/
    private BigDecimal memoryValue = new BigDecimal(BigInteger.ZERO);
    /**Object calculator used for some methods.*/
    private final Calculator calculator = new Calculator();

    /**
     * Memory minus operation. (for M- button)
     *
     * @param value the value
     * @throws DivisionByZeroException the division by zero exception
     */
    public void memoryMinus(BigDecimal value) throws DivisionByZeroException {
        memoryValue = calculator.calculate(memoryValue, value, BinaryOperations.MINUS);
    }

    /**
     * Memory operation. (for M+ button)
     *
     * @param value the value
     * @throws DivisionByZeroException the division by zero exception
     */
    public void memoryPlus(BigDecimal value) throws DivisionByZeroException {
        memoryValue = calculator.calculate(memoryValue, value, PLUS);
    }

    /**
     * Gets memory value. (for MR button)
     *
     * @return the memory value
     */
    public BigDecimal getMemoryValue() {
        return memoryValue;
    }

    /**
     * Sets memory value. (for MS button)
     *
     * @param value the current value
     */
    public void setMemoryValue(BigDecimal value) {
        memoryValue = value;
    }

    /**
     * Memory clear operation. (for MC button)
     */
    public void clearMemoryValue() {
        memoryValue = BigDecimal.ZERO;
    }
}
