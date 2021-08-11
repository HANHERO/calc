package controllers.formatters;

import java.math.BigDecimal;

/**
 * The {@code InputFormatter} class
 * represents number which is entered in numeric field.
 * <br/>
 * There are methods for changing the number (removing the last character, appending to the end, adding a comma).
 * <br> for example:
 * <br>25454334545 transformed into 25 454 334 545
 * <br>0.02345675432345676543 transformed into 0,0234567543234568
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class InputFormatter {
    /**
     * Maximum digits count
     */
    private static final int MAX_DIGITS = 16;
    /**
     * Default value of main label
     */
    private static final String DEFAULT_MAIN_LABEL_TEXT = "0";
    /**
     * Comma sign
     */
    private static final char COMMA = ',';
    /**
     * Default value for main label
     */
    private String mainLabel = DEFAULT_MAIN_LABEL_TEXT;
    /**
     * Decimal part
     */
    private int scale;
    /**
     * Shows if point is present
     */
    private boolean isPointSet;
    /**
     * Input number
     */
    private BigDecimal input = BigDecimal.ZERO;

    /**
     * Add digit to input number
     *
     * @param numeric input digit
     */
    public void appendNumeric(String numeric) {
        if (canInput()) {
            if (isPointSet) {
                scale++;
            }
            if (mainLabel.equals(DEFAULT_MAIN_LABEL_TEXT)) {
                mainLabel = numeric;
            } else {
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
    public BigDecimal getInput() {
        return input.movePointLeft(scale);
    }

    /**
     * Adds point to input.
     */
    public void addPointToInput() {
        if (mainLabel.indexOf(COMMA) == -1) {
            mainLabel += COMMA;
        }
        isPointSet = true;
    }

    /**
     * Is input point set boolean.
     *
     * @return the boolean
     */
    public boolean isInputPointSet() {
        return isPointSet;
    }

    /**
     * Backspace operation on input number.
     */
    public void backspaceInput() {
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
        if (mainLabel.length() > 1) {
            mainLabel = mainLabel.substring(0, mainLabel.length() - 1);
        } else {
            mainLabel = "0";
        }
    }

    /**
     * Separates the input with spaces where necessary and returns a string.
     *
     * @return the string for main label
     */
    public String getMainLabelText() {
        StringBuilder stringBuilder = new StringBuilder(mainLabel);
        char spaceChar = ' ';
        int spaceEveryCharacters = 3;
        if (mainLabel.indexOf(COMMA) != -1) {
            for (int i = 0; i < mainLabel.indexOf(COMMA); i += spaceEveryCharacters) {
                if (i == 0) {
                    continue;
                }
                stringBuilder.insert(mainLabel.indexOf(COMMA) - i, spaceChar);
            }
        } else {
            for (int i = 0; i < mainLabel.length(); i += spaceEveryCharacters) {
                if (i == 0) {
                    continue;
                }
                stringBuilder.insert(mainLabel.length() - i, spaceChar);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Clear input number.
     */
    public void clearInput() {
        scale = 0;
        input = BigDecimal.ZERO;
        isPointSet = false;
        mainLabel = DEFAULT_MAIN_LABEL_TEXT;
    }

    /**
     * Checks if input number reach limit
     *
     * @return permission for input
     */
    public boolean canInput() {
        return input.precision() < MAX_DIGITS && scale < MAX_DIGITS;
    }
}