package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class Subtract extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("5 - 8 =", "-3", "5 - 8 = ");
        mouseInputTest("1 - 4 =", "-3", "1 - 4 = ");
        mouseInputTest("5 - 1 =", "4", "5 - 1 = ");
        mouseInputTest("5 - 3 =", "2", "5 - 3 = ");
        mouseInputTest("1 - 9 =", "-8", "1 - 9 = ");
        mouseInputTest("4 - 1 =", "3", "4 - 1 = ");
        mouseInputTest("9 - 5 =", "4", "9 - 5 = ");
        mouseInputTest("10 - 5 =", "5", "10 - 5 = ");
        mouseInputTest("9 - 10 =", "-1", "9 - 10 = ");
        mouseInputTest("56 - 7 =", "49", "56 - 7 = ");
        mouseInputTest("3 - 1 =", "2", "3 - 1 = ");
        mouseInputTest("83 - 71 =", "12", "83 - 71 = ");
        mouseInputTest("79 - 16 =", "63", "79 - 16 = ");
        mouseInputTest("6 - 85 =", "-79", "6 - 85 = ");
        mouseInputTest("94 - 28 =", "66", "94 - 28 = ");
        mouseInputTest("97 - 60 =", "37", "97 - 60 = ");
        mouseInputTest("69 - 43 =", "26", "69 - 43 = ");
        mouseInputTest("0,87 - 0,14 =", "0,73", "0,87 - 0,14 = ");
        mouseInputTest("99 - 58 =", "41", "99 - 58 = ");
        mouseInputTest("76 - 35 =", "41", "76 - 35 = ");
        mouseInputTest("0,83 - 0,73 =", "0,1", "0,83 - 0,73 = ");
        mouseInputTest("1,6 - 70 plusMinus =", "71,6", "1,6 - -70 = ");
        mouseInputTest("10 - 68 =", "-58", "10 - 68 = ");
        mouseInputTest("90 plusMinus - 8,1 =", "-98,1", "-90 - 8,1 = ");
        mouseInputTest("0,26 - 0,13 =", "0,13", "0,26 - 0,13 = ");
        mouseInputTest("2,9 - 0,5 =", "2,4", "2,9 - 0,5 = ");
        mouseInputTest("7,9 - 0,99 =", "6,91", "7,9 - 0,99 = ");
        mouseInputTest("2,1 - 0,4 =", "1,7", "2,1 - 0,4 = ");
        mouseInputTest("0,42 - 0,32 =", "0,1", "0,42 - 0,32 = ");
        mouseInputTest("1,5 - 3,8 =", "-2,3", "1,5 - 3,8 = ");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("50,6 - 1,14 =", "49,46", "50,6 - 1,14 = ");
        mouseInputTest("4,2 - 534 =", "-529,8", "4,2 - 534 = ");
        mouseInputTest("229 - 8,31 =", "220,69", "229 - 8,31 = ");
        mouseInputTest("1,49 - 223 =", "-221,51", "1,49 - 223 = ");
        mouseInputTest("795 - 2,19 =", "792,81", "795 - 2,19 = ");
        mouseInputTest("8,08 - 441 =", "-432,92", "8,08 - 441 = ");
        mouseInputTest("0,66 - 3,84 =", "-3,18", "0,66 - 3,84 = ");
        mouseInputTest("29,4 - 0,244 =", "29,156", "29,4 - 0,244 = ");
        mouseInputTest("5,57 - 0,585 =", "4,985", "5,57 - 0,585 = ");
        mouseInputTest("4,73 - 6,2 =", "-1,47", "4,73 - 6,2 = ");
        mouseInputTest("194 - 108 =", "86", "194 - 108 = ");
        mouseInputTest("286 - 385 =", "-99", "286 - 385 = ");
        mouseInputTest("198 - 798 =", "-600", "198 - 798 = ");
        mouseInputTest("147 - 29 =", "118", "147 - 29 = ");
        mouseInputTest("513 - 936 =", "-423", "513 - 936 = ");
        mouseInputTest("347 - 802 =", "-455", "347 - 802 = ");
        mouseInputTest("89 - 63 =", "26", "89 - 63 = ");
        mouseInputTest("229 - 370 =", "-141", "229 - 370 = ");
        mouseInputTest("52 - 472 =", "-420", "52 - 472 = ");
        mouseInputTest("966 - 133 =", "833", "966 - 133 = ");
        mouseInputTest("2 - 2 =", "0", "2 - 2 = ");
        mouseInputTest("12 - 24 =", "-12", "12 - 24 = ");
        mouseInputTest("300 - =", "0", "300 - 300 = ");
        mouseInputTest("300 - = =", "-300", "0 - 300 = ");
        mouseInputTest("1234 - 265 =", "969", "1234 - 265 = ");
        mouseInputTest("421,87 - 0,42 =", "421,45", "421,87 - 0,42 = ");
        mouseInputTest("2341 - 54 =", "2 287", "2341 - 54 = ");
        mouseInputTest("0,421 - ,353 =", "0,068", "0,421 - 0,353 = ");
        mouseInputTest("57899 - 543213 =", "-485 314", "57899 - 543213 = ");
        mouseInputTest("5456,74 - 532,34 =", "4 924,4", "5456,74 - 532,34 = ");
        mouseInputTest("65,432 - 322 =", "-256,568", "65,432 - 322 = ");
        mouseInputTest("543 - 5432 =", "-4 889", "543 - 5432 = ");
        mouseInputTest("324,43 - 56,64 =", "267,79", "324,43 - 56,64 = ");
        mouseInputTest("245,6 - 1212222 =", "-1 211 976,4", "245,6 - 1212222 = ");
        mouseInputTest("254 - 68 =", "186", "254 - 68 = ");
        mouseInputTest("6841,5 - 651 =", "6 190,5", "6841,5 - 651 = ");
        mouseInputTest("695,45 - 365,4 =", "330,05", "695,45 - 365,4 = ");
        mouseInputTest("698854 - 869541 =", "-170 687", "698854 - 869541 = ");
        mouseInputTest("1547 - 8561,5 =", "-7 014,5", "1547 - 8561,5 = ");
        mouseInputTest("3254 - 65985 =", "-62 731", "3254 - 65985 = ");
        mouseInputTest("854,55 - 785,4 =", "69,15", "854,55 - 785,4 = ");
        mouseInputTest("0,5897 - 0,85751 =", "-0,26781", "0,5897 - 0,85751 = ");
        mouseInputTest("2,74 - 1,77 =", "0,97", "2,74 - 1,77 = ");
        mouseInputTest("123587458 - 9581 =", "123 577 877", "123587458 - 9581 = ");
    }

    @Test
    public void randomSubtractScenarios() {
        mouseInputTest("2804283685904262 - 3770050392348772 =", "-965 766 706 444 510", "2804283685904262 - 3770050392348772 = ");
        mouseInputTest("15216056106784 - 1139097799493685 =", "-1 123 881 743 386 901", "15216056106784 - 1139097799493685 = ");
        mouseInputTest("862069,2202713910 - 7233,425940889578 =", "854 835,7943305014", "862069,220271391 - 7233,425940889578 = ");
        mouseInputTest("18650523300,05526 - 16394,44527286028 =", "18 650 506 905,60999", "18650523300,05526 - 16394,44527286028 = ");
        mouseInputTest("5417,612255374980 - 492115243664,6449 =", "-492 115 238 247,0326", "5417,61225537498 - 492115243664,6449 = ");
        mouseInputTest("9484736475874736 - 8675645353783743 =", "809 091 122 090 993", "9484736475874736 - 8675645353783743 = ");
        mouseInputTest("87675646355654 - 9685746464646463 =", "-9 598 070 818 290 809", "87675646355654 - 9685746464646463 = ");
        mouseInputTest("4543,4345354534 - 54532,3231233448 =", "-49 988,8885878914", "4543,4345354534 - 54532,3231233448 = ");
        mouseInputTest("99686757775,32312 - 66654,34534544434 =", "99 686 691 120,97777", "99686757775,32312 - 66654,34534544434 = ");
        mouseInputTest("8796,323456776665 - 766565787867,4344 =", "-766 565 779 071,1109", "8796,323456776665 - 766565787867,4344 = ");
        mouseInputTest("8796776767676858 - 8675767565574873 =", "121 009 202 101 985", "8796776767676858 - 8675767565574873 = ");
        mouseInputTest("44332356775332 - 987867685544334 =", "-943 535 328 769 002", "44332356775332 - 987867685544334 = ");
        mouseInputTest("342342,2545323230 - 7432,425435667768 =", "334 909,8290966552", "342342,254532323 - 7432,425435667768 = ");
        mouseInputTest("18643435640,05436 - 163544345353028 =", "-163 525 701 917 387,9", "18643435640,05436 - 163544345353028 = ");
        mouseInputTest("5654,6134534533 - 492536776464,6449 =", "-492 536 770 810,0314", "5654,6134534533 - 492536776464,6449 = ");
        mouseInputTest(MIN_INPUT + " * 0,0000001 - = = = = =", "-4e-23", "-3e-23 - 1e-23 = ");
        mouseInputTest(MIN_INPUT + " * " + MIN_INPUT + " - = = = = = ", "-4e-32", "-3e-32 - 1e-32 = ");
        mouseInputTest(MIN_INPUT + " * 0,0000000324412 - = = = = =", "-1,297648e-23", "-9,73236e-24 - 3,24412e-24 = ");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr", "4,203024415375744e-80", "sqr( -2,050127902199213e-40 )");
        mouseInputTest("- 9999999999999 * 99999 = 1/ sqr sqrt", "1,000010000100101e-18", "√( sqr( 1/( -9,999899999999e+17 ) ) )");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr", "4,203024415375744e-80", "sqr( -2,050127902199213e-40 )");
        mouseInputTest(MIN_INPUT + " * 0,0000001 - = = = = = 1/", "-2,5e+22", "1/( -4e-23 )");
        mouseInputTest(MIN_INPUT + " * " + MIN_INPUT + " - = = = = = 1/", "-2,5e+31", "1/( -4e-32 )");
        mouseInputTest(MIN_INPUT + " * 0,0000000324412 - = = = = = 1/", "-7,706250077062501e+22", "1/( -1,297648e-23 )");
        mouseInputTest("- 9999999999999 * 99999 = sqr sqrt", "9,999899999999e+17", "√( sqr( -9,999899999999e+17 ) )");
        mouseInputTest("0,0002569 sqr sqr sqr sqr sqr sqr - = = = plusMinus 1/", "2,978978242572731e+229", "1/( 3,356855668527379e-230 )");
        mouseInputTest("- 0,05484 / 48468915 = = = = = sqr 1/", "2,379239093500725e+79", "1/( sqr( -2,050127902199213e-40 ) )");
        mouseInputTest("9847564736475643 sqr sqr sqr sqr plusMinus - 93122131231 = sqr sqr sqr sqr + = = = = =", "1,175805364502728e+4095", "9,798378037522735e+4094 + 1,959675607504547e+4094 = ");
        mouseInputTest("0,000000000000014 sqr sqr sqr plusMinus - 0,000000000000014 sqr sqr sqr = = =", "-5,903156224e-111", "-4,427367168e-111 - 1,475789056e-111 = ");
        mouseInputTest("0,0000345654756734 sqr sqr sqr plusMinus - 0,0025484 sqr sqr sqr plusMinus = = = =", "7,115423644532373e-21", "5,336567733399279e-21 - -1,778855911133094e-21 = ");
    }

    @Test
    public void severalOperationsScenarios() {
        mouseInputTest("5 - 4 - 3 - 6 =", "-8", "-2 - 6 = ");
        mouseInputTest("5,43554 - 43,455 - =", "0", "-38,01946 - -38,01946 = ");
        mouseInputTest("23112 - 43223 = - 12331 - 55644 =", "-88 086", "-32442 - 55644 = ");
        mouseInputTest("2,4463 - 545,345 - 533,2 = - 6,54665 - 66,43 =", "-1 149,07535", "-1082,64535 - 66,43 = ");
        mouseInputTest("552 - 332 = - 12 = - 554 = - 665 = - 456 = - 463 =", "-1 930", "-1467 - 463 = ");
        mouseInputTest("433344 - 566654 - 554566 - 344323 = - 445335 =", "-1 477 534", "-1032199 - 445335 = ");
        mouseInputTest("1 - 23 = - 12 =", "-34", "-22 - 12 = ");
        mouseInputTest("33 - 33 = - 6 - 2 - 10 = - 10 - =", "0", "-28 - -28 = ");
        mouseInputTest("21 - 2 = - 23 = - 76 = - 56 = - 54 = - 34 = - 54 = - 66 =", "-344", "-278 - 66 = ");
        mouseInputTest("6,6545 - 65,45 - 65,545 - 65,443 = - 44,322 - 34,323 - 234,34 - 32,3445 =", "-535,113", "-502,7685 - 32,3445 = ");
        mouseInputTest("10 - = = = = =", "-40", "-30 - 10 = ");
    }

    @Test
    public void formatterSubtractScenarios() {
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus - 2740 =", "-1,763044461609195e+121", "negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) - 2740 = ");
        mouseInputTest("9405 sqr sqr sqr sqr - 455 plusMinus =", "3,747492722896453e+63", "sqr( sqr( sqr( sqr( 9405 ) ) ) ) - -455 = ");
        mouseInputTest("3290 sqr sqr sqr plusMinus - 7129 sqr sqr sqr sqr plusMinus =", "4,451002471247301e+61", "negate( sqr( sqr( sqr( 3290 ) ) ) ) - negate( sqr( sqr( sqr( sqr( 7129 ) ) ) ) ) = ");
        mouseInputTest("6280 sqr sqr sqr - 2235 sqr sqr =", "2,419229947156145e+30", "sqr( sqr( sqr( 6280 ) ) ) - sqr( sqr( 2235 ) ) = ");
        mouseInputTest("7833 sqr sqr sqr - 8916 sqr sqr sqr sqr =", "-1,594854091656744e+63", "sqr( sqr( sqr( 7833 ) ) ) - sqr( sqr( sqr( sqr( 8916 ) ) ) ) = ");
        mouseInputTest("3476 sqr sqr plusMinus - 5451 sqr sqr sqr =", "-7,794880403613613e+29", "negate( sqr( sqr( 3476 ) ) ) - sqr( sqr( sqr( 5451 ) ) ) = ");
        mouseInputTest("99 - 5298 sqr sqr sqr sqr plusMinus =", "3,852931282433017e+59", "99 - negate( sqr( sqr( sqr( sqr( 5298 ) ) ) ) ) = ");
        mouseInputTest("4575 plusMinus - 668 sqr sqr sqr =", "-3,964712497716495e+22", "-4575 - sqr( sqr( sqr( 668 ) ) ) = ");
        mouseInputTest("617 plusMinus - 9087 sqr sqr sqr plusMinus =", "4,649050079478631e+31", "-617 - negate( sqr( sqr( sqr( 9087 ) ) ) ) = ");
        mouseInputTest("9191 - 4959 sqr sqr sqr sqr sqr =", "-1,789004633208848e+118", "9191 - sqr( sqr( sqr( sqr( sqr( 4959 ) ) ) ) ) = ");
        mouseInputTest("3 plusMinus sqr sqrt 1/ - 49 =", "-48,66666666666667", "1/( √( sqr( -3 ) ) ) - 49 = ");
        mouseInputTest("22 plusMinus sqr sqrt - 41 sqr 1/ =", "21,99940511600238", "√( sqr( -22 ) ) - 1/( sqr( 41 ) ) = ");
        mouseInputTest("40 sqr sqrt 1/ - 61 sqr sqrt plusMinus =", "61,025", "1/( √( sqr( 40 ) ) ) - negate( √( sqr( 61 ) ) ) = ");
        mouseInputTest("88 plusMinus 1/ - 16 sqrt plusMinus =", "3,988636363636364", "1/( -88 ) - negate( √( 16 ) ) = ");
        mouseInputTest("10 - 22 sqr 1/ sqrt =", "9,954545454545455", "10 - √( 1/( sqr( 22 ) ) ) = ");
        mouseInputTest("1 plusMinus 1/ - 35 sqr 1/ =", "-1,000816326530612", "1/( -1 ) - 1/( sqr( 35 ) ) = ");
        mouseInputTest("27 plusMinus plusMinus sqrt sqr 1/ - 66 sqr plusMinus plusMinus sqrt =", "-65,96296296296296", "1/( sqr( √( 27 ) ) ) - √( negate( negate( sqr( 66 ) ) ) ) = ");
        mouseInputTest("61 plusMinus plusMinus sqrt - 80 sqr 1/ sqrt =", "7,797749675906654", "√( 61 ) - √( 1/( sqr( 80 ) ) ) = ");
    }
}
