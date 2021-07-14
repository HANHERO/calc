package controller.robotTests.operationsTests;

import controller.sandBox.Clicker;
import controller.sandBox.TestingSandBox;
import org.junit.Test;

import java.awt.*;

public class Negate extends TestingSandBox {
    Clicker clicker;

    public Negate() throws AWTException {
        clicker = new Clicker();
    }

    @Test
    public void simpleScenarios() {
        test("5 plusMinus", "-5", "");
        test("1 plusMinus", "-1", "");
        test("10 plusMinus", "-10", "");
        test("9 plusMinus", "-9", "");
        test("3 plusMinus =", "-3", "-3 = ");
        test("4 plusMinus", "-4", "");
        test("56 plusMinus", "-56", "");
        test("79 plusMinus", "-79", "");
        test("69 plusMinus", "-69", "");
        test("83 plusMinus", "-83", "");
        test("97 plusMinus", "-97", "");
        test("76 plusMinus", "-76", "");
        test("94 plusMinus", "-94", "");
        test("99 plusMinus", "-99", "");
        test("0,87 plusMinus", "-0,87", "");
        test("1,6 plusMinus", "-1,6", "");
        test("2,9 plusMinus", "-2,9", "");
        test("0,83 plusMinus", "-0,83", "");
        test("0,26 plusMinus", "-0,26", "");
        test("90 plusMinus", "-90", "");
        test("1,5 plusMinus", "-1,5", "");
        test("2,1 plusMinus", "-2,1", "");
        test("0,42 plusMinus", "-0,42", "");
        test("7,9 plusMinus", "-7,9", "");
    }

    @Test
    public void subjectAreaScenarios() {
        test("50,6 plusMinus", "-50,6", "");
        test("4,2 plusMinus", "-4,2", "");
        test("229 plusMinus", "-229", "");
        test("1,49 plusMinus", "-1,49", "");
        test("795 plusMinus", "-795", "");
        test("8,08 plusMinus", "-8,08", "");
        test("0,66 plusMinus", "-0,66", "");
        test("29,4 plusMinus", "-29,4", "");
        test("5,57 plusMinus", "-5,57", "");
        test("4,73 plusMinus", "-4,73", "");
        test("194 plusMinus", "-194", "");
        test("286 plusMinus", "-286", "");
        test("198 plusMinus", "-198", "");
        test("147 plusMinus", "-147", "");
        test("513 plusMinus", "-513", "");
        test("347 plusMinus", "-347", "");
        test("89 plusMinus", "-89", "");
        test("229 plusMinus", "-229", "");
        test("52 plusMinus", "-52", "");
        test("966 plusMinus", "-966", "");
        test("2 plusMinus", "-2", "");
        test("12 plusMinus", "-12", "");
        test("300 plusMinus", "-300", "");
        test("435 plusMinus", "-435", "");
        test("0,32 plusMinus", "-0,32", "");
        test("342 plusMinus", "-342", "");
        test("0,06 plusMinus", "-0,06", "");
        test("435 plusMinus plusMinus", "435", "");
        test("0,32 plusMinus plusMinus", "0,32", "");
        test("342 plusMinus plusMinus", "342", "");
        test("0,06 plusMinus plusMinus", "0,06", "");
    }

    @Test
    public void randomNegateScenarios() {
        test("5822499848481556 plusMinus", "-5 822 499 848 481 556", "");
        test("1244855,4448569 plusMinus", "-1 244 855,4448569", "");
        test("26558745878,5688 plusMinus", "-26 558 745 878,5688", "");
        test("5893,1587891474 plusMinus", "-5 893,1587891474", "");
        test("965856,14577845 plusMinus", "-965 856,14577845", "");
        test("985654789,1245 plusMinus", "-985 654 789,1245", "");
        test("986247521457,1254 plusMinus", "-986 247 521 457,1254", "");
        test("69852,1447845874 plusMinus", "-69 852,1447845874", "");
        test("41,4557812365215 plusMinus", "-41,4557812365215", "");
        test("3,14578521414521 plusMinus", "-3,14578521414521", "");
        test("0,00015005542112 plusMinus", "-0,00015005542112", "");
        test("0,0000000000000001 plusMinus", "-0,0000000000000001", "");
        test("9999999999999999 plusMinus", "-9 999 999 999 999 999", "");
        test("147,56889 plusMinus", "-147,56889", "");
        test("2145879521455632 plusMinus", "-2 145 879 521 455 632", "");
        test("1245856321254123 plusMinus", "-1 245 856 321 254 123", "");
        test("0,000002555547 plusMinus", "-0,000002555547", "");
        test("2658,1448877154 plusMinus", "-2 658,1448877154", "");
        test("3265487412355221 plusMinus", "-3 265 487 412 355 221", "");
        test("95244,2558775265 plusMinus", "-95 244,2558775265", "");
    }

    @Test
    public void formatterNegateScenarios() {
        test("2 + 2 = plusMinus", "-4", "negate( 4 )");
        test("2 - 2 = plusMinus", "0", "negate( 0 )");
        test("2 / 2 = plusMinus", "-1", "negate( 1 )");
        test("2 * 2 = plusMinus", "-4", "negate( 4 )");
        test("2 sqr plusMinus", "-4", "negate( sqr( 2 ) )");
        test("2 sqrt plusMinus", "-1,414213562373095", "negate( √( 2 ) )");
        test("2 1/ plusMinus", "-0,5", "negate( 1/( 2 ) )");
        test("2 + 2 = plusMinus plusMinus", "4", "negate( negate( 4 ) )");
        test("2 - 2 = plusMinus plusMinus", "0", "negate( negate( 0 ) )");
        test("2 / 2 = plusMinus plusMinus", "1", "negate( negate( 1 ) )");
        test("2 * 2 = plusMinus plusMinus", "4", "negate( negate( 4 ) )");
        test("2 sqr plusMinus plusMinus", "4", "negate( negate( sqr( 2 ) ) )");
        test("2 sqrt plusMinus plusMinus", "1,414213562373095", "negate( negate( √( 2 ) ) )");
        test("2 1/ plusMinus plusMinus", "0,5", "negate( negate( 1/( 2 ) ) )");
        test("12 plusMinus sqr", "144", "sqr( -12 )");
        test("25 plusMinus sqrt", NEGATIVE_SQRT, "√( -25 )");
        test("12 plusMinus 1/", "-0,0833333333333333", "1/( -12 )");
        test("5 plusMinus plusMinus plusMinus sqr", "25", "sqr( -5 )");
        test("1 + 12 plusMinus sqr =", "145", "1 + sqr( -12 ) = ");
        test("1 + 25 plusMinus sqrt", NEGATIVE_SQRT, "1 + √( -25 )");
        test("1 + 12 plusMinus 1/ =", "0,9166666666666667", "1 + 1/( -12 ) = ");
        test("1 + 5 plusMinus plusMinus plusMinus sqr =", "26", "1 + sqr( -5 ) = ");
        test("6151 sqr sqr sqr sqr sqr plusMinus plusMinus", "1,763044461609195e+121", "negate( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) )");
        test("9405 sqr sqr sqr sqr plusMinus", "-3,747492722896453e+63", "negate( sqr( sqr( sqr( sqr( 9405 ) ) ) ) )");
        test("3290 sqr sqr sqr plusMinus plusMinus", "1,372673291590065e+28", "negate( negate( sqr( sqr( sqr( 3290 ) ) ) ) )");
        test("6280 sqr sqr sqr plusMinus", "-2,419229947156145e+30", "negate( sqr( sqr( sqr( 6280 ) ) ) )");
        test("7833 sqr sqr sqr plusMinus", "-1,41717999227222e+31", "negate( sqr( sqr( sqr( 7833 ) ) ) )");
        test("3476 sqr sqr plusMinus plusMinus", "145 988 642 795 776", "negate( negate( sqr( sqr( 3476 ) ) ) )");
        test("6151 sqr sqr sqr sqr sqr plusMinus 1/ plusMinus", "5,672006700768417e-122", "negate( 1/( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) ) )");
        test("9405 sqr sqr sqr sqr 1/ plusMinus", "-2,66845081216621e-64", "negate( 1/( sqr( sqr( sqr( sqr( 9405 ) ) ) ) ) )");
        test("3290 sqr sqr sqr plusMinus 1/ plusMinus", "7,285054689463865e-29", "negate( 1/( negate( sqr( sqr( sqr( 3290 ) ) ) ) ) )");
        test("6280 sqr sqr sqr 1/ plusMinus", "-4,133546714629259e-31", "negate( 1/( sqr( sqr( sqr( 6280 ) ) ) ) )");
        test("7833 sqr sqr sqr 1/ plusMinus", "-7,056266708907322e-32", "negate( 1/( sqr( sqr( sqr( 7833 ) ) ) ) )");
        test("3476 sqr sqr plusMinus 1/ plusMinus", "6,849847911792038e-15", "negate( 1/( negate( sqr( sqr( 3476 ) ) ) ) )");
    }

    public void test(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        clicker.clickExpression(expression);
        mainLabelAndHistoryTest(mainLabelExcepted, historyLabelExcepted);
    }

}
