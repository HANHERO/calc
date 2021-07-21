package controller.robotTests.buttonsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

import java.awt.*;

public class Memory extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("1 ms c mr", "1", "");
        mouseInputTest("10 ms c mr", "10", "");
        mouseInputTest(", ms c mr", "0", "");
        mouseInputTest("0,000000000000001 ms c mr", "0,000000000000001", "");
        mouseInputTest("9999999999999999 ms c mr", "9 999 999 999 999 999", "");
        mouseInputTest("9999999999999999 + 1 = ms c mr", "1e+16", "");
    }

    @Test
    public void addScenarios() {
        mouseInputTest("23 m+ + 123 = mr", "23", "23 + 123 = ");
        mouseInputTest("0,321 m+ m+ m+ mr", "0,963", "");
        mouseInputTest("532 m+ plusMinus m+ mr", "0", "negate( 532 )");
        mouseInputTest("678 plusMinus m+ plusMinus m+ mr", "0", "negate( -678 )");
    }

    @Test
    public void subtractScenarios() {
        mouseInputTest("4723399 m- c 2377 m- mr", "-4 725 776", "");
        mouseInputTest("98 m- c mr", "-98", "");
        mouseInputTest("98 plusMinus m- c mr", "98", "");
        mouseInputTest("125 m- m- m- m- mr", "-500", "");
    }

    @Test
    public void clearScenarios() {
        mouseInputTest("32453 ms c mc 2377 m- mr", "-2 377", "");
        mouseInputTest("98 m- c mc 23 ms mr", "23", "");
        mouseInputTest("4524 plusMinus m- c ms 22 m- mr", "-22", "");
        mouseInputTest("125 m- m- m- m- mc ms mr", "125", "");
    }
}
