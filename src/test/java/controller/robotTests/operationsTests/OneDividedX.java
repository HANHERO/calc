package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class OneDividedX extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("25 1/", "0,04", "1/( 25 )");
        mouseInputTest("1 1/", "1", "1/( 1 )");
        mouseInputTest("100 1/", "0,01", "1/( 100 )");
        mouseInputTest("9 1/", "0,1111111111111111", "1/( 9 )");
        mouseInputTest("3 1/", "0,3333333333333333", "1/( 3 )");
        mouseInputTest("4 1/", "0,25", "1/( 4 )");
        mouseInputTest("56 1/", "0,0178571428571429", "1/( 56 )");
        mouseInputTest("79 1/", "0,0126582278481013", "1/( 79 )");
        mouseInputTest("69 1/", "0,0144927536231884", "1/( 69 )");
        mouseInputTest("83 1/", "0,0120481927710843", "1/( 83 )");
        mouseInputTest("97 1/", "0,0103092783505155", "1/( 97 )");
        mouseInputTest("76 1/", "0,0131578947368421", "1/( 76 )");
        mouseInputTest("94 1/", "0,0106382978723404", "1/( 94 )");
        mouseInputTest("99 1/", "0,0101010101010101", "1/( 99 )");
        mouseInputTest("0,87 1/", "1,149425287356322", "1/( 0,87 )");
        mouseInputTest("1,6 1/", "0,625", "1/( 1,6 )");
        mouseInputTest("2,9 1/", "0,3448275862068966", "1/( 2,9 )");
        mouseInputTest("0,83 1/", "1,204819277108434", "1/( 0,83 )");
        mouseInputTest("0,26 1/", "3,846153846153846", "1/( 0,26 )");
        mouseInputTest("90 1/", "0,0111111111111111", "1/( 90 )");
        mouseInputTest("1,5 1/", "0,6666666666666667", "1/( 1,5 )");
        mouseInputTest("2,1 1/", "0,4761904761904762", "1/( 2,1 )");
        mouseInputTest("0,42 1/", "2,380952380952381", "1/( 0,42 )");
        mouseInputTest("7,9 1/", "0,1265822784810127", "1/( 7,9 )");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("0 1/", DIVISION_BY_ZERO, "1/( 0 )");
        mouseInputTest("50,6 1/", "0,0197628458498024", "1/( 50,6 )");
        mouseInputTest("4,2 1/", "0,2380952380952381", "1/( 4,2 )");
        mouseInputTest("229 1/", "0,0043668122270742", "1/( 229 )");
        mouseInputTest("1,49 1/", "0,6711409395973154", "1/( 1,49 )");
        mouseInputTest("795 1/", "0,0012578616352201", "1/( 795 )");
        mouseInputTest("8,08 1/", "0,1237623762376238", "1/( 8,08 )");
        mouseInputTest("0,66 1/", "1,515151515151515", "1/( 0,66 )");
        mouseInputTest("29,4 1/", "0,0340136054421769", "1/( 29,4 )");
        mouseInputTest("5,57 1/", "0,1795332136445242", "1/( 5,57 )");
        mouseInputTest("4,73 1/", "0,2114164904862579", "1/( 4,73 )");
        mouseInputTest("194 1/", "0,0051546391752577", "1/( 194 )");
        mouseInputTest("286 1/", "0,0034965034965035", "1/( 286 )");
        mouseInputTest("198 1/", "0,0050505050505051", "1/( 198 )");
        mouseInputTest("147 1/", "0,0068027210884354", "1/( 147 )");
        mouseInputTest("513 1/", "0,0019493177387914", "1/( 513 )");
        mouseInputTest("347 1/", "0,0028818443804035", "1/( 347 )");
        mouseInputTest("89 1/", "0,0112359550561798", "1/( 89 )");
        mouseInputTest("229 1/", "0,0043668122270742", "1/( 229 )");
        mouseInputTest("52 1/", "0,0192307692307692", "1/( 52 )");
        mouseInputTest("966 1/", "0,0010351966873706", "1/( 966 )");
        mouseInputTest("2 1/", "0,5", "1/( 2 )");
        mouseInputTest("12 1/", "0,0833333333333333", "1/( 12 )");
        mouseInputTest("300 1/", "0,0033333333333333", "1/( 300 )");
    }

    @Test
    public void randomOneDividedXScenarios() {
        mouseInputTest("4123412356234523 1/", "2,425175834010437e-16", "1/( 4123412356234523 )");
        mouseInputTest("41235656765432 1/", "2,425085662363704e-14", "1/( 41235656765432 )");
        mouseInputTest("123432,2134565542 1/", "8,10161279617643e-6", "1/( 123432,2134565542 )");
        mouseInputTest("32454656532,32454 1/", "3,08122194731597e-11", "1/( 32454656532,32454 )");
        mouseInputTest("2312,324556542234 1/", "4,324652424637844e-4", "1/( 2312,324556542234 )");
        mouseInputTest("2345432246665433 1/", "4,263606426583962e-16", "1/( 2345432246665433 )");
        mouseInputTest("34566534523454 1/", "2,892971522272452e-14", "1/( 34566534523454 )");
        mouseInputTest("453453,3452345343 1/", "2,205298539550484e-6", "1/( 453453,3452345343 )");
        mouseInputTest("23432452334,34234 1/", "4,267585764100376e-11", "1/( 23432452334,34234 )");
        mouseInputTest("1234,632342345212 1/", "8,099577223940833e-4", "1/( 1234,632342345212 )");
        mouseInputTest("2804283685904262 1/", "3,56597303270886e-16", "1/( 2804283685904262 )");
        mouseInputTest("15216056106784 1/", "6,572005209379815e-14", "1/( 15216056106784 )");
        mouseInputTest("862069,2202713910 1/", "1,159999657202918e-6", "1/( 862069,220271391 )");
        mouseInputTest("18650523300,05526 1/", "5,361779848810125e-11", "1/( 18650523300,05526 )");
        mouseInputTest("5417,612255374980 1/", "1,845831618916376e-4", "1/( 5417,61225537498 )");
        mouseInputTest("72346744532 1/ sqr", "1,910565860169429e-22", "sqr( 1/( 72346744532 ) )");
        mouseInputTest("33333 1/ * = = = =", "2,430121503645085e-23", "8,100324008100162e-19 × 3,000030000300003e-5 = ");
        mouseInputTest("999999 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,001024524979528e-6144", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 999999 ) ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("768756463574 + 442553232 % = = = = 1/", "7,348279842819386e-20", "1/( 1,360862707177902e+19 )");
        mouseInputTest("99999999999 * 99999999 * 999999999 sqr sqr = = 1/", "1,00000001801e-91", "1/( 9,999999819900001e+90 )");
        mouseInputTest("423423535 sqr sqr sqr sqr * = 1/", "8,774052023437409e-277", "1/( 1,139724265742648e+276 )");
        mouseInputTest("523122 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,414306747728418e-5856", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 523122 ) ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("71323123435 sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        mouseInputTest("32100 1/", "3,115264797507788e-5", "1/( 32100 )");
        mouseInputTest("76400 1/", "1,308900523560209e-5", "1/( 76400 )");
        mouseInputTest("523100 1/", "1,91168036704263e-6", "1/( 523100 )");
        mouseInputTest("734800 1/", "1,360914534567229e-6", "1/( 734800 )");
        mouseInputTest("512200 1/", "1,952362358453729e-6", "1/( 512200 )");
        mouseInputTest("23100 1/", "4,329004329004329e-5", "1/( 23100 )");
        mouseInputTest("12,55259884754265 1/", "0,0796647779591685", "1/( 12,55259884754265 )");
        mouseInputTest("487,2136 1/", "0,0020524878615868", "1/( 487,2136 )");
        mouseInputTest(MIN_INPUT + " / " + MAX_INPUT + " = 1/", "9,999999999999999e+31", "1/( 1e-32 )");
        mouseInputTest(MIN_INPUT + " * 0,0000001 - = = = = = 1/", "-2,5e+22", "1/( -4e-23 )");
        mouseInputTest(MIN_INPUT + " * " + MIN_INPUT + " - = = = = = 1/", "-2,5e+31", "1/( -4e-32 )");
        mouseInputTest(MIN_INPUT + " * = = = = 1/", "1e+80", "1/( 1e-80 )");
        mouseInputTest(MIN_INPUT + " * 0,0000000324412 - = = = = = 1/", "-7,706250077062501e+22", "1/( -1,297648e-23 )");
        mouseInputTest("0,0000001 * 0,31 = = = / 3213 = = = 1/", "1,113389432949549e+19", "1/( 8,981583356246147e-20 )");
        mouseInputTest("0,4342 sqr sqr sqr sqr 1/ sqr sqr", "1,541173654637358e+23", "sqr( sqr( 1/( sqr( sqr( sqr( sqr( 0,4342 ) ) ) ) ) ) )");
        mouseInputTest(",4865258684 * ,0000000778 sqr sqr sqr sqr = = = 1/", "3,514579795129855e+341", "1/( 2,845290357002842e-342 )");
        mouseInputTest("0,0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus 1/", "2,978978242572731e+229", "1/( 3,356855668527379e-230 )");
        mouseInputTest("0,0000000002 * = = = = sqr 1/", "9,765625e+96", "1/( sqr( 3,2e-49 ) )");
        mouseInputTest(",000000342 * 0,3123134 * 0,00000000000321 = sqr 1/", "8,506609298345788e+36", "1/( sqr( 3,42863896788e-19 ) )");
        mouseInputTest(MIN_INPUT + " / " + MAX_INPUT + " = = = 1/", "9,999999999999997e+63", "1/( 1e-64 )");
        mouseInputTest("0,000000000052578 / 95858478529985,5 = 1/", "1,823167076153249e+24", "1/( 5,484960830413459e-25 )");
        mouseInputTest("0,0000001 * 0,31132 = = = / 32213 = = = 1/", "1,107828292952838e+22", "1/( 9,026669623453742e-23 )");
        mouseInputTest("71323123435 sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr 1/", "2,379239093500725e+79", "1/( sqr( -2,050127902199213e-40 ) )");
    }

    @Test
    public void formatterNegateScenarios() {
        mouseInputTest("4234 sqr sqr sqr sqr sqr plusMinus 1/", "-8,789672265442665e-117", "1/( negate( sqr( sqr( sqr( sqr( sqr( 4234 ) ) ) ) ) ) )");
        mouseInputTest("0,23 sqr sqr sqr sqr 1/", "16 306 269 797,3283", "1/( sqr( sqr( sqr( sqr( 0,23 ) ) ) ) )");
        mouseInputTest("3290 sqr sqr sqr plusMinus 1/", "-7,285054689463865e-29", "1/( negate( sqr( sqr( sqr( 3290 ) ) ) ) )");
        mouseInputTest("6280 sqr sqr sqr 1/", "4,133546714629259e-31", "1/( sqr( sqr( sqr( 6280 ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr 1/", "7,056266708907322e-32", "1/( sqr( sqr( sqr( 7833 ) ) ) )");
        mouseInputTest("324 sqr sqr plusMinus 1/", "-9,074442627116709e-11", "1/( negate( sqr( sqr( 324 ) ) ) )");
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus 1/ 1/", "-1,763044461609195e+121", "1/( 1/( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) ) )");
        mouseInputTest("0,423 sqr sqr sqr sqr 1/ 1/", "1,050620517843467e-6", "1/( 1/( sqr( sqr( sqr( sqr( 0,423 ) ) ) ) ) )");
        mouseInputTest("3290 sqr sqr sqr plusMinus 1/ 1/", "-1,372673291590065e+28", "1/( 1/( negate( sqr( sqr( sqr( 3290 ) ) ) ) ) )");
        mouseInputTest("2314,432 sqr sqr sqr 1/ 1/", "8,232948578414145e+26", "1/( 1/( sqr( sqr( sqr( 2314,432 ) ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr 1/ 1/", "1,41717999227222e+31", "1/( 1/( sqr( sqr( sqr( 7833 ) ) ) ) )");
        mouseInputTest("0,00321 sqr sqr plusMinus 1/ 1/", "-1,0617447681e-10", "1/( 1/( negate( sqr( sqr( 0,00321 ) ) ) ) )");
        mouseInputTest("2 1/ 1/ 1/ 1/", "2", "1/( 1/( 1/( 1/( 2 ) ) ) )");
        mouseInputTest("1 1/ 1/ 1/ 1/ 1/", "1", "1/( 1/( 1/( 1/( 1/( 1 ) ) ) ) )");
        mouseInputTest("58 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/", "58", "1/( 1/( 1/( 1/( 1/( 1/( 1/( 1/( 58 ) ) ) ) ) ) ) )");
        mouseInputTest("80546 1/ 1/ 1/ 1/ 1/", "1,241526581084101e-5", "1/( 1/( 1/( 1/( 1/( 80546 ) ) ) ) )");
        mouseInputTest("24,7931 1/ 1/ 1/ 1/ 1/ 1/", "24,7931", "1/( 1/( 1/( 1/( 1/( 1/( 24,7931 ) ) ) ) ) )");
        mouseInputTest("17,4772 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/", "17,4772", "1/( 1/( 1/( 1/( 1/( 1/( 1/( 1/( 17,4772 ) ) ) ) ) ) ) )");
        mouseInputTest("313,392 1/ 1/ 1/ 1/ 1/", "0,0031908919181089", "1/( 1/( 1/( 1/( 1/( 313,392 ) ) ) ) )");
        mouseInputTest("234123 1/ 1/ 1/ 1/", "234 123", "1/( 1/( 1/( 1/( 234123 ) ) ) )");
        mouseInputTest("89 1/ 1/", "89", "1/( 1/( 89 ) )");
        mouseInputTest("71 1/ 1/ 1/", "0,0140845070422535", "1/( 1/( 1/( 71 ) ) )");
    }
}
