package controllers.formatters;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Objects;

/**
 * The {@code OutputFormatter} class
 * allows transform a calculation result to a custom number representation pattern.
 *
 * for example:
 * <br>25454334545 transformed into 25 454 334 545
 * <br>6.277e57 transformed into 6,277e+57
 * <br>0.02345675432345676543 transformed into 0,0234567543234568
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class OutputFormatter {
    /**
     * Maximum of length of number in plain form
     */
    private static final int MAX_PLAIN_SCALE = 16;

    /**
     * Min output precision, that can be for view a number
     */
    private static final int MAX_OUTPUT_PRECISION = 19;

    /**
     * Symbol e
     */
    private static final String EXHIBITOR_SYMBOL = "e";

    /**
     * Precise for result number number, that uses HALF_UP rounding mode
     */
    private static final MathContext HALF_UP_16 = new MathContext(MAX_PLAIN_SCALE, RoundingMode.HALF_UP);

    /**
     * Number with exhibitor representation pattern
     */
    private static final Format EXPONENTIAL_FORMAT = new DecimalFormat("0.################E0");

    /**
     * MAX_OUTPUT_PRECISION + DOWN rounding mode
     */
    private static final MathContext MAX_OUTPUT_PRECISION_DOWN = new MathContext(MAX_OUTPUT_PRECISION, RoundingMode.DOWN);

    /**
     * MIN_OUTPUT_PRECISION + DOWN rounding mode
     */
    private static final MathContext MIN_OUTPUT_PRECISION_DOWN = new MathContext(MAX_PLAIN_SCALE, RoundingMode.DOWN);

    /**
     * Symbol for EXPONENTIAL_FORMAT in BigDecimal
     */
    private static final String BIG_DECIMAL_EXPONENTIAL_MARK = "E";

    /**
     * Separator, that BigDecimal use BigDecimal
     */
    private static final String BIG_DECIMAL_SEPARATOR = ".";

    /**
     * Separator, that Calculator use
     */
    private static final String VIEW_SEPARATOR = ",";

    /**
     * Symbol space
     */
    private static final char SPACE = ' ';

    /**
     * Number representation pattern
     */
    private static final String NUMBER_PATTERN = "###,###.###################";

    /**
     * Symbol minus
     */
    private static final String MINUS = "-";

    /**
     * Symbol plus
     */
    private static final String PLUS = "+";

    /**
     * BigDecimal view for Calculator
     */
    private static final DecimalFormat OUTPUT_FORMAT;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(SPACE);
        OUTPUT_FORMAT = new DecimalFormat(NUMBER_PATTERN, symbols);
    }

    /**
     * Return correct string representation of given number
     *
     * @param resultNumber given number
     * @param separator true if separator needed
     * @return string representation of number
     */
    public static String format(BigDecimal resultNumber, boolean separator) {
        if(Objects.isNull(resultNumber)){
            resultNumber = BigDecimal.ZERO;
        }
        resultNumber = resultNumber.stripTrailingZeros();
        resultNumber = rounding(resultNumber);

        String result;
        int scale = resultNumber.scale();
        int precision = resultNumber.precision();

        if ((scale < 0 && (Math.abs(scale) + precision > MAX_PLAIN_SCALE)) ||
                (scale > MAX_PLAIN_SCALE && (scale - precision) >= MAX_OUTPUT_PRECISION - MAX_PLAIN_SCALE)) {
            result = exponentialForm(resultNumber);
        } else if (separator) {
            result = OUTPUT_FORMAT.format(resultNumber);
        } else {
            result = resultNumber.toPlainString().replace(BIG_DECIMAL_SEPARATOR, VIEW_SEPARATOR);
        }

        return result;
    }

    private static BigDecimal rounding(BigDecimal resultNumber) {
        resultNumber = resultNumber.round(MAX_OUTPUT_PRECISION_DOWN).stripTrailingZeros();
        int scale = resultNumber.scale();
        int precision = resultNumber.precision();

        int round;
        int wholeNumberCount = scale - precision;
        if (wholeNumberCount >= MAX_OUTPUT_PRECISION - MAX_PLAIN_SCALE) {
            round = scale - (scale - MAX_PLAIN_SCALE);
        } else if (wholeNumberCount > 0) {
            round = precision - (scale - MAX_PLAIN_SCALE);
        } else {
            round = MAX_PLAIN_SCALE;
        }

        return resultNumber.round(new MathContext(round, HALF_UP_16.getRoundingMode())).stripTrailingZeros();
    }

    private static String exponentialForm(BigDecimal resultNumber) {
        return EXPONENTIAL_FORMAT.format(resultNumber.round(MIN_OUTPUT_PRECISION_DOWN)
                .stripTrailingZeros())
                .replace(BIG_DECIMAL_EXPONENTIAL_MARK + MINUS,
                        EXHIBITOR_SYMBOL + MINUS)
                .replace(BIG_DECIMAL_EXPONENTIAL_MARK, EXHIBITOR_SYMBOL + PLUS);
    }

    private OutputFormatter() {
    }
}