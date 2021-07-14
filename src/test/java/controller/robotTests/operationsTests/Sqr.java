package controller.robotTests.operationsTests;

import controller.sandBox.Clicker;
import controller.sandBox.TestingSandBox;
import org.junit.Test;

import java.awt.*;

public class Sqr extends TestingSandBox {
    Clicker clicker;

    public Sqr() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void simpleScenarios() {
        test("5 sqr", "25", "sqr( 5 )");
        test("1 sqr", "1", "sqr( 1 )");
        test("10 sqr", "100", "sqr( 10 )");
        test("9 sqr", "81", "sqr( 9 )");
        test("3 sqr", "9", "sqr( 3 )");
        test("4 sqr", "16", "sqr( 4 )");
        test("56 sqr", "3 136", "sqr( 56 )");
        test("79 sqr", "6 241", "sqr( 79 )");
        test("69 sqr", "4 761", "sqr( 69 )");
        test("83 sqr", "6 889", "sqr( 83 )");
        test("97 sqr", "9 409", "sqr( 97 )");
        test("76 sqr", "5 776", "sqr( 76 )");
        test("94 sqr", "8 836", "sqr( 94 )");
        test("99 sqr", "9 801", "sqr( 99 )");
        test("0,87 sqr", "0,7569", "sqr( 0,87 )");
        test("1,6 sqr", "2,56", "sqr( 1,6 )");
        test("2,9 sqr", "8,41", "sqr( 2,9 )");
        test("0,83 sqr", "0,6889", "sqr( 0,83 )");
        test("0,26 sqr", "0,0676", "sqr( 0,26 )");
        test("90 sqr", "8 100", "sqr( 90 )");
        test("1,5 sqr", "2,25", "sqr( 1,5 )");
        test("2,1 sqr", "4,41", "sqr( 2,1 )");
        test("0,42 sqr", "0,1764", "sqr( 0,42 )");
        test("7,9 sqr", "62,41", "sqr( 7,9 )");
    }

    @Test
    public void subjectAreaScenarios() {
        test("50,6 sqr", "2 560,36", "sqr( 50,6 )");
        test("4,2 sqr", "17,64", "sqr( 4,2 )");
        test("229 sqr", "52 441", "sqr( 229 )");
        test("1,49 sqr", "2,2201", "sqr( 1,49 )");
        test("795 sqr", "632 025", "sqr( 795 )");
        test("8,08 sqr", "65,2864", "sqr( 8,08 )");
        test("0,66 sqr", "0,4356", "sqr( 0,66 )");
        test("29,4 sqr", "864,36", "sqr( 29,4 )");
        test("5,57 sqr", "31,0249", "sqr( 5,57 )");
        test("4,73 sqr", "22,3729", "sqr( 4,73 )");
        test("194 sqr", "37 636", "sqr( 194 )");
        test("286 sqr", "81 796", "sqr( 286 )");
        test("198 sqr", "39 204", "sqr( 198 )");
        test("147 sqr", "21 609", "sqr( 147 )");
        test("513 sqr", "263 169", "sqr( 513 )");
        test("347 sqr", "120 409", "sqr( 347 )");
        test("89 sqr", "7 921", "sqr( 89 )");
        test("229 sqr", "52 441", "sqr( 229 )");
        test("52 sqr", "2 704", "sqr( 52 )");
        test("966 sqr", "933 156", "sqr( 966 )");
        test("2 sqr", "4", "sqr( 2 )");
        test("12 sqr", "144", "sqr( 12 )");
        test("300 sqr", "90 000", "sqr( 300 )");
        test("15 sqr", "225", "sqr( 15 )");
        test("74 sqr", "5 476", "sqr( 74 )");
        test("34,44 sqr", "1 186,1136", "sqr( 34,44 )");
        test("98,4 sqr", "9 682,56", "sqr( 98,4 )");
        test("0,07 sqr", "0,0049", "sqr( 0,07 )");
        test("0,25 sqr", "0,0625", "sqr( 0,25 )");
        test("3,14 sqr", "9,8596", "sqr( 3,14 )");
        test("9 sqr", "81", "sqr( 9 )");
        test("25 sqr", "625", "sqr( 25 )");
        test("812322 sqr", "659 867 031 684", "sqr( 812322 )");
    }

    @Test
    public void randomSqrScenarios() {
        test("1234654453453545 sqr", "1,524371619432672e+30", "sqr( 1234654453453545 )");
        test("12353453453633 sqr", "1,526078122310771e+26", "sqr( 12353453453633 )");
        test("452353,3245454543 sqr", "204 623 530 227,3251", "sqr( 452353,3245454543 )");
        test("89874848478,48652 sqr", "8,077488389030911e+21", "sqr( 89874848478,48652 )");
        test("6654,612255374980 sqr", "44 283 864,26938688", "sqr( 6654,61225537498 )");
        test("2804283685904262 sqr", "7,864006991028794e+30", "sqr( 2804283685904262 )");
        test("15216056106784 sqr", "2,315283634447987e+26", "sqr( 15216056106784 )");
        test("862069,2202713910 sqr", "743 163 340 539,3241", "sqr( 862069,220271391 )");
        test("18650523300,05526 sqr", "3,478420193659041e+20", "sqr( 18650523300,05526 )");
        test("5417,612255374980 sqr", "29 350 522,54958918", "sqr( 5417,61225537498 )");
        test("3423455656543423 sqr", "1,172004863231916e+31", "sqr( 3423455656543423 )");
        test("43425656534345 sqr", "1,885787645438901e+27", "sqr( 43425656534345 )");
        test("434353,543665654 sqr", "188 663 000 894,9112", "sqr( 434353,543665654 )");
        test("31234565445,34234 sqr", "9,755980785593737e+20", "sqr( 31234565445,34234 )");
        test("5453,234565654432 sqr", "29 737 767,22804828", "sqr( 5453,234565654432 )");
    }

    @Test
    public void formatterSqrScenarios() {
        test("6151 sqr sqr sqr sqr sqr plusMinus sqr", "3,108325773610856e+242", "sqr( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) )");
        test("9405 sqr sqr sqr sqr sqr", "1,404370170816187e+127", "sqr( sqr( sqr( sqr( sqr( 9405 ) ) ) ) )");
        test("3290 sqr sqr sqr plusMinus sqr", "1,884231965444703e+56", "sqr( negate( sqr( sqr( sqr( 3290 ) ) ) ) )");
        test("6280 sqr sqr sqr sqr", "5,852673537217125e+60", "sqr( sqr( sqr( sqr( 6280 ) ) ) )");
        test("7833 sqr sqr sqr sqr", "2,008399130496689e+62", "sqr( sqr( sqr( sqr( 7833 ) ) ) )");
        test("3476 sqr sqr plusMinus sqr", "2,131268382535268e+28", "sqr( negate( sqr( sqr( 3476 ) ) ) )");
        test("6151 sqr sqr sqr sqr sqr plusMinus 1/ sqr", "3,217166001356182e-243", "sqr( 1/( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) ) )");
        test("9405 sqr sqr sqr sqr 1/ sqr", "7,120629736950503e-128", "sqr( 1/( sqr( sqr( sqr( sqr( 9405 ) ) ) ) ) )");
        test("3290 sqr sqr sqr plusMinus 1/ sqr", "5,307202182847944e-57", "sqr( 1/( negate( sqr( sqr( sqr( 3290 ) ) ) ) ) )");
        test("6280 sqr sqr sqr 1/ sqr", "1,708620844202234e-61", "sqr( 1/( sqr( sqr( sqr( 6280 ) ) ) ) )");
        test("7833 sqr sqr sqr 1/ sqr", "4,979089986723376e-63", "sqr( 1/( sqr( sqr( sqr( 7833 ) ) ) ) )");
        test("3476 sqr sqr plusMinus 1/ sqr", "4,692041641468174e-29", "sqr( 1/( negate( sqr( sqr( 3476 ) ) ) ) )");
    }

    public void test(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }
}
