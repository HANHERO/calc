package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class Sqr extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("5 sqr", "25", "sqr( 5 )");
        mouseInputTest("1 sqr", "1", "sqr( 1 )");
        mouseInputTest("10 sqr", "100", "sqr( 10 )");
        mouseInputTest("9 sqr", "81", "sqr( 9 )");
        mouseInputTest("3 sqr", "9", "sqr( 3 )");
        mouseInputTest("4 sqr", "16", "sqr( 4 )");
        mouseInputTest("56 sqr", "3 136", "sqr( 56 )");
        mouseInputTest("79 sqr", "6 241", "sqr( 79 )");
        mouseInputTest("69 sqr", "4 761", "sqr( 69 )");
        mouseInputTest("83 sqr", "6 889", "sqr( 83 )");
        mouseInputTest("97 sqr", "9 409", "sqr( 97 )");
        mouseInputTest("76 sqr", "5 776", "sqr( 76 )");
        mouseInputTest("94 sqr", "8 836", "sqr( 94 )");
        mouseInputTest("99 sqr", "9 801", "sqr( 99 )");
        mouseInputTest("0,87 sqr", "0,7569", "sqr( 0,87 )");
        mouseInputTest("1,6 sqr", "2,56", "sqr( 1,6 )");
        mouseInputTest("2,9 sqr", "8,41", "sqr( 2,9 )");
        mouseInputTest("0,83 sqr", "0,6889", "sqr( 0,83 )");
        mouseInputTest("0,26 sqr", "0,0676", "sqr( 0,26 )");
        mouseInputTest("90 sqr", "8 100", "sqr( 90 )");
        mouseInputTest("1,5 sqr", "2,25", "sqr( 1,5 )");
        mouseInputTest("2,1 sqr", "4,41", "sqr( 2,1 )");
        mouseInputTest("0,42 sqr", "0,1764", "sqr( 0,42 )");
        mouseInputTest("7,9 sqr", "62,41", "sqr( 7,9 )");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("50,6 sqr", "2 560,36", "sqr( 50,6 )");
        mouseInputTest("4,2 sqr", "17,64", "sqr( 4,2 )");
        mouseInputTest("229 sqr", "52 441", "sqr( 229 )");
        mouseInputTest("1,49 sqr", "2,2201", "sqr( 1,49 )");
        mouseInputTest("795 sqr", "632 025", "sqr( 795 )");
        mouseInputTest("8,08 sqr", "65,2864", "sqr( 8,08 )");
        mouseInputTest("0,66 sqr", "0,4356", "sqr( 0,66 )");
        mouseInputTest("29,4 sqr", "864,36", "sqr( 29,4 )");
        mouseInputTest("5,57 sqr", "31,0249", "sqr( 5,57 )");
        mouseInputTest("4,73 sqr", "22,3729", "sqr( 4,73 )");
        mouseInputTest("194 sqr", "37 636", "sqr( 194 )");
        mouseInputTest("286 sqr", "81 796", "sqr( 286 )");
        mouseInputTest("198 sqr", "39 204", "sqr( 198 )");
        mouseInputTest("147 sqr", "21 609", "sqr( 147 )");
        mouseInputTest("513 sqr", "263 169", "sqr( 513 )");
        mouseInputTest("347 sqr", "120 409", "sqr( 347 )");
        mouseInputTest("89 sqr", "7 921", "sqr( 89 )");
        mouseInputTest("229 sqr", "52 441", "sqr( 229 )");
        mouseInputTest("52 sqr", "2 704", "sqr( 52 )");
        mouseInputTest("966 sqr", "933 156", "sqr( 966 )");
        mouseInputTest("2 sqr", "4", "sqr( 2 )");
        mouseInputTest("12 sqr", "144", "sqr( 12 )");
        mouseInputTest("300 sqr", "90 000", "sqr( 300 )");
        mouseInputTest("15 sqr", "225", "sqr( 15 )");
        mouseInputTest("74 sqr", "5 476", "sqr( 74 )");
        mouseInputTest("34,44 sqr", "1 186,1136", "sqr( 34,44 )");
        mouseInputTest("98,4 sqr", "9 682,56", "sqr( 98,4 )");
        mouseInputTest("0,07 sqr", "0,0049", "sqr( 0,07 )");
        mouseInputTest("0,25 sqr", "0,0625", "sqr( 0,25 )");
        mouseInputTest("3,14 sqr", "9,8596", "sqr( 3,14 )");
        mouseInputTest("9 sqr", "81", "sqr( 9 )");
        mouseInputTest("25 sqr", "625", "sqr( 25 )");
        mouseInputTest("812322 sqr", "659 867 031 684", "sqr( 812322 )");
    }

    @Test
    public void randomSqrScenarios() {
        mouseInputTest("1234654453453545 sqr", "1,524371619432672e+30", "sqr( 1234654453453545 )");
        mouseInputTest("12353453453633 sqr", "1,526078122310771e+26", "sqr( 12353453453633 )");
        mouseInputTest("452353,3245454543 sqr", "204 623 530 227,3251", "sqr( 452353,3245454543 )");
        mouseInputTest("89874848478,48652 sqr", "8,077488389030911e+21", "sqr( 89874848478,48652 )");
        mouseInputTest("6654,612255374980 sqr", "44 283 864,26938688", "sqr( 6654,61225537498 )");
        mouseInputTest("2804283685904262 sqr", "7,864006991028794e+30", "sqr( 2804283685904262 )");
        mouseInputTest("15216056106784 sqr", "2,315283634447987e+26", "sqr( 15216056106784 )");
        mouseInputTest("862069,2202713910 sqr", "743 163 340 539,3241", "sqr( 862069,220271391 )");
        mouseInputTest("18650523300,05526 sqr", "3,478420193659041e+20", "sqr( 18650523300,05526 )");
        mouseInputTest("5417,612255374980 sqr", "29 350 522,54958918", "sqr( 5417,61225537498 )");
        mouseInputTest("3423455656543423 sqr", "1,172004863231916e+31", "sqr( 3423455656543423 )");
        mouseInputTest("43425656534345 sqr", "1,885787645438901e+27", "sqr( 43425656534345 )");
        mouseInputTest("434353,543665654 sqr", "188 663 000 894,9112", "sqr( 434353,543665654 )");
        mouseInputTest("31234565445,34234 sqr", "9,755980785593737e+20", "sqr( 31234565445,34234 )");
        mouseInputTest("5453,234565654432 sqr", "29 737 767,22804828", "sqr( 5453,234565654432 )");
        mouseInputTest("0,00000025 sqr sqr sqr sqr", "2,328306436538696e-106", "sqr( sqr( sqr( sqr( 0,00000025 ) ) ) )");
        mouseInputTest("0,0000231 / 0,5 = = = = sqr sqr sqr", "3,482215949588381e-28", "sqr( sqr( sqr( 0,0003696 ) ) )");
        mouseInputTest("999 sqr sqr sqr 1/", "1,008036120330794e-24", "1/( sqr( sqr( sqr( 999 ) ) ) )");
        mouseInputTest("999999 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,001024524979528e-6144", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 999999 ) ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("423423535 sqr sqr sqr sqr * = 1/", "8,774052023437409e-277", "1/( 1,139724265742648e+276 )");
        mouseInputTest("523122 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr 1/", "1,414306747728418e-5856", "1/( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 523122 ) ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("0,0000001 * 0,31132 = = = / 32213 = = =", "9,026669623453742e-23", "2,907761085803154e-18 ÷ 32213 = ");
        mouseInputTest("71323123435 sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        mouseInputTest("0,00031 sqr ms sqr m+ mr mc", "9,610000923521e-8", "sqr( sqr( 0,00031 ) )");
        mouseInputTest("0,000252 sqr ms sqr m+ mr mc", "6,350400403275802e-8", "sqr( sqr( 0,000252 ) )");
        mouseInputTest("0,000231 sqr ms sqr m+ mr mc", "5,336100284739632e-8", "sqr( sqr( 0,000231 ) )");
        mouseInputTest("0,000512 sqr ms sqr m+ mr mc", "2,621440687194767e-7", "sqr( sqr( 0,000512 ) )");
        mouseInputTest("0,000341 sqr ms sqr m+ mr mc", "1,16281013521271e-7", "sqr( sqr( 0,000341 ) )");
        mouseInputTest("99,98887 sqr", "9 997,7741238769", "sqr( 99,98887 )");
        mouseInputTest("46894125648425 sqrt", "6 847 928,566247241", "√( 46894125648425 )");
        mouseInputTest("25000000 sqr sqr sqr sqr", "2,328306436538696e+118", "sqr( sqr( sqr( sqr( 25000000 ) ) ) )");
        mouseInputTest("999999 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "9,989765235976125e+6143", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 999999 ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("0,0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus 1/", "2,978978242572731e+229", "1/( negate( -3,356855668527379e-230 ) )");
        mouseInputTest("523122 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "7,070601915787683e+5855", "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( 523122 ) ) ) ) ) ) ) ) ) )");
        mouseInputTest("71323123435 sqr sqr sqr sqr * = 1/", "4,97311699471495e-348", "1/( 2,010811330324068e+347 )");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr 1/", "2,379239093500725e+79", "1/( sqr( -2,050127902199213e-40 ) )");
    }

    @Test
    public void formatterSqrScenarios() {
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus sqr", "3,108325773610856e+242", "sqr( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) )");
        mouseInputTest("9405 sqr sqr sqr sqr sqr", "1,404370170816187e+127", "sqr( sqr( sqr( sqr( sqr( 9405 ) ) ) ) )");
        mouseInputTest("3290 sqr sqr sqr plusMinus sqr", "1,884231965444703e+56", "sqr( negate( sqr( sqr( sqr( 3290 ) ) ) ) )");
        mouseInputTest("6280 sqr sqr sqr sqr", "5,852673537217125e+60", "sqr( sqr( sqr( sqr( 6280 ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr sqr", "2,008399130496689e+62", "sqr( sqr( sqr( sqr( 7833 ) ) ) )");
        mouseInputTest("3476 sqr sqr plusMinus sqr", "2,131268382535268e+28", "sqr( negate( sqr( sqr( 3476 ) ) ) )");
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus 1/ sqr", "3,217166001356182e-243", "sqr( 1/( negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) ) )");
        mouseInputTest("9405 sqr sqr sqr sqr 1/ sqr", "7,120629736950503e-128", "sqr( 1/( sqr( sqr( sqr( sqr( 9405 ) ) ) ) ) )");
        mouseInputTest("3290 sqr sqr sqr plusMinus 1/ sqr", "5,307202182847944e-57", "sqr( 1/( negate( sqr( sqr( sqr( 3290 ) ) ) ) ) )");
        mouseInputTest("6280 sqr sqr sqr 1/ sqr", "1,708620844202234e-61", "sqr( 1/( sqr( sqr( sqr( 6280 ) ) ) ) )");
        mouseInputTest("7833 sqr sqr sqr 1/ sqr", "4,979089986723376e-63", "sqr( 1/( sqr( sqr( sqr( 7833 ) ) ) ) )");
        mouseInputTest("3476 sqr sqr plusMinus 1/ sqr", "4,692041641468174e-29", "sqr( 1/( negate( sqr( sqr( 3476 ) ) ) ) )");
    }
}
