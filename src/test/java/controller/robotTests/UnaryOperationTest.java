package controller.robotTests;

import javafx.scene.control.Label;
import org.junit.Test;
import controller.sandBox.TestingSandBox;

import java.awt.*;

import static org.testfx.api.FxAssert.verifyThat;

public class UnaryOperationTest extends TestingSandBox {
    Clicker clicker;

    public UnaryOperationTest() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void oneDividedXScenarios() {
        expressionTest("(100) 1/ 1/ 1/", "0,01", "1/( 1/( 1/( 100 ) ) )");
        expressionTest("(100) 1/ 1/", "100", "1/( 1/( 100 ) )");
        expressionTest("(2) 1/", "0,5", "1/( 2 )");
        expressionTest("(4) 1/", "0,25", "1/( 4 )");
    }

    @Test
    public void sqrScenarios() {
        expressionTest("(2) sqr sqr sqr", "256", "sqr( sqr( sqr( 2 ) ) )");
        expressionTest("(2) sqr", "4", "sqr( 2 )");
        expressionTest("(1) sqr sqr sqr", "1", "sqr( sqr( sqr( 1 ) ) )");
        expressionTest("(0,2) sqr sqr", "0,0016", "sqr( sqr( 0,2 ) )");
    }

    @Test
    public void sqrtScenarios() {
        expressionTest("(256) sqrt sqrt sqrt", "2", "√( √( √( 256 ) ) )");
        expressionTest("(2) sqrt", "1,414213562373095", "√( 2 )");
        expressionTest("(2) sqrt sqrt", "1,189207115002721", "√( √( 2 ) )");
        expressionTest("(4) sqrt", "2", "√( 4 )");
    }

    @Test
    public void plusMinusScenarios() {
        expressionTest("(265) plusMinus", "-265", "");
        expressionTest("(265) plusMinus plusMinus", "265", "");
        expressionTest("(0) plusMinus", "0", "");
        expressionTest("(10) plusMinus =", "-10", "-10 = ");
    }

    public void expressionTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelTest(mainLabelExcepted, historyLabelExcepted);
    }

    public void mainLabelTest(String mainLabelExcepted, String historyLabelExcepted) {
        String mainLabel = "#mainLabel";
        String historyLabel = "#historyLabel";
        verifyThat(historyLabel, (Label label) -> label.getText().equals(historyLabelExcepted));
        verifyThat(mainLabel, (Label label) -> label.getText().equals(mainLabelExcepted));
        clicker.click("c");
        verifyThat(mainLabel, (Label label) -> label.getText().equals("0"));
        verifyThat(historyLabel, (Label label) -> label.getText().equals(""));
    }
}
