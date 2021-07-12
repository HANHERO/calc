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
    public void boundaryScenarios() {
        /*min/max*/
        expressionTest(MAX_NUMBER + " mc", "9,999999999999999e+9999", "");
        expressionTest(MAX_NUMBER + " plusMinus mc", "-9,999999999999999e+9999", "");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER, "1e-9999", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 1e-39 ) ) ) ) ) ) ) ) × 0,000000000000001 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus", "-1e-9999", "negate( 1e-9999 )");

        //*left/right steps*/
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
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER, "1e-9999", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 1e-39 ) ) ) ) ) ) ) ) × 0,000000000000001 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (1,000000000000001) =", "1,000000000000001e-9999", "1e-9999 × 1,000000000000001 = ");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (4,999999999999999) =", "4,999999999999999e-9999", "1e-9999 × 4,999999999999999 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (5) =", "5e-9999", "1e-9999 × 5 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (5,000000000000001) =", "5,000000000000001e-9999", "1e-9999 × 5,000000000000001 = ");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (9,999999999999999) =", "9,999999999999999e-9999", "1e-9999 × 9,999999999999999 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) =", "1e-9998", "1e-9999 × 10 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10,00000000000001) =", "1,000000000000001e-9998", "1e-9999 × 10,00000000000001 = ");


        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt ms * (0,001) * (0,00000000000005) = m- " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-5000", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt ms * (0,001) * (0,00000000000005) = m- c mr mc", "1e-4999", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt ms * (0,001) * (0,0000000000005) = m+ c mr mc", "1,000000000000001e-4999", "");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (4,999999999999999) =", "4,999999999999999e-4999", "√( 1e-9998 ) × 4,999999999999999 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (5) =", "5e-4999", "√( 1e-9998 ) × 5 = ");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (5,000000000000001) =", "5,000000000000001e-4999", "√( 1e-9998 ) × 5,000000000000001 = ");

        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (10) = ms * (0,001) * (0,00000000000005) = m- " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-4999", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (10) = ms * (0,001) * (0,00000000000005) = m- c mr mc", "1e-4998", "");
        expressionTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * (10) = sqrt * (10) = ms * (0,001) * (0,0000000000005) = m+ c mr mc", "1,000000000000001e-4998", "");


        expressionTest(MIN_INPUT + " * (0,1) = ms c " + MIN_INPUT + " * (0,001) * (0,000000000000005) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-18", "");
        expressionTest(MIN_INPUT + " * (0,1) = ms c " + MIN_INPUT + " * (0,001) * (0,000000000000005) = m- c mr mc", "1e-17", "");
        expressionTest(MIN_INPUT + " * (0,1) = ms c " + MIN_INPUT + " * (0,001) * (0,0000000000001) = m+ c mr mc", "1,000000000000001e-17", "");

        expressionTest(MIN_INPUT + " * (0,5) = ms c mr mc", "5e-17", "");

        expressionTest(MIN_INPUT + " ms * (0,0000000000000001) * (0,5) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-17", "");
        expressionTest(MIN_INPUT + " ms * (0,0000000000000001) * (0,5) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e-17", ""); //0.0000000000000000999999999999999949....9

        expressionTest(MIN_INPUT + " ms * (0,0000000000000001) * (5) = m+ c mr mc", "1,000000000000001e-16", "");
        expressionTest(MIN_INPUT + " ms * (0,0000000000000001) * (5) = m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "0,0000000000000001", "");

        expressionTest(MIN_INPUT + " ms * (0,000000000000005) * (5) = m+ c mr mc", "1,000000000000025e-16", "");
        expressionTest(MIN_INPUT + " ms * (0,000000000000005) * (5) = m+ c " + MIN_INPUT + " * (0,000000000000005) * (5) = m- c mr mc", "0,0000000000000001", "");

        expressionTest("(0,0000000000000005) ms * (0,0000000000000001) = m+ c mr mc", "5,000000000000001e-16", "");
        expressionTest("(0,0000000000000005) ms * (0,0000000000000001) = m+ c (0,0000000000000005) * (0,0000000000000001) = m- c mr mc", "0,0000000000000005", "");

        expressionTest(MAX_INPUT + " + (0,5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr * (0,0000000000000001) * (0,001) = ", "9,999999999999999e-4", "0,9999999999999999 × 0,001 = ");
        expressionTest(MAX_INPUT + " + (0,5) = * (0,0000000000000001) * (0,001) = ", "0,001", "1 × 0,001 = ");

        expressionTest(MIN_INPUT + " * (0,1) + (0,001) = ", "0,001", "1e-17 + 0,001 = ");
        expressionTest(MIN_INPUT + " * (0,5) + (0,001) = ", "0,0010000000000001", "5e-17 + 0,001 = ");
        expressionTest(MIN_INPUT + " * (0,5) + (0,001) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "0,001", "");

        expressionTest(MIN_INPUT + " * (0,1) + (0,47) = ", "0,47", "1e-17 + 0,47 = ");
        expressionTest(MIN_INPUT + " * (0,5) + (0,47) = ", "0,4700000000000001", "5e-17 + 0,47 = ");
        expressionTest(MIN_INPUT + " * (0,5) + (0,47) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "0,47", "");

        expressionTest("(0,1) + (5000000000000000) = ", "5 000 000 000 000 000", "0,1 + 5000000000000000 = ");
        expressionTest("(0,5) + (5000000000000000) = ", "5 000 000 000 000 001", "0,5 + 5000000000000000 = ");
        expressionTest("(0,5) + (5000000000000000) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "5 000 000 000 000 000", "");

        expressionTest("(0,1) + (9999999999999999) = ", "9 999 999 999 999 999", "0,1 + 9999999999999999 = ");

        expressionTest(MAX_INPUT + " + (0,5) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9 999 999 999 999 999", "");    //маскимальное до экспоненты  9 999 999 999 999 999,49...9
        expressionTest(MAX_INPUT + " + (0,5) =", "1e+16", "9999999999999999 + 0,5 = ");
        expressionTest(MAX_INPUT + " + (6) = ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "1e+16", "");
        expressionTest(MAX_INPUT + " + (6) =", "1,000000000000001e+16", "9999999999999999 + 6 = ");

        expressionTest(MAX_INPUT + " + (1) * (5) = ", "5e+16", "1e+16 × 5 = ");

        expressionTest(MAX_INPUT + " + (1) * (5) = ms * (0,0000000000000001) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "4,999999999999999e+16", "");
        expressionTest(MAX_INPUT + " + (1) * (5) = ms * (0,0000000000000001) = m+ c mr mc", "5,000000000000001e+16", "");

        expressionTest(MAX_INPUT + " + (1) * (10) = ms * (0,0000000000000001) = m- c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e+16", "");
        expressionTest(MAX_INPUT + " + (1) * (10) =", "1e+17", "1e+16 × 10 = ");
        expressionTest(MAX_INPUT + " + (1) * (10) = ms * (0,000000000000001) = m+ c mr mc", "1,000000000000001e+17", "");

        expressionTest(MAX_NUMBER + " sqrt mc ms * (0,0000000000000001) * (0,5) = m- c mr mc", "9,999999999999999e+4999", "");
        expressionTest(MAX_NUMBER + " sqrt mc", "1e+5000", "√( 9,999999999999999e+9999 )");
        expressionTest(MAX_NUMBER + " sqrt mc ms * (0,0000000000000001) * (6) = m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "1,000000000000001e+5000", "");

        expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (1000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,05) = m- c mr " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "9,999999999999999e+9998", "");
        expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (1000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,05) = m- c mr mc", "1e+9999", "");
        expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (1000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,5) = m+ c mr mc", "1,000000000000001e+9999", "");

        expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (5000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,5) = m- c mr " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "4,999999999999999e+9999", "");
        expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (5000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,05) = m- c mr mc", "5e+9999", "");
        expressionTest("(1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (5000000000000000) = m+ c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr * (0,5) = m+ c mr mc", "5,000000000000001e+9999", "");

        expressionTest(MAX_NUMBER + " c (1000000000000000) sqr * (1000000000) = sqr sqr sqr sqr sqr sqr sqr sqr = m- c mr mc", "9,999999999999998e+9999", "");
        expressionTest(MAX_NUMBER + " mc", "9,999999999999999e+9999", "");
    }

    @Test
    public void subjectAreaScenarios(){
        expressionTest("(1234) + (265) =", "1 499", "1234 + 265 = ");
        expressionTest("(421,87) + (0,42) =", "422,29", "421,87 + 0,42 = ");
        expressionTest("(2341) + (54) =", "2 395", "2341 + 54 = ");
        expressionTest("(0,421) + (0,353) =", "0,774", "0,421 + 0,353 = ");
        expressionTest("(57899) + (543213) =", "601 112", "57899 + 543213 = ");
        expressionTest("(5456,74) + (532,34) =", "5 989,08", "5456,74 + 532,34 = ");
        expressionTest("(65,432) + (322) =", "387,432", "65,432 + 322 = ");
        expressionTest("(543) + (5432) =", "5 975", "543 + 5432 = ");
        expressionTest("(324,43) + (56,64) =", "381,07", "324,43 + 56,64 = ");
        expressionTest("(245,6) + (1212222) =", "1 212 467,6", "245,6 + 1212222 = ");

        expressionTest("(254) - (68) =", "186", "254 - 68 = ");
        expressionTest("(6841,5) - (651) =", "6 190,5", "6841,5 - 651 = ");
        expressionTest("(695,45) - (365,4) =", "330,05", "695,45 - 365,4 = ");
        expressionTest("(698854) - (869541) =", "-170 687", "698854 - 869541 = ");
        expressionTest("(1547) - (8561,5) =", "-7 014,5", "1547 - 8561,5 = ");
        expressionTest("(3254) - (65985) =", "-62 731", "3254 - 65985 = ");
        expressionTest("(854,55) - (785,4) =", "69,15", "854,55 - 785,4 = ");
        expressionTest("(0,5897) - (0,85751) =", "-0,26781", "0,5897 - 0,85751 = ");
        expressionTest("(2,74) - (1,77) =", "0,97", "2,74 - 1,77 = ");
        expressionTest("(123587458) - (9581) =", "123 577 877", "123587458 - 9581 = ");

        expressionTest("(0,54) * (0,057) =", "0,03078", "0,54 × 0,057 = ");
        expressionTest("(324) * (0,26) =", "84,24", "324 × 0,26 = ");
        expressionTest("(362) * (17) =", "6 154", "362 × 17 = ");
        expressionTest("(5981) * (0,7) =", "4 186,7", "5981 × 0,7 = ");
        expressionTest("(3,14) * (24) =", "75,36", "3,14 × 24 = ");
        expressionTest("(231) * (211) =", "48 741", "231 × 211 = ");
        expressionTest("(74) * (0,5) =", "37", "74 × 0,5 = ");
        expressionTest("(0,78) * (85) =", "66,3", "0,78 × 85 = ");
        expressionTest("(14,7) * (21) =", "308,7", "14,7 × 21 = ");
        expressionTest("(69,58) * (47,58) =", "3 310,6164", "69,58 × 47,58 = ");

        expressionTest("(0,533) / (0,057) =", "9,350877192982456", "0,533 ÷ 0,057 = ");
        expressionTest("(324) / (0,26) =", "1 246,153846153846", "324 ÷ 0,26 = ");
        expressionTest("(362) / (17) =", "21,29411764705882", "362 ÷ 17 = ");
        expressionTest("(5981) / (0,7) =", "8 544,285714285714", "5981 ÷ 0,7 = ");
        expressionTest("(26) / (24) =", "1,083333333333333", "26 ÷ 24 = ");
        expressionTest("(231) / (211) =", "1,09478672985782", "231 ÷ 211 = ");
        expressionTest("(74) / (0,5) =", "148", "74 ÷ 0,5 = ");
        expressionTest("(0,78) / (3,14) =", "0,2484076433121019", "0,78 ÷ 3,14 = ");
        expressionTest("(14,7) / (21) =", "0,7", "14,7 ÷ 21 = ");
        expressionTest("(69,58) / (47,58) =", "1,462379150903741", "69,58 ÷ 47,58 = ");

        expressionTest("(15) sqr", "225", "sqr( 15 )");
        expressionTest("(74) sqr", "5 476", "sqr( 74 )");
        expressionTest("(34,44) sqr", "1 186,1136", "sqr( 34,44 )");
        expressionTest("(98,4) sqr", "9 682,56", "sqr( 98,4 )");
        expressionTest("(0,07) sqr", "0,0049", "sqr( 0,07 )");
        expressionTest("(0,25) sqr", "0,0625", "sqr( 0,25 )");
        expressionTest("(3,14) sqr", "9,8596", "sqr( 3,14 )");
        expressionTest("(9) sqr", "81", "sqr( 9 )");
        expressionTest("(25) sqr", "625", "sqr( 25 )");
        expressionTest("(812322) sqr", "659 867 031 684", "sqr( 812322 )");

        expressionTest("(15) sqrt", "3,872983346207417", "√( 15 )");
        expressionTest("(74) sqrt", "8,602325267042627", "√( 74 )");
        expressionTest("(34,44) sqrt", "5,868560300448484", "√( 34,44 )");
        expressionTest("(98,4) sqrt", "9,919677414109796", "√( 98,4 )");
        expressionTest("(0,07) sqrt", "0,2645751311064591", "√( 0,07 )");
        expressionTest("(0,25) sqrt", "0,5", "√( 0,25 )");
        expressionTest("(411) sqrt", "20,27313493271329", "√( 411 )");
        expressionTest("(9) sqrt", "3", "√( 9 )");
        expressionTest("(25) sqrt", "5", "√( 25 )");
        expressionTest("(812322) sqrt", "901,2890768227473", "√( 812322 )");

        expressionTest("(42) 1/", "0,0238095238095238", "1/( 42 )");
        expressionTest("(654) 1/", "0,0015290519877676", "1/( 654 )");
        expressionTest("(11) 1/", "0,0909090909090909", "1/( 11 )");
        expressionTest("(0,32) 1/", "3,125", "1/( 0,32 )");
        expressionTest("(0,666) 1/", "1,501501501501502", "1/( 0,666 )");
        expressionTest("(453) 1/", "0,0022075055187638", "1/( 453 )");
        expressionTest("(1,321) 1/", "0,757002271006813", "1/( 1,321 )");
        expressionTest("(98) 1/", "0,0102040816326531", "1/( 98 )");
        expressionTest("(3,14) 1/", "0,3184713375796178", "1/( 3,14 )");
        expressionTest("(325) 1/", "0,0030769230769231", "1/( 325 )");

        expressionTest("(42) + (17) % =", "49,14", "42 + 7,14 = ");
        expressionTest("(42) + (17) %", "7,14", "42 + 7,14");
        expressionTest("(123) + (124) % =", "275,52", "123 + 152,52 = ");
        expressionTest("(123) + (124) %", "152,52", "123 + 152,52");
        expressionTest("(0,24) + (2,4) % =", "0,24576", "0,24 + 0,00576 = ");
        expressionTest("(0,24) + (2,4) %", "0,00576", "0,24 + 0,00576");

        expressionTest("(42) - (17) % =", "34,86", "42 - 7,14 = ");
        expressionTest("(42) - (17) %", "7,14", "42 - 7,14");
        expressionTest("(123) - (124) % =", "-29,52", "123 - 152,52 = ");
        expressionTest("(123) - (124) %", "152,52", "123 - 152,52");
        expressionTest("(0,24) - (2,4) % =", "0,23424", "0,24 - 0,00576 = ");
        expressionTest("(0,24) - (2,4) %", "0,00576", "0,24 - 0,00576");

        expressionTest("(42) / (17) % =", "247,0588235294118", "42 ÷ 0,17 = ");
        expressionTest("(42) / (17) %", "0,17", "42 ÷ 0,17");
        expressionTest("(123) / (124) % =", "99,19354838709677", "123 ÷ 1,24 = ");
        expressionTest("(123) / (124) %", "1,24", "123 ÷ 1,24");
        expressionTest("(0,24) / (2,4) % =", "10", "0,24 ÷ 0,024 = ");
        expressionTest("(0,24) / (2,4) %", "0,024", "0,24 ÷ 0,024");

        expressionTest("(42) * (17) % =", "7,14", "42 × 0,17 = ");
        expressionTest("(42) * (17) %", "0,17", "42 × 0,17");
        expressionTest("(123) * (124) % =", "152,52", "123 × 1,24 = ");
        expressionTest("(123) * (124) %", "1,24", "123 × 1,24");
        expressionTest("(0,24) * (2,4) % =", "0,00576", "0,24 × 0,024 = ");
        expressionTest("(0,24) * (2,4) %", "0,024", "0,24 × 0,024");

        expressionTest("(435) plusMinus", "-435", "");
        expressionTest("(0,32) plusMinus", "-0,32", "");
        expressionTest("(342) plusMinus", "-342", "");
        expressionTest("(0,06) plusMinus", "-0,06", "");
        expressionTest("(435) plusMinus plusMinus", "435", "");
        expressionTest("(0,32) plusMinus plusMinus", "0,32", "");
        expressionTest("(342) plusMinus plusMinus", "342", "");
        expressionTest("(0,06) plusMinus plusMinus", "0,06", "");
        expressionTest("(2) + (2) = plusMinus", "-4", "negate( 4 )");
        expressionTest("(2) - (2) = plusMinus", "0", "negate( 0 )");
        expressionTest("(2) / (2) = plusMinus", "-1", "negate( 1 )");
        expressionTest("(2) * (2) = plusMinus", "-4", "negate( 4 )");
        expressionTest("(2) sqr plusMinus", "-4", "negate( sqr( 2 ) )");
        expressionTest("(2) sqrt plusMinus", "-1,414213562373095", "negate( √( 2 ) )");
        expressionTest("(2) 1/ plusMinus", "-0,5", "negate( 1/( 2 ) )");
        expressionTest("(2) + (2) = plusMinus plusMinus", "4", "negate( negate( 4 ) )");
        expressionTest("(2) - (2) = plusMinus plusMinus", "0", "negate( negate( 0 ) )");
        expressionTest("(2) / (2) = plusMinus plusMinus", "1", "negate( negate( 1 ) )");
        expressionTest("(2) * (2) = plusMinus plusMinus", "4", "negate( negate( 4 ) )");
        expressionTest("(2) sqr plusMinus plusMinus", "4", "negate( negate( sqr( 2 ) ) )");
        expressionTest("(2) sqrt plusMinus plusMinus", "1,414213562373095", "negate( negate( √( 2 ) ) )");
        expressionTest("(2) 1/ plusMinus plusMinus", "0,5", "negate( negate( 1/( 2 ) ) )");
    }

    @Test
    public void realizationScenarios(){
        expressionTest("(1234)", "1 234", "");
        expressionTest("(23)", "23", "");
        expressionTest("(1232314)", "1 232 314", "");
        expressionTest("(543422)", "543 422", "");
        expressionTest("(1232314)", "1 232 314", "");
        expressionTest("(1596321,324)", "1 596 321,324", "");
        expressionTest("(324,1596321)", "324,1596321", "");
        expressionTest(MAX_INPUT, "9 999 999 999 999 999", "");

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
        expressionTest(MIN_INPUT, "0,0000000000000001", "");
        expressionTest("(1,00000000000001)", "1,00000000000001", "");
        expressionTest("(1,00000000000000123456)", "1,000000000000001", "");
        expressionTest("(0,00000000000000123456)", "0,0000000000000012", "");
        expressionTest("(0,99999999999999983456)", "0,9999999999999998", "");

        expressionTest("del", "0", "");
        expressionTest(MAX_INPUT + " del del del del del del del del del del del del del del del del", "0", "");
        expressionTest("(0) del", "0", "");
        expressionTest("(1) del", "0", "");
        expressionTest("(1) del del del del", "0", "");
        expressionTest("(1) plusMinus del", "0", "");

        expressionTest("(1234) del", "123", "");
        expressionTest("(1234) del del", "12", "");
        expressionTest("(1234) del del del", "1", "");

        expressionTest("(1234,2) del", "1 234,", "");
        expressionTest("(1234,2) del del", "1 234", "");

        expressionTest("(1234) + (123654) del del", "1 236", "1234 + ");
        expressionTest("(10) + (15) + (9) =", "34", "25 + 9 = ");
        expressionTest("(9) + (3) + (17) + (32) + (43) + (1) + (43) + (2) = = =", "154", "152 + 2 = ");
        expressionTest("(12) + (1) + (100) + (256) + (326) + (100)", "100", "695 + ");
        expressionTest("(10) + = = = = = = = = =", "100", "90 + 10 = ");
        expressionTest("(9) + (1) + (5) + (949) + (494) + (231) + (1512) =", "3 201", "1689 + 1512 = ");

        expressionTest("(1234) - (123654) del del", "1 236", "1234 - ");
        expressionTest("(10) - (15) - (9) =", "-14", "-5 - 9 = ");
        expressionTest("(212) - (3) - (17) - (32) - (43) - (1) - (43) - (2) = = =", "67", "69 - 2 = ");
        expressionTest("(12) - (1) - (100) - (256) - (326) - (100)", "100", "-671 - ");
        expressionTest("(10) - = = = = = = = = =", "-80", "-70 - 10 = ");
        expressionTest("(10000) - (9) - (1) - (5) - (949) - (494) - (231) - (1512) =", "6 799", "8311 - 1512 = ");

        expressionTest("(1234) / (123654) del del", "1 236", "1234 ÷ ");
        expressionTest("(150) / (15) / (10) =", "1", "10 ÷ 10 = ");
        expressionTest("(212) / (3) / (17) / (32) / (43) / (1) / (43) / (2) = = =", "8,781906488934135e-6", "1,756381297786827e-5 ÷ 2 = ");
        expressionTest("(12) / (1) / (100) / (256) / (326) / (100)", "100", "1,437883435582822e-6 ÷ ");
        expressionTest("(10) / = = = =", "0,001", "0,01 ÷ 10 = ");
        expressionTest("(9) / (1) / (5) / (5) / (658) =", "5,47112462006079e-4", "0,36 ÷ 658 = ");

        expressionTest("(1234) * (123654) del del", "1 236", "1234 × ");
        expressionTest("(10) * (15) * (9) =", "1 350", "150 × 9 = ");
        expressionTest("(212) * (3) * (17) * (32) * (43) * (1) * (43) * (2) = = =", "5 117 795 328", "2558897664 × 2 = ");
        expressionTest("(12) * (1) * (100) * (256) * (326) * (100)", "100", "100147200 × ");
        expressionTest("(10) * = = = =", "100 000", "10000 × 10 = ");
        expressionTest("(9) * (1) * (5) * (5) * (658) =", "148 050", "225 × 658 = ");

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

        expressionTest("(100) 1/ 1/ 1/", "0,01", "1/( 1/( 1/( 100 ) ) )");
        expressionTest("(100) 1/ 1/", "100", "1/( 1/( 100 ) )");
        expressionTest("(2) 1/", "0,5", "1/( 2 )");
        expressionTest("(4) 1/", "0,25", "1/( 4 )");

        expressionTest("(2) sqr sqr sqr", "256", "sqr( sqr( sqr( 2 ) ) )");
        expressionTest("(2) sqr", "4", "sqr( 2 )");
        expressionTest("(1) sqr sqr sqr", "1", "sqr( sqr( sqr( 1 ) ) )");
        expressionTest("(0,2) sqr sqr", "0,0016", "sqr( sqr( 0,2 ) )");

        expressionTest("(256) sqrt sqrt sqrt", "2", "√( √( √( 256 ) ) )");
        expressionTest("(2) sqrt", "1,414213562373095", "√( 2 )");
        expressionTest("(2) sqrt sqrt", "1,189207115002721", "√( √( 2 ) )");
        expressionTest("(4) sqrt", "2", "√( 4 )");

        expressionTest("(265) plusMinus", "-265", "");
        expressionTest("(265) plusMinus plusMinus", "265", "");
        expressionTest("(0) plusMinus", "0", "");
        expressionTest("(10) plusMinus =", "-10", "-10 = ");

        expressionTest("(100) + (20) % =", "120", "100 + 20 = ");
        expressionTest("(100) + (20) % = = =", "160", "140 + 20 = ");
        expressionTest("(100) + (20) %", "20", "100 + 20");
        expressionTest("(0,01) + (20) % =", "0,012", "0,01 + 0,002 = ");
        expressionTest("(0,01) + (20) % = = =", "0,016", "0,014 + 0,002 = ");
        expressionTest("(0,01) + (20) %", "0,002", "0,01 + 0,002");
        expressionTest("(0,01) + (0,2) % =", "0,01002", "0,01 + 0,00002 = ");
        expressionTest("(0,01) + (0,2) % = = =", "0,01006", "0,01004 + 0,00002 = ");
        expressionTest("(0,01) + (0,2) %", "0,00002", "0,01 + 0,00002");
        expressionTest("(100) - (20) % =", "80", "100 - 20 = ");
        expressionTest("(100) - (20) % = = =", "40", "60 - 20 = ");
        expressionTest("(100) - (20) %", "20", "100 - 20");
        expressionTest("(0,01) - (20) % =", "0,008", "0,01 - 0,002 = ");
        expressionTest("(0,01) - (20) % = = =", "0,004", "0,006 - 0,002 = ");
        expressionTest("(0,01) - (20) %", "0,002", "0,01 - 0,002");
        expressionTest("(0,01) - (0,2) % =", "0,00998", "0,01 - 0,00002 = ");
        expressionTest("(0,01) - (0,2) % = = =", "0,00994", "0,00996 - 0,00002 = ");
        expressionTest("(0,01) - (0,2) %", "0,00002", "0,01 - 0,00002");
        expressionTest("(100) * (20) % =", "20", "100 × 0,2 = ");
        expressionTest("(100) * (20) % = = =", "0,8", "4 × 0,2 = ");
        expressionTest("(100) * (20) %", "0,2", "100 × 0,2");
        expressionTest("(0,01) * (20) % =", "0,002", "0,01 × 0,2 = ");
        expressionTest("(0,01) * (20) % = = =", "0,00008", "0,0004 × 0,2 = ");
        expressionTest("(0,01) * (20) %", "0,2", "0,01 × 0,2");
        expressionTest("(0,01) * (0,2) % =", "0,00002", "0,01 × 0,002 = ");
        expressionTest("(0,01) * (0,2) % = = =", "0,00000000008", "0,00000004 × 0,002 = ");
        expressionTest("(0,01) * (0,2) %", "0,002", "0,01 × 0,002");
        expressionTest("(100) / (20) % =", "500", "100 ÷ 0,2 = ");
        expressionTest("(100) / (20) % = = =", "12 500", "2500 ÷ 0,2 = ");
        expressionTest("(100) / (20) %", "0,2", "100 ÷ 0,2");
        expressionTest("(0,01) / (20) % =", "0,05", "0,01 ÷ 0,2 = ");
        expressionTest("(0,01) / (20) % = = =", "1,25", "0,25 ÷ 0,2 = ");
        expressionTest("(0,01) / (20) %", "0,2", "0,01 ÷ 0,2");
        expressionTest("(0,01) / (0,2) % =", "5", "0,01 ÷ 0,002 = ");
        expressionTest("(0,01) / (0,2) % = = =", "1 250 000", "2500 ÷ 0,002 = ");
        expressionTest("(0,01) / (0,2) %", "0,002", "0,01 ÷ 0,002");

        expressionTest("(0) 1/", DIVISION_BY_ZERO, "1/( 0 )");
        expressionTest("(0) / (0) =", RESULT_UNDEFINED, "0 ÷ 0 = ");
        expressionTest("(1) - (1) / (0) =", RESULT_UNDEFINED, "0 ÷ 0 = ");

        expressionTest("- (1) = sqrt", NEGATIVE_SQRT, "√( -1 )");
        expressionTest("(1) - (2) = sqrt", NEGATIVE_SQRT, "√( -1 )");
    }

    @Test
    public void randomEquivalenceClassesScenarios() {
        expressionTest("(0,0000000000000005) * (0,0000000000000231) ms c (0,000000000000032) sqr m+ mr mc", "2,310000000000102e-14", "sqr( 0,000000000000032 )");
        expressionTest("(0,0000000000000001) * (0,0000000000000001) =", "1e-32", "0,0000000000000001 × 0,0000000000000001 = ");
        expressionTest(MIN_INPUT + " / " + MAX_INPUT + " =", "1e-32", "0,0000000000000001 ÷ 9999999999999999 = ");
        expressionTest(MIN_INPUT + " * (0,0000001) - = = = = =", "-4e-23", "-3e-23 - 1e-23 = ");
        expressionTest("(0,00000025) sqr sqr sqr sqr", "2,328306436538696e-106", "sqr( sqr( sqr( sqr( 0,00000025 ) ) ) )");
        expressionTest("(0,000000069) * (0,00000002) = = = = =", "2,208e-46", "1,104e-38 × 0,00000002 = ");
        expressionTest("(0,000000000956) * (0,000025) % =", "2,39e-16", "0,000000000956 × 0,00000025 = ");
        expressionTest("(0,00000000000956) / (2532242) % =", "3,775310574581734e-16", "0,00000000000956 ÷ 25322,42 = ");
        expressionTest(MIN_INPUT + " * " + MIN_INPUT + " - = = = = = ", "-4e-32", "-3e-32 - 1e-32 = ");
        expressionTest(MIN_INPUT + " * = = = =", "1e-80", "1e-64 × 0,0000000000000001 = ");
        expressionTest("(0,000000000021578) / (9585847859985,58) =", "2,251026754771848e-24", "0,000000000021578 ÷ 9585847859985,58 = ");
        expressionTest(MIN_INPUT + " * (0,0000000324412) - = = = = =", "-1,297648e-23", "-9,73236e-24 - 3,24412e-24 = ");
        expressionTest("(0,0000000000000003) * (0,0000000000004326) * (0,00000000021) = ms c (0,000000000009584) sqr m+ mr mc", "9,185305600000003e-23", "sqr( 0,000000000009584 )");
        expressionTest("(0,000000002) * = = = = = = / (10000) =", "1,28e-65", "1,28e-61 ÷ 10000 = ");
        expressionTest("(0,0000231) / (0,5) = = = = sqr sqr sqr", "3,482215949588381e-28", "sqr( sqr( sqr( 0,0003696 ) ) )");
        expressionTest("- (0,05484) / (48468915) = = = = = sqr", "4,203024415375744e-80", "sqr( -2,050127902199213e-40 )");
        expressionTest("(72346744532) 1/ sqr", "1,910565860169429e-22", "sqr( 1/( 72346744532 ) )");
        expressionTest("(33333) 1/ * = = = =", "2,430121503645085e-23", "8,100324008100162e-19 × 3,000030000300003e-5 = ");
        expressionTest("(9584484) / (0,000000256) = = = 1/", "1,750455840919553e-27", "1/( 5,71279764175415e+26 )");
        expressionTest("- (9999999999999) * (99999) = 1/ sqr sqrt", "1,000010000100101e-18", "√( sqr( 1/( -9,999899999999e+17 ) ) )");
        expressionTest("(0,0000005) * (0,05875) % = * = = = =", "2,187204427719116e-48", "7,445802307128906e-39 × 0,00000000029375 = ");
        expressionTest("(0,0000001) * (0,31) = = = / (3213) = = =", "8,981583356246147e-20", "2,885782732361887e-16 ÷ 3213 = ");
        expressionTest("(999) sqr sqr sqr 1/", "1,008036120330794e-24", "1/( sqr( sqr( sqr( 999 ) ) ) )");
        expressionTest("(0,4342) 1/ sqr sqr sqr sqr 1/ sqr sqr", "6,488561473854825e-24", "sqr( sqr( 1/( sqr( sqr( sqr( sqr( 1/( 0,4342 ) ) ) ) ) ) ) )");
        expressionTest("(999999) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,001024524979528e-6144", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 999999 ) ) ) ) ) ) ) ) ) ) )");
        expressionTest("(768756463574) + (442553232) % = = = = 1/", "7,348279842819386e-20", "1/( 1,360862707177902e+19 )");
        expressionTest("(99999999999) * (99999999) * (999999999) sqr sqr = = 1/", "1,00000001801e-91", "1/( 9,999999819900001e+90 )");
        expressionTest("(,4865258684) * (,0000000778) sqr sqr sqr sqr = = =", "2,845290357002842e-342", "1,57925783490972e-228 × 1,801662967317491e-114 = ");
        expressionTest("(,0002569) sqr sqr sqr sqr sqr sqr - = = = plusMinus", "3,356855668527379e-230", "negate( -3,356855668527379e-230 )");
        expressionTest("(0,0000000002) * = = = = sqr", "1,024e-97", "sqr( 3,2e-49 )");
        expressionTest("(423423535) sqr sqr sqr sqr * = 1/", "8,774052023437409e-277", "1/( 1,139724265742648e+276 )");
        expressionTest("(,000000342) * (0,3123134) * (0,00000000000321) = sqr", "1,175556517206523e-37", "sqr( 3,42863896788e-19 )");
        expressionTest(MIN_INPUT + " / " + MAX_INPUT + " = = =", "1e-64", "1e-48 ÷ 9999999999999999 = ");
        expressionTest("(0,000000000052578) / (95858478529985,5) =", "5,484960830413459e-25", "0,000000000052578 ÷ 95858478529985,5 = ");
        expressionTest("(523122) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,414306747728418e-5856", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 523122 ) ) ) ) ) ) ) ) ) ) )");
        expressionTest("(0,0000001) * (0,31132) = = = / (32213) = = =", "9,026669623453742e-23", "2,907761085803154e-18 ÷ 32213 = ");
        expressionTest("(0,00001123) / (0,511) = = = = sqr sqr sqr", "5,414635742824431e-31", "sqr( sqr( sqr( 1,6470096953913e-4 ) ) )");
        expressionTest("(71323123435) sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        expressionTest("(0,0000000000000002) * (0,0000000000002326) * (0,000000000211111) = ms c (0,0000000000095184) sqr m+ mr mc", "9,059993856000001e-23", "sqr( 0,0000000000095184 )");
        expressionTest("- (0,05484) / (48468915) = = = = = sqr", "4,203024415375744e-80", "sqr( -2,050127902199213e-40 )");

        expressionTest(MIN_INPUT + " * (0,1) + (0,0009999999999999) =", "9,9999999999991e-4", "1e-17 + 0,0009999999999999 = ");
        expressionTest(MIN_INPUT + " ms * (0,98595123) = m+ mr mc", "1,98595123e-16", "0,0000000000000001 × 0,98595123 = ");
        expressionTest("(0,00004746) ms * (0,00000000914) = m+ mr mc", "4,74600004337844e-5", "0,00004746 × 0,00000000914 = ");
        expressionTest(MIN_INPUT + " * (0,1) + (0,0000003) =", "3,0000000001e-7", "1e-17 + 0,0000003 = ");
        expressionTest("(0,00031) sqr ms sqr m+ mr mc", "9,610000923521e-8", "sqr( sqr( 0,00031 ) )");
        expressionTest("(32100) 1/", "3,115264797507788e-5", "1/( 32100 )");
        expressionTest("(0,00005321) ms * (0,00000000543) = m+ mr mc", "5,32100002889303e-5", "0,00005321 × 0,00000000543 = ");
        expressionTest("(0,000252) sqr ms sqr m+ mr mc", "6,350400403275802e-8", "sqr( sqr( 0,000252 ) )");
        expressionTest(MIN_INPUT + " * (0,2) + (0,00000064) =", "6,4000000002e-7", "2e-17 + 0,00000064 = ");
        expressionTest("(76400) 1/", "1,308900523560209e-5", "1/( 76400 )");
        expressionTest("(0,00007643) ms * (0,00000000231) = m+ mr mc", "7,64300001765533e-5", "0,00007643 × 0,00000000231 = ");
        expressionTest(MIN_INPUT + " * (0,5) + (0,000000234) =", "2,3400000005e-7", "5e-17 + 0,000000234 = ");
        expressionTest("(523100) 1/", "1,91168036704263e-6", "1/( 523100 )");
        expressionTest("(0,000731) sqr ms sqr m+ mr mc", "5,343612855416783e-7", "sqr( sqr( 0,000731 ) )");
        expressionTest("(0,000061231) ms * (0,00000000614) = m+ mr mc", "6,123100037595834e-5", "0,000061231 × 0,00000000614 = ");
        expressionTest("(734800) 1/", "1,360914534567229e-6", "1/( 734800 )");
        expressionTest("(0,000231) sqr ms sqr m+ mr mc", "5,336100284739632e-8", "sqr( sqr( 0,000231 ) )");
        expressionTest("(878000) 1/", "1,138952164009112e-6", "1/( 878000 )");
        expressionTest(MIN_INPUT + " * (0,11) + (0,00000031) =", "3,10000000011e-7", "1,1e-17 + 0,00000031 = ");
        expressionTest("(0,000005231) ms * (0,0000000322) = m+ mr mc", "5,2310001684382e-6", "0,000005231 × 0,0000000322 = ");
        expressionTest("(767000) 1/", "1,303780964797914e-6", "1/( 767000 )");
        expressionTest("(0,00008588) ms * (0,00000002311) = m+ mr mc", "8,58800019846868e-5", "0,00008588 × 0,00000002311 = ");
        expressionTest("(434200) 1/", "2,303086135421465e-6", "1/( 434200 )");
        expressionTest("(8675000) 1/", "1,152737752161383e-7", "1/( 8675000 )");
        expressionTest(MIN_INPUT + " * (0,42) + (0,0000003) =", "3,00000000042e-7", "4,2e-17 + 0,0000003 = ");
        expressionTest(MIN_INPUT + " * (0,123) + (0,0000026) =", "2,6000000000123e-6", "1,23e-17 + 0,0000026 = ");
        expressionTest("(123100) 1/", "8,123476848090983e-6", "1/( 123100 )");
        expressionTest("(0,000512) sqr ms sqr m+ mr mc", "2,621440687194767e-7", "sqr( sqr( 0,000512 ) )");
        expressionTest("(0,00005234) ms * (0,00000000121) = m+ mr mc", "5,23400000633314e-5", "0,00005234 × 0,00000000121 = ");
        expressionTest("(63400) 1/", "1,577287066246057e-5", "1/( 63400 )");
        expressionTest(MIN_INPUT + " * (0,2) + (0,0000011) =", "1,10000000002e-6", "2e-17 + 0,0000011 = ");
        expressionTest("(0,00006643) ms * (0,00000000421) = m+ mr mc", "6,64300002796703e-5", "0,00006643 × 0,00000000421 = ");
        expressionTest("(776800) 1/", "1,287332646755922e-6", "1/( 776800 )");
        expressionTest("(0,000341) sqr ms sqr m+ mr mc", "1,16281013521271e-7", "sqr( sqr( 0,000341 ) )");
        expressionTest("(0,00004234) ms * (0,00000000412) = m+ mr mc", "4,23400001744408e-5", "0,00004234 × 0,00000000412 = ");
        expressionTest(MIN_INPUT + " * (0,2) + (0,0000002) =", "2,0000000002e-7", "2e-17 + 0,0000002 = ");
        expressionTest("(512200) 1/", "1,952362358453729e-6", "1/( 512200 )");
        expressionTest("(23100) 1/", "4,329004329004329e-5", "1/( 23100 )");
        expressionTest("(0,00004231) ms * (0,00000000521) = m+ mr mc", "4,23100002204351e-5", "0,00004231 × 0,00000000521 = ");
        expressionTest("(0,00051) sqr ms sqr m+ mr mc", "2,6010006765201e-7", "sqr( sqr( 0,00051 ) )");

        expressionTest("(594845151) + (484951155698) = ", "485 546 000 849", "594845151 + 484951155698 = ");
        expressionTest("(36214) * (51155698) = ", "1 852 552 447 372", "36214 × 51155698 = ");
        expressionTest("(845682) / (42694848) = ", "0,0198075889624903", "845682 ÷ 42694848 = ");
        expressionTest("(48,4951155698) - (594845151) = ", "-594 845 102,5048844", "48,4951155698 - 594845151 = ");
        expressionTest("(10) + (2547) = ", "2 557", "10 + 2547 = ");
        expressionTest("(23655454) * (484958) = ", "11 471 901 660 932", "23655454 × 484958 = ");
        expressionTest("(100000000000000) / (4849,5115698) = ", "20 620 633 348,46815", "100000000000000 ÷ 4849,5115698 = ");
        expressionTest("(54543,39878) - (8654213312355) = ", "-8 654 213 257 811,601", "54543,39878 - 8654213312355 = ");
        expressionTest("(534532132354) + (3578654234568) = ", "4 113 186 366 922", "534532132354 + 3578654234568 = ");
        expressionTest("(34323) * (564345) = ", "19 370 013 435", "34323 × 564345 = ");
        expressionTest("(231248678995) / (51155698) = ", "4 520,487219136371", "231248678995 ÷ 51155698 = ");
        expressionTest("(0,112454867) - (484951155698) = ", "-484 951 155 697,8875", "0,112454867 - 484951155698 = ");
        expressionTest("(21238786864) + (231451155345) = ", "252 689 942 209", "21238786864 + 231451155345 = ");
        expressionTest("(23456867776) * (5698) = ", "133 657 232 587 648", "23456867776 × 5698 = ");
        expressionTest("(997845233265) / (48495698) = ", "20 575,95362922707", "997845233265 ÷ 48495698 = ");
        expressionTest("(1231514) - (48495548) = ", "-47 264 034", "1231514 - 48495548 = ");
        expressionTest("(423452211) + (484,58877445) = ", "423 452 695,5887745", "423452211 + 484,58877445 = ");
        expressionTest("(421431231) * (0,155698) = ", "65 615 999,804238", "421431231 × 0,155698 = ");
        expressionTest("(5948451512132) / (4951155698) = ", "1 201,426873837729", "5948451512132 ÷ 4951155698 = ");
        expressionTest("(594845151) - (1231553231) = ", "-636 708 080", "594845151 - 1231553231 = ");
        expressionTest("(2) sqr", "4", "sqr( 2 )");
        expressionTest("(4) sqrt", "2", "√( 4 )");
        expressionTest("(4) 1/", "0,25", "1/( 4 )");
        expressionTest("(5) plusMinus", "-5", "");
        expressionTest("(8484959) sqr", "71 994 529 231 681", "sqr( 8484959 )");
        expressionTest("(999,9999999) sqrt", "31,62277660010265", "√( 999,9999999 )");
        expressionTest("(625) 1/", "0,0016", "1/( 625 )");
        expressionTest("(595958,4845194) plusMinus", "-595 958,4845194", "");
        expressionTest("(595115) sqr", "354 161 863 225", "sqr( 595115 )");
        expressionTest("(595484136) sqrt", "24 402,54363790791", "√( 595484136 )");
        expressionTest("(8,4965) 1/", "0,1176955216853999", "1/( 8,4965 )");
        expressionTest("(95977845144) plusMinus", "-95 977 845 144", "");
        expressionTest("(59841652) sqr", "3 581 023 314 089 104", "sqr( 59841652 )");
        expressionTest("(8496584,11985) sqrt", "2 914,890069942604", "√( 8496584,11985 )");
        expressionTest("(12,55259884754265) 1/", "0,0796647779591685", "1/( 12,55259884754265 )");
        expressionTest("(999999999,8888777) plusMinus", "-999 999 999,8888777", "");
        expressionTest("(99,98887) sqr", "9 997,7741238769", "sqr( 99,98887 )");
        expressionTest("(46894125648425) sqrt", "6 847 928,566247241", "√( 46894125648425 )");
        expressionTest("(487,2136) 1/", "0,0020524878615868", "1/( 487,2136 )");
        expressionTest("(4915,88784447485) plusMinus", "-4 915,88784447485", "");

        expressionTest("(5000000000000000) * (2310000000000000) ms c (320000000000000) sqr m+ mr mc", "1,024000000000023e+29", "sqr( 320000000000000 )");
        expressionTest("(1000000000000000) * (1000000000000000) =", "1e+30", "1000000000000000 × 1000000000000000 = ");
        expressionTest(MIN_INPUT + " / " + MAX_INPUT + " = 1/", "9,999999999999999e+31", "1/( 1e-32 )");
        expressionTest(MIN_INPUT + " * (0,0000001) - = = = = = 1/", "-2,5e+22", "1/( -4e-23 )");
        expressionTest("(25000000) sqr sqr sqr sqr", "2,328306436538696e+118", "sqr( sqr( sqr( sqr( 25000000 ) ) ) )");
        expressionTest("(690000000) * (20000000) = = = = =", "2,208e+45", "1,104e+38 × 20000000 = ");
        expressionTest("(956000000000) / (0,000025) % =", "3,824e+18", "956000000000 ÷ 0,00000025 = ");
        expressionTest("(95600000000000) * (2532242) % =", "2,420823352e+18", "95600000000000 × 25322,42 = ");
        expressionTest(MIN_INPUT + " * " + MIN_INPUT + " - = = = = = 1/", "-2,5e+31", "1/( -4e-32 )");
        expressionTest(MIN_INPUT + " * = = = = 1/", "1e+80", "1/( 1e-80 )");
        expressionTest("(215780000000000) * (9585847859985,58) =", "2,068434251227688e+27", "215780000000000 × 9585847859985,58 = ");
        expressionTest(MIN_INPUT + " * (0,0000000324412) - = = = = = 1/", "-7,706250077062501e+22", "1/( -1,297648e-23 )");
        expressionTest("(3000000000000000) / (4326000000000000) * (21000000000) = ms c (958400000000000) sqr m+ mr mc", "9,1853056e+29", "sqr( 958400000000000 )");
        expressionTest("(200000000) * = = = = = = / (0,00001) =", "1,28e+63", "1,28e+58 ÷ 0,00001 = ");
        expressionTest("(2310000) / (0,5) = = = = sqr sqr sqr", "3,482215949588381e+60", "sqr( sqr( sqr( 36960000 ) ) )");
        expressionTest("- (54840) * (48468915) = = = = = sqr", "2,151928669852084e+86", "sqr( -1,466945353396671e+43 )");
        expressionTest("(72346744532) sqr", "5,234051444378472e+21", "sqr( 72346744532 )");
        expressionTest("(33333) * = = = =", "4,115020580246872e+22", "1,234518519259254e+18 × 33333 = ");
        expressionTest("(9584484) / (0,000000256) = = = ", "5,71279764175415e+26", "1,462476196289063e+20 ÷ 0,000000256 = ");
        expressionTest("- (9999999999999) * (99999) = sqr sqrt", "9,999899999999e+17", "√( sqr( -9,999899999999e+17 ) )");
        expressionTest("(5495848) / (0,05875) % = * = = = =", "7,16364753231495e+49", "7,657859033283004e+39 × 9354634893,617021 = ");
        expressionTest("(0,0000001) * (0,31) = = = / (3213) = = = 1/", "1,113389432949549e+19", "1/( 8,981583356246147e-20 )");
        expressionTest("(999) sqr sqr sqr ", "9,92027944069944e+23", "sqr( sqr( sqr( 999 ) ) )");
        expressionTest("(0,4342) sqr sqr sqr sqr 1/ sqr sqr", "1,541173654637358e+23", "sqr( sqr( 1/( sqr( sqr( sqr( sqr( 0,4342 ) ) ) ) ) ) )");
        expressionTest("(999999) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "9,989765235976125e+6143", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 999999 ) ) ) ) ) ) ) ) ) )");
        expressionTest("(768756463574) + (442553232) % = = = =", "1,360862707177902e+19", "1,020647049602338e+19 + 3,40215657575564e+18 = ");
        expressionTest("(99999999999) * (99999999) * (999999999) sqr sqr = =", "9,999999819900001e+90", "9,9999998599e+54 × 9,99999996e+35 = ");
        expressionTest("(,4865258684) * (,0000000778) sqr sqr sqr sqr = = = 1/", "3,514579795129855e+341", "1/( 2,845290357002842e-342 )");
        expressionTest("(0,0002569) sqr sqr sqr sqr sqr sqr - = = = plusMinus 1/", "2,978978242572731e+229", "1/( negate( -3,356855668527379e-230 ) )");
        expressionTest("(0,0000000002) * = = = = sqr 1/", "9,765625e+96", "1/( sqr( 3,2e-49 ) )");
        expressionTest("(423423535) sqr sqr sqr sqr * =", "1,139724265742648e+276", "sqr( sqr( sqr( sqr( 423423535 ) ) ) ) × 1,067578692997686e+138 = ");
        expressionTest("(,000000342) * (0,3123134) * (0,00000000000321) = sqr 1/", "8,506609298345788e+36", "1/( sqr( 3,42863896788e-19 ) )");
        expressionTest(MIN_INPUT + " / " + MAX_INPUT + " = = = 1/", "9,999999999999997e+63", "1/( 1e-64 )");
        expressionTest("(0,000000000052578) / (95858478529985,5) = 1/", "1,823167076153249e+24", "1/( 5,484960830413459e-25 )");
        expressionTest("(523122) sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "7,070601915787683e+5855", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 523122 ) ) ) ) ) ) ) ) ) )");
        expressionTest("(0,0000001) * (0,31132) = = = / (32213) = = = 1/", "1,107828292952838e+22", "1/( 9,026669623453742e-23 )");
        expressionTest("(11230000) / (5110) = = = = sqr sqr sqr", "5,414635742824431e-63", "sqr( sqr( sqr( 1,6470096953913e-8 ) ) )");
        expressionTest("(71323123435) sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        expressionTest("(2000000000000000) * (2326) =", "4,652e+18", "2000000000000000 × 2326 = ");
        expressionTest("- (0,05484) / (48468915) = = = = = sqr 1/", "2,379239093500725e+79", "1/( sqr( -2,050127902199213e-40 ) )");
    }

    public void expressionTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }
}