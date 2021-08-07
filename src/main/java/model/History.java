package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code History} class
 * represents information about two numbers
 * and their unary operations.
 * <br/>
 * Includes methods for editing the state of fields.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class History {

    /** History of unary operations of the first number */
    private final List<UnaryOperations> firstHistory = new ArrayList<>();

    /** History of unary operations of the second number */
    private final List<UnaryOperations> secondHistory = new ArrayList<>();

    /** What binary operation is used.*/
    private BinaryOperations operation = null;

    /** The value of the first number before the first unary operation */
    private BigDecimal first = BigDecimal.ZERO;

    /** The value of the second number before the first unary operation */
    private BigDecimal second = BigDecimal.ZERO;

    /** Whether an equals operation was performed.*/
    private boolean isEqual = false;

    /**
     * Gets first history.
     *
     * @return the first history
     */
    public List<UnaryOperations> getFirstHistory() {
        return firstHistory;
    }

    /**
     * Gets second history.
     *
     * @return the second history
     */
    public List<UnaryOperations> getSecondHistory() {
        return secondHistory;
    }

    /**
     * Gets first.
     *
     * @return the first
     */
    public BigDecimal getFirst() {
        return first;
    }

    /**
     * Gets second.
     *
     * @return the second
     */
    public BigDecimal getSecond() {
        return second;
    }

    /**
     * Clear first history.
     */
    public void clearFirstHistory() {
        firstHistory.clear();
    }

    /**
     * Clear second history.
     */
    public void clearSecondHistory() {
        secondHistory.clear();
    }

    /**
     * Clean all history.
     */
    public void cleanAll() {
        isEqual = false;
        firstHistory.clear();
        secondHistory.clear();
        first = BigDecimal.ZERO;
        second = BigDecimal.ZERO;
        operation = null;
    }

    /**
     * Sets first.
     *
     * @param first the first
     */
    public void setFirst(BigDecimal first) {
        this.first = first;
    }

    /**
     * Sets second.
     *
     * @param second the second
     */
    public void setSecond(BigDecimal second) {
        this.second = second;
    }

    /**
     * Is equal boolean.
     *
     * @return the boolean
     */
    public boolean isEqual() {
        return isEqual;
    }

    /**
     * Sets equal.
     *
     * @param equal the equal
     */
    public void setEqual(boolean equal) {
        isEqual = equal;
    }

    /**
     * Is operator boolean.
     *
     * @return the boolean
     */
    public boolean isOperator() {
        return operation != null;
    }

    /**
     * Gets operation.
     *
     * @return the operation
     */
    public BinaryOperations getOperation() {
        return operation;
    }

    /**
     * Sets operation.
     *
     * @param operation the operation
     */
    public void setOperation(BinaryOperations operation) {
        this.operation = operation;
    }

    /**
     * Append to current sequence new operation
     *
     * @param isOperation flag indicating the history to perform the operation
     * @param operation   operation to be added
     * @param bigDecimal  number on which the operation is performed
     */
    public void addHistory(boolean isOperation, UnaryOperations operation, BigDecimal bigDecimal) {
        if (!(operation.equals(UnaryOperations.NEGATIVE) && (isOperation && secondHistory.isEmpty() || !isOperation && firstHistory.isEmpty()))) {
            if (isOperation) {
                if (secondHistory.isEmpty()) {
                    second = bigDecimal;
                }
                secondHistory.add(operation);
            } else {
                if (firstHistory.isEmpty()) {
                    first = bigDecimal;
                }
                firstHistory.add(operation);
            }
        }
    }
}
