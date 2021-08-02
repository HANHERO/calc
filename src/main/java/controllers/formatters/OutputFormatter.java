package controllers.formatters;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Objects;

public class OutputFormatter {
    private static final int MAX_PLAIN_SCALE = 16;
    private static final int MAX_OUTPUT_PRECISION = 19;
    private static final String EXHIBITOR_SYMBOL = "e";
    private static final MathContext HALF_UP_16 = new MathContext(MAX_PLAIN_SCALE, RoundingMode.HALF_UP);
    private static final Format EXPONENTIAL_FORMAT = new DecimalFormat("0.################E0");
    private static final MathContext MAX_OUTPUT_PRECISION_DOWN = new MathContext(MAX_OUTPUT_PRECISION, RoundingMode.DOWN);
    private static final MathContext MIN_OUTPUT_PRECISION_DOWN = new MathContext(MAX_PLAIN_SCALE, RoundingMode.DOWN);
    private static final String BIG_DECIMAL_EXPONENTIAL_MARK = "E";
    static final String BIG_DECIMAL_SEPARATOR = ".";
    static final String VIEW_SEPARATOR = ",";
    private static final char SPACE = ' ';
    private static final String NUMBER_PATTERN = "###,###.###################";
    private static final String MINUS = "-";
    private static final String PLUS = "+";
    private static final DecimalFormat OUTPUT_FORMAT;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(SPACE);
        OUTPUT_FORMAT = new DecimalFormat(NUMBER_PATTERN, symbols);
    }

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