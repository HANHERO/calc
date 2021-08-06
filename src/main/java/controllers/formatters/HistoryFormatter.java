package controllers.formatters;

import model.BinaryOperations;
import model.History;
import model.UnaryOperations;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

import static controllers.formatters.OutputFormatter.format;

public class HistoryFormatter {
    private static final String DEFAULT_VALUE = "";
    private static final String EQUALS = " = ";
    private static final String OPEN_PARENTHESIS = "( ";
    private static final String CLOSE_PARENTHESIS = " )";
    private static final EnumMap<BinaryOperations, String> binaryMap = new EnumMap<>(BinaryOperations.class);
    private static final EnumMap<UnaryOperations, String> unaryMap = new EnumMap<>(UnaryOperations.class);

    static {
        unaryMap.put(UnaryOperations.ONE_DIVIDED_X, "1/");
        unaryMap.put(UnaryOperations.NEGATIVE, "negate");
        unaryMap.put(UnaryOperations.SQUARE, "sqr");
        unaryMap.put(UnaryOperations.SQRT, "√");
        unaryMap.put(UnaryOperations.PERCENT, "");

        binaryMap.put(BinaryOperations.PLUS, " + ");
        binaryMap.put(BinaryOperations.MINUS, " - ");
        binaryMap.put(BinaryOperations.DIVIDE, " ÷ ");
        binaryMap.put(BinaryOperations.MULTIPLY, " × ");
    }

    private HistoryFormatter() {
    }

    public static String formatHistory(History history) {
        String formatHistory = DEFAULT_VALUE;
        if (history.isEqual()) {
            formatHistory = formatHistoryWithEqual(history, formatHistory);
        } else {
            if (history.isOperator()) {
                formatHistory = formatHistory + formatHistoryNumber(history.getFirst(), history.getFirstHistory());
                formatHistory = formatHistory + binaryMap.get(history.getOperation());
                if (!history.getSecondHistory().isEmpty()) {
                    formatHistory = formatHistory + formatHistoryNumber(history.getSecond(), history.getSecondHistory());
                }
            } else {
                if (!history.getFirstHistory().isEmpty()) {
                    formatHistory = formatHistoryNumber(history.getFirst(), history.getFirstHistory());
                }
            }
        }
        return formatHistory;
    }

    private static String formatHistoryWithEqual(History history, String formatHistory) {
        StringBuilder formatHistoryBuilder = new StringBuilder(formatHistory);
        if (history.isOperator()) {
            formatHistoryBuilder
                    .append(formatHistoryNumber(history.getFirst(), history.getFirstHistory()))
                    .append(binaryMap.get(history.getOperation()))
                    .append(formatHistoryNumber(history.getSecond(), history.getSecondHistory()))
                    .append(formatHistory)
                    .append(EQUALS);
        } else {
            formatHistoryBuilder
                    .append(formatHistoryNumber(history.getFirst(), history.getFirstHistory()))
                    .append(EQUALS);
        }
        return formatHistoryBuilder.toString();
    }

    private static String formatHistoryNumber(BigDecimal number, List<UnaryOperations> history) {
        String formatHistoryNumber;
        if (history.isEmpty()) {
            formatHistoryNumber = format(number, false);
        } else {
            formatHistoryNumber = formatHistory(number, history);
        }
        return formatHistoryNumber;
    }

    private static String formatHistory(BigDecimal number, List<UnaryOperations> history) {
        StringBuilder formatNumber = new StringBuilder(format(number, false));
        for (UnaryOperations u : history) {
            if (u == UnaryOperations.PERCENT) {
                formatNumber.insert(0, unaryMap.get(u));
            } else {
                formatNumber.append(CLOSE_PARENTHESIS).insert(0, OPEN_PARENTHESIS).insert(0, unaryMap.get(u));
            }
        }
        return formatNumber.toString();
    }
}
