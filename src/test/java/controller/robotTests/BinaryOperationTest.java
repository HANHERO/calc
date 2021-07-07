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
    public void boundariesScenarios() {
        /*min/max*/
        expressionTest(MAX_NUMBER + " mc", "9,999999999999999e+9999", "");
        expressionTest(MAX_NUMBER + " plusMinus mc", "-9,999999999999999e+9999", "");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER, "1e-9999", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 1e-39 ) ) ) ) ) ) ) ) × 0,000000000000001 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus", "-1e-9999", "negate( 1e-9999 )");

        /*left/right steps*/
        expressionTest(MAX_NUMBER + " " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e+9999", "");
        expressionTest(MAX_NUMBER + " " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m+ c mr mc", OVERFLOW, "");

        expressionTest(MAX_NUMBER + " plusMinus mc m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m+ c mr mc", "-9,999999999999999e+9999", "");
        expressionTest(MAX_NUMBER + " plusMinus mc m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", OVERFLOW, "");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m+ c mr mc ", "2e-9999", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (0,9999999999999999) =", OVERFLOW, "1e-9999 × 0,9999999999999999 = ");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus m+ c mr mc ", "-2e-9999", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus * (0,9999999999999999) =", OVERFLOW, "negate( 1e-9999 ) × 0,9999999999999999 = ");
    }

    @Test
    public void equivalenceClassesScenarios() {
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER, "1e-9999", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 1e-39 ) ) ) ) ) ) ) ) × 0,000000000000001 = ");
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (1,000000000000001) =", "1,000000000000001e-9999", "1e-9999 × 1,000000000000001 = ");

        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (5) =", "5e-9999", "1e-9999 × 5 = ");

        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (9,999999999999999) =", "9,999999999999999e-9999", "1e-9999 × 9,999999999999999 = ");
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10)  =", "1e-9998", "1e-9999 × 10 = ");
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10,00000000000001) =", "1,000000000000001e-9998", "1e-9999 × 10,00000000000001 = ");


        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt ms * (0,001) * (0,00000000000005) = m- " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-5000", "");
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt ms * (0,001) * (0,00000000000005) = m- c mr mc", "1e-4999", "");
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt ms * (0,001) * (0,0000000000005) = m+ c mr mc", "1,000000000000001e-4999", "");

        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (5) =", "5e-4999", "√( 1e-9998 ) × 5 = ");

        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (10) = ms * (0,001) * (0,00000000000005) = m- " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-4999", "");
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (10) = ms * (0,001) * (0,00000000000005) = m- c mr mc", "1e-4998", "");
        //expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (10) = ms * (0,001) * (0,0000000000005) = m+ c mr mc", "1,000000000000001e-4998", "");


        //expressionTest(MIN_INPUT + " * (0,1) = ms c " + MIN_INPUT + " * (0,001) * (0,000000000000005) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-18", "");
        //expressionTest(MIN_INPUT + " * (0,1) = ms c " + MIN_INPUT + " * (0,001) * (0,000000000000005) = m- c mr mc", "1e-17", "");
        //expressionTest(MIN_INPUT + " * (0,1) = ms c " + MIN_INPUT + " * (0,001) * (0,0000000000001) = m+ c mr mc", "1,000000000000001e-17", "");

        //expressionTest(MIN_INPUT + " * (0,5) = ms c mr mc", "5e-17", "");

        //expressionTest(MIN_INPUT + " ms c (0,000000000000001) * (0,000000000000001) * (0,005) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER +" m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER +" m- c mr mc", "9,999999999999999e-17", "");
        //expressionTest(MIN_INPUT + " ms c (0,000000000000001) * (0,000000000000001) * (0,005) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER +" m- c mr mc", "9,999999999999999e-17", ""); //0.0000000000000000999999999999999949....9

        expressionTest(MIN_INPUT + " ms c (0,000000000000001) * (0,000000000000001) * (0,005) = m- c mr mc", "0,0000000000000001", ""); //максимально малое до экспоненты 0.000000000000000099999999999999995




        //expressionTest(MAX_INPUT + " + (0,5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9 999 999 999 999 999", "");    //маскимальное до экспоненты  9 999 999 999 999 999,49...9
        //expressionTest(MAX_INPUT + " + (0,5) =", "1e+16", "9999999999999999 + 0,5 = ");




        //expressionTest(MAX_NUMBER + " mc", "9,999999999999999e+9999", "");




        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //expressionTest(MAX_INPUT + " + (0,5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m+ c mr mc", "1e+16", "");

        //expressionTest(MAX_INPUT + " + (1) + (5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc ", "1e+16", "");
        //expressionTest(MAX_INPUT + " + (1) + (5) =", "1,000000000000001e+16", "1e+16 + 5 = ");

        //expressionTest(MAX_INPUT + " + (1) * (10) - (5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc ", "9,999999999999999e+16", "");
        //expressionTest(MAX_INPUT + " + (1) * (10) - (5) =", "1e+17", "1e+17 - 5 = ");

        //expressionTest(MAX_NUMBER + " c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr = m- c mr", "9,999999999999998e+9999", "");

        //expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (1000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,05) = m- c mr mc", "1e+9999", "");
        //expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (1000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,05) = m- c mr " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e+9998", "");




        //expressionTest("(594845151) + (484951155698) = ", "485 546 000 849", "594845151 + 484951155698 = ");
        //expressionTest("(36214) * (51155698) = ", "1 852 552 447 372", "36214 × 51155698 = ");
        //expressionTest("(845682) / (42694848) = ", "0,0198075889624903", "845682 ÷ 42694848 = ");
        //expressionTest("(48,4951155698) - (594845151) = ", "-594 845 102,5048844", "48,4951155698 - 594845151 = ");
        //expressionTest("(10) + (2547) = ", "2 557", "10 + 2547 = ");
        //expressionTest("(23655454) * (484958) = ", "11 471 901 660 932", "23655454 × 484958 = ");
        //expressionTest("(100000000000000) / (4849,5115698) = ", "20 620 633 348,46815", "100000000000000 ÷ 4849,5115698 = ");
        //expressionTest("(54543,39878) - (8654213312355) = ", "-8 654 213 257 811,601", "54543,39878 - 8654213312355 = ");
        //expressionTest("(534532132354) + (3578654234568) = ", "4 113 186 366 922", "534532132354 + 3578654234568 = ");
        //expressionTest("(34323) * (564345) = ", "19 370 013 435", "34323 × 564345 = ");
        //expressionTest("(231248678995) / (51155698) = ", "4 520,487219136371", "231248678995 ÷ 51155698 = ");
        //expressionTest("(0,112454867) - (484951155698) = ", "-484 951 155 697,8875", "0,112454867 - 484951155698 = ");
        //expressionTest("(21238786864) + (231451155345) = ", "252 689 942 209", "21238786864 + 231451155345 = ");
        //expressionTest("(23456867776) * (5698) = ", "133 657 232 587 648", "23456867776 × 5698 = ");
        //expressionTest("(997845233265) / (48495698) = ", "20 575,95362922707", "997845233265 ÷ 48495698 = ");
        //expressionTest("(1231514) - (48495548) = ", "-47 264 034", "1231514 - 48495548 = ");
        //expressionTest("(423452211) + (484,58877445) = ", "423 452 695,5887745", "423452211 + 484,58877445 = ");
        //expressionTest("(421431231) * (0,155698) = ", "65 615 999,804238", "421431231 × 0,155698 = ");
        //expressionTest("(5948451512132) / (4951155698) = ", "1 201,426873837729", "5948451512132 ÷ 4951155698 = ");
        //expressionTest("(594845151) - (1231553231) = ", "-636 708 080", "594845151 - 1231553231 = ");
        //expressionTest("(2) sqr", "4", "sqr( 2 )");
        //expressionTest("(4) sqrt", "2", "√( 4 )");
        //expressionTest("(4) 1/", "0,25", "1/( 4 )");
        //expressionTest("(5) plusMinus", "-5", "");
        //expressionTest("(8484959) sqr", "71 994 529 231 681", "sqr( 8484959 )");
        //expressionTest("(999,9999999) sqrt", "31,62277660010265", "√( 999,9999999 )");
        //expressionTest("(625) 1/", "0,0016", "1/( 625 )");
        //expressionTest("(595958,4845194) plusMinus", "-595 958,4845194", "");
        //expressionTest("(595115) sqr", "354 161 863 225", "sqr( 595115 )");
        //expressionTest("(595484136) sqrt", "24 402,54363790791", "√( 595484136 )");
        //expressionTest("(8,4965) 1/", "0,1176955216853999", "1/( 8,4965 )");
        //expressionTest("(95977845144) plusMinus", "-95 977 845 144", "");
        //expressionTest("(59841652) sqr", "3 581 023 314 089 104", "sqr( 59841652 )");
        //expressionTest("(8496584,11985) sqrt", "2 914,890069942604", "√( 8496584,11985 )");
        //expressionTest("(12,55259884754265) 1/", "0,0796647779591685", "1/( 12,55259884754265 )");
        //expressionTest("(999999999,8888777) plusMinus", "-999 999 999,8888777", "");
        //expressionTest("(99,98887) sqr", "9 997,7741238769", "sqr( 99,98887 )");
        //expressionTest("(46894125648425) sqrt", "6 847 928,566247241", "√( 46894125648425 )");
        //expressionTest("(487,2136) 1/", "0,0020524878615868", "1/( 487,2136 )");
        //expressionTest("(4915,88784447485) plusMinus", "-4 915,88784447485", "");
    }

    public void expressionTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }
}