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
    public void plusScenarios() {
        /////////////////////////////////// max/min
        expressionTest("(10) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr " +  //max
                "sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr " +
                "sqr * (9999999999999999) = m+ c mr mc", "9,999999999999999e+9999", "");

       /* expressionTest("(10) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr " +  //max - smallest(1e-9999)
                "sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr " +
                "sqr * (9999999999999999) = m+ c (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr " +
                "sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr " +
                "sqr * (0,4) = m+ c (0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr " +
                "sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr " +
                "* (0,000000000000001) = m- c mr mc", "9,999999999999999e+9999", "");*/

        expressionTest("(10) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr " + //min
                "sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr " +
                "sqr * (9999999999999999) = plusMinus m+ c mr mc", "-9,999999999999999e+9999", "");

        /*expressionTest("(10) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr " +  //min + smallest(1e-9999)
                "sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr " +
                "sqr * (9999999999999999) = m+ c (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr " +
                "sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (10) sqr sqr sqr sqr sqr sqr sqr " +
                "sqr * (0,4) = m+ c mr plusMinus mc m+ c (0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr " +
                "sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr " +
                "* (0,000000000000001) = m+ c mr mc", "-9,999999999999999e+9999", "");*/

        expressionTest("(0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr " + //smallest positive
                "sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr " +
                "* (0,000000000000001) = m+ c mr mc", "1e-9999", "");

        expressionTest("(0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr " + //smallest negative
                "sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr sqr * (0,1) sqr sqr sqr sqr sqr sqr sqr sqr " +
                "* (0,000000000000001) = m+ c mr plusMinus mc", "-1e-9999", "");


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
        expressionTest("(10) * = = = =", "100 000", "10000 × 10 = ");
        expressionTest("(9) * (1) * (5) * (5) * (658) =", "148 050", "225 × 658 = ");
    }

    @Test
    public void divideScenarios() {
        expressionTest("(150) / (15) / (10) =", "1", "10 ÷ 10 = ");
        expressionTest("(212) / (3) / (17) / (32) / (43) / (1) / (43) / (2) = = =", "8,781906488934135e-6", "1,756381297786827e-5 ÷ 2 = ");
        expressionTest("(12) / (1) / (100) / (256) / (326) / (100)", "100", "1,437883435582822e-6 ÷ ");
        expressionTest("(10) / = = = =", "0,001", "0,01 ÷ 10 = ");
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
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }
}