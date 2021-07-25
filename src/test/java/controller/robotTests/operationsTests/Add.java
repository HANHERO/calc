package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class Add extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("5 + 1 =", "6", "5 + 1 = ");
        mouseInputTest("5 + 3 =", "8", "5 + 3 = ");
        mouseInputTest("1 + 4 =", "5", "1 + 4 = ");
        mouseInputTest("1 + 9 =", "10", "1 + 9 = ");
        mouseInputTest("10 + 5 =", "15", "10 + 5 = ");
        mouseInputTest("5 + 8 =", "13", "5 + 8 = ");
        mouseInputTest("9 + 5 =", "14", "9 + 5 = ");
        mouseInputTest("3 + 1 =", "4", "3 + 1 = ");
        mouseInputTest("4 + 1 =", "5", "4 + 1 = ");
        mouseInputTest("9 + 10 =", "19", "9 + 10 = ");
        mouseInputTest("6 + 85 =", "91", "6 + 85 = ");
        mouseInputTest("56 + 7 =", "63", "56 + 7 = ");
        mouseInputTest("79 + 16 =", "95", "79 + 16 = ");
        mouseInputTest("69 + 43 =", "112", "69 + 43 = ");
        mouseInputTest("83 + 71 =", "154", "83 + 71 = ");
        mouseInputTest("97 + 60 =", "157", "97 + 60 = ");
        mouseInputTest("76 + 35 =", "111", "76 + 35 = ");
        mouseInputTest("94 + 28 =", "122", "94 + 28 = ");
        mouseInputTest("99 + 58 =", "157", "99 + 58 = ");
        mouseInputTest("10 + 68 =", "78", "10 + 68 = ");
        mouseInputTest("0,87 + 0,14 =", "1,01", "0,87 + 0,14 = ");
        mouseInputTest("1,6 + 70 plusMinus =", "-68,4", "1,6 + -70 = ");
        mouseInputTest("2,9 + 0,5 =", "3,4", "2,9 + 0,5 = ");
        mouseInputTest("0,83 + 0,73 =", "1,56", "0,83 + 0,73 = ");
        mouseInputTest("0,26 + 0,13 =", "0,39", "0,26 + 0,13 = ");
        mouseInputTest("90 plusMinus + 8,1 =", "-81,9", "-90 + 8,1 = ");
        mouseInputTest("1,5 + 3,8 =", "5,3", "1,5 + 3,8 = ");
        mouseInputTest("2,1 + 0,4 =", "2,5", "2,1 + 0,4 = ");
        mouseInputTest("0,42 + 0,32 =", "0,74", "0,42 + 0,32 = ");
        mouseInputTest("7,9 + 0,99 =", "8,89", "7,9 + 0,99 = ");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("50,6 + 1,14 =", "51,74", "50,6 + 1,14 = ");
        mouseInputTest("4,2 + 534 =", "538,2", "4,2 + 534 = ");
        mouseInputTest("229 + 8,31 =", "237,31", "229 + 8,31 = ");
        mouseInputTest("1,49 + 223 =", "224,49", "1,49 + 223 = ");
        mouseInputTest("795 + 2,19 =", "797,19", "795 + 2,19 = ");
        mouseInputTest("8,08 + 441 =", "449,08", "8,08 + 441 = ");
        mouseInputTest("0,66 + 3,84 =", "4,5", "0,66 + 3,84 = ");
        mouseInputTest("29,4 + 0,244 =", "29,644", "29,4 + 0,244 = ");
        mouseInputTest("5,57 + 0,585 =", "6,155", "5,57 + 0,585 = ");
        mouseInputTest("4,73 + 6,2 =", "10,93", "4,73 + 6,2 = ");
        mouseInputTest("194 + 108 =", "302", "194 + 108 = ");
        mouseInputTest("286 + 385 =", "671", "286 + 385 = ");
        mouseInputTest("198 + 798 =", "996", "198 + 798 = ");
        mouseInputTest("147 + 29 =", "176", "147 + 29 = ");
        mouseInputTest("513 + 936 =", "1 449", "513 + 936 = ");
        mouseInputTest("347 + 802 =", "1 149", "347 + 802 = ");
        mouseInputTest("89 + 63 =", "152", "89 + 63 = ");
        mouseInputTest("229 + 370 =", "599", "229 + 370 = ");
        mouseInputTest("52 + 472 =", "524", "52 + 472 = ");
        mouseInputTest("966 + 133 =", "1 099", "966 + 133 = ");
        mouseInputTest("2 + 2 =", "4", "2 + 2 = ");
        mouseInputTest("12 + 24 =", "36", "12 + 24 = ");
        mouseInputTest("300 + =", "600", "300 + 300 = ");
        mouseInputTest("300 + = =", "900", "600 + 300 = ");
        mouseInputTest("1234 + 265 =", "1 499", "1234 + 265 = ");
        mouseInputTest("421,87 + 0,42 =", "422,29", "421,87 + 0,42 = ");
        mouseInputTest("2341 + 54 =", "2 395", "2341 + 54 = ");
        mouseInputTest("0,421 + ,353 =", "0,774", "0,421 + 0,353 = ");
        mouseInputTest("57899 + 543213 =", "601 112", "57899 + 543213 = ");
        mouseInputTest("5456,74 + 532,34 =", "5 989,08", "5456,74 + 532,34 = ");
        mouseInputTest("65,432 + 322 =", "387,432", "65,432 + 322 = ");
        mouseInputTest("543 + 5432 =", "5 975", "543 + 5432 = ");
        mouseInputTest("324,43 + 56,64 =", "381,07", "324,43 + 56,64 = ");
        mouseInputTest("245,6 + 1212222 =", "1 212 467,6", "245,6 + 1212222 = ");
    }

    @Test
    public void randomAddScenarios() {
        mouseInputTest("2804283685904262 + 3770050392348772 =", "6 574 334 078 253 034", "2804283685904262 + 3770050392348772 = ");
        mouseInputTest("15216056106784 + 1139097799493685 =", "1 154 313 855 600 469", "15216056106784 + 1139097799493685 = ");
        mouseInputTest("862069,2202713910 + 7233,425940889578 =", "869 302,6462122806", "862069,220271391 + 7233,425940889578 = ");
        mouseInputTest("18650523300,05526 + 16394,44527286028 =", "18 650 539 694,50053", "18650523300,05526 + 16394,44527286028 = ");
        mouseInputTest("5417,612255374980 + 492115243664,6449 =", "492 115 249 082,2572", "5417,61225537498 + 492115243664,6449 = ");
        mouseInputTest("9484736475874736 + 8675645353783743 =", "1,816038182965848e+16", "9484736475874736 + 8675645353783743 = ");
        mouseInputTest("87675646355654 + 9685746464646463 =", "9 773 422 111 002 117", "87675646355654 + 9685746464646463 = ");
        mouseInputTest("4543,4345354534 + 54532,3231233448 =", "59 075,7576587982", "4543,4345354534 + 54532,3231233448 = ");
        mouseInputTest("99686757775,32312 + 66654,34534544434 =", "99 686 824 429,66847", "99686757775,32312 + 66654,34534544434 = ");
        mouseInputTest("8796,323456776665 + 766565787867,4344 =", "766 565 796 663,7579", "8796,323456776665 + 766565787867,4344 = ");
        mouseInputTest("8796776767676858 + 8675767565574873 =", "1,747254433325173e+16", "8796776767676858 + 8675767565574873 = ");
        mouseInputTest("44332356775332 + 987867685544334 =", "1 032 200 042 319 666", "44332356775332 + 987867685544334 = ");
        mouseInputTest("342342,2545323230 + 7432,425435667768 =", "349 774,6799679908", "342342,254532323 + 7432,425435667768 = ");
        mouseInputTest("18643435640,05436 + 163544345353028 =", "163 562 988 788 668,1", "18643435640,05436 + 163544345353028 = ");
        mouseInputTest("5654,6134534533 + 492536776464,6449 =", "492 536 782 119,2584", "5654,6134534533 + 492536776464,6449 = ");
        mouseInputTest("453345565 sqr + = = = = =", "1,233133207831015e+18", "1,027611006525846e+18 + 2,055222013051692e+17 = ");
        mouseInputTest(MIN_INPUT + " * 0,1 + 0,0000003 =", "3,0000000001e-7", "1e-17 + 0,0000003 = ");
        mouseInputTest(MIN_INPUT + " * 0,11 + 0,00000031 =", "3,10000000011e-7", "1,1e-17 + 0,00000031 = ");
        mouseInputTest("3465757565432 + 484951155698 = + = + = * = + = =", "7,491887711622067e+26", "4,994591807748045e+26 + 2,497295903874022e+26 = ");
        mouseInputTest(MIN_INPUT + " * 0,42 + 0,0000003 =", "3,00000000042e-7", "4,2e-17 + 0,0000003 = ");
        mouseInputTest("5948451514232221 sqr + = = =", "1,415363016686864e+32", "1,061522262515148e+32 + 3,53840754171716e+31 = ");
        mouseInputTest(MIN_INPUT + " * 0,123 + 0,0000026 =", "2,6000000000123e-6", "1,23e-17 + 0,0000026 = ");
        mouseInputTest(MIN_INPUT + " * 0,2 + 0,0000002 =", "2,0000000002e-7", "2e-17 + 0,0000002 = ");
        mouseInputTest("7345645644566 sqr + = = =", "2,158340397421258e+26", "1,618755298065943e+26 + 5,395850993553145e+25 = ");
        mouseInputTest("65444334533 sqr + = = =", "1,713184368986887e+22", "1,284888276740165e+22 + 4,282960922467216e+21 = ");
        mouseInputTest("3456547567345 sqr + = = =", "4,779088434127455e+25", "3,584316325595591e+25 + 1,194772108531864e+25 = ");
        mouseInputTest("0,0000345654756734 sqr + = = =", "4,779088434113629e-9", "3,584316325585222e-9 + 1,194772108528407e-9 = ");
        mouseInputTest("9847564736475643 sqr sqr sqr sqr + = + = + =", "6,256788846159051e+256", "3,128394423079525e+256 + 3,128394423079525e+256 = ");
        mouseInputTest("0,000000000000014 sqr sqr sqr + = + = + =", "1,1806312448e-110", "5,903156224e-111 + 5,903156224e-111 = ");
        mouseInputTest("0,0000345654756734 sqr sqr sqr + 0,0025484 sqr sqr sqr = = = =", "7,115423644532377e-21", "5,336567733399283e-21 + 1,778855911133094e-21 = ");
    }

    @Test
    public void severalOperationsScenarios() {
        mouseInputTest("5 + 4 + 3 + 6 =", "18", "12 + 6 = ");
        mouseInputTest("5,43554 + 43,455 + =", "97,78108", "48,89054 + 48,89054 = ");
        mouseInputTest("23112 + 43223 = + 12331 + 55644 =", "134 310", "78666 + 55644 = ");
        mouseInputTest("2,4463 + 545,345 + 533,2 = + 6,54665 + 66,43 =", "1 153,96795", "1087,53795 + 66,43 = ");
        mouseInputTest("552 + 332 = + 12 = + 554 = + 665 = + 456 = + 463 =", "3 034", "2571 + 463 = ");
        mouseInputTest("433344 + 566654 + 554566 + 344323 = + 445335 =", "2 344 222", "1898887 + 445335 = ");
        mouseInputTest("1 + 23 = + 12 =", "36", "24 + 12 = ");
        mouseInputTest("33 + 33 = + 6 + 2 + 10 = + 10 + =", "188", "94 + 94 = ");
        mouseInputTest("21 + 2 = + 23 = + 76 = + 56 = + 54 = + 34 = + 54 = + 66 =", "386", "320 + 66 = ");
        mouseInputTest("6,6545 + 65,45 + 65,545 + 65,443 = + 44,322 + 34,323 + 234,34 + 32,3445 =", "548,422", "516,0775 + 32,3445 = ");
        mouseInputTest("10 + = = = = =", "60", "50 + 10 = ");
    }

    @Test
    public void formatterAddScenarios() {
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus + 2740 =", "-1,763044461609195e+121", "negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) + 2740 = ");
        mouseInputTest("9405 sqr sqr sqr sqr + 455 plusMinus =", "3,747492722896453e+63", "sqr( sqr( sqr( sqr( 9405 ) ) ) ) + -455 = ");
        mouseInputTest("3290 sqr sqr sqr plusMinus + 7129 sqr sqr sqr sqr plusMinus =", "-4,451002471247301e+61", "negate( sqr( sqr( sqr( 3290 ) ) ) ) + negate( sqr( sqr( sqr( sqr( 7129 ) ) ) ) ) = ");
        mouseInputTest("6280 sqr sqr sqr + 2235 sqr sqr =", "2,419229947156145e+30", "sqr( sqr( sqr( 6280 ) ) ) + sqr( sqr( 2235 ) ) = ");
        mouseInputTest("7833 sqr sqr sqr + 8916 sqr sqr sqr sqr =", "1,594854091656744e+63", "sqr( sqr( sqr( 7833 ) ) ) + sqr( sqr( sqr( sqr( 8916 ) ) ) ) = ");
        mouseInputTest("3476 sqr sqr plusMinus + 5451 sqr sqr sqr =", "7,79488040361361e+29", "negate( sqr( sqr( 3476 ) ) ) + sqr( sqr( sqr( 5451 ) ) ) = ");
        mouseInputTest("99 + 5298 sqr sqr sqr sqr plusMinus =", "-3,852931282433017e+59", "99 + negate( sqr( sqr( sqr( sqr( 5298 ) ) ) ) ) = ");
        mouseInputTest("4575 plusMinus + 668 sqr sqr sqr =", "3,964712497716495e+22", "-4575 + sqr( sqr( sqr( 668 ) ) ) = ");
        mouseInputTest("617 plusMinus + 9087 sqr sqr sqr plusMinus =", "-4,649050079478631e+31", "-617 + negate( sqr( sqr( sqr( 9087 ) ) ) ) = ");
        mouseInputTest("9191 + 4959 sqr sqr sqr sqr sqr =", "1,789004633208848e+118", "9191 + sqr( sqr( sqr( sqr( sqr( 4959 ) ) ) ) ) = ");
        mouseInputTest("3 plusMinus sqr sqrt 1/ + 49 =", "49,33333333333333", "1/( √( sqr( -3 ) ) ) + 49 = ");
        mouseInputTest("22 plusMinus sqr sqrt + 41 sqr 1/ =", "22,00059488399762", "√( sqr( -22 ) ) + 1/( sqr( 41 ) ) = ");
        mouseInputTest("40 sqr sqrt 1/ + 61 sqr sqrt plusMinus =", "-60,975", "1/( √( sqr( 40 ) ) ) + negate( √( sqr( 61 ) ) ) = ");
        mouseInputTest("88 plusMinus 1/ + 16 sqrt plusMinus =", "-4,011363636363636", "1/( -88 ) + negate( √( 16 ) ) = ");
        mouseInputTest("10 + 22 sqr 1/ sqrt =", "10,04545454545455", "10 + √( 1/( sqr( 22 ) ) ) = ");
        mouseInputTest("1 plusMinus 1/ + 35 sqr 1/ =", "-0,9991836734693878", "1/( -1 ) + 1/( sqr( 35 ) ) = ");
        mouseInputTest("27 plusMinus plusMinus sqrt sqr 1/ + 66 sqr plusMinus plusMinus sqrt =", "66,03703703703704", "1/( sqr( √( 27 ) ) ) + √( negate( negate( sqr( 66 ) ) ) ) = ");
        mouseInputTest("61 plusMinus plusMinus sqrt + 80 sqr 1/ sqrt =", "7,822749675906654", "√( 61 ) + √( 1/( sqr( 80 ) ) ) = ");
    }
}
