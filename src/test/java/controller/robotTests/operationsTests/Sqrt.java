package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class Sqrt extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("25 sqrt", "5", "√( 25 )");
        mouseInputTest("1 sqrt", "1", "√( 1 )");
        mouseInputTest("100 sqrt", "10", "√( 100 )");
        mouseInputTest("9 sqrt", "3", "√( 9 )");
        mouseInputTest("3 sqrt", "1,732050807568877", "√( 3 )");
        mouseInputTest("4 sqrt", "2", "√( 4 )");
        mouseInputTest("56 sqrt", "7,483314773547883", "√( 56 )");
        mouseInputTest("79 sqrt", "8,888194417315589", "√( 79 )");
        mouseInputTest("69 sqrt", "8,306623862918075", "√( 69 )");
        mouseInputTest("83 sqrt", "9,110433579144299", "√( 83 )");
        mouseInputTest("97 sqrt", "9,848857801796105", "√( 97 )");
        mouseInputTest("76 sqrt", "8,717797887081347", "√( 76 )");
        mouseInputTest("94 sqrt", "9,695359714832658", "√( 94 )");
        mouseInputTest("99 sqrt", "9,9498743710662", "√( 99 )");
        mouseInputTest("0,87 sqrt", "0,9327379053088815", "√( 0,87 )");
        mouseInputTest("1,6 sqrt", "1,264911064067352", "√( 1,6 )");
        mouseInputTest("2,9 sqrt", "1,70293863659264", "√( 2,9 )");
        mouseInputTest("0,83 sqrt", "0,9110433579144299", "√( 0,83 )");
        mouseInputTest("0,26 sqrt", "0,5099019513592785", "√( 0,26 )");
        mouseInputTest("90 sqrt", "9,486832980505138", "√( 90 )");
        mouseInputTest("1,5 sqrt", "1,224744871391589", "√( 1,5 )");
        mouseInputTest("2,1 sqrt", "1,449137674618944", "√( 2,1 )");
        mouseInputTest("0,42 sqrt", "0,648074069840786", "√( 0,42 )");
        mouseInputTest("7,9 sqrt", "2,810693864511039", "√( 7,9 )");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("15 sqrt", "3,872983346207417", "√( 15 )");
        mouseInputTest("74 sqrt", "8,602325267042627", "√( 74 )");
        mouseInputTest("34,44 sqrt", "5,868560300448484", "√( 34,44 )");
        mouseInputTest("98,4 sqrt", "9,919677414109796", "√( 98,4 )");
        mouseInputTest("0,07 sqrt", "0,2645751311064591", "√( 0,07 )");
        mouseInputTest("0,25 sqrt", "0,5", "√( 0,25 )");
        mouseInputTest("411 sqrt", "20,27313493271329", "√( 411 )");
        mouseInputTest("9 sqrt", "3", "√( 9 )");
        mouseInputTest("25 sqrt", "5", "√( 25 )");
        mouseInputTest("812322 sqrt", "901,2890768227473", "√( 812322 )");
        mouseInputTest("50,6 sqrt", "7,113367697511496", "√( 50,6 )");
        mouseInputTest("4,2 sqrt", "2,04939015319192", "√( 4,2 )");
        mouseInputTest("229 sqrt", "15,13274595042156", "√( 229 )");
        mouseInputTest("1,49 sqrt", "1,22065556157337", "√( 1,49 )");
        mouseInputTest("795 sqrt", "28,19574435974337", "√( 795 )");
        mouseInputTest("8,08 sqrt", "2,842534080710379", "√( 8,08 )");
        mouseInputTest("0,66 sqrt", "0,812403840463596", "√( 0,66 )");
        mouseInputTest("29,4 sqrt", "5,422176684690384", "√( 29,4 )");
        mouseInputTest("5,57 sqrt", "2,360084744241189", "√( 5,57 )");
        mouseInputTest("194 sqrt", "13,92838827718412", "√( 194 )");
        mouseInputTest("286 sqrt", "16,91153452528776", "√( 286 )");
        mouseInputTest("198 sqrt", "14,07124727947029", "√( 198 )");
        mouseInputTest("147 sqrt", "12,12435565298214", "√( 147 )");
        mouseInputTest("513 sqrt", "22,64950330581225", "√( 513 )");
        mouseInputTest("347 sqrt", "18,62793601019716", "√( 347 )");
        mouseInputTest("89 sqrt", "9,433981132056604", "√( 89 )");
        mouseInputTest("229 sqrt", "15,13274595042156", "√( 229 )");
        mouseInputTest("52 sqrt", "7,211102550927979", "√( 52 )");
        mouseInputTest("966 sqrt", "31,08054053584011", "√( 966 )");
        mouseInputTest("2 sqrt", "1,414213562373095", "√( 2 )");
        mouseInputTest("12 sqrt", "3,464101615137755", "√( 12 )");
        mouseInputTest("300 sqrt", "17,32050807568877", "√( 300 )");
    }

    @Test
    public void negateSqrtScenarios() {
        mouseInputTest("8 plusMinus sqrt", NEGATIVE_SQRT, "√( -8 )");
        mouseInputTest("75 plusMinus sqrt", NEGATIVE_SQRT, "√( -75 )");
        mouseInputTest("698 plusMinus sqrt", NEGATIVE_SQRT, "√( -698 )");
        mouseInputTest("245 plusMinus sqrt", NEGATIVE_SQRT, "√( -245 )");
        mouseInputTest("659 plusMinus sqrt", NEGATIVE_SQRT, "√( -659 )");
        mouseInputTest("9417 plusMinus sqrt", NEGATIVE_SQRT, "√( -9417 )");
        mouseInputTest("3961 plusMinus sqrt", NEGATIVE_SQRT, "√( -3961 )");
        mouseInputTest("360,416 plusMinus sqrt", NEGATIVE_SQRT, "√( -360,416 )");
        mouseInputTest("2,9935 plusMinus sqrt", NEGATIVE_SQRT, "√( -2,9935 )");
        mouseInputTest("120 plusMinus sqrt", NEGATIVE_SQRT, "√( -120 )");
    }

    @Test
    public void randomSqrtScenarios() {
        mouseInputTest("4848984562654847 sqrt", "69 634 650,58901959", "√( 4848984562654847 )");
        mouseInputTest("48456998844785 sqrt", "6 961 106,150949359", "√( 48456998844785 )");
        mouseInputTest("15181848484,48481 sqrt", "123 214,6439530822", "√( 15181848484,48481 )");
        mouseInputTest("49958474848,48485 sqrt", "223 513,9254017182", "√( 49958474848,48485 )");
        mouseInputTest("8971,487824435234 sqrt", "94,71793823999356", "√( 8971,487824435234 )");
        mouseInputTest("2804283685904262 sqrt", "52 955 487,77892865", "√( 2804283685904262 )");
        mouseInputTest("15216056106784 sqrt", "3 900 776,34667562", "√( 15216056106784 )");
        mouseInputTest("862069,2202713910 sqrt", "928,4768280745573", "√( 862069,220271391 )");
        mouseInputTest("18650523300,05526 sqrt", "136 566,9187616652", "√( 18650523300,05526 )");
        mouseInputTest("5417,612255374980 sqrt", "73,60443094933198", "√( 5417,61225537498 )");
        mouseInputTest("4483442895982312 sqrt", "66 958 516,23193507", "√( 4483442895982312 )");
        mouseInputTest("48443918244561 sqrt", "6 960 166,538565079", "√( 48443918244561 )");
        mouseInputTest("424829,1425462811 sqrt", "651,789185662267", "√( 424829,1425462811 )");
        mouseInputTest("91372893827,42341 sqrt", "302 279,4962074395", "√( 91372893827,42341 )");
        mouseInputTest("192344743,9417238 sqrt", "13 868,84075695311", "√( 192344743,9417238 )");
        mouseInputTest("- 9999999999999 * 99999 = sqrt", "9,999899999999e+17", "√( sqr( -9,999899999999e+17 ) )");

    }

    @Test
    public void formatterSqrtScenarios() {
        mouseInputTest("9405 sqr sqr sqr sqr sqrt", "6,121676831470649e+31", "√( sqr( sqr( sqr( sqr( 9405 ) ) ) ) )");
        mouseInputTest("6280 sqr sqr sqr sqrt", "1 555 387 394 560 000", "√( sqr( sqr( sqr( 6280 ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr sqrt", "3 764 545 114 980 321", "√( sqr( sqr( sqr( 7833 ) ) ) )");
        mouseInputTest("9405 sqr sqr sqr sqr 1/ sqrt", "1,633539351275692e-32", "√( 1/( sqr( sqr( sqr( sqr( 9405 ) ) ) ) ) )");
        mouseInputTest("6280 sqr sqr sqr 1/ sqrt", "6,429266454759251e-16", "√( 1/( sqr( sqr( sqr( 6280 ) ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr 1/ sqrt", "2,656363436901532e-16", "√( 1/( sqr( sqr( sqr( 7833 ) ) ) ) )");
        mouseInputTest("53 sqr sqr sqr sqr sqrt + 675 sqr sqr sqr sqrt =", "62 467 284 551 986", "√( sqr( sqr( sqr( sqr( 53 ) ) ) ) ) + √( sqr( sqr( sqr( 675 ) ) ) ) = ");
        mouseInputTest("214 sqr sqr sqr sqrt - 654 sqr sqr sqr sqrt =", "-180 843 703 040", "√( sqr( sqr( sqr( 214 ) ) ) ) - √( sqr( sqr( sqr( 654 ) ) ) ) = ");
        mouseInputTest("7862 sqr sqr sqr sqrt * 234,23 sqr sqr sqr sqr 1/ sqrt =", "4,216887459472663e-4", "√( sqr( sqr( sqr( 7862 ) ) ) ) × √( 1/( sqr( sqr( sqr( sqr( 234,23 ) ) ) ) ) ) = ");
        mouseInputTest("0,0042 sqr sqr sqr sqr 1/ sqrt / 0,423 sqr sqr sqr 1/ sqrt =", "3,306489487885185e+17", "√( 1/( sqr( sqr( sqr( sqr( 0,0042 ) ) ) ) ) ) ÷ √( 1/( sqr( sqr( sqr( 0,423 ) ) ) ) ) = ");
        mouseInputTest("0,42 sqr sqr sqr 1/ sqrt + 0,2341 =", "32,37091542155789", "√( 1/( sqr( sqr( sqr( 0,42 ) ) ) ) ) + 0,2341 = ");
        mouseInputTest("523 sqr sqr sqr 1/ sqrt - 234 =", "-233,9999999999866", "√( 1/( sqr( sqr( sqr( 523 ) ) ) ) ) - 234 = ");
        mouseInputTest("234 sqr sqr sqr 1/ sqrt * 2,34 =", "7,804631955409952e-10", "√( 1/( sqr( sqr( sqr( 234 ) ) ) ) ) × 2,34 = ");
        mouseInputTest("0,44 sqr sqr sqr 1/ sqrt / 423,42 =", "0,0630112254976101", "√( 1/( sqr( sqr( sqr( 0,44 ) ) ) ) ) ÷ 423,42 = ");
        mouseInputTest("12 + 0,1234 sqr sqr sqr 1/ sqrt =", "4 324,601813736906", "12 + √( 1/( sqr( sqr( sqr( 0,1234 ) ) ) ) ) = ");
        mouseInputTest("423 - 0,234 sqr sqr sqr 1/ sqrt =", "89,46871985427554", "423 - √( 1/( sqr( sqr( sqr( 0,234 ) ) ) ) ) = ");
        mouseInputTest("1234 * 23,42 sqr sqr sqr 1/ sqrt =", "0,0041017349829314", "1234 × √( 1/( sqr( sqr( sqr( 23,42 ) ) ) ) ) = ");
        mouseInputTest("123,42 / 23,231 sqr sqr sqr 1/ sqrt =", "35 946 545,56212184", "123,42 ÷ √( 1/( sqr( sqr( sqr( 23,231 ) ) ) ) ) = ");
    }
}
