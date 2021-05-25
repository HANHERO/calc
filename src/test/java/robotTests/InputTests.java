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
        //inputTest("1232314", "1 232 314");
        //inputTest("543422", "543 422");
        //inputTest("1232314", "1 232 314");
        //inputTest("1596321,324", "1 596 321,324");
        //inputTest("9999999999999999", "9 999 999 999 999 999");

        //expressionTest("(10) + (15) - (9) sqrt =", "22", "25 - √( 9 ) = ");
        //expressionTest("(9) sqrt + (3) square =", "12", "√( 9 ) + sqr( 3 ) = ");
        //expressionTest("(9) sqrt + (12) =", "15", "√( 9 ) + 12 = ");
        //expressionTest("(9) + = = = = = = = = =", "90", "81 + 9 = ");
        //expressionTest("(9) + (1) =", "10", "9 + 1 = ");
        //expressionTest("(9) sqrt square sqrt square sqrt =", "3", "√( sqr( √( sqr( √( 9 ) ) ) ) ) = ");
        //expressionTest("(9) sqrt square sqrt square sqrt = =", "3", "3 = ");
        //expressionTest("1 +", "1", "1 + ");
        //expressionTest("1 -", "1", "1 - ");
        //expressionTest("1 /", "1", "1 ÷ ");
        //expressionTest("1 *", "1", "1 × ");
        expressionTest("(10) + (5) - (2) * (4) / (4) = 1/ 1/ = + (4)", "7,25", "3,25 + 4 = ");
    }
    public void inputTest(String numberToInput, String excepted) {
        clicker.clickNumber(numberToInput);
        mainLabelTest(excepted, "");
    }

    public void expressionTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelTest(mainLabelExcepted, historyLabelExcepted);
    }

    public void mainLabelTest(String mainLabelExcepted, String historyLabelExcepted){
        String mainLabel = "#mainLabel";
        String historyLabel = "#historyLabel";
        verifyThat(historyLabel, (Label label) -> label.getText().equals(historyLabelExcepted));
        verifyThat(mainLabel, (Label label) -> label.getText().equals(mainLabelExcepted));
        clicker.click("c");
        verifyThat(mainLabel, (Label label) -> label.getText().equals("0"));
        verifyThat(historyLabel, (Label label) -> label.getText().equals(""));
    }
}