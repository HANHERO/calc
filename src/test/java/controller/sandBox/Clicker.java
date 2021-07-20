package controller.sandBox;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashMap;

public class Clicker {
    private final Robot bot = new Robot();
    private final HashMap<String, String> mapOfKeysCoordinates = new HashMap<>();

    public Clicker() throws AWTException {
        fillTheMapOfKeysCoordinates();
    }

    private void fillTheMapOfKeysCoordinates() {
        mapOfKeysCoordinates.put("plusMinus", "648 579");
        mapOfKeysCoordinates.put("0", "729 579");
        mapOfKeysCoordinates.put(",", "804 579");
        mapOfKeysCoordinates.put("=", "890 579");

        mapOfKeysCoordinates.put("1", "648 532");
        mapOfKeysCoordinates.put("2", "729 532");
        mapOfKeysCoordinates.put("3", "804 532");
        mapOfKeysCoordinates.put("+", "890 532");

        mapOfKeysCoordinates.put("4", "648 478");
        mapOfKeysCoordinates.put("5", "729 478");
        mapOfKeysCoordinates.put("6", "804 478");
        mapOfKeysCoordinates.put("-", "890 478");

        mapOfKeysCoordinates.put("7", "648 427");
        mapOfKeysCoordinates.put("8", "729 427");
        mapOfKeysCoordinates.put("9", "804 427");
        mapOfKeysCoordinates.put("*", "890 427");

        mapOfKeysCoordinates.put("1/", "648 375");
        mapOfKeysCoordinates.put("sqr", "729 375");
        mapOfKeysCoordinates.put("sqrt", "804 375");
        mapOfKeysCoordinates.put("/", "890 375");

        mapOfKeysCoordinates.put("%", "648 322");
        mapOfKeysCoordinates.put("ce", "729 322");
        mapOfKeysCoordinates.put("c", "804 322");
        mapOfKeysCoordinates.put("del", "890 322");

        mapOfKeysCoordinates.put("mc", "637 288");
        mapOfKeysCoordinates.put("mr", "689 288");
        mapOfKeysCoordinates.put("m+", "745 288");
        mapOfKeysCoordinates.put("m-", "799 288");
        mapOfKeysCoordinates.put("ms", "850 288");

        mapOfKeysCoordinates.put("close", "904 125");
    }

    public void click(String whatToClick) {
        String[] coordinates = mapOfKeysCoordinates.get(whatToClick).split(" ");
        int coordinateX = Integer.parseInt(coordinates[0]);
        int coordinateY = Integer.parseInt(coordinates[1]);
        bot.mouseMove(coordinateX, coordinateY);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        bot.delay(20);
    }

    public void clickNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            click(number.charAt(i) + "");
        }
        bot.delay(20);
    }

    public void clickExpression(String expression) {
        String[] mass = expression.split(" ");
        for (String s : mass) {
            if (mapOfKeysCoordinates.containsKey(s)) {
                click(s);
            } else {
                clickNumber(s);
            }
        }
    }
}