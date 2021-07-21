package controller.robotTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class FontSizeTest extends TestingSandBox {

    @Test
    public void fontScenarios() {
        mainLabelTest("9", 46);
        mainLabelTest("9999999999", 46);
        mainLabelTest("99999999999", 43);
        mainLabelTest("999999999999", 40);
        mainLabelTest("9999999999999", 36);
        mainLabelTest("99999999999999", 33);
        mainLabelTest("999999999999999", 31);
        mainLabelTest("9999999999999999", 29);

        mainLabelTest("8", 46);
        mainLabelTest("8888888888", 46);
        mainLabelTest("88888888888", 44);
        mainLabelTest("888888888888", 40);
        mainLabelTest("8888888888888", 36);
        mainLabelTest("88888888888888", 33);
        mainLabelTest("888888888888888", 31);
        mainLabelTest("8888888888888888", 29);

        mainLabelTest("7", 46);
        mainLabelTest("7777777777", 46);
        mainLabelTest("77777777777", 45);
        mainLabelTest("777777777777", 41);
        mainLabelTest("7777777777777", 38);
        mainLabelTest("77777777777777", 34);
        mainLabelTest("777777777777777", 32);
        mainLabelTest("7777777777777777", 30);

        mainLabelTest("6", 46);
        mainLabelTest("6666666666", 46);
        mainLabelTest("66666666666", 43);
        mainLabelTest("666666666666", 40);
        mainLabelTest("6666666666666", 36);
        mainLabelTest("66666666666666", 33);
        mainLabelTest("666666666666666", 31);
        mainLabelTest("6666666666666666", 29);

        mainLabelTest("5", 46);
        mainLabelTest("5555555555", 46);
        mainLabelTest("55555555555", 44);
        mainLabelTest("555555555555", 40);
        mainLabelTest("5555555555555", 36);
        mainLabelTest("55555555555555", 33);
        mainLabelTest("555555555555555", 31);
        mainLabelTest("5555555555555555", 29);

        mainLabelTest("4", 46);
        mainLabelTest("444444444", 46);
        mainLabelTest("4444444444", 45);
        mainLabelTest("44444444444", 42);
        mainLabelTest("444444444444", 39);
        mainLabelTest("4444444444444", 35);
        mainLabelTest("44444444444444", 32);
        mainLabelTest("444444444444444", 30);
        mainLabelTest("4444444444444444", 28);

        mainLabelTest("3", 46);
        mainLabelTest("3333333333", 46);
        mainLabelTest("33333333333", 44);
        mainLabelTest("333333333333", 40);
        mainLabelTest("3333333333333", 36);
        mainLabelTest("33333333333333", 33);
        mainLabelTest("333333333333333", 31);
        mainLabelTest("3333333333333333", 29);

        mainLabelTest("2", 46);
        mainLabelTest("2222222222", 46);
        mainLabelTest("22222222222", 44);
        mainLabelTest("222222222222", 40);
        mainLabelTest("2222222222222", 36);
        mainLabelTest("22222222222222", 33);
        mainLabelTest("222222222222222", 31);
        mainLabelTest("2222222222222222", 29);

        mainLabelTest("1", 46);
        mainLabelTest("1111111111111", 46);
        mainLabelTest("11111111111111", 45);
        mainLabelTest("111111111111111", 41);
        mainLabelTest("1111111111111111", 38);
    }
}
