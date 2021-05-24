package robotTests;

import org.junit.Test;
import javafx.scene.control.Label;
import sandBox.TestingSandBox;

import java.awt.*;

import static org.testfx.api.FxAssert.verifyThat;

public class InputTests extends TestingSandBox {
    Clicker clicker;

    public InputTests() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void scenarios() {
        //inputTest("1234", "1 234");
        //inputTest("23", "23");
        //inputTest("5334", "5 334");
        //inputTest("1232314", "1 232 314");
        //inputTest("8753", "8 753");
        //inputTest("543422", "543 422");
        //inputTest("1232314", "1 232 314");
        //inputTest("1596321,324", "1 596 321,324");
        //inputTest("9999999999999999", "9 999 999 999 999 999");
//
        //expressionTest("(10) + (15) - (9) sqrt =", "22");
        //expressionTest("(9) + = = = = = = = = =", "90");
        //expressionTest("(10) + (15) - (9) sqrt =", "22");
        expressionTest("(9999999999999999) + (9999999999999999) = = = = =", "6,e+16");
        expressionTest("(9) sqrt square sqrt square sqrt square sqrt square sqrt square sqrt square sqrt square sqrt square =", "9");

    }

    public void inputTest(String numberToInput, String excepted) {
        clicker.clickNumber(numberToInput);
        test(excepted);
    }

    public void expressionTest(String expression, String excepted) {
        clicker.clickExpression(expression);
        test(excepted);
    }

    public void test(String excepted){
        String mainLabel = "#mainLabel";
        verifyThat(mainLabel, (Label label) -> label.getText().equals(excepted));
        clicker.click("c");
        verifyThat(mainLabel, (Label label) -> label.getText().equals("0"));
    }
}
