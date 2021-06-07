package robotTests;

import javafx.scene.control.Label;
import org.junit.Test;
import sandBox.TestingSandBox;

import java.awt.*;

import static org.testfx.api.FxAssert.verifyThat;

public class BinaryOperationTest extends TestingSandBox {

    Clicker clicker;
    public BinaryOperationTest() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void plusScenarios() {
        expressionTest("(10) + (15) + (9) =", "34", "25 + 9 = ");
        expressionTest("(9) + (3) + (17) + (32) + (43) + (1) + (43) + (2) = = =", "154", "152 + 2 = ");
        expressionTest("(12) + (1) + (100) + (256) + (326) + (100)", "100", "695 + ");
        expressionTest("(10) + = = = = = = = = =", "100", "90 + 10 = ");
        expressionTest("(9) + (1) + (5) + (949) + (494) + (231) + (1512) =", "3 201", "1689 + 1512 = ");
    }

    @Test
    public void minusScenarios() {
        expressionTest("(10) - (15) - (9) =", "-14", "-5 - 9 = ");
        expressionTest("(212) - (3) - (17) - (32) - (43) - (1) - (43) - (2) = = =", "67", "69 - 2 = ");
        expressionTest("(12) - (1) - (100) - (256) - (326) - (100)", "100", "-671 - ");
        expressionTest("(10) - = = = = = = = = =", "-80", "-70 - 10 = ");
        expressionTest("(10000) - (9) - (1) - (5) - (949) - (494) - (231) - (1512) =", "6 799", "8311 - 1512 = ");
    }

    @Test
    public void multiplyScenarios() {
        expressionTest("(10) * (15) * (9) =", "1 350", "150 × 9 = ");
        expressionTest("(212) * (3) * (17) * (32) * (43) * (1) * (43) * (2) = = =", "5 117 795 328", "2558897664 × 2 = ");
        expressionTest("(12) * (1) * (100) * (256) * (326) * (100)", "100", "100147200 × ");
        expressionTest("(10) * = = =", "10 000", "1000 × 10 = ");
        expressionTest("(9) * (1) * (5) * (5) * (658) =", "148 050", "225 × 658 = ");
    }

    @Test
    public void divideScenarios() {
        expressionTest("(150) / (15) / (10) =", "1", "10 ÷ 10 = ");
        expressionTest("(212) / (3) / (17) / (32) / (43) / (1) / (43) / (2) = = =", "8,781906488934135e-6", "1,756381297786827e-5 ÷ 2 = ");
        expressionTest("(12) / (1) / (100) / (256) / (326) / (100)", "100", "1,437883435582822e-6 ÷ ");
        expressionTest("(10) / = = =", "0,01", "0,1 ÷ 10 = ");
        expressionTest("(9) / (1) / (5) / (5) / (658) =", "5,47112462006079e-4", "0,36 ÷ 658 = ");
    }

    @Test
    public void percentScenarios() {
        expressionTest("(100) + (20) % =", "120", "100 + 20 = ");
        expressionTest("(100) - (20) % =", "80", "100 - 20 = ");
        expressionTest("(100) * (20) % =", "20", "100 × 0,2 = ");
        expressionTest("(100) / (20) % =", "500", "100 ÷ 0,2 = ");
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