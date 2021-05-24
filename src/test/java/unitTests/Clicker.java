package unitTests;

import controllers.MainController;

public class Clicker extends MainController {

    public String run(String input) {
        for (int i = 0; i < input.length(); i++) {
            click(input.substring(i, i + 1));
        }
        return mainLabel.getText();
    }

    private void click(String toClick) {
        switch (toClick) {
            case "1" -> one.fire();
            case "2" -> two.fire();
            case "3" -> three.fire();
            case "4" -> four.fire();
            case "5" -> five.fire();
            case "6" -> six.fire();
            case "7" -> seven.fire();
            case "8" -> eight.fire();
            case "9" -> nine.fire();
            case "0" -> zero.fire();
            case "=" -> equals.fire();
            case "+/-" -> plusMinus.fire();
            case "," -> comma.fire();
            case "+" -> plus.fire();
            case "-" -> minus.fire();
            case "*" -> multiply.fire();
            case "/" -> divide.fire();
            case "sqrt" -> sqrt.fire();
            case "square" -> square.fire();
            case "1/x" -> oneDividedX.fire();
            case "del" -> del.fire();
            case "c" -> c.fire();
            case "ce" -> ce.fire();
            case "%" -> percent.fire();
            case "ms" -> ms.fire();
            case "m-" -> mMinus.fire();
            case "m+" -> mPlus.fire();
            case "mr" -> mr.fire();
            case "mc" -> mc.fire();

        }
    }
}
