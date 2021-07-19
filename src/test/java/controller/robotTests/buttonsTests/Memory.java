package controller.robotTests.buttonsTests;

import controller.sandBox.Clicker;
import controller.sandBox.TestingSandBox;
import org.junit.Test;

import java.awt.*;

public class Memory extends TestingSandBox {
    Clicker clicker;

    public Memory() throws AWTException {
        clicker = new Clicker();
    }
    @Test
    public void simpleScenarios() {
        test("1 ms c mr", "1", "");
        test("10 ms c mr", "10", "");
        test(", ms c mr", "0", "");
        test("0,000000000000001 ms c mr", "0,000000000000001", "");
        test("9999999999999999 ms c mr", "9 999 999 999 999 999", "");
        test("9999999999999999 + 1 = ms c mr", "1e+16", "");
    }

    @Test
    public void addScenarios() {
        test("23 m+ + 123 = mr", "23", "23 + 123 = ");
        test("0,321 m+ m+ m+ mr", "0,963", "");
        test("532 m+ plusMinus m+ mr", "0", "negate( 532 )");
        test("678 plusMinus m+ plusMinus m+ mr", "0", "negate( -678 )");
    }

    @Test
    public void subtractScenarios(){
        test("4723399 m- c 2377 m- mr", "-4 725 776", "");
        test("98 m- c mr", "-98", "");
        test("98 plusMinus m- c mr", "98", "");
        test("125 m- m- m- m- mr", "-500", "");
    }

    @Test
    public void clearScenarios(){
        test("32453 ms c mc 2377 m- mr", "-2 377", "");
        test("98 m- c mc 23 ms mr", "23", "");
        test("4524 plusMinus m- c ms 22 m- mr", "-22", "");
        test("125 m- m- m- m- mc ms mr", "125", "");
    }
    
    public void test(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }
}
