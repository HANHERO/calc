/*
package robotTests;

import org.junit.Test;
import sandBox.TestingSandBox;

import java.awt.*;

import static org.testfx.api.FxAssert.verifyThat;

public class FontSizeTest extends TestingSandBox {
    Clicker clicker;
    public FontSizeTest() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void fontScenarios() {
        expressionTest("9", 46);
        expressionTest("99", 46);
        expressionTest("999", 46);
        expressionTest("9999", 46);
        expressionTest("99999", 46);
        expressionTest("999999", 46);
        expressionTest("9999999", 46);
        expressionTest("99999999", 46);
        expressionTest("999999999", 46);
        expressionTest("9999999999", 46);
        expressionTest("99999999999", 43);
        expressionTest("999999999999", 40);
        expressionTest("9999999999999", 36);
        expressionTest("99999999999999", 33);
        expressionTest("999999999999999", 31);
        expressionTest("9999999999999999", 29);

        expressionTest("8", 46);
        expressionTest("88", 46);
        expressionTest("888", 46);
        expressionTest("8888", 46);
        expressionTest("88888", 46);
        expressionTest("888888", 46);
        expressionTest("8888888", 46);
        expressionTest("88888888", 46);
        expressionTest("888888888", 46);
        expressionTest("8888888888", 46);
        expressionTest("88888888888", 44);
        expressionTest("888888888888", 40);
        expressionTest("8888888888888", 36);
        expressionTest("88888888888888", 33);
        expressionTest("888888888888888", 31);
        expressionTest("8888888888888888", 29);

        expressionTest("7", 46);
        expressionTest("77", 46);
        expressionTest("777", 46);
        expressionTest("7777", 46);
        expressionTest("77777", 46);
        expressionTest("777777", 46);
        expressionTest("7777777", 46);
        expressionTest("77777777", 46);
        expressionTest("777777777", 46);
        expressionTest("7777777777", 46);
        expressionTest("77777777777", 45);
        expressionTest("777777777777", 41);
        expressionTest("7777777777777", 38);
        expressionTest("77777777777777", 34);
        expressionTest("777777777777777", 32);
        expressionTest("7777777777777777", 30);

        expressionTest("6", 46);
        expressionTest("66", 46);
        expressionTest("666", 46);
        expressionTest("6666", 46);
        expressionTest("66666", 46);
        expressionTest("666666", 46);
        expressionTest("6666666", 46);
        expressionTest("66666666", 46);
        expressionTest("666666666", 46);
        expressionTest("6666666666", 46);
        expressionTest("66666666666", 43);
        expressionTest("666666666666", 40);
        expressionTest("6666666666666", 36);
        expressionTest("66666666666666", 33);
        expressionTest("666666666666666", 31);
        expressionTest("6666666666666666", 29);

        expressionTest("5", 46);
        expressionTest("55", 46);
        expressionTest("555", 46);
        expressionTest("5555", 46);
        expressionTest("55555", 46);
        expressionTest("555555", 46);
        expressionTest("5555555", 46);
        expressionTest("55555555", 46);
        expressionTest("555555555", 46);
        expressionTest("5555555555", 46);
        expressionTest("55555555555", 44);
        expressionTest("555555555555", 40);
        expressionTest("5555555555555", 36);
        expressionTest("55555555555555", 33);
        expressionTest("555555555555555", 31);
        expressionTest("5555555555555555", 29);

        expressionTest("4", 46);
        expressionTest("44", 46);
        expressionTest("444", 46);
        expressionTest("4444", 46);
        expressionTest("44444", 46);
        expressionTest("444444", 46);
        expressionTest("4444444", 46);
        expressionTest("44444444", 46);
        expressionTest("444444444", 46);
        expressionTest("4444444444", 45);
        expressionTest("44444444444", 42);
        expressionTest("444444444444", 39);
        expressionTest("4444444444444", 35);
        expressionTest("44444444444444", 32);
        expressionTest("444444444444444", 30);
        expressionTest("4444444444444444", 28);

        expressionTest("3", 46);
        expressionTest("33", 46);
        expressionTest("333", 46);
        expressionTest("3333", 46);
        expressionTest("33333", 46);
        expressionTest("333333", 46);
        expressionTest("3333333", 46);
        expressionTest("33333333", 46);
        expressionTest("333333333", 46);
        expressionTest("3333333333", 46);
        expressionTest("33333333333", 44);
        expressionTest("333333333333", 40);
        expressionTest("3333333333333", 36);
        expressionTest("33333333333333", 33);
        expressionTest("333333333333333", 31);
        expressionTest("3333333333333333", 29);

        expressionTest("2", 46);
        expressionTest("22", 46);
        expressionTest("222", 46);
        expressionTest("2222", 46);
        expressionTest("22222", 46);
        expressionTest("222222", 46);
        expressionTest("2222222", 46);
        expressionTest("22222222", 46);
        expressionTest("222222222", 46);
        expressionTest("2222222222", 46);
        expressionTest("22222222222", 44);
        expressionTest("222222222222", 40);
        expressionTest("2222222222222", 36);
        expressionTest("22222222222222", 33);
        expressionTest("222222222222222", 31);
        expressionTest("2222222222222222", 29);

        expressionTest("1", 46);
        expressionTest("11", 46);
        expressionTest("111", 46);
        expressionTest("1111", 46);
        expressionTest("11111", 46);
        expressionTest("111111", 46);
        expressionTest("1111111", 46);
        expressionTest("11111111", 46);
        expressionTest("111111111", 46);
        expressionTest("1111111111", 46);
        expressionTest("11111111111", 46);
        expressionTest("111111111111", 46);
        expressionTest("1111111111111", 46);
        expressionTest("11111111111111", 45);
        expressionTest("111111111111111", 41);
        expressionTest("1111111111111111", 38);

    }

    public void expressionTest(String number, int size) {
        clicker.clickNumber(number);
        mainLabelTest(size);
    }

    public void mainLabelTest(int size){
        String mainLabel = "#mainLabel";
        verifyThat(mainLabel, (javafx.scene.control.Label label) -> label.getFont().getSize() == size);
        clicker.click("c");
    }
}
*/
