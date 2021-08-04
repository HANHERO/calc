package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class Negate extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("5 plusMinus", "-5", "");
        mouseInputTest("1 plusMinus", "-1", "");
        mouseInputTest("10 plusMinus", "-10", "");
        mouseInputTest("9 plusMinus", "-9", "");
        mouseInputTest("3 plusMinus =", "-3", "-3 = ");
        mouseInputTest("4 plusMinus", "-4", "");
        mouseInputTest("56 plusMinus", "-56", "");
        mouseInputTest("79 plusMinus", "-79", "");
        mouseInputTest("69 plusMinus", "-69", "");
        mouseInputTest("83 plusMinus", "-83", "");
        mouseInputTest("97 plusMinus", "-97", "");
        mouseInputTest("76 plusMinus", "-76", "");
        mouseInputTest("94 plusMinus", "-94", "");
        mouseInputTest("99 plusMinus", "-99", "");
        mouseInputTest("0,87 plusMinus", "-0,87", "");
        mouseInputTest("1,6 plusMinus", "-1,6", "");
        mouseInputTest("2,9 plusMinus", "-2,9", "");
        mouseInputTest("0,83 plusMinus", "-0,83", "");
        mouseInputTest("0,26 plusMinus", "-0,26", "");
        mouseInputTest("90 plusMinus", "-90", "");
        mouseInputTest("1,5 plusMinus", "-1,5", "");
        mouseInputTest("2,1 plusMinus", "-2,1", "");
        mouseInputTest("0,42 plusMinus", "-0,42", "");
        mouseInputTest("7,9 plusMinus", "-7,9", "");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("50,6 plusMinus", "-50,6", "");
        mouseInputTest("4,2 plusMinus", "-4,2", "");
        mouseInputTest("229 plusMinus", "-229", "");
        mouseInputTest("1,49 plusMinus", "-1,49", "");
        mouseInputTest("795 plusMinus", "-795", "");
        mouseInputTest("8,08 plusMinus", "-8,08", "");
        mouseInputTest("0,66 plusMinus", "-0,66", "");
        mouseInputTest("29,4 plusMinus", "-29,4", "");
        mouseInputTest("5,57 plusMinus", "-5,57", "");
        mouseInputTest("4,73 plusMinus", "-4,73", "");
        mouseInputTest("194 plusMinus", "-194", "");
        mouseInputTest("286 plusMinus", "-286", "");
        mouseInputTest("198 plusMinus", "-198", "");
        mouseInputTest("147 plusMinus", "-147", "");
        mouseInputTest("513 plusMinus", "-513", "");
        mouseInputTest("347 plusMinus", "-347", "");
        mouseInputTest("89 plusMinus", "-89", "");
        mouseInputTest("229 plusMinus", "-229", "");
        mouseInputTest("52 plusMinus", "-52", "");
        mouseInputTest("966 plusMinus", "-966", "");
        mouseInputTest("2 plusMinus", "-2", "");
        mouseInputTest("12 plusMinus", "-12", "");
        mouseInputTest("300 plusMinus", "-300", "");
        mouseInputTest("435 plusMinus", "-435", "");
        mouseInputTest("0,32 plusMinus", "-0,32", "");
        mouseInputTest("342 plusMinus", "-342", "");
        mouseInputTest("0,06 plusMinus", "-0,06", "");
        mouseInputTest("435 plusMinus plusMinus", "435", "");
        mouseInputTest("0,32 plusMinus plusMinus", "0,32", "");
        mouseInputTest("342 plusMinus plusMinus", "342", "");
        mouseInputTest("0,06 plusMinus plusMinus", "0,06", "");
    }

    @Test
    public void randomNegateScenarios() {
        mouseInputTest("5822499848481556 plusMinus", "-5 822 499 848 481 556", "");
        mouseInputTest("1244855,4448569 plusMinus", "-1 244 855,4448569", "");
        mouseInputTest("26558745878,5688 plusMinus", "-26 558 745 878,5688", "");
        mouseInputTest("5893,1587891474 plusMinus", "-5 893,1587891474", "");
        mouseInputTest("965856,14577845 plusMinus", "-965 856,14577845", "");
        mouseInputTest("985654789,1245 plusMinus", "-985 654 789,1245", "");
        mouseInputTest("986247521457,1254 plusMinus", "-986 247 521 457,1254", "");
        mouseInputTest("69852,1447845874 plusMinus", "-69 852,1447845874", "");
        mouseInputTest("41,4557812365215 plusMinus", "-41,4557812365215", "");
        mouseInputTest("3,14578521414521 plusMinus", "-3,14578521414521", "");
        mouseInputTest("0,00015005542112 plusMinus", "-0,00015005542112", "");
        mouseInputTest("0,0000000000000001 plusMinus", "-0,0000000000000001", "");
        mouseInputTest("9999999999999999 plusMinus", "-9 999 999 999 999 999", "");
        mouseInputTest("147,56889 plusMinus", "-147,56889", "");
        mouseInputTest("2145879521455632 plusMinus", "-2 145 879 521 455 632", "");
        mouseInputTest("1245856321254123 plusMinus", "-1 245 856 321 254 123", "");
        mouseInputTest("0,000002555547 plusMinus", "-0,000002555547", "");
        mouseInputTest("2658,1448877154 plusMinus", "-2 658,1448877154", "");
        mouseInputTest("3265487412355221 plusMinus", "-3 265 487 412 355 221", "");
        mouseInputTest("95244,2558775265 plusMinus", "-95 244,2558775265", "");
        mouseInputTest(",0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus", "3,356855668527379e-230", "");
        mouseInputTest("0,0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus 1/", "2,978978242572731e+229", "1/( 3,356855668527379e-230 )");
        mouseInputTest("0,0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus 1/ - 0,0002569 sqr sqr sqr sqr sqr sqr - = = =", "-5,957956485145461e+229", "-2,978978242572731e+229 - 2,978978242572731e+229 = ");
        mouseInputTest("0,0002569 sqr sqr sqr sqr sqr sqr plusMinus 1/ - 2,05 sqr sqr sqr sqr sqr sqr plusMinus = = =", "-5,957956485145461e+229", "-5,957956485145461e+229 - -8,958743607104719e+19 = ");
        mouseInputTest(MAX_NUMBER + " plusMinus", "-9,999999999999999e+9999", "");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " plusMinus", "-1e-9999", "");
    }

    @Test
    public void formatterNegateScenarios() {
        mouseInputTest("2 + 2 = plusMinus", "-4", "");
        mouseInputTest("2 - 2 = plusMinus", "0", "");
        mouseInputTest("2 / 2 = plusMinus", "-1", "");
        mouseInputTest("2 * 2 = plusMinus", "-4", "");
        mouseInputTest("2 sqr plusMinus", "-4", "negate( sqr( 2 ) )");
        mouseInputTest("2 sqrt plusMinus", "-1,414213562373095", "negate( √( 2 ) )");
        mouseInputTest("2 1/ plusMinus", "-0,5", "negate( 1/( 2 ) )");
        mouseInputTest("2 + 2 = plusMinus plusMinus", "4", "");
        mouseInputTest("2 - 2 = plusMinus plusMinus", "0", "");
        mouseInputTest("2 / 2 = plusMinus plusMinus", "1", "");
        mouseInputTest("2 * 2 = plusMinus plusMinus", "4", "");
        mouseInputTest("2 sqr plusMinus plusMinus", "4", "negate( negate( sqr( 2 ) ) )");
        mouseInputTest("2 sqrt plusMinus plusMinus", "1,414213562373095", "negate( negate( √( 2 ) ) )");
        mouseInputTest("2 1/ plusMinus plusMinus", "0,5", "negate( negate( 1/( 2 ) ) )");
        mouseInputTest("12 plusMinus sqr", "144", "sqr( -12 )");
        mouseInputTest("25 plusMinus sqrt", NEGATIVE_SQRT, "√( -25 )");
        mouseInputTest("12 plusMinus 1/", "-0,0833333333333333", "1/( -12 )");
        mouseInputTest("5 plusMinus plusMinus plusMinus sqr", "25", "sqr( -5 )");
        mouseInputTest("1 + 12 plusMinus sqr =", "145", "1 + sqr( -12 ) = ");
        mouseInputTest("1 + 25 plusMinus sqrt", NEGATIVE_SQRT, "1 + √( -25 )");
        mouseInputTest("1 + 12 plusMinus 1/ =", "0,9166666666666667", "1 + 1/( -12 ) = ");
        mouseInputTest("1 + 5 plusMinus plusMinus plusMinus sqr =", "26", "1 + sqr( -5 ) = ");
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus plusMinus", "1,763044461609195e+121", "negate( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) )");
        mouseInputTest("9405 sqr sqr sqr sqr plusMinus", "-3,747492722896453e+63", "negate( sqr( sqr( sqr( sqr( 9405 ) ) ) ) )");
        mouseInputTest("3290 sqr sqr sqr plusMinus plusMinus", "1,372673291590065e+28", "negate( negate( sqr( sqr( sqr( 3290 ) ) ) ) )");
        mouseInputTest("6280 sqr sqr sqr plusMinus", "-2,419229947156145e+30", "negate( sqr( sqr( sqr( 6280 ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr plusMinus", "-1,41717999227222e+31", "negate( sqr( sqr( sqr( 7833 ) ) ) )");
        mouseInputTest("3476 sqr sqr plusMinus plusMinus", "145 988 642 795 776", "negate( negate( sqr( sqr( 3476 ) ) ) )");
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus 1/ plusMinus", "5,672006700768417e-122", "negate( 1/( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) ) )");
        mouseInputTest("9405 sqr sqr sqr sqr 1/ plusMinus", "-2,66845081216621e-64", "negate( 1/( sqr( sqr( sqr( sqr( 9405 ) ) ) ) ) )");
        mouseInputTest("3290 sqr sqr sqr plusMinus 1/ plusMinus", "7,285054689463865e-29", "negate( 1/( negate( sqr( sqr( sqr( 3290 ) ) ) ) ) )");
        mouseInputTest("6280 sqr sqr sqr 1/ plusMinus", "-4,133546714629259e-31", "negate( 1/( sqr( sqr( sqr( 6280 ) ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr 1/ plusMinus", "-7,056266708907322e-32", "negate( 1/( sqr( sqr( sqr( 7833 ) ) ) ) )");
        mouseInputTest("3476 sqr sqr plusMinus 1/ plusMinus", "6,849847911792038e-15", "negate( 1/( negate( sqr( sqr( 3476 ) ) ) ) )");
    }
}
