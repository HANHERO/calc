package controller.robotTests;

import controller.sandBox.Clicker;
import org.junit.Test;
import controller.sandBox.TestingSandBox;

import java.awt.*;

public class InputTests extends TestingSandBox {
    Clicker clicker;

    public InputTests() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void scenarios() {
        expressionTest("(1234)", "1 234", "");
        expressionTest("(23)", "23", "");
        expressionTest("(1232314)", "1 232 314", "");
        expressionTest("(543422)", "543 422", "");
        expressionTest("(1232314)", "1 232 314", "");
        expressionTest("(1596321,324)", "1 596 321,324", "");
        expressionTest("(324,1596321)", "324,1596321", "");
        expressionTest(MAX_INPUT, "9 999 999 999 999 999", "");

        expressionTest("(1234) plusMinus", "-1 234", "");
        expressionTest("(23) plusMinus", "-23", "");
        expressionTest("(1232314) plusMinus", "-1 232 314", "");
        expressionTest("(543422) plusMinus", "-543 422", "");
        expressionTest("(1232314) plusMinus", "-1 232 314", "");
        expressionTest("(1596321,324) plusMinus", "-1 596 321,324", "");
        expressionTest("(324,1596321) plusMinus", "-324,1596321", "");
        expressionTest(MAX_INPUT + " plusMinus", "-9 999 999 999 999 999", "");

        expressionTest("(1234) plusMinus plusMinus", "1 234", "");
        expressionTest("(23) plusMinus plusMinus", "23", "");
        expressionTest("(1232314) plusMinus plusMinus", "1 232 314", "");
        expressionTest("(543422) plusMinus plusMinus", "543 422", "");
        expressionTest("(1232314) plusMinus plusMinus", "1 232 314", "");
        expressionTest("(1596321,324) plusMinus plusMinus", "1 596 321,324", "");
        expressionTest("(324,1596321) plusMinus plusMinus", "324,1596321", "");
        expressionTest(MAX_INPUT + " plusMinus plusMinus", "9 999 999 999 999 999", "");

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
    }

    public void expressionTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }
}