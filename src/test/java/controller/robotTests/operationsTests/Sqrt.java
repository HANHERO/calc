package controller.robotTests.operationsTests;

import controller.sandBox.Clicker;
import controller.sandBox.TestingSandBox;
import org.junit.Test;

import java.awt.*;

public class Sqrt extends TestingSandBox {
    Clicker clicker;

    public Sqrt() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void simpleScenarios() {
        test("25 sqrt", "5", "√( 25 )");
        test("1 sqrt", "1", "√( 1 )");
        test("100 sqrt", "10", "√( 100 )");
        test("9 sqrt", "3", "√( 9 )");
        test("3 sqrt", "1,732050807568877", "√( 3 )");
        test("4 sqrt", "2", "√( 4 )");
        test("56 sqrt", "7,483314773547883", "√( 56 )");
        test("79 sqrt", "8,888194417315589", "√( 79 )");
        test("69 sqrt", "8,306623862918075", "√( 69 )");
        test("83 sqrt", "9,110433579144299", "√( 83 )");
        test("97 sqrt", "9,848857801796105", "√( 97 )");
        test("76 sqrt", "8,717797887081347", "√( 76 )");
        test("94 sqrt", "9,695359714832658", "√( 94 )");
        test("99 sqrt", "9,9498743710662", "√( 99 )");
        test("0,87 sqrt", "0,9327379053088815", "√( 0,87 )");
        test("1,6 sqrt", "1,264911064067352", "√( 1,6 )");
        test("2,9 sqrt", "1,70293863659264", "√( 2,9 )");
        test("0,83 sqrt", "0,9110433579144299", "√( 0,83 )");
        test("0,26 sqrt", "0,5099019513592785", "√( 0,26 )");
        test("90 sqrt", "9,486832980505138", "√( 90 )");
        test("1,5 sqrt", "1,224744871391589", "√( 1,5 )");
        test("2,1 sqrt", "1,449137674618944", "√( 2,1 )");
        test("0,42 sqrt", "0,648074069840786", "√( 0,42 )");
        test("7,9 sqrt", "2,810693864511039", "√( 7,9 )");
    }

    @Test
    public void subjectAreaScenarios() {
        test("15 sqrt", "3,872983346207417", "√( 15 )");
        test("74 sqrt", "8,602325267042627", "√( 74 )");
        test("34,44 sqrt", "5,868560300448484", "√( 34,44 )");
        test("98,4 sqrt", "9,919677414109796", "√( 98,4 )");
        test("0,07 sqrt", "0,2645751311064591", "√( 0,07 )");
        test("0,25 sqrt", "0,5", "√( 0,25 )");
        test("411 sqrt", "20,27313493271329", "√( 411 )");
        test("9 sqrt", "3", "√( 9 )");
        test("25 sqrt", "5", "√( 25 )");
        test("812322 sqrt", "901,2890768227473", "√( 812322 )");
        test("50,6 sqrt", "7,113367697511496", "√( 50,6 )");
        test("4,2 sqrt", "2,04939015319192", "√( 4,2 )");
        test("229 sqrt", "15,13274595042156", "√( 229 )");
        test("1,49 sqrt", "1,22065556157337", "√( 1,49 )");
        test("795 sqrt", "28,19574435974337", "√( 795 )");
        test("8,08 sqrt", "2,842534080710379", "√( 8,08 )");
        test("0,66 sqrt", "0,812403840463596", "√( 0,66 )");
        test("29,4 sqrt", "5,422176684690384", "√( 29,4 )");
        test("5,57 sqrt", "2,360084744241189", "√( 5,57 )");
        test("194 sqrt", "13,92838827718412", "√( 194 )");
        test("286 sqrt", "16,91153452528776", "√( 286 )");
        test("198 sqrt", "14,07124727947029", "√( 198 )");
        test("147 sqrt", "12,12435565298214", "√( 147 )");
        test("513 sqrt", "22,64950330581225", "√( 513 )");
        test("347 sqrt", "18,62793601019716", "√( 347 )");
        test("89 sqrt", "9,433981132056604", "√( 89 )");
        test("229 sqrt", "15,13274595042156", "√( 229 )");
        test("52 sqrt", "7,211102550927979", "√( 52 )");
        test("966 sqrt", "31,08054053584011", "√( 966 )");
        test("2 sqrt", "1,414213562373095", "√( 2 )");
        test("12 sqrt", "3,464101615137755", "√( 12 )");
        test("300 sqrt", "17,32050807568877", "√( 300 )");
    }

    @Test
    public void negateSqrtScenarios() {
        test("8 plusMinus sqrt", NEGATIVE_SQRT, "√( -8 )");
        test("75 plusMinus sqrt", NEGATIVE_SQRT, "√( -75 )");
        test("698 plusMinus sqrt", NEGATIVE_SQRT, "√( -698 )");
        test("245 plusMinus sqrt", NEGATIVE_SQRT, "√( -245 )");
        test("659 plusMinus sqrt", NEGATIVE_SQRT, "√( -659 )");
        test("9417 plusMinus sqrt", NEGATIVE_SQRT, "√( -9417 )");
        test("3961 plusMinus sqrt", NEGATIVE_SQRT, "√( -3961 )");
        test("360,416 plusMinus sqrt", NEGATIVE_SQRT, "√( -360,416 )");
        test("2,9935 plusMinus sqrt", NEGATIVE_SQRT, "√( -2,9935 )");
        test("120 plusMinus sqrt", NEGATIVE_SQRT, "√( -120 )");
    }

    @Test
    public void randomSqrtScenarios() {
        test("4848984562654847 sqrt", "69 634 650,58901959", "√( 4848984562654847 )");
        test("48456998844785 sqrt", "6 961 106,150949359", "√( 48456998844785 )");
        test("15181848484,48481 sqrt", "123 214,6439530822", "√( 15181848484,48481 )");
        test("49958474848,48485 sqrt", "223 513,9254017182", "√( 49958474848,48485 )");
        test("8971,487824435234 sqrt", "94,71793823999356", "√( 8971,487824435234 )");
        test("2804283685904262 sqrt", "52 955 487,77892865", "√( 2804283685904262 )");
        test("15216056106784 sqrt", "3 900 776,34667562", "√( 15216056106784 )");
        test("862069,2202713910 sqrt", "928,4768280745573", "√( 862069,220271391 )");
        test("18650523300,05526 sqrt", "136 566,9187616652", "√( 18650523300,05526 )");
        test("5417,612255374980 sqrt", "73,60443094933198", "√( 5417,61225537498 )");
        test("4483442895982312 sqrt", "66 958 516,23193507", "√( 4483442895982312 )");
        test("48443918244561 sqrt", "6 960 166,538565079", "√( 48443918244561 )");
        test("424829,1425462811 sqrt", "651,789185662267", "√( 424829,1425462811 )");
        test("91372893827,42341 sqrt", "302 279,4962074395", "√( 91372893827,42341 )");
        test("192344743,9417238 sqrt", "13 868,84075695311", "√( 192344743,9417238 )");
    }

    @Test
    public void formatterSqrtScenarios() {
        test("9405 sqr sqr sqr sqr sqrt", "6,121676831470649e+31", "√( sqr( sqr( sqr( sqr( 9405 ) ) ) ) )");
        test("6280 sqr sqr sqr sqrt", "1 555 387 394 560 000", "√( sqr( sqr( sqr( 6280 ) ) ) )");
        test("7833 sqr sqr sqr sqrt", "3 764 545 114 980 321", "√( sqr( sqr( sqr( 7833 ) ) ) )");
        test("9405 sqr sqr sqr sqr 1/ sqrt", "1,633539351275692e-32", "√( 1/( sqr( sqr( sqr( sqr( 9405 ) ) ) ) ) )");
        test("6280 sqr sqr sqr 1/ sqrt", "6,429266454759251e-16", "√( 1/( sqr( sqr( sqr( 6280 ) ) ) ) )");
        test("7833 sqr sqr sqr 1/ sqrt", "2,656363436901532e-16", "√( 1/( sqr( sqr( sqr( 7833 ) ) ) ) )");
        test("53 sqr sqr sqr sqr sqrt + 675 sqr sqr sqr sqrt =", "62 467 284 551 986", "√( sqr( sqr( sqr( sqr( 53 ) ) ) ) ) + √( sqr( sqr( sqr( 675 ) ) ) ) = ");
        test("214 sqr sqr sqr sqrt - 654 sqr sqr sqr sqrt =", "-180 843 703 040", "√( sqr( sqr( sqr( 214 ) ) ) ) - √( sqr( sqr( sqr( 654 ) ) ) ) = ");
        test("7862 sqr sqr sqr sqrt * 234,23 sqr sqr sqr sqr 1/ sqrt =", "4,216887459472663e-4", "√( sqr( sqr( sqr( 7862 ) ) ) ) × √( 1/( sqr( sqr( sqr( sqr( 234,23 ) ) ) ) ) ) = ");
        test("0,0042 sqr sqr sqr sqr 1/ sqrt / 0,423 sqr sqr sqr 1/ sqrt =", "3,306489487885185e+17", "√( 1/( sqr( sqr( sqr( sqr( 0,0042 ) ) ) ) ) ) ÷ √( 1/( sqr( sqr( sqr( 0,423 ) ) ) ) ) = ");
        test("0,42 sqr sqr sqr 1/ sqrt + 0,2341 =", "32,37091542155789", "√( 1/( sqr( sqr( sqr( 0,42 ) ) ) ) ) + 0,2341 = ");
        test("523 sqr sqr sqr 1/ sqrt - 234 =", "-233,9999999999866", "√( 1/( sqr( sqr( sqr( 523 ) ) ) ) ) - 234 = ");
        test("234 sqr sqr sqr 1/ sqrt * 2,34 =", "7,804631955409952e-10", "√( 1/( sqr( sqr( sqr( 234 ) ) ) ) ) × 2,34 = ");
        test("0,44 sqr sqr sqr 1/ sqrt / 423,42 =", "0,0630112254976101", "√( 1/( sqr( sqr( sqr( 0,44 ) ) ) ) ) ÷ 423,42 = ");
        test("12 + 0,1234 sqr sqr sqr 1/ sqrt =", "4 324,601813736906", "12 + √( 1/( sqr( sqr( sqr( 0,1234 ) ) ) ) ) = ");
        test("423 - 0,234 sqr sqr sqr 1/ sqrt =", "89,46871985427554", "423 - √( 1/( sqr( sqr( sqr( 0,234 ) ) ) ) ) = ");
        test("1234 * 23,42 sqr sqr sqr 1/ sqrt =", "0,0041017349829314", "1234 × √( 1/( sqr( sqr( sqr( 23,42 ) ) ) ) ) = ");
        test("123,42 / 23,231 sqr sqr sqr 1/ sqrt =", "35 946 545,56212184", "123,42 ÷ √( 1/( sqr( sqr( sqr( 23,231 ) ) ) ) ) = ");
    }

    public void test(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }

}
