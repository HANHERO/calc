package controller.robotTests;

import controller.sandBox.Clicker;
import org.junit.Test;
import controller.sandBox.TestingSandBox;

import java.awt.*;

public class FontSizeTest extends TestingSandBox {
    Clicker clicker;

    public FontSizeTest() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void fontScenarios() {
        textSizeTest("9", 46);
        textSizeTest("9999999999", 46);
        textSizeTest("99999999999", 43);
        textSizeTest("999999999999", 40);
        textSizeTest("9999999999999", 36);
        textSizeTest("99999999999999", 33);
        textSizeTest("999999999999999", 31);
        textSizeTest("9999999999999999", 29);

        textSizeTest("8", 46);
        textSizeTest("8888888888", 46);
        textSizeTest("88888888888", 44);
        textSizeTest("888888888888", 40);
        textSizeTest("8888888888888", 36);
        textSizeTest("88888888888888", 33);
        textSizeTest("888888888888888", 31);
        textSizeTest("8888888888888888", 29);

        textSizeTest("7", 46);
        textSizeTest("7777777777", 46);
        textSizeTest("77777777777", 45);
        textSizeTest("777777777777", 41);
        textSizeTest("7777777777777", 38);
        textSizeTest("77777777777777", 34);
        textSizeTest("777777777777777", 32);
        textSizeTest("7777777777777777", 30);

        textSizeTest("6", 46);
        textSizeTest("6666666666", 46);
        textSizeTest("66666666666", 43);
        textSizeTest("666666666666", 40);
        textSizeTest("6666666666666", 36);
        textSizeTest("66666666666666", 33);
        textSizeTest("666666666666666", 31);
        textSizeTest("6666666666666666", 29);

        textSizeTest("5", 46);
        textSizeTest("5555555555", 46);
        textSizeTest("55555555555", 44);
        textSizeTest("555555555555", 40);
        textSizeTest("5555555555555", 36);
        textSizeTest("55555555555555", 33);
        textSizeTest("555555555555555", 31);
        textSizeTest("5555555555555555", 29);

        textSizeTest("4", 46);
        textSizeTest("444444444", 46);
        textSizeTest("4444444444", 45);
        textSizeTest("44444444444", 42);
        textSizeTest("444444444444", 39);
        textSizeTest("4444444444444", 35);
        textSizeTest("44444444444444", 32);
        textSizeTest("444444444444444", 30);
        textSizeTest("4444444444444444", 28);

        textSizeTest("3", 46);
        textSizeTest("3333333333", 46);
        textSizeTest("33333333333", 44);
        textSizeTest("333333333333", 40);
        textSizeTest("3333333333333", 36);
        textSizeTest("33333333333333", 33);
        textSizeTest("333333333333333", 31);
        textSizeTest("3333333333333333", 29);

        textSizeTest("2", 46);
        textSizeTest("2222222222", 46);
        textSizeTest("22222222222", 44);
        textSizeTest("222222222222", 40);
        textSizeTest("2222222222222", 36);
        textSizeTest("22222222222222", 33);
        textSizeTest("222222222222222", 31);
        textSizeTest("2222222222222222", 29);

        textSizeTest("1", 46);
        textSizeTest("1111111111111", 46);
        textSizeTest("11111111111111", 45);
        textSizeTest("111111111111111", 41);
        textSizeTest("1111111111111111", 38);
    }

    public void textSizeTest(String expression, int mainLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelTest(mainLabelExcepted);
    }
}
