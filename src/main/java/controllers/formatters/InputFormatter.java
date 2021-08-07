package controllers.formatters;

import java.math.BigDecimal;

/**
 * The {@code InputFormatter} class
 * represents number which is entered in numeric field.
 * <br/>
 * There are methods for changing the number (removing the last character, appending to the end, adding a comma).
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class InputFormatter {

    private InputFormatter() {
    }
    /** Maximum digits count */
    private static final int MAX_DIGITS = 16;
    /** Default value for main label*/
    private static String mainLabel = "0";
    /** Decimal part */
    private static int scale;
    /** Shows if point is present */
    private static boolean isPointSet;
    /** Input number */
    private static BigDecimal input = BigDecimal.ZERO;

    /**
     * Add digit to input number
     *
     * @param numeric input digit
     */
    public static void appendNumeric(String numeric) {
        if (canInput()) {
            if (isPointSet) {
                scale++;
            }
            if (mainLabel.equals("0")){
                mainLabel = numeric;
            }else {
                mainLabel += numeric;
            }

            input = input.multiply(BigDecimal.TEN).add(new BigDecimal(numeric));
        }
    }

    /**
     * Gets input.
     *
     * @return the input
     */
    public static BigDecimal getInput() {
        return input.movePointLeft(scale);
    }

    /**
     * Adds point to input.
     */
    public static void addPointToInput() {
        if (mainLabel.equals("")) {
            mainLabel = "0,";
        } else if (!mainLabel.contains(",")) {
            mainLabel += ",";
        }
        isPointSet = true;
    }

    /**
     * Is input point set boolean.
     *
     * @return the boolean
     */
    public static boolean isInputPointSet() {
        return isPointSet;
    }

    /**
     *Backspace operation on input number.
     */
    public static void backspaceInput() {
        if (isPointSet) {
            if (scale > 0) {
                input = input.divideToIntegralValue(BigDecimal.TEN);
                scale--;
            } else {
                isPointSet = false;
            }
        } else {
            input = input.divideToIntegralValue(BigDecimal.TEN);
        }
        if (mainLabel.length() > 1){
            mainLabel = mainLabel.substring(0, mainLabel.length() - 1);
        } else  {
            mainLabel = "0";
        }
    }

    /**
     * Separates the input with spaces where necessary and returns a string.
     *
     * @return the string for main label
     */
    public static String getMainLabelText() {
        StringBuilder stringBuilder = new StringBuilder(mainLabel);
        if (mainLabel.contains(",")) {
            for (int i = 0; i < mainLabel.indexOf(","); i += 3) {
                if (i == 0) continue;
                stringBuilder.insert(mainLabel.indexOf(",") - i, " ");
            }
        } else {
            for (int i = 0; i < mainLabel.length(); i += 3) {
                if (i == 0) continue;
                stringBuilder.insert(mainLabel.length() - i, " ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Clear input number.
     */
    public static void clearInput() {
        scale = 0;
        input = BigDecimal.ZERO;
        isPointSet = false;
        mainLabel = "";
    }

    /**
     * Checks if input number reach limit
     *
     * @return permission for input
     */
    public static boolean canInput() {
        return input.precision() < MAX_DIGITS && scale < MAX_DIGITS;
    }
}