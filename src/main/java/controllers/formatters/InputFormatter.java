package controllers.formatters;

import java.math.BigDecimal;

import static controllers.Controller.isNegatePressed;

public class InputFormatter {

    private InputFormatter() {
    }

    private static final int MAX_DIGITS = 16;
    private static String stringForMainLabel = "";
    private static int scale;
    private static boolean isPointSet;
    private static BigDecimal input = BigDecimal.ZERO;

    public static void appendNumeric(String numeric) {
        if (canInput()) {
            if (isPointSet) {
                scale++;
            }
            if (stringForMainLabel.equals("0")){
                stringForMainLabel = numeric;
            }else {
                stringForMainLabel += numeric;
            }

            input = input.multiply(BigDecimal.TEN).add(new BigDecimal(numeric));
        }
    }

    public static BigDecimal getInput() {
        return input.movePointLeft(scale);
    }

    public static void addPointToInput() {
        if (stringForMainLabel.equals("")) {
            stringForMainLabel = "0,";
        } else if (!stringForMainLabel.contains(",")) {
            stringForMainLabel += ",";
        }
        isPointSet = true;
    }

    public static boolean isInputPointSet() {
        return isPointSet;
    }

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
        if (stringForMainLabel.length() != 0){
            stringForMainLabel = stringForMainLabel.substring(0, stringForMainLabel.length() - 1);
        } if (stringForMainLabel.length() == 0) {
            stringForMainLabel = "0";
        }
    }

    public static String getStringForMainLabel() {
        StringBuilder stringBuilder = new StringBuilder(stringForMainLabel);
        if (stringForMainLabel.contains(",")) {
            for (int i = 0; i < stringForMainLabel.indexOf(","); i += 3) {
                if (i == 0) continue;
                stringBuilder.insert(stringForMainLabel.indexOf(",") - i, " ");
            }
        } else {
            for (int i = 0; i < stringForMainLabel.length(); i += 3) {
                if (i == 0) continue;
                stringBuilder.insert(stringForMainLabel.length() - i, " ");
            }
        }
        return stringBuilder.toString();
    }

    public static void clearInput() {
        scale = 0;
        input = BigDecimal.ZERO;
        isPointSet = false;
        stringForMainLabel = "";
    }

    public static boolean canInput() {
        return input.precision() < MAX_DIGITS && scale < MAX_DIGITS;
    }
}