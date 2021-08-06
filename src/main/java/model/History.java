package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<UnaryOperations> firstHistory = new ArrayList<>();
    private final List<UnaryOperations> secondHistory = new ArrayList<>();
    private BinaryOperations operation = null;
    private BigDecimal first = BigDecimal.ZERO;
    private BigDecimal second = BigDecimal.ZERO;
    private boolean isEqual = false;

    public List<UnaryOperations> getFirstHistory() {
        return firstHistory;
    }

    public List<UnaryOperations> getSecondHistory() {
        return secondHistory;
    }

    public BigDecimal getFirst() {
        return first;
    }

    public BigDecimal getSecond() {
        return second;
    }

    public void clearFirstHistory() {
        firstHistory.clear();
    }

    public void clearSecondHistory() {
        secondHistory.clear();
    }

    public void cleanAll() {
        isEqual = false;
        firstHistory.clear();
        secondHistory.clear();
        first = BigDecimal.ZERO;
        second = BigDecimal.ZERO;
        operation = null;
    }

    public void setFirst(BigDecimal first) {
        this.first = first;
    }

    public void setSecond(BigDecimal second) {
        this.second = second;
    }

    public boolean isEqual() {
        return isEqual;
    }

    public void setEqual(boolean equal) {
        isEqual = equal;
    }

    public boolean isOperator() {
        return operation != null;
    }

    public BinaryOperations getOperation() {
        return operation;
    }

    public void setOperation(BinaryOperations operation) {
        this.operation = operation;
    }

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
