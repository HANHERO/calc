package controller.robotTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class KeyboardInputTest extends TestingSandBox {
    @Test
    public void test() {
        test("1234567890,012345", "1 234 567 890,012345", "");

        test("32 - 4 =", "28", "32 - 4 = ");
        test("1234 + 4321 -", "5 555", "5555 - ");
        test("8,905 * 345 =", "3 072,225", "8,905 × 345 = ");
        test("6555 / 30 /", "218,5", "218,5 ÷ ");

        test("12345 del del", "123", "");
        test("78 - 985 - 66 c", "0", "");
        test("78 - 985 - 66 ce", "0", "-907 - ");

        test("1000 + 55 %", "550", "1000 + 550");
        test("81 sqrt sqrt", "3", "√( √( 81 ) )");
        test("2 sqr sqr sqr", "256", "sqr( sqr( sqr( 2 ) ) )");
        test("777 plusMinus plusMinus plusMinus", "-777", "");
        test("100 1/ 1/ 1/", "0,01", "1/( 1/( 1/( 100 ) ) )");

        test("91 ms + 12345 mr", "91", "91 + ");
        test("48 plusMinus m+ plusMinus m+ mr", "0", "negate( -48 )");
        test("654,78 m- c mr", "-654,78", "");
        test("653 ms c mc", "0", "");
    }
    private void test(String expression, String mainLabel, String historyLabel){
        keyboardInputTest(expression,mainLabel,historyLabel);
        alternativeKeyboardInputTest(expression,mainLabel,historyLabel);
    }
}
