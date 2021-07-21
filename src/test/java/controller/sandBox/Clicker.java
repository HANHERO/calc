package controller.sandBox;

import javafx.scene.input.KeyCode;
import org.testfx.api.FxRobot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Clicker {
    private final Robot bot = new Robot();
    private final FxRobot fxBot = new FxRobot();
    private final HashMap<String, String> mapOfKeysCoordinates = new HashMap<>();
    private final Map<String, java.util.List<KeyCode>> keyCodesMap = new HashMap<>();
    private final Map<String, java.util.List<KeyCode>> alternativeKeyCodesMap = new HashMap<>();

    public Clicker() throws AWTException {
        fillTheMapOfKeysCoordinates();
        fillTheMapOfKayCodes();
        fillTheMapOfAlternativeKayCodes();
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

    private void fillTheMapOfKayCodes() {
        keyCodesMap.put("plusMinus", Collections.singletonList(KeyCode.F9));
        keyCodesMap.put("0", Collections.singletonList(KeyCode.NUMPAD0));
        keyCodesMap.put(",", Collections.singletonList(KeyCode.COMMA));
        keyCodesMap.put("=", Collections.singletonList(KeyCode.EQUALS));

        keyCodesMap.put("1", Collections.singletonList(KeyCode.NUMPAD1));
        keyCodesMap.put("2", Collections.singletonList(KeyCode.NUMPAD2));
        keyCodesMap.put("3", Collections.singletonList(KeyCode.NUMPAD3));
        keyCodesMap.put("+", Arrays.asList(KeyCode.SHIFT, KeyCode.EQUALS));

        keyCodesMap.put("4", Collections.singletonList(KeyCode.NUMPAD4));
        keyCodesMap.put("5", Collections.singletonList(KeyCode.NUMPAD5));
        keyCodesMap.put("6", Collections.singletonList(KeyCode.NUMPAD6));
        keyCodesMap.put("-", Collections.singletonList(KeyCode.MINUS));

        keyCodesMap.put("7", Collections.singletonList(KeyCode.NUMPAD7));
        keyCodesMap.put("8", Collections.singletonList(KeyCode.NUMPAD8));
        keyCodesMap.put("9", Collections.singletonList(KeyCode.NUMPAD9));
        keyCodesMap.put("*", Arrays.asList(KeyCode.SHIFT, KeyCode.DIGIT8));

        keyCodesMap.put("1/", Collections.singletonList(KeyCode.R));
        keyCodesMap.put("sqr", Collections.singletonList(KeyCode.Q));
        keyCodesMap.put("sqrt", Arrays.asList(KeyCode.SHIFT, KeyCode.DIGIT2));
        keyCodesMap.put("/", Collections.singletonList(KeyCode.SLASH));

        keyCodesMap.put("%", Arrays.asList(KeyCode.SHIFT, KeyCode.DIGIT5));
        keyCodesMap.put("ce", Collections.singletonList(KeyCode.DELETE));
        keyCodesMap.put("c", Collections.singletonList(KeyCode.ESCAPE));
        keyCodesMap.put("del", Collections.singletonList(KeyCode.BACK_SPACE));

        keyCodesMap.put("mc", Arrays.asList(KeyCode.CONTROL, KeyCode.L));
        keyCodesMap.put("mr", Arrays.asList(KeyCode.CONTROL, KeyCode.R));
        keyCodesMap.put("m+", Arrays.asList(KeyCode.CONTROL, KeyCode.P));
        keyCodesMap.put("m-", Arrays.asList(KeyCode.CONTROL, KeyCode.Q));
        keyCodesMap.put("ms", Arrays.asList(KeyCode.CONTROL, KeyCode.M));
    }

    private void fillTheMapOfAlternativeKayCodes() {

        alternativeKeyCodesMap.put("plusMinus", Collections.singletonList(KeyCode.F9));
        alternativeKeyCodesMap.put("0", Collections.singletonList(KeyCode.DIGIT0));
        alternativeKeyCodesMap.put(",", Collections.singletonList(KeyCode.COMMA));
        alternativeKeyCodesMap.put("=", Collections.singletonList(KeyCode.ENTER));

        alternativeKeyCodesMap.put("1", Collections.singletonList(KeyCode.DIGIT1));
        alternativeKeyCodesMap.put("2", Collections.singletonList(KeyCode.DIGIT2));
        alternativeKeyCodesMap.put("3", Collections.singletonList(KeyCode.DIGIT3));
        alternativeKeyCodesMap.put("+", Collections.singletonList(KeyCode.ADD));

        alternativeKeyCodesMap.put("4", Collections.singletonList(KeyCode.DIGIT4));
        alternativeKeyCodesMap.put("5", Collections.singletonList(KeyCode.DIGIT5));
        alternativeKeyCodesMap.put("6", Collections.singletonList(KeyCode.DIGIT6));
        alternativeKeyCodesMap.put("-", Collections.singletonList(KeyCode.SUBTRACT));

        alternativeKeyCodesMap.put("7", Collections.singletonList(KeyCode.DIGIT7));
        alternativeKeyCodesMap.put("8", Collections.singletonList(KeyCode.DIGIT8));
        alternativeKeyCodesMap.put("9", Collections.singletonList(KeyCode.DIGIT9));
        alternativeKeyCodesMap.put("*", Collections.singletonList(KeyCode.MULTIPLY));

        alternativeKeyCodesMap.put("1/", Collections.singletonList(KeyCode.R));
        alternativeKeyCodesMap.put("sqr", Collections.singletonList(KeyCode.Q));
        alternativeKeyCodesMap.put("sqrt", Arrays.asList(KeyCode.SHIFT, KeyCode.DIGIT2));
        alternativeKeyCodesMap.put("/", Collections.singletonList(KeyCode.DIVIDE));

        alternativeKeyCodesMap.put("%", Arrays.asList(KeyCode.SHIFT, KeyCode.DIGIT5));
        alternativeKeyCodesMap.put("ce", Collections.singletonList(KeyCode.DELETE));
        alternativeKeyCodesMap.put("c", Collections.singletonList(KeyCode.ESCAPE));
        alternativeKeyCodesMap.put("del", Collections.singletonList(KeyCode.BACK_SPACE));

        alternativeKeyCodesMap.put("mc", Arrays.asList(KeyCode.CONTROL, KeyCode.L));
        alternativeKeyCodesMap.put("mr", Arrays.asList(KeyCode.CONTROL, KeyCode.R));
        alternativeKeyCodesMap.put("m+", Arrays.asList(KeyCode.CONTROL, KeyCode.P));
        alternativeKeyCodesMap.put("m-", Arrays.asList(KeyCode.CONTROL, KeyCode.Q));
        alternativeKeyCodesMap.put("ms", Arrays.asList(KeyCode.CONTROL, KeyCode.M));
    }

    public void clickMouse(String whatToClick) {
        String[] coordinates = mapOfKeysCoordinates.get(whatToClick).split(" ");
        int coordinateX = Integer.parseInt(coordinates[0]);
        int coordinateY = Integer.parseInt(coordinates[1]);
        bot.mouseMove(coordinateX, coordinateY);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        bot.delay(20);
    }

    public void mouseClickNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            clickMouse(number.charAt(i) + "");
        }
        bot.delay(20);
    }

    public void mouseClickExpression(String expression) {
        String[] mass = expression.split(" ");
        for (String s : mass) {
            if (mapOfKeysCoordinates.containsKey(s)) {
                clickMouse(s);
            } else {
                mouseClickNumber(s);
            }
        }
    }

    public void keyboardClickExpression(String expression) {
        String[] mass = expression.split(" ");
        for (String s : mass) {
            if (mapOfKeysCoordinates.containsKey(s)) {
                clickKeyboard(s);
            } else {
                keyboardClickNumber(s);
            }
        }
    }

    private void keyboardClickNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            clickKeyboard(number.charAt(i) + "");
        }
        fxBot.sleep(20);
    }

    public void clickKeyboard(String whatToClick) {
        for (KeyCode keyCode : keyCodesMap.get(whatToClick)) {
            fxBot.press(keyCode);
        }
        for (KeyCode keyCode : keyCodesMap.get(whatToClick)) {
            fxBot.release(keyCode);
        }
    }

    public void alternativeKeyboardClickExpression(String expression) {
        String[] mass = expression.split(" ");
        for (String s : mass) {
            if (mapOfKeysCoordinates.containsKey(s)) {
                clickAlternativeKeyboard(s);
            } else {
                alternativeKeyboardClickNumber(s);
            }
        }
    }

    private void alternativeKeyboardClickNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            clickAlternativeKeyboard(number.charAt(i) + "");
        }
        fxBot.sleep(20);
    }

    public void clickAlternativeKeyboard(String whatToClick) {
        for (KeyCode keyCode : alternativeKeyCodesMap.get(whatToClick)) {
            fxBot.press(keyCode);
        }
        for (KeyCode keyCode : alternativeKeyCodesMap.get(whatToClick)) {
            fxBot.release(keyCode);
        }
    }
}