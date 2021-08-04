package controller.robotTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class EquivalenceClassesTest extends TestingSandBox {

    @Test
    public void boundaryScenarios() {
        /*min/max*/
        mouseInputTest(MAX_NUMBER, "9,999999999999999e+9999", "");
        mouseInputTest(MAX_NUMBER + " plusMinus", "-9,999999999999999e+9999", "");

        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER, "1e-9999", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 1e-39 ) ) ) ) ) ) ) ) × 0,000000000000001 = ");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus", "-1e-9999", "");

        /*left/right steps*/
        mouseInputTest(MAX_NUMBER + " 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr / 1000000000000000 / 1000 = m- c mr mc", "9,999999999999999e+9999", "");
        mouseInputTest(MAX_NUMBER + " 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr / 1000000000000000 / 1000 = m+ c mr mc", OVERFLOW, "");

        mouseInputTest(MAX_NUMBER + " plusMinus mc m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr / 1000000000000000 / 1000 = m+ c mr mc", "-9,999999999999999e+9999", "");
        mouseInputTest(MAX_NUMBER + " plusMinus mc m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr / 1000000000000000 / 1000 = m- c mr mc", OVERFLOW, "");

        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m+ c mr mc ", "2e-9999", "");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 0,9999999999999999 =", OVERFLOW, "1e-9999 × 0,9999999999999999 = ");

        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus ms c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus m+ c mr mc ", "-2e-9999", "");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus * 0,9999999999999999 =", OVERFLOW, "-1e-9999 × 0,9999999999999999 = ");
    }

    @Test
    public void equivalenceClassesScenarios() {
        //First equivalence class 1e-9999 - 9,999999999999999e-17
        //Going beyond the lower bound of the equivalence class (left step).
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 0,9999999999999999 =", OVERFLOW, "1e-9999 × 0,9999999999999999 = ");
        //The lower bound for the equivalence class.
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER, "1e-9999", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 1e-39 ) ) ) ) ) ) ) ) × 0,000000000000001 = ");
        //The closest point to the boundary of the equivalence class (right step).
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 1,000000000000001 =", "1,000000000000001e-9999", "1e-9999 × 1,000000000000001 = ");


        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 4,999999999999999 =", "4,999999999999999e-9999", "1e-9999 × 4,999999999999999 = ");
        //A random point in this equivalence class and points to the left and right of it.
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 5 =", "5e-9999", "1e-9999 × 5 = ");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 5,000000000000001 =", "5,000000000000001e-9999", "1e-9999 × 5,000000000000001 = ");

        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 9,999999999999999 =", "9,999999999999999e-9999", "1e-9999 × 9,999999999999999 = ");
        //A random point in this equivalence class and points to the left and right of it.
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 =", "1e-9998", "1e-9999 × 10 = ");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10,00000000000001 =", "1,000000000000001e-9998", "1e-9999 × 10,00000000000001 = ");

        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt ms * 0,001 * 0,00000000000005 = m- " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " sqrt * 0,0000000000000001 sqr = m- c mr mc", "9,999999999999999e-5000", "");
        //A random point in this equivalence class and points to the left and right of it.
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt ms * 0,001 * 0,00000000000005 = m- c mr mc", "1e-4999", "");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt ms * 0,001 * 0,0000000000005 = m+ c mr mc", "1,000000000000001e-4999", "");

        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt * 4,999999999999999 =", "4,999999999999999e-4999", "√( 1e-9998 ) × 4,999999999999999 = ");
        //The point in the middle of the equivalence class and points to the right and left of it.
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt * 5 =", "5e-4999", "√( 1e-9998 ) × 5 = ");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt * 5,000000000000001 =", "5,000000000000001e-4999", "√( 1e-9998 ) × 5,000000000000001 = ");

        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt * 10 = ms * 0,001 * 0,00000000000005 = m- " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " sqrt * 0,0000000000000001 sqr =  m- c mr mc", "9,999999999999999e-4999", "");
        //A random point in this equivalence class and points to the left and right of it.
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt * 10 = ms * 0,001 * 0,00000000000005 = m- c mr mc", "1e-4998", "");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 10 = sqrt * 10 = ms * 0,001 * 0,0000000000005 = m+ c mr mc", "1,000000000000001e-4998", "");

        mouseInputTest(MIN_INPUT + " * 0,1 = ms c " + MIN_INPUT + " * 0,001 * 0,000000000000005 = m- c 0,0000000000000001 sqr * 0,1 = m- c mr mc", "9,999999999999999e-18", "");
        //A random point in this equivalence class and points to the left and right of it.
        mouseInputTest(MIN_INPUT + " * 0,1 = ms c " + MIN_INPUT + " * 0,001 * 0,000000000000005 = m- c mr mc", "1e-17", "");
        mouseInputTest(MIN_INPUT + " * 0,1 = ms c " + MIN_INPUT + " * 0,001 * 0,0000000000001 = m+ c mr mc", "1,000000000000001e-17", "");

        //Point to the left of the right border of the first equivalence class.
        mouseInputTest(MIN_INPUT + " ms * 0,0000000000000001 * 0,5000000000000001 = m- c " + MIN_INPUT + " * 0,0000000000000001 = m- c mr mc", "9,999999999999998e-17", "");
        //The right boundary of the first equivalence class and the left step from the left boundary of the second equivalence class.
        mouseInputTest(MIN_INPUT + " ms * 0,0000000000000001 * 0,5000000000000001 = m- c mr mc", "9,999999999999999e-17", "");
        //The left boundary of the second equivalence class and right step from the right boundary of the second equivalence class
        mouseInputTest(MIN_INPUT, "0,0000000000000001", "");
        //The right step from the left border of the second equivalence class.
        mouseInputTest(MIN_INPUT + " ms * 0,0000000000000001 * 5 = m+ c mr mc", "1,000000000000001e-16", "");

        //Random points in second equivalence class
        mouseInputTest(MIN_INPUT + " ms * 0,000000000000005 * 5 = m+ c mr mc", "1,000000000000025e-16", "");
        mouseInputTest(MIN_INPUT + " ms * 0,000000000000005 * 5 = m+ c " + MIN_INPUT + " * 0,000000000000005 * 5 = m- c mr mc", "0,0000000000000001", "");

        //Random points in second equivalence class
        mouseInputTest("0,0000000000000005 ms * 0,0000000000000001 = m+ c mr mc", "5,000000000000001e-16", "");
        mouseInputTest("0,0000000000000005 ms * 0,0000000000000001 = m+ c 0,0000000000000005 * 0,0000000000000001 = m- c mr mc", "0,0000000000000005", "");

        //Left step from the right boundary of the second equivalence class.
        mouseInputTest(MAX_INPUT + " + 0,5 = - 0,0000000000000001 = ms c mr * 0,0000000000000001 * 0,001 = mc ms " + MIN_INPUT + " * 0,001 = m- c mr mc", "9,999999999999998e-4", "");
        //Right boundary of the second equivalence class and left step from the left boundary of the third equivalence class.
        mouseInputTest(MAX_INPUT + " + 0,5 = - 0,0000000000000001 = ms c mr * 0,0000000000000001 * 0,001 = ", "9,999999999999999e-4", "0,9999999999999999 × 0,001 = ");
        //Left boundary of the third equivalence class and right step from the right boundary of the second equivalence class.
        mouseInputTest(MAX_INPUT + " + 0,5 = * 0,0000000000000001 * 0,001 = ", "0,001", "1 × 0,001 = ");
        //Right step from the left boundary of the third equivalence class.
        mouseInputTest(MIN_INPUT + " * 0,5 + 0,001 = ", "0,0010000000000001", "5e-17 + 0,001 = ");
        //Random points.
        mouseInputTest(MIN_INPUT + " * 0,05 + 0,001 = ms c mr mc", "0,001", "");
        mouseInputTest(MIN_INPUT + " * 0,1 + 0,47 = ", "0,47", "1e-17 + 0,47 = ");
        mouseInputTest(MIN_INPUT + " * 0,5 + 0,47 = ", "0,4700000000000001", "5e-17 + 0,47 = ");
        mouseInputTest(MIN_INPUT + " * 0,5 + 0,47 = ms c 0,0000000000000001 sqr m- c mr mc", "0,47", "");


        mouseInputTest("0,1 + 5000000000000000 = ", "5 000 000 000 000 000", "0,1 + 5000000000000000 = ");
        //The middle of the third equivalence class and points to the left and right of it.
        mouseInputTest("0,5 + 5000000000000000 = ", "5 000 000 000 000 001", "0,5 + 5000000000000000 = ");
        mouseInputTest("0,5 + 5000000000000000 = ms c 0,0000000000000001 m- c mr mc", "5 000 000 000 000 000", "");

        //Random point.
        mouseInputTest("0,1 + 9999999999999999 = ", "9 999 999 999 999 999", "0,1 + 9999999999999999 = ");

        //Left step from the right boundary of the third equivalence class
        mouseInputTest(MAX_INPUT + " - 0,51 = ", "9 999 999 999 999 998", "9999999999999999 - 0,51 = ");
        //The right boundary of the third equivalence class and the left step from the boundary of the fourth equivalence class.
        mouseInputTest(MAX_INPUT + " + 0,5 = ms c 0,0000000000000001 m- c mr mc", "9 999 999 999 999 999", "");    //маскимальное до экспоненты  9 999 999 999 999 999,49...9
        //The left boundary of the fourth equivalence class and the right step from the right boundary of the third equivalence class.
        mouseInputTest(MAX_INPUT + " + 0,5 =", "1e+16", "9999999999999999 + 0,5 = ");
        //The right step from the left border of the fourth equivalence class.
        mouseInputTest(MAX_INPUT + " + 6 =", "1,000000000000001e+16", "9999999999999999 + 6 = ");

        //Random points.
        mouseInputTest(MAX_INPUT + " + 1 * 5 = ", "5e+16", "1e+16 × 5 = ");
        mouseInputTest(MAX_INPUT + " + 1 * 5 = ms * 0,0000000000000002 = m- c mr mc", "4,999999999999999e+16", "");
        mouseInputTest(MAX_INPUT + " + 1 * 5 = ms * 0,0000000000000001 = m+ c mr mc", "5,000000000000001e+16", "");
        mouseInputTest(MAX_INPUT + " + 1 * 10 = ms * 0,0000000000000001 = m- c mr mc", "9,999999999999999e+16", "");
        mouseInputTest(MAX_INPUT + " + 1 * 10 =", "1e+17", "1e+16 × 10 = ");
        mouseInputTest(MAX_INPUT + " + 1 * 10 = ms * 0,000000000000001 = m+ c mr mc", "1,000000000000001e+17", "");

        mouseInputTest(MAX_NUMBER + " sqrt mc ms * 0,0000000000000001 * 0,5 = m- c mr mc", "9,999999999999999e+4999", "");
        //The middle of the fourth equivalence class and the left one with the right step from it.
        mouseInputTest(MAX_NUMBER + " sqrt mc", "1e+5000", "√( 9,999999999999999e+9999 )");
        mouseInputTest(MAX_NUMBER + " sqrt mc ms * 0,0000000000000001 * 6 = m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER + " m- c mr mc", "1,000000000000001e+5000", "");

        //Random points.
        mouseInputTest("1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 1000000000000000 = m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,06 = m- c mr mc", "9,999999999999999e+9998", "");
        mouseInputTest(MAX_NUMBER + " / " + MAX_INPUT + " * 1000000000000000 =", "1e+9999", "1e+9984 × 1000000000000000 = ");
        mouseInputTest("1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 1000000000000000 = m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,5 = m+ c mr mc", "1,000000000000001e+9999", "");
        mouseInputTest("1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 5000000000000000 = m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,6 = m- c mr mc", "4,999999999999999e+9999", "");
        mouseInputTest("1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 5000000000000000 = m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,05 = m- c mr mc", "5e+9999", "");
        mouseInputTest("1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 5000000000000000 = m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,5 = m+ c mr mc", "5,000000000000001e+9999", "");
        //Left step from the right boundary of the fourth equivalence class.
        mouseInputTest(MAX_NUMBER + " c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr = m- c mr mc", "9,999999999999998e+9999", "");
        //Right bounds of the fourth equivalence class.
        mouseInputTest(MAX_NUMBER + " mc", "9,999999999999999e+9999", "");
        //The right step from the right boundary of the fourth equivalence class.
        mouseInputTest(MAX_NUMBER + " 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr / 1000000000000000 / 1000 = m+ c mr mc", OVERFLOW, "");
    }

    @Test
    public void realizationScenarios() {
        mouseInputTest("1234", "1 234", "");
        mouseInputTest("23", "23", "");
        mouseInputTest("1232314", "1 232 314", "");
        mouseInputTest("543422", "543 422", "");
        mouseInputTest("1232314", "1 232 314", "");
        mouseInputTest("1596321,324", "1 596 321,324", "");
        mouseInputTest("324,1596321", "324,1596321", "");
        mouseInputTest(MAX_INPUT, "9 999 999 999 999 999", "");

        mouseInputTest("1 +", "1", "1 + ");
        mouseInputTest("1 -", "1", "1 - ");
        mouseInputTest("1 /", "1", "1 ÷ ");
        mouseInputTest("1 *", "1", "1 × ");

        mouseInputTest(",", "0,", "");
        mouseInputTest(",1", "0,1", "");
        mouseInputTest(",1111111111111111", "0,1111111111111111", "");
        mouseInputTest(",1,,", "0,1", "");
        mouseInputTest(",1111,,11111,1111111", "0,1111111111111111", "");
        mouseInputTest(",,,", "0,", "");
        mouseInputTest(",,,1", "0,1", "");
        mouseInputTest(",,,1111111111111111", "0,1111111111111111", "");
        mouseInputTest(",,,1,1111,,111,11,111111", "0,1111111111111111", "");
        mouseInputTest("2,", "2,", "");
        mouseInputTest("2,1", "2,1", "");
        mouseInputTest("2,1111111111111111", "2,111111111111111", "");
        mouseInputTest("2,1,1111,,111,11,111111", "2,111111111111111", "");
        mouseInputTest("2,,,", "2,", "");
        mouseInputTest("2,,,1", "2,1", "");
        mouseInputTest("2,,,1111111111111111", "2,111111111111111", "");
        mouseInputTest("2,,,1,1111,,111,11,111111", "2,111111111111111", "");

        mouseInputTest("2 + ,", "0,", "2 + ");
        mouseInputTest("2 + ,1", "0,1", "2 + ");
        mouseInputTest("2 + ,1111111111111111", "0,1111111111111111", "2 + ");
        mouseInputTest("2 + ,1,1111,,111,11,111111", "0,1111111111111111", "2 + ");
        mouseInputTest("2 + ,,,", "0,", "2 + ");
        mouseInputTest("2 + ,,,1", "0,1", "2 + ");
        mouseInputTest("2 + ,,,1111111111111111", "0,1111111111111111", "2 + ");
        mouseInputTest("2 + ,,,1,1111,,111,11,111111", "0,1111111111111111", "2 + ");

        mouseInputTest("0", "0", "");
        mouseInputTest("000", "0", "");
        mouseInputTest("00000000000000000000", "0", "");
        mouseInputTest("000236", "236", "");
        mouseInputTest("000,0000000000000000", "0,0000000000000000", "");
        mouseInputTest("0000000000000000000,0000000000000000", "0,0000000000000000", "");
        mouseInputTest("0000000000000000000,1625595262626261", "0,1625595262626261", "");
        mouseInputTest("1,00000000000000", "1,00000000000000", "");
        mouseInputTest(MIN_INPUT, "0,0000000000000001", "");
        mouseInputTest("1,00000000000001", "1,00000000000001", "");
        mouseInputTest("1,00000000000000123456", "1,000000000000001", "");
        mouseInputTest("0,00000000000000123456", "0,0000000000000012", "");
        mouseInputTest("0,99999999999999983456", "0,9999999999999998", "");

        mouseInputTest("del", "0", "");
        mouseInputTest(MAX_INPUT + " del del del del del del del del del del del del del del del del", "0", "");
        mouseInputTest("0 del", "0", "");
        mouseInputTest("1 del", "0", "");
        mouseInputTest("1 del del del del", "0", "");
        mouseInputTest("1 plusMinus del", "0", "");
        mouseInputTest("4324 plusMinus", "-4 324", "");

        mouseInputTest("1234 del", "123", "");
        mouseInputTest("1234 del del", "12", "");
        mouseInputTest("1234 del del del", "1", "");

        mouseInputTest("1234,2 del", "1 234,", "");
        mouseInputTest("1234,2 del del", "1 234", "");

        mouseInputTest("1234 + 123654 del del", "1 236", "1234 + ");
        mouseInputTest("10 + 15 + 9 =", "34", "25 + 9 = ");
        mouseInputTest("9 + 3 + 17 + 32 + 43 + 1 + 43 + 2 = = =", "154", "152 + 2 = ");
        mouseInputTest("12 + 1 + 100 + 256 + 326 + 100", "100", "695 + ");
        mouseInputTest("10 + = = = = = = = = =", "100", "90 + 10 = ");
        mouseInputTest("9 + 1 + 5 + 949 + 494 + 231 + 1512 =", "3 201", "1689 + 1512 = ");

        mouseInputTest("1234 - 123654 del del", "1 236", "1234 - ");
        mouseInputTest("10 - 15 - 9 =", "-14", "-5 - 9 = ");
        mouseInputTest("212 - 3 - 17 - 32 - 43 - 1 - 43 - 2 = = =", "67", "69 - 2 = ");
        mouseInputTest("12 - 1 - 100 - 256 - 326 - 100", "100", "-671 - ");
        mouseInputTest("10 - = = = = = = = = =", "-80", "-70 - 10 = ");
        mouseInputTest("10000 - 9 - 1 - 5 - 949 - 494 - 231 - 1512 =", "6 799", "8311 - 1512 = ");

        mouseInputTest("1234 / 123654 del del", "1 236", "1234 ÷ ");
        mouseInputTest("150 / 15 / 10 =", "1", "10 ÷ 10 = ");
        mouseInputTest("212 / 3 / 17 / 32 / 43 / 1 / 43 / 2 = = =", "8,781906488934135e-6", "1,756381297786827e-5 ÷ 2 = ");
        mouseInputTest("12 / 1 / 100 / 256 / 326 / 100", "100", "1,437883435582822e-6 ÷ ");
        mouseInputTest("10 / = = = =", "0,001", "0,01 ÷ 10 = ");
        mouseInputTest("9 / 1 / 5 / 5 / 658 =", "5,47112462006079e-4", "0,36 ÷ 658 = ");

        mouseInputTest("1234 * 123654 del del", "1 236", "1234 × ");
        mouseInputTest("10 * 15 * 9 =", "1 350", "150 × 9 = ");
        mouseInputTest("212 * 3 * 17 * 32 * 43 * 1 * 43 * 2 = = =", "5 117 795 328", "2558897664 × 2 = ");
        mouseInputTest("12 * 1 * 100 * 256 * 326 * 100", "100", "100147200 × ");
        mouseInputTest("10 * = = = =", "100 000", "10000 × 10 = ");
        mouseInputTest("9 * 1 * 5 * 5 * 658 =", "148 050", "225 × 658 = ");

        mouseInputTest("2 sqr", "4", "sqr( 2 )");
        mouseInputTest("2 sqr sqr", "16", "sqr( sqr( 2 ) )");

        mouseInputTest("16 sqrt", "4", "√( 16 )");
        mouseInputTest("16 sqrt sqrt", "2", "√( √( 16 ) )");

        mouseInputTest("2 1/", "0,5", "1/( 2 )");
        mouseInputTest("2 1/ 1/", "2", "1/( 1/( 2 ) )");

        mouseInputTest("2 sqr sqr sqrt", "4", "√( sqr( sqr( 2 ) ) )");
        mouseInputTest("2 sqr sqr sqrt sqrt", "2", "√( √( sqr( sqr( 2 ) ) ) )");
        mouseInputTest("2 sqr + 3", "3", "sqr( 2 ) + ");
        mouseInputTest("3 + 2 sqr", "4", "3 + sqr( 2 )");
        mouseInputTest("2 sqr + 9 sqrt", "3", "sqr( 2 ) + √( 9 )");

        mouseInputTest("10 + 15 - 9 sqrt =", "22", "25 - √( 9 ) = ");
        mouseInputTest("9 sqrt + 3 sqr =", "12", "√( 9 ) + sqr( 3 ) = ");
        mouseInputTest("9 sqrt + 12 =", "15", "√( 9 ) + 12 = ");
        mouseInputTest("9 + = = = = = = = = =", "90", "81 + 9 = ");
        mouseInputTest("9 + 1 =", "10", "9 + 1 = ");
        mouseInputTest("9 sqrt sqr sqrt sqr sqrt =", "3", "√( sqr( √( sqr( √( 9 ) ) ) ) ) = ");
        mouseInputTest("9 sqrt sqr sqrt sqr sqrt = =", "3", "3 = ");

        mouseInputTest("100 1/ 1/ 1/", "0,01", "1/( 1/( 1/( 100 ) ) )");
        mouseInputTest("100 1/ 1/", "100", "1/( 1/( 100 ) )");
        mouseInputTest("2 1/", "0,5", "1/( 2 )");
        mouseInputTest("4 1/", "0,25", "1/( 4 )");

        mouseInputTest("2 sqr sqr sqr", "256", "sqr( sqr( sqr( 2 ) ) )");
        mouseInputTest("2 sqr", "4", "sqr( 2 )");
        mouseInputTest("1 sqr sqr sqr", "1", "sqr( sqr( sqr( 1 ) ) )");
        mouseInputTest("0,2 sqr sqr", "0,0016", "sqr( sqr( 0,2 ) )");

        mouseInputTest("256 sqrt sqrt sqrt", "2", "√( √( √( 256 ) ) )");
        mouseInputTest("2 sqrt", "1,414213562373095", "√( 2 )");
        mouseInputTest("2 sqrt sqrt", "1,189207115002721", "√( √( 2 ) )");
        mouseInputTest("4 sqrt", "2", "√( 4 )");

        mouseInputTest("265 plusMinus", "-265", "");
        mouseInputTest("265 plusMinus plusMinus", "265", "");
        mouseInputTest("0 plusMinus", "0", "");
        mouseInputTest("10 plusMinus =", "-10", "-10 = ");

        mouseInputTest("100 + 20 % =", "120", "100 + 20 = ");
        mouseInputTest("100 + 20 % = = =", "160", "140 + 20 = ");
        mouseInputTest("100 + 20 %", "20", "100 + 20");
        mouseInputTest("0,01 + 20 % =", "0,012", "0,01 + 0,002 = ");
        mouseInputTest("0,01 + 20 % = = =", "0,016", "0,014 + 0,002 = ");
        mouseInputTest("0,01 + 20 %", "0,002", "0,01 + 0,002");
        mouseInputTest("0,01 + 0,2 % =", "0,01002", "0,01 + 0,00002 = ");
        mouseInputTest("0,01 + 0,2 % = = =", "0,01006", "0,01004 + 0,00002 = ");
        mouseInputTest("0,01 + 0,2 %", "0,00002", "0,01 + 0,00002");
        mouseInputTest("100 - 20 % =", "80", "100 - 20 = ");
        mouseInputTest("100 - 20 % = = =", "40", "60 - 20 = ");
        mouseInputTest("100 - 20 %", "20", "100 - 20");
        mouseInputTest("0,01 - 20 % =", "0,008", "0,01 - 0,002 = ");
        mouseInputTest("0,01 - 20 % = = =", "0,004", "0,006 - 0,002 = ");
        mouseInputTest("0,01 - 20 %", "0,002", "0,01 - 0,002");
        mouseInputTest("0,01 - 0,2 % =", "0,00998", "0,01 - 0,00002 = ");
        mouseInputTest("0,01 - 0,2 % = = =", "0,00994", "0,00996 - 0,00002 = ");
        mouseInputTest("0,01 - 0,2 %", "0,00002", "0,01 - 0,00002");
        mouseInputTest("100 * 20 % =", "20", "100 × 0,2 = ");
        mouseInputTest("100 * 20 % = = =", "0,8", "4 × 0,2 = ");
        mouseInputTest("100 * 20 %", "0,2", "100 × 0,2");
        mouseInputTest("0,01 * 20 % =", "0,002", "0,01 × 0,2 = ");
        mouseInputTest("0,01 * 20 % = = =", "0,00008", "0,0004 × 0,2 = ");
        mouseInputTest("0,01 * 20 %", "0,2", "0,01 × 0,2");
        mouseInputTest("0,01 * 0,2 % =", "0,00002", "0,01 × 0,002 = ");
        mouseInputTest("0,01 * 0,2 % = = =", "0,00000000008", "0,00000004 × 0,002 = ");
        mouseInputTest("0,01 * 0,2 %", "0,002", "0,01 × 0,002");
        mouseInputTest("100 / 20 % =", "500", "100 ÷ 0,2 = ");
        mouseInputTest("100 / 20 % = = =", "12 500", "2500 ÷ 0,2 = ");
        mouseInputTest("100 / 20 %", "0,2", "100 ÷ 0,2");
        mouseInputTest("0,01 / 20 % =", "0,05", "0,01 ÷ 0,2 = ");
        mouseInputTest("0,01 / 20 % = = =", "1,25", "0,25 ÷ 0,2 = ");
        mouseInputTest("0,01 / 20 %", "0,2", "0,01 ÷ 0,2");
        mouseInputTest("0,01 / 0,2 % =", "5", "0,01 ÷ 0,002 = ");
        mouseInputTest("0,01 / 0,2 % = = =", "1 250 000", "2500 ÷ 0,002 = ");
        mouseInputTest("0,01 / 0,2 %", "0,002", "0,01 ÷ 0,002");

        mouseInputTest("0 1/", DIVISION_BY_ZERO, "1/( 0 )");
        mouseInputTest("0 / 0 =", RESULT_UNDEFINED, "0 ÷ 0 = ");
        mouseInputTest("1 - 1 / 0 =", RESULT_UNDEFINED, "0 ÷ 0 = ");

        mouseInputTest("- 1 = sqrt", NEGATIVE_SQRT, "√( -1 )");
        mouseInputTest("1 - 2 = sqrt", NEGATIVE_SQRT, "√( -1 )");

        mouseInputTest("25 + 15 = 996 * 807 =", "803 772", "996 × 807 = ");
        mouseInputTest("23 - 89 = 93,7296 + 199,659 =", "293,3886", "93,7296 + 199,659 = ");
        mouseInputTest("49 * 6 = 52 / 18 =", "2,888888888888889", "52 ÷ 18 = ");
        mouseInputTest("65 / 92 = 46 + 50 =", "96", "46 + 50 = ");
        mouseInputTest("204 + 939 = 100 * 68 =", "6 800", "100 × 68 = ");
        mouseInputTest("454 - 625 = 6,3409 - 0,411052 =", "5,929848", "6,3409 - 0,411052 = ");
        mouseInputTest("317 * 5880 = 525 / 551 =", "0,9528130671506352", "525 ÷ 551 = ");
        mouseInputTest("2664 / 2797 = 10 * 58 =", "580", "10 × 58 = ");
        mouseInputTest("3,4939 - 17,6132 = 27 - 77 =", "-50", "27 - 77 = ");
        mouseInputTest("45,8794 * 168,381 = 488 / 534 =", "0,9138576779026217", "488 ÷ 534 = ");
        mouseInputTest("38 + =", "76", "38 + 38 = ");
        mouseInputTest("36 - =", "0", "36 - 36 = ");
        mouseInputTest("3 * =", "9", "3 × 3 = ");
        mouseInputTest("221 / =", "1", "221 ÷ 221 = ");
        mouseInputTest("7654 + =", "15 308", "7654 + 7654 = ");
        mouseInputTest("9061 - =", "0", "9061 - 9061 = ");
        mouseInputTest("6,6909 * =", "44,76814281", "6,6909 × 6,6909 = ");
        mouseInputTest("4536,48 / =", "1", "4536,48 ÷ 4536,48 = ");
        mouseInputTest("626,864 + =", "1 253,728", "626,864 + 626,864 = ");
        mouseInputTest("70 plusMinus sqr 1/ + =", "4,081632653061224e-4", "1/( sqr( -70 ) ) + 2,040816326530612e-4 = ");
        mouseInputTest("22 / * - + * + 81 =", "103", "22 + 81 = ");
        mouseInputTest("85 / * - + - * 19 =", "1 615", "85 × 19 = ");
        mouseInputTest("52 + - * - / 50 =", "1,04", "52 ÷ 50 = ");
        mouseInputTest("95 / * - + - * - 58 =", "37", "95 - 58 = ");
        mouseInputTest("45 + - * - * - * + / 2 =", "22,5", "45 ÷ 2 = ");
        mouseInputTest("38 / 59 - 56 * 48 + 15 =", "-2 642,084745762712", "-2657,084745762712 + 15 = ");
        mouseInputTest("90 / 50 - 65 + 70 - 68 * 36 / 50 * 41 * 18 =", "-32 519,232", "-1806,624 × 18 = ");
        mouseInputTest("94 + 28 * 2 / 9 * 69 - 76 + 90 =", "1 884,666666666667", "1794,666666666667 + 90 = ");
        mouseInputTest("93 + 33 - 86 / 4 * 12 / 43 * 95 =", "265,1162790697674", "2,790697674418605 × 95 = ");
        mouseInputTest("9435 / 3922 * 2772 + 4075 + 3207 - 7545 * 8409 - 9589 =", "53 854 181,16981132", "53863770,16981132 - 9589 = ");
        mouseInputTest("8409 + 3855 * 3257 / 6874 * 3091 / 7678 =", "2 339,328812609784", "17961366,62321792 ÷ 7678 = ");
        mouseInputTest("6,14458 / 5,67702 * 25,0124 - 0,564167 + 0,0983596 / 1,69446 * 90,8707 - 25,8756 + 582,062 =", "1 983,049164422847", "1400,987164422847 + 582,062 = ");
        mouseInputTest("49,7094 * 1,76954 - 6,77641 * 5,55554 / 68,4793 * 26,403 - 1,46633 * 7,24918 / 6,50886 * 61,4647 - 60,3667 + 2,68666 =", "11 746,49286555605", "11743,80620555605 + 2,68666 = ");
        mouseInputTest("548,431 + 9,3497 - 485,421 * 1,02924 / 3,43877 * 5,23894 - 3,38500 + 60004,9 - 348,444 =", "59 766,53385548124", "60114,97785548124 - 348,444 = ");
        mouseInputTest("2 + 2 = = = = = = = = = = =", "24", "22 + 2 = ");
        mouseInputTest("8 - 29 = = = = = = = = =", "-253", "-224 - 29 = ");
        mouseInputTest("54 * 71 = = = = = = = = = = = =", "8,861228679946038e+23", "1,248060377457188e+22 × 71 = ");
        mouseInputTest("76 / 97 = = = = = = = = =", "9,99696067857351e-17", "9,697051858216304e-15 ÷ 97 = ");
        mouseInputTest("112 + 183 = = = = =", "1 027", "844 + 183 = ");
        mouseInputTest("646 - 858 = = = = = = = =", "-6 218", "-5360 - 858 = ");
        mouseInputTest("882 * 954 = = = = = = = = = = =", "5,254128702945601e+35", "5,50747243495346e+32 × 954 = ");
        mouseInputTest("440832 / 642666 = =", "1,067339209282003e-6", "0,6859426202724277 ÷ 642666 = ");
        mouseInputTest("707595 + 715530 = = = = =", "4 285 245", "3569715 + 715530 = ");
        mouseInputTest("81,7988 - 986,821 = = = = = = = = = = =", "-10 773,2322", "-9786,4112 - 986,821 = ");
    }

    @Test
    public void randomScenarios() {
        mouseInputTest("0,0000000000000005 * 0,0000000000000231 ms c 0,000000000000032 sqr m+ mr mc", "2,310000000000102e-14", "sqr( 0,000000000000032 )");
        mouseInputTest("0,0000000000000001 * 0,0000000000000001 =", "1e-32", "0,0000000000000001 × 0,0000000000000001 = ");
        mouseInputTest(MIN_INPUT + " / " + MAX_INPUT + " =", "1e-32", "0,0000000000000001 ÷ 9999999999999999 = ");
        mouseInputTest(MIN_INPUT + " * 0,0000001 - = = = = =", "-4e-23", "-3e-23 - 1e-23 = ");
        mouseInputTest("0,00000025 sqr sqr sqr sqr", "2,328306436538696e-106", "sqr( sqr( sqr( sqr( 0,00000025 ) ) ) )");
        mouseInputTest("0,000000069 * 0,00000002 = = = = =", "2,208e-46", "1,104e-38 × 0,00000002 = ");
        mouseInputTest("0,000000000956 * 0,000025 % =", "2,39e-16", "0,000000000956 × 0,00000025 = ");
        mouseInputTest("0,00000000000956 / 2532242 % =", "3,775310574581734e-16", "0,00000000000956 ÷ 25322,42 = ");
        mouseInputTest(MIN_INPUT + " * " + MIN_INPUT + " - = = = = = ", "-4e-32", "-3e-32 - 1e-32 = ");
        mouseInputTest(MIN_INPUT + " * = = = =", "1e-80", "1e-64 × 0,0000000000000001 = ");
        mouseInputTest("0,000000000021578 / 9585847859985,58 =", "2,251026754771848e-24", "0,000000000021578 ÷ 9585847859985,58 = ");
        mouseInputTest(MIN_INPUT + " * 0,0000000324412 - = = = = =", "-1,297648e-23", "-9,73236e-24 - 3,24412e-24 = ");
        mouseInputTest("0,0000000000000003 * 0,0000000000004326 * 0,00000000021 = ms c 0,000000000009584 sqr m+ mr mc", "9,185305600000003e-23", "sqr( 0,000000000009584 )");
        mouseInputTest("0,000000002 * = = = = = = / 10000 =", "1,28e-65", "1,28e-61 ÷ 10000 = ");
        mouseInputTest("0,0000231 / 0,5 = = = = sqr sqr sqr", "3,482215949588381e-28", "sqr( sqr( sqr( 0,0003696 ) ) )");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr", "4,203024415375744e-80", "sqr( -2,050127902199213e-40 )");
        mouseInputTest("72346744532 1/ sqr", "1,910565860169429e-22", "sqr( 1/( 72346744532 ) )");
        mouseInputTest("33333 1/ * = = = =", "2,430121503645085e-23", "8,100324008100162e-19 × 3,000030000300003e-5 = ");
        mouseInputTest("9584484 / 0,000000256 = = = 1/", "1,750455840919553e-27", "1/( 5,71279764175415e+26 )");
        mouseInputTest("- 9999999999999 * 99999 = 1/ sqr sqrt", "1,000010000100101e-18", "√( sqr( 1/( -9,999899999999e+17 ) ) )");
        mouseInputTest("0,0000005 * 0,05875 % = * = = = =", "2,187204427719116e-48", "7,445802307128906e-39 × 0,00000000029375 = ");
        mouseInputTest("0,0000001 * 0,31 = = = / 3213 = = =", "8,981583356246147e-20", "2,885782732361887e-16 ÷ 3213 = ");
        mouseInputTest("999 sqr sqr sqr 1/", "1,008036120330794e-24", "1/( sqr( sqr( sqr( 999 ) ) ) )");
        mouseInputTest("0,4342 1/ sqr sqr sqr sqr 1/ sqr sqr", "6,488561473854825e-24", "sqr( sqr( 1/( sqr( sqr( sqr( sqr( 1/( 0,4342 ) ) ) ) ) ) ) )");
        mouseInputTest("999999 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,001024524979528e-6144", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 999999 ) ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("768756463574 + 442553232 % = = = = 1/", "7,348279842819386e-20", "1/( 1,360862707177902e+19 )");
        mouseInputTest("99999999999 * 99999999 * 999999999 sqr sqr = = 1/", "1,00000001801e-91", "1/( 9,999999819900001e+90 )");
        mouseInputTest(",4865258684 * ,0000000778 sqr sqr sqr sqr = = =", "2,845290357002842e-342", "1,57925783490972e-228 × 1,801662967317491e-114 = ");
        mouseInputTest(",0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus", "3,356855668527379e-230", "");
        mouseInputTest("0,0000000002 * = = = = sqr", "1,024e-97", "sqr( 3,2e-49 )");
        mouseInputTest("423423535 sqr sqr sqr sqr * = 1/", "8,774052023437409e-277", "1/( 1,139724265742648e+276 )");
        mouseInputTest(",000000342 * 0,3123134 * 0,00000000000321 = sqr", "1,175556517206523e-37", "sqr( 3,42863896788e-19 )");
        mouseInputTest(MIN_INPUT + " / " + MAX_INPUT + " = = =", "1e-64", "1e-48 ÷ 9999999999999999 = ");
        mouseInputTest("0,000000000052578 / 95858478529985,5 =", "5,484960830413459e-25", "0,000000000052578 ÷ 95858478529985,5 = ");
        mouseInputTest("523122 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,414306747728418e-5856", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 523122 ) ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("0,0000001 * 0,31132 = = = / 32213 = = =", "9,026669623453742e-23", "2,907761085803154e-18 ÷ 32213 = ");
        mouseInputTest("0,00001123 / 0,511 = = = = sqr sqr sqr", "5,414635742824431e-31", "sqr( sqr( sqr( 1,6470096953913e-4 ) ) )");
        mouseInputTest("71323123435 sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        mouseInputTest("0,0000000000000002 * 0,0000000000002326 * 0,000000000211111 = ms c 0,0000000000095184 sqr m+ mr mc", "9,059993856000001e-23", "sqr( 0,0000000000095184 )");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr", "4,203024415375744e-80", "sqr( -2,050127902199213e-40 )");

        mouseInputTest(MIN_INPUT + " * 0,1 + 0,0009999999999999 =", "9,9999999999991e-4", "1e-17 + 0,0009999999999999 = ");
        mouseInputTest(MIN_INPUT + " ms * 0,98595123 = m+ mr mc", "1,98595123e-16", "0,0000000000000001 × 0,98595123 = ");
        mouseInputTest("0,00004746 ms * 0,00000000914 = m+ mr mc", "4,74600004337844e-5", "0,00004746 × 0,00000000914 = ");
        mouseInputTest(MIN_INPUT + " * 0,1 + 0,0000003 =", "3,0000000001e-7", "1e-17 + 0,0000003 = ");
        mouseInputTest("0,00031 sqr ms sqr m+ mr mc", "9,610000923521e-8", "sqr( sqr( 0,00031 ) )");
        mouseInputTest("32100 1/", "3,115264797507788e-5", "1/( 32100 )");
        mouseInputTest("0,00005321 ms * 0,00000000543 = m+ mr mc", "5,32100002889303e-5", "0,00005321 × 0,00000000543 = ");
        mouseInputTest("0,000252 sqr ms sqr m+ mr mc", "6,350400403275802e-8", "sqr( sqr( 0,000252 ) )");
        mouseInputTest(MIN_INPUT + " * 0,2 + 0,00000064 =", "6,4000000002e-7", "2e-17 + 0,00000064 = ");
        mouseInputTest("76400 1/", "1,308900523560209e-5", "1/( 76400 )");
        mouseInputTest("0,00007643 ms * 0,00000000231 = m+ mr mc", "7,64300001765533e-5", "0,00007643 × 0,00000000231 = ");
        mouseInputTest(MIN_INPUT + " * 0,5 + 0,000000234 =", "2,3400000005e-7", "5e-17 + 0,000000234 = ");
        mouseInputTest("523100 1/", "1,91168036704263e-6", "1/( 523100 )");
        mouseInputTest("0,000731 sqr ms sqr m+ mr mc", "5,343612855416783e-7", "sqr( sqr( 0,000731 ) )");
        mouseInputTest("0,000061231 ms * 0,00000000614 = m+ mr mc", "6,123100037595834e-5", "0,000061231 × 0,00000000614 = ");
        mouseInputTest("734800 1/", "1,360914534567229e-6", "1/( 734800 )");
        mouseInputTest("0,000231 sqr ms sqr m+ mr mc", "5,336100284739632e-8", "sqr( sqr( 0,000231 ) )");
        mouseInputTest("878000 1/", "1,138952164009112e-6", "1/( 878000 )");
        mouseInputTest(MIN_INPUT + " * 0,11 + 0,00000031 =", "3,10000000011e-7", "1,1e-17 + 0,00000031 = ");
        mouseInputTest("0,000005231 ms * 0,0000000322 = m+ mr mc", "5,2310001684382e-6", "0,000005231 × 0,0000000322 = ");
        mouseInputTest("767000 1/", "1,303780964797914e-6", "1/( 767000 )");
        mouseInputTest("0,00008588 ms * 0,00000002311 = m+ mr mc", "8,58800019846868e-5", "0,00008588 × 0,00000002311 = ");
        mouseInputTest("434200 1/", "2,303086135421465e-6", "1/( 434200 )");
        mouseInputTest("8675000 1/", "1,152737752161383e-7", "1/( 8675000 )");
        mouseInputTest(MIN_INPUT + " * 0,42 + 0,0000003 =", "3,00000000042e-7", "4,2e-17 + 0,0000003 = ");
        mouseInputTest(MIN_INPUT + " * 0,123 + 0,0000026 =", "2,6000000000123e-6", "1,23e-17 + 0,0000026 = ");
        mouseInputTest("123100 1/", "8,123476848090983e-6", "1/( 123100 )");
        mouseInputTest("0,000512 sqr ms sqr m+ mr mc", "2,621440687194767e-7", "sqr( sqr( 0,000512 ) )");
        mouseInputTest("0,00005234 ms * 0,00000000121 = m+ mr mc", "5,23400000633314e-5", "0,00005234 × 0,00000000121 = ");
        mouseInputTest("63400 1/", "1,577287066246057e-5", "1/( 63400 )");
        mouseInputTest(MIN_INPUT + " * 0,2 + 0,0000011 =", "1,10000000002e-6", "2e-17 + 0,0000011 = ");
        mouseInputTest("0,00006643 ms * 0,00000000421 = m+ mr mc", "6,64300002796703e-5", "0,00006643 × 0,00000000421 = ");
        mouseInputTest("776800 1/", "1,287332646755922e-6", "1/( 776800 )");
        mouseInputTest("0,000341 sqr ms sqr m+ mr mc", "1,16281013521271e-7", "sqr( sqr( 0,000341 ) )");
        mouseInputTest("0,00004234 ms * 0,00000000412 = m+ mr mc", "4,23400001744408e-5", "0,00004234 × 0,00000000412 = ");
        mouseInputTest(MIN_INPUT + " * 0,2 + 0,0000002 =", "2,0000000002e-7", "2e-17 + 0,0000002 = ");
        mouseInputTest("512200 1/", "1,952362358453729e-6", "1/( 512200 )");
        mouseInputTest("23100 1/", "4,329004329004329e-5", "1/( 23100 )");
        mouseInputTest("0,00004231 ms * 0,00000000521 = m+ mr mc", "4,23100002204351e-5", "0,00004231 × 0,00000000521 = ");
        mouseInputTest("0,00051 sqr ms sqr m+ mr mc", "2,6010006765201e-7", "sqr( sqr( 0,00051 ) )");

        mouseInputTest("594845151 + 484951155698 = ", "485 546 000 849", "594845151 + 484951155698 = ");
        mouseInputTest("36214 * 51155698 = ", "1 852 552 447 372", "36214 × 51155698 = ");
        mouseInputTest("845682 / 42694848 = ", "0,0198075889624903", "845682 ÷ 42694848 = ");
        mouseInputTest("48,4951155698 - 594845151 = ", "-594 845 102,5048844", "48,4951155698 - 594845151 = ");
        mouseInputTest("10 + 2547 = ", "2 557", "10 + 2547 = ");
        mouseInputTest("23655454 * 484958 = ", "11 471 901 660 932", "23655454 × 484958 = ");
        mouseInputTest("100000000000000 / 4849,5115698 = ", "20 620 633 348,46815", "100000000000000 ÷ 4849,5115698 = ");
        mouseInputTest("54543,39878 - 8654213312355 = ", "-8 654 213 257 811,601", "54543,39878 - 8654213312355 = ");
        mouseInputTest("534532132354 + 3578654234568 = ", "4 113 186 366 922", "534532132354 + 3578654234568 = ");
        mouseInputTest("34323 * 564345 = ", "19 370 013 435", "34323 × 564345 = ");
        mouseInputTest("231248678995 / 51155698 = ", "4 520,487219136371", "231248678995 ÷ 51155698 = ");
        mouseInputTest("0,112454867 - 484951155698 = ", "-484 951 155 697,8875", "0,112454867 - 484951155698 = ");
        mouseInputTest("21238786864 + 231451155345 = ", "252 689 942 209", "21238786864 + 231451155345 = ");
        mouseInputTest("23456867776 * 5698 = ", "133 657 232 587 648", "23456867776 × 5698 = ");
        mouseInputTest("997845233265 / 48495698 = ", "20 575,95362922707", "997845233265 ÷ 48495698 = ");
        mouseInputTest("1231514 - 48495548 = ", "-47 264 034", "1231514 - 48495548 = ");
        mouseInputTest("423452211 + 484,58877445 = ", "423 452 695,5887745", "423452211 + 484,58877445 = ");
        mouseInputTest("421431231 * 0,155698 = ", "65 615 999,804238", "421431231 × 0,155698 = ");
        mouseInputTest("5948451512132 / 4951155698 = ", "1 201,426873837729", "5948451512132 ÷ 4951155698 = ");
        mouseInputTest("594845151 - 1231553231 = ", "-636 708 080", "594845151 - 1231553231 = ");
        mouseInputTest("2 sqr", "4", "sqr( 2 )");
        mouseInputTest("4 sqrt", "2", "√( 4 )");
        mouseInputTest("4 1/", "0,25", "1/( 4 )");
        mouseInputTest("5 plusMinus", "-5", "");
        mouseInputTest("8484959 sqr", "71 994 529 231 681", "sqr( 8484959 )");
        mouseInputTest("999,9999999 sqrt", "31,62277660010265", "√( 999,9999999 )");
        mouseInputTest("625 1/", "0,0016", "1/( 625 )");
        mouseInputTest("595958,4845194 plusMinus", "-595 958,4845194", "");
        mouseInputTest("595115 sqr", "354 161 863 225", "sqr( 595115 )");
        mouseInputTest("595484136 sqrt", "24 402,54363790791", "√( 595484136 )");
        mouseInputTest("8,4965 1/", "0,1176955216853999", "1/( 8,4965 )");
        mouseInputTest("95977845144 plusMinus", "-95 977 845 144", "");
        mouseInputTest("59841652 sqr", "3 581 023 314 089 104", "sqr( 59841652 )");
        mouseInputTest("8496584,11985 sqrt", "2 914,890069942604", "√( 8496584,11985 )");
        mouseInputTest("12,55259884754265 1/", "0,0796647779591685", "1/( 12,55259884754265 )");
        mouseInputTest("999999999,8888777 plusMinus", "-999 999 999,8888777", "");
        mouseInputTest("99,98887 sqr", "9 997,7741238769", "sqr( 99,98887 )");
        mouseInputTest("46894125648425 sqrt", "6 847 928,566247241", "√( 46894125648425 )");
        mouseInputTest("487,2136 1/", "0,0020524878615868", "1/( 487,2136 )");
        mouseInputTest("4915,88784447485 plusMinus", "-4 915,88784447485", "");

        mouseInputTest("5000000000000000 * 2310000000000000 ms c 320000000000000 sqr m+ mr mc", "1,024000000000023e+29", "sqr( 320000000000000 )");
        mouseInputTest("1000000000000000 * 1000000000000000 =", "1e+30", "1000000000000000 × 1000000000000000 = ");
        mouseInputTest(MIN_INPUT + " / " + MAX_INPUT + " = 1/", "9,999999999999999e+31", "1/( 1e-32 )");
        mouseInputTest(MIN_INPUT + " * 0,0000001 - = = = = = 1/", "-2,5e+22", "1/( -4e-23 )");
        mouseInputTest("25000000 sqr sqr sqr sqr", "2,328306436538696e+118", "sqr( sqr( sqr( sqr( 25000000 ) ) ) )");
        mouseInputTest("690000000 * 20000000 = = = = =", "2,208e+45", "1,104e+38 × 20000000 = ");
        mouseInputTest("956000000000 / 0,000025 % =", "3,824e+18", "956000000000 ÷ 0,00000025 = ");
        mouseInputTest("95600000000000 * 2532242 % =", "2,420823352e+18", "95600000000000 × 25322,42 = ");
        mouseInputTest(MIN_INPUT + " * " + MIN_INPUT + " - = = = = = 1/", "-2,5e+31", "1/( -4e-32 )");
        mouseInputTest(MIN_INPUT + " * = = = = 1/", "1e+80", "1/( 1e-80 )");
        mouseInputTest("215780000000000 * 9585847859985,58 =", "2,068434251227688e+27", "215780000000000 × 9585847859985,58 = ");
        mouseInputTest(MIN_INPUT + " * 0,0000000324412 - = = = = = 1/", "-7,706250077062501e+22", "1/( -1,297648e-23 )");
        mouseInputTest("3000000000000000 / 4326000000000000 * 21000000000 = ms c 958400000000000 sqr m+ mr mc", "9,1853056e+29", "sqr( 958400000000000 )");
        mouseInputTest("200000000 * = = = = = = / 0,00001 =", "1,28e+63", "1,28e+58 ÷ 0,00001 = ");
        mouseInputTest("2310000 / 0,5 = = = = sqr sqr sqr", "3,482215949588381e+60", "sqr( sqr( sqr( 36960000 ) ) )");
        mouseInputTest("- 54840 * 48468915 = = = = = sqr", "2,151928669852084e+86", "sqr( -1,466945353396671e+43 )");
        mouseInputTest("72346744532 sqr", "5,234051444378472e+21", "sqr( 72346744532 )");
        mouseInputTest("33333 * = = = =", "4,115020580246872e+22", "1,234518519259254e+18 × 33333 = ");
        mouseInputTest("9584484 / 0,000000256 = = = ", "5,71279764175415e+26", "1,462476196289063e+20 ÷ 0,000000256 = ");
        mouseInputTest("- 9999999999999 * 99999 = sqr sqrt", "9,999899999999e+17", "√( sqr( -9,999899999999e+17 ) )");
        mouseInputTest("5495848 / 0,05875 % = * = = = =", "7,16364753231495e+49", "7,657859033283004e+39 × 9354634893,617021 = ");
        mouseInputTest("0,0000001 * 0,31 = = = / 3213 = = = 1/", "1,113389432949549e+19", "1/( 8,981583356246147e-20 )");
        mouseInputTest("999 sqr sqr sqr ", "9,92027944069944e+23", "sqr( sqr( sqr( 999 ) ) )");
        mouseInputTest("0,4342 sqr sqr sqr sqr 1/ sqr sqr", "1,541173654637358e+23", "sqr( sqr( 1/( sqr( sqr( sqr( sqr( 0,4342 ) ) ) ) ) ) )");
        mouseInputTest("999999 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "9,989765235976125e+6143", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 999999 ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("768756463574 + 442553232 % = = = =", "1,360862707177902e+19", "1,020647049602338e+19 + 3,40215657575564e+18 = ");
        mouseInputTest("99999999999 * 99999999 * 999999999 sqr sqr = =", "9,999999819900001e+90", "9,9999998599e+54 × 9,99999996e+35 = ");
        mouseInputTest(",4865258684 * ,0000000778 sqr sqr sqr sqr = = = 1/", "3,514579795129855e+341", "1/( 2,845290357002842e-342 )");
        mouseInputTest("0,0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus 1/", "2,978978242572731e+229", "1/( 3,356855668527379e-230 )");
        mouseInputTest("0,0000000002 * = = = = sqr 1/", "9,765625e+96", "1/( sqr( 3,2e-49 ) )");
        mouseInputTest("423423535 sqr sqr sqr sqr * =", "1,139724265742648e+276", "sqr( sqr( sqr( sqr( 423423535 ) ) ) ) × 1,067578692997686e+138 = ");
        mouseInputTest(",000000342 * 0,3123134 * 0,00000000000321 = sqr 1/", "8,506609298345788e+36", "1/( sqr( 3,42863896788e-19 ) )");
        mouseInputTest(MIN_INPUT + " / " + MAX_INPUT + " = = = 1/", "9,999999999999997e+63", "1/( 1e-64 )");
        mouseInputTest("0,000000000052578 / 95858478529985,5 = 1/", "1,823167076153249e+24", "1/( 5,484960830413459e-25 )");
        mouseInputTest("523122 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "7,070601915787683e+5855", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 523122 ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("0,0000001 * 0,31132 = = = / 32213 = = = 1/", "1,107828292952838e+22", "1/( 9,026669623453742e-23 )");
        mouseInputTest("11230000 / 5110 = = = = sqr sqr sqr", "5,414635742824431e-63", "sqr( sqr( sqr( 1,6470096953913e-8 ) ) )");
        mouseInputTest("71323123435 sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        mouseInputTest("2000000000000000 * 2326 =", "4,652e+18", "2000000000000000 × 2326 = ");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr 1/", "2,379239093500725e+79", "1/( sqr( -2,050127902199213e-40 ) )");
    }
}