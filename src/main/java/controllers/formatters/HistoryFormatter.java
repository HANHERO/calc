package controllers.formatters;

import model.BinaryOperations;
import model.History;
import model.UnaryOperations;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

import static controllers.formatters.OutputFormatter.format;

/**
 * The {@code HistoryFormatter} class allows transform
 * a set of inputs to a custom history representation pattern.
 * <br> Consist set of method for work with history.
 * <p/>
 * for example:
 * <br> √( sqr( -42 ) ) × 1/( sqr( 12 ) ) =
 * <br> There are
 * <br> The first number = 42,
 * <br> The second number = 12,
 * <br> The binary operation = MULTIPLY,
 * <br> The list of unary operations of the first number = {SQRT, SQR, NEGATE},
 * <br> The list of unary operations of the second number = {INVERSE, SQR}.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class HistoryFormatter {
    /**
     * Default history value
     */
    private static final String DEFAULT_VALUE = "";
    /**
     * History representation of binary operations
     */
    private final EnumMap<BinaryOperations, String> binaryMap = new EnumMap<>(BinaryOperations.class);
    /**
     * History representation of unary operations
     */
    private final EnumMap<UnaryOperations, String> unaryMap = new EnumMap<>(UnaryOperations.class);
    /**Open parenthesis*/
    private static final String openParenthesis = "( ";
    /**Close parenthesis*/
    private static final String closeParenthesis = " )";
    /**Equals*/
    private static final String equals = " = ";

    public HistoryFormatter(){
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

    /**
     * Return string representation of current history.
     * History is contained in given {@link History} object
     *
     * @param history given statement of history
     * @return string representation of history
     */
    public String formatHistory(History history) {
        String formatHistory;
        if (history.isEqual()) {
            formatHistory = formatHistoryWithEqual(history);
        } else {
            if (history.isOperator()) {
                formatHistory = DEFAULT_VALUE + formatHistoryNumber(history.getFirst(), history.getFirstHistory());
                formatHistory = formatHistory + binaryMap.get(history.getOperation());
                if (!history.getSecondHistory().isEmpty()) {
                    formatHistory = formatHistory + formatHistoryNumber(history.getSecond(), history.getSecondHistory());
                }
            } else {
                if (!history.getFirstHistory().isEmpty()) {
                    formatHistory = formatHistoryNumber(history.getFirst(), history.getFirstHistory());
                } else {
                    formatHistory = DEFAULT_VALUE;
                }
            }
        }
        return formatHistory;
    }

    private String formatHistoryWithEqual(History history) {
        StringBuilder formatHistoryBuilder = new StringBuilder(DEFAULT_VALUE);
        formatHistoryBuilder.append(formatHistoryNumber(history.getFirst(), history.getFirstHistory()));
        if (history.isOperator()) {
            formatHistoryBuilder
                    .append(binaryMap.get(history.getOperation()))
                    .append(formatHistoryNumber(history.getSecond(), history.getSecondHistory()))
                    .append(DEFAULT_VALUE);
        }
        formatHistoryBuilder.append(equals);
        return formatHistoryBuilder.toString();
    }

    private String formatHistoryNumber(BigDecimal number, List<UnaryOperations> history) {
        String formatHistoryNumber;
        if (history.isEmpty()) {
            formatHistoryNumber = format(number, false);
        } else {
            formatHistoryNumber = formatHistory(number, history);
        }
        return formatHistoryNumber;
    }

    private String formatHistory(BigDecimal number, List<UnaryOperations> history) {
        StringBuilder formatNumber = new StringBuilder(format(number, false));
        for (UnaryOperations u : history) {
            if (u.equals(UnaryOperations.PERCENT)) {
                formatNumber.insert(0, unaryMap.get(u));
            } else {
                formatNumber.append(closeParenthesis).insert(0, openParenthesis).insert(0, unaryMap.get(u));
            }
        }
        return formatNumber.toString();
    }
}
