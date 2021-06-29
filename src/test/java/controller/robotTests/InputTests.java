package controller.robotTests;

import controller.sandBox.Clicker;
import org.junit.Test;
import controller.sandBox.TestingSandBox;

import java.awt.*;

import static org.testfx.api.FxAssert.verifyThat;

public class InputTests extends TestingSandBox {
    Clicker clicker;

    public InputTests() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void scenarios() throws InterruptedException {
        expressionTest("(1234)", "1 234", "");
        expressionTest("(23)", "23", "");
        expressionTest("(1232314)", "1 232 314", "");
        expressionTest("(543422)", "543 422", "");
        expressionTest("(1232314)", "1 232 314", "");
        expressionTest("(1596321,324)", "1 596 321,324", "");
        expressionTest("(9999999999999999)", "9 999 999 999 999 999", "");

        expressionTest("(1234) plusMinus", "-1 234", "");
        expressionTest("(23) plusMinus", "-23", "");
        expressionTest("(1232314) plusMinus", "-1 232 314", "");
        expressionTest("(543422) plusMinus", "-543 422", "");
        expressionTest("(1232314) plusMinus", "-1 232 314", "");
        expressionTest("(1596321,324) plusMinus", "-1 596 321,324", "");
        expressionTest("(9999999999999999) plusMinus", "-9 999 999 999 999 999", "");

        expressionTest("(1234) plusMinus plusMinus", "1 234", "");
        expressionTest("(23) plusMinus plusMinus", "23", "");
        expressionTest("(1232314) plusMinus plusMinus", "1 232 314", "");
        expressionTest("(543422) plusMinus plusMinus", "543 422", "");
        expressionTest("(1232314) plusMinus plusMinus", "1 232 314", "");
        expressionTest("(1596321,324) plusMinus plusMinus", "1 596 321,324", "");
        expressionTest("(9999999999999999) plusMinus plusMinus", "9 999 999 999 999 999", "");

        expressionTest("1 +", "1", "1 + ");
        expressionTest("1 -", "1", "1 - ");
        expressionTest("1 /", "1", "1 ÷ ");
        expressionTest("1 *", "1", "1 × ");

        expressionTest("(,)", "0,", "");
        expressionTest("(,1)", "0,1", "");
        expressionTest("(,1111111111111111)", "0,1111111111111111", "");
        expressionTest("(,1,,)", "0,1", "");
        expressionTest("(,1111,,11111,1111111)", "0,1111111111111111", "");
        expressionTest("(,,,)", "0,", "");
        expressionTest("(,,,1)", "0,1", "");
        expressionTest("(,,,1111111111111111)", "0,1111111111111111", "");
        expressionTest("(,,,1,1111,,111,11,111111)", "0,1111111111111111", "");
        expressionTest("(2,)", "2,", "");
        expressionTest("(2,1)", "2,1", "");
        expressionTest("(2,1111111111111111)", "2,111111111111111", "");
        expressionTest("(2,1,1111,,111,11,111111)", "2,111111111111111", "");
        expressionTest("(2,,,)", "2,", "");
        expressionTest("(2,,,1)", "2,1", "");
        expressionTest("(2,,,1111111111111111)", "2,111111111111111", "");
        expressionTest("(2,,,1,1111,,111,11,111111)", "2,111111111111111", "");
        expressionTest("(2) + (,)", "0,", "2 + ");
        expressionTest("(2) + (,1)", "0,1", "2 + ");
        expressionTest("(2) + (,1111111111111111)", "0,1111111111111111", "2 + ");
        expressionTest("(2) + (,1,1111,,111,11,111111)", "0,1111111111111111", "2 + ");
        expressionTest("(2) + (,,,)", "0,", "2 + ");
        expressionTest("(2) + (,,,1)", "0,1", "2 + ");
        expressionTest("(2) + (,,,1111111111111111)", "0,1111111111111111", "2 + ");
        expressionTest("(2) + (,,,1,1111,,111,11,111111)", "0,1111111111111111", "2 + ");

        expressionTest("(0)", "0", "");
        expressionTest("(000)", "0", "");
        expressionTest("(00000000000000000000)", "0", "");
        expressionTest("(000236)", "236", "");
        expressionTest("(000,0000000000000000)", "0,0000000000000000", "");
        expressionTest("(0000000000000000000,0000000000000000)", "0,0000000000000000", "");
        expressionTest("(0000000000000000000,1625595262626261)", "0,1625595262626261", "");
        expressionTest("(1,00000000000000)", "1,00000000000000", "");
        expressionTest("(0,000000000000001)", "0,000000000000001", "");
        expressionTest("(1,00000000000001)", "1,00000000000001", "");
        expressionTest("(1,0000000000000012)", "1,000000000000001", "");
        expressionTest("(0,00000000000000123456)", "0,0000000000000012", "");

        expressionTest("del", "0", "");
        expressionTest("(9999999999999999) del del del del del del del del del del del del del del del del", "0", "");
        expressionTest("(0) del", "0", "");
        expressionTest("(1) del", "0", "");
        expressionTest("(1) plusMinus del", "0", "");

        expressionTest("(1234) del", "123", "");
        expressionTest("(1234) del del", "12", "");
        expressionTest("(1234) del del del", "1", "");

        expressionTest("(1234,2) del", "1 234,", "");
        expressionTest("(1234,2) del del", "1 234", "");

        expressionTest("(1234) + (123654) del del", "1 236", "1234 + ");
        expressionTest("(1234) - (123654) del del", "1 236", "1234 - ");
        expressionTest("(1234) / (123654) del del", "1 236", "1234 ÷ ");
        expressionTest("(1234) * (123654) del del", "1 236", "1234 × ");

        expressionTest("(2) sqr", "4", "sqr( 2 )");
        expressionTest("(2) sqr sqr", "16", "sqr( sqr( 2 ) )");

        expressionTest("(16) sqrt", "4", "√( 16 )");
        expressionTest("(16) sqrt sqrt", "2", "√( √( 16 ) )");

        expressionTest("(2) 1/", "0,5", "1/( 2 )");
        expressionTest("(2) 1/ 1/", "2", "1/( 1/( 2 ) )");

        expressionTest("(2) sqr sqr sqrt", "4", "√( sqr( sqr( 2 ) ) )");
        expressionTest("(2) sqr sqr sqrt sqrt", "2", "√( √( sqr( sqr( 2 ) ) ) )");
        expressionTest("(2) sqr + (3)", "3", "sqr( 2 ) + ");
        expressionTest("(3) + (2) sqr", "4", "3 + sqr( 2 )");
        expressionTest("(2) sqr + (9) sqrt", "3", "sqr( 2 ) + √( 9 )");

        expressionTest("(10) + (15) - (9) sqrt =", "22", "25 - √( 9 ) = ");
        expressionTest("(9) sqrt + (3) sqr =", "12", "√( 9 ) + sqr( 3 ) = ");
        expressionTest("(9) sqrt + (12) =", "15", "√( 9 ) + 12 = ");
        expressionTest("(9) + = = = = = = = = =", "90", "81 + 9 = ");
        expressionTest("(9) + (1) =", "10", "9 + 1 = ");
        expressionTest("(9) sqrt sqr sqrt sqr sqrt =", "3", "√( sqr( √( sqr( √( 9 ) ) ) ) ) = ");
        expressionTest("(9) sqrt sqr sqrt sqr sqrt = =", "3", "3 = ");
    }

    public void expressionTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }

    /*public void mainLabelTest(String mainLabelExcepted, String historyLabelExcepted) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        String historyLabel = "#historyLabel";
        verifyThat(historyLabel, (Label label) -> label.getText().equals(historyLabelExcepted));
        verifyThat(mainLabel, (Label label) -> label.getText().equals(mainLabelExcepted));
        clicker.click("c");
        verifyThat(mainLabel, (Label label) -> label.getText().equals("0"));
        verifyThat(historyLabel, (Label label) -> label.getText().equals(""));
    }*/
}