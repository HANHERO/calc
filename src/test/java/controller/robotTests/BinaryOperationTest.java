package controller.robotTests;

import controller.sandBox.Clicker;
import org.junit.Test;
import controller.sandBox.TestingSandBox;

import java.awt.*;

public class BinaryOperationTest extends TestingSandBox {

    Clicker clicker;

    public BinaryOperationTest() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void boundariesScenarios(){
        /*min/max*/
        expressionTest(MAX_NUMBER + " mc", "9,999999999999999e+9999", "");
        expressionTest(MAX_NUMBER + " plusMinus mc", "-9,999999999999999e+9999", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER, "1e-9999", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 1e-39 ) ) ) ) ) ) ) ) × 0,000000000000001 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus", "-1e-9999", "negate( 1e-9999 )");

        /*left/right steps*/
        expressionTest(MAX_NUMBER + " " + NEAREST_TO_ZERO_POSITIVE_NUMBER +" m- c mr mc" , "9,999999999999999e+9999", "");
        expressionTest(MAX_NUMBER + " " + NEAREST_TO_ZERO_POSITIVE_NUMBER +" m+ c mr mc" , OVERFLOW, "");

        expressionTest(MAX_NUMBER + " plusMinus mc m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER +" m+ c mr mc" , "-9,999999999999999e+9999", "");
        expressionTest(MAX_NUMBER + " plusMinus mc m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER +" m- c mr mc" , OVERFLOW, "");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m+ c mr mc ", "2e-9999", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc ", "0", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (0,1) =", OVERFLOW, "1e-9999 × 0,1 = ");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus m+ c mr mc ", "-2e-9999", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus m- c mr mc ", "0", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus * (0,1) =", OVERFLOW, "negate( 1e-9999 ) × 0,1 = ");
    }

    @Test
    public void exponentScenarios(){
        expressionTest(MAX_INPUT + " + (0,5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9 999 999 999 999 999","");
        expressionTest(MAX_INPUT + " + (0,5) =", "1e+16","9999999999999999 + 0,5 = ");

        expressionTest(MAX_INPUT + " plusMinus - (0,5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m+ c mr mc", "-9 999 999 999 999 999","");
        expressionTest(MAX_INPUT + " plusMinus - (0,5) =", "-1e+16","-9999999999999999 - 0,5 = ");
    }

    public void expressionTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }
}