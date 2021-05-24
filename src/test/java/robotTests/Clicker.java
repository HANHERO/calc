package robotTests;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashMap;

public class Clicker {
    private final Robot bot = new Robot();
    private final HashMap<String, String> mapOfKeysCoordinates= new HashMap<>();
    public Clicker() throws AWTException {
        fillTheMapOfKeysCoordinates();
    }

    private void fillTheMapOfKeysCoordinates(){
        mapOfKeysCoordinates.put("plusMinus", "648 579");
        mapOfKeysCoordinates.put("0", "729 579");
        mapOfKeysCoordinates.put(",", "804 579");
        mapOfKeysCoordinates.put("equals", "890 579");

        mapOfKeysCoordinates.put("1", "648 532");
        mapOfKeysCoordinates.put("2", "729 532");
        mapOfKeysCoordinates.put("3", "804 532");
        mapOfKeysCoordinates.put("plus", "890 532");

        mapOfKeysCoordinates.put("4", "648 478");
        mapOfKeysCoordinates.put("5", "729 478");
        mapOfKeysCoordinates.put("6", "804 478");
        mapOfKeysCoordinates.put("minus", "890 478");

        mapOfKeysCoordinates.put("7", "648 427");
        mapOfKeysCoordinates.put("8", "729 427");
        mapOfKeysCoordinates.put("9", "804 427");
        mapOfKeysCoordinates.put("multiply", "890 427");

        mapOfKeysCoordinates.put("oneDivideX", "648 375");
        mapOfKeysCoordinates.put("square", "729 375");
        mapOfKeysCoordinates.put("sqrt", "804 375");
        mapOfKeysCoordinates.put("divide", "890 375");

        mapOfKeysCoordinates.put("percent", "648 375");
        mapOfKeysCoordinates.put("ce", "729 375");
        mapOfKeysCoordinates.put("c", "804 375");
        mapOfKeysCoordinates.put("del", "890 375");

        mapOfKeysCoordinates.put("mc", "648 375");
        mapOfKeysCoordinates.put("mr", "729 375");
        mapOfKeysCoordinates.put("m+", "804 375");
        mapOfKeysCoordinates.put("m-", "890 375");
        mapOfKeysCoordinates.put("ms", "890 375");
    }

    public void click(String whatToClick){
        String [] coordinates = mapOfKeysCoordinates.get(whatToClick).split(" ");
        int coordinateX = Integer.parseInt(coordinates[0]);
        int coordinateY = Integer.parseInt(coordinates[1]);
        bot.mouseMove(coordinateX, coordinateY);
        bot.delay(50);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.delay(50);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void clickNumber(int number) {
        String stringNumber = number + "";
        for (int i = 0; i < stringNumber.length(); i++) {
            click(stringNumber.substring(i, i + 1));
        }
    }
}