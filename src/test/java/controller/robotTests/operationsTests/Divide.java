package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class Divide extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("10 / 5 =", "2", "10 ÷ 5 = ");
        mouseInputTest("56 / 7 =", "8", "56 ÷ 7 = ");
        mouseInputTest("5 / 3 =", "1,666666666666667", "5 ÷ 3 = ");
        mouseInputTest("76 / 35 =", "2,171428571428571", "76 ÷ 35 = ");
        mouseInputTest("1 / 9 =", "0,1111111111111111", "1 ÷ 9 = ");
        mouseInputTest("5 / 8 =", "0,625", "5 ÷ 8 = ");
        mouseInputTest("4 / 1 =", "4", "4 ÷ 1 = ");
        mouseInputTest("9 / 10 =", "0,9", "9 ÷ 10 = ");
        mouseInputTest("9 / 5 =", "1,8", "9 ÷ 5 = ");
        mouseInputTest("1,6 / 70 plusMinus =", "-0,0228571428571429", "1,6 ÷ -70 = ");
        mouseInputTest("83 / 71 =", "1,169014084507042", "83 ÷ 71 = ");
        mouseInputTest("1 / 4 =", "0,25", "1 ÷ 4 = ");
        mouseInputTest("0,87 / 0,14 =", "6,214285714285714", "0,87 ÷ 0,14 = ");
        mouseInputTest("69 / 43 =", "1,604651162790698", "69 ÷ 43 = ");
        mouseInputTest("99 / 58 =", "1,706896551724138", "99 ÷ 58 = ");
        mouseInputTest("1,5 / 3,8 =", "0,3947368421052632", "1,5 ÷ 3,8 = ");
        mouseInputTest("94 / 28 =", "3,357142857142857", "94 ÷ 28 = ");
        mouseInputTest("3 / 1 =", "3", "3 ÷ 1 = ");
        mouseInputTest("6 / 85 =", "0,0705882352941176", "6 ÷ 85 = ");
        mouseInputTest("79 / 16 =", "4,9375", "79 ÷ 16 = ");
        mouseInputTest("97 / 60 =", "1,616666666666667", "97 ÷ 60 = ");
        mouseInputTest("2,1 / 0,4 =", "5,25", "2,1 ÷ 0,4 = ");
        mouseInputTest("2,9 / 0,5 =", "5,8", "2,9 ÷ 0,5 = ");
        mouseInputTest("0,83 / 0,73 =", "1,136986301369863", "0,83 ÷ 0,73 = ");
        mouseInputTest("0,42 / 0,32 =", "1,3125", "0,42 ÷ 0,32 = ");
        mouseInputTest("90 plusMinus / 8,1 =", "-11,11111111111111", "-90 ÷ 8,1 = ");
        mouseInputTest("0,26 / 0,13 =", "2", "0,26 ÷ 0,13 = ");
        mouseInputTest("10 / 68 =", "0,1470588235294118", "10 ÷ 68 = ");
        mouseInputTest("5 / 1 =", "5", "5 ÷ 1 = ");
        mouseInputTest("7,9 / 0,99 =", "7,97979797979798", "7,9 ÷ 0,99 = ");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("4,2 / 534 =", "0,0078651685393258", "4,2 ÷ 534 = ");
        mouseInputTest("198 / 798 =", "0,2481203007518797", "198 ÷ 798 = ");
        mouseInputTest("286 / 385 =", "0,7428571428571429", "286 ÷ 385 = ");
        mouseInputTest("8,08 / 441 =", "0,0183219954648526", "8,08 ÷ 441 = ");
        mouseInputTest("229 / 8,31 =", "27,55716004813478", "229 ÷ 8,31 = ");
        mouseInputTest("4,73 / 6,2 =", "0,7629032258064516", "4,73 ÷ 6,2 = ");
        mouseInputTest("89 / 63 =", "1,412698412698413", "89 ÷ 63 = ");
        mouseInputTest("795 / 2,19 =", "363,013698630137", "795 ÷ 2,19 = ");
        mouseInputTest("29,4 / 0,244 =", "120,4918032786885", "29,4 ÷ 0,244 = ");
        mouseInputTest("194 / 108 =", "1,796296296296296", "194 ÷ 108 = ");
        mouseInputTest("50,6 / 1,14 =", "44,3859649122807", "50,6 ÷ 1,14 = ");
        mouseInputTest("147 / 29 =", "5,068965517241379", "147 ÷ 29 = ");
        mouseInputTest("52 / 472 =", "0,1101694915254237", "52 ÷ 472 = ");
        mouseInputTest("12 / 24 =", "0,5", "12 ÷ 24 = ");
        mouseInputTest("347 / 802 =", "0,4326683291770574", "347 ÷ 802 = ");
        mouseInputTest("5,57 / 0,585 =", "9,521367521367521", "5,57 ÷ 0,585 = ");
        mouseInputTest("2 / 2 =", "1", "2 ÷ 2 = ");
        mouseInputTest("1,49 / 223 =", "0,0066816143497758", "1,49 ÷ 223 = ");
        mouseInputTest("0,66 / 3,84 =", "0,171875", "0,66 ÷ 3,84 = ");
        mouseInputTest("513 / 936 =", "0,5480769230769231", "513 ÷ 936 = ");
        mouseInputTest("1234 / 265 =", "4,656603773584906", "1234 ÷ 265 = ");
        mouseInputTest("300 / = =", "0,0033333333333333", "1 ÷ 300 = ");
        mouseInputTest("966 / 133 =", "7,263157894736842", "966 ÷ 133 = ");
        mouseInputTest("300 / =", "1", "300 ÷ 300 = ");
        mouseInputTest("0,533 / 0,057 =", "9,350877192982456", "0,533 ÷ 0,057 = ");
        mouseInputTest("57899 / 543213 =", "0,1065861825839956", "57899 ÷ 543213 = ");
        mouseInputTest("229 / 370 =", "0,6189189189189189", "229 ÷ 370 = ");
        mouseInputTest("2341 / 54 =", "43,35185185185185", "2341 ÷ 54 = ");
        mouseInputTest("324 / 0,26 =", "1 246,153846153846", "324 ÷ 0,26 = ");
        mouseInputTest("0,421 / ,353 =", "1,192634560906516", "0,421 ÷ 0,353 = ");
        mouseInputTest("65,432 / 322 =", "0,2032049689440994", "65,432 ÷ 322 = ");
        mouseInputTest("245,6 / 1212222 =", "2,026031535477825e-4", "245,6 ÷ 1212222 = ");
        mouseInputTest("421,87 / 0,42 =", "1 004,452380952381", "421,87 ÷ 0,42 = ");
        mouseInputTest("5981 / 0,7 =", "8 544,285714285714", "5981 ÷ 0,7 = ");
        mouseInputTest("543 / 5432 =", "0,0999631811487482", "543 ÷ 5432 = ");
        mouseInputTest("324,43 / 56,64 =", "5,727930790960452", "324,43 ÷ 56,64 = ");
        mouseInputTest("362 / 17 =", "21,29411764705882", "362 ÷ 17 = ");
        mouseInputTest("69,58 / 47,58 =", "1,462379150903741", "69,58 ÷ 47,58 = ");
        mouseInputTest("26 / 24 =", "1,083333333333333", "26 ÷ 24 = ");
        mouseInputTest("14,7 / 21 =", "0,7", "14,7 ÷ 21 = ");
        mouseInputTest("5456,74 / 532,34 =", "10,25047901716948", "5456,74 ÷ 532,34 = ");
        mouseInputTest("231 / 211 =", "1,09478672985782", "231 ÷ 211 = ");
        mouseInputTest("0,78 / 3,14 =", "0,2484076433121019", "0,78 ÷ 3,14 = ");
        mouseInputTest("74 / 0,5 =", "148", "74 ÷ 0,5 = ");
    }

    @Test
    public void randomDivideScenarios() {
        mouseInputTest("99686757775,32312 / 66654,34534544434 =", "1 495 577,779043275", "99686757775,32312 ÷ 66654,34534544434 = ");
        mouseInputTest("18643435640,05436 / 163544345353028 =", "1,13996210629053e-4", "18643435640,05436 ÷ 163544345353028 = ");
        mouseInputTest("18650523300,05526 / 16394,44527286028 =", "1 137 612,343061692", "18650523300,05526 ÷ 16394,44527286028 = ");
        mouseInputTest("342342,2545323230 / 7432,425435667768 =", "46,06063760686288", "342342,254532323 ÷ 7432,425435667768 = ");
        mouseInputTest("15216056106784 / 1139097799493685 =", "0,013357989202988", "15216056106784 ÷ 1139097799493685 = ");
        mouseInputTest("5654,6134534533 / 492536776464,6449 =", "1,148059134597272e-8", "5654,6134534533 ÷ 492536776464,6449 = ");
        mouseInputTest("8796,323456776665 / 766565787867,4344 =", "1,147497526761245e-8", "8796,323456776665 ÷ 766565787867,4344 = ");
        mouseInputTest("8796776767676858 / 8675767565574873 =", "1,013947953444736", "8796776767676858 ÷ 8675767565574873 = ");
        mouseInputTest("5417,612255374980 / 492115243664,6449 =", "1,100882836920786e-8", "5417,61225537498 ÷ 492115243664,6449 = ");
        mouseInputTest("2804283685904262 / 3770050392348772 =", "0,7438318839439094", "2804283685904262 ÷ 3770050392348772 = ");
        mouseInputTest("44332356775332 / 987867685544334 =", "0,0448768164239566", "44332356775332 ÷ 987867685544334 = ");
        mouseInputTest("87675646355654 / 9685746464646463 =", "0,009052027809697", "87675646355654 ÷ 9685746464646463 = ");
        mouseInputTest("4543,4345354534 / 54532,3231233448 =", "0,083316357624757", "4543,4345354534 ÷ 54532,3231233448 = ");
        mouseInputTest("862069,2202713910 / 7233,425940889578 =", "119,1785507055834", "862069,220271391 ÷ 7233,425940889578 = ");
        mouseInputTest("9484736475874736 / 8675645353783743 =", "1,093260050301402", "9484736475874736 ÷ 8675645353783743 = ");
    }

    @Test
    public void severalOperationsScenarios() {
        mouseInputTest("5 / 4 / 3 / 6 =", "0,0694444444444444", "0,4166666666666667 ÷ 6 = ");
        mouseInputTest("5,43554 / 43,455 / =", "1", "0,1250843401219653 ÷ 0,1250843401219653 = ");
        mouseInputTest("23112 / 43223 = / 12331 / 55644 =", "7,793023435254269e-10", "4,336349960312885e-5 ÷ 55644 = ");
        mouseInputTest("2,4463 / 545,345 / 533,2 = / 6,54665 / 66,43 =", "1,934482758730937e-8", "1,285076896624961e-6 ÷ 66,43 = ");
        mouseInputTest("552 / 332 = / 12 = / 554 = / 665 = / 456 = / 463 =", "1,781322297884892e-12", "8,24752223920705e-10 ÷ 463 = ");
        mouseInputTest("433344 / 566654 / 554566 / 344323 = / 445335 =", "8,993085591984747e-18", "4,004935772106527e-12 ÷ 445335 = ");
        mouseInputTest("1 / 23 = / 12 =", "0,0036231884057971", "0,0434782608695652 ÷ 12 = ");
        mouseInputTest("33 / 33 = / 6 / 2 / 10 = / 10 / =", "1", "8,333333333333333e-4 ÷ 8,333333333333333e-4 = ");
        mouseInputTest("21 / 2 = / 23 = / 76 = / 56 = / 54 = / 34 = / 54 = / 66 =", "1,639266151961645e-11", "1,081915660294685e-9 ÷ 66 = ");
        mouseInputTest("6,6545 / 65,45 / 65,545 / 65,443 = / 44,322 / 34,323 / 234,34 / 32,3445 =", "2,055661270391137e-12", "6,648933596016612e-11 ÷ 32,3445 = ");
        mouseInputTest("10 / = = = = =", "0,0001", "0,001 ÷ 10 = ");
    }

    @Test
    public void divisionByZeroScenarios() {
        mouseInputTest("0 / 0=", RESULT_UNDEFINED, "0 ÷ 0 = ");
        mouseInputTest("23 / 0=", DIVISION_BY_ZERO, "23 ÷ 0 = ");
        mouseInputTest("53 / 0=", DIVISION_BY_ZERO, "53 ÷ 0 = ");
        mouseInputTest("218 / 0=", DIVISION_BY_ZERO, "218 ÷ 0 = ");
        mouseInputTest("564 / 0=", DIVISION_BY_ZERO, "564 ÷ 0 = ");
        mouseInputTest("654 / 0=", DIVISION_BY_ZERO, "654 ÷ 0 = ");
        mouseInputTest("5434 / 0=", DIVISION_BY_ZERO, "5434 ÷ 0 = ");
        mouseInputTest("6658 / 0=", DIVISION_BY_ZERO, "6658 ÷ 0 = ");
        mouseInputTest("6665,43 / 0=", DIVISION_BY_ZERO, "6665,43 ÷ 0 = ");
        mouseInputTest("665,437 / 0=", DIVISION_BY_ZERO, "665,437 ÷ 0 = ");
    }

    @Test
    public void formatterDivideScenarios() {
        mouseInputTest("7833 sqr sqr sqr / 8916 sqr sqr sqr sqr =", "8,8859538918701e-33", "sqr( sqr( sqr( 7833 ) ) ) ÷ sqr( sqr( sqr( sqr( 8916 ) ) ) ) = ");
        mouseInputTest("3476 sqr sqr plusMinus / 5451 sqr sqr sqr =", "-1,872878546386644e-16", "negate( sqr( sqr( 3476 ) ) ) ÷ sqr( sqr( sqr( 5451 ) ) ) = ");
        mouseInputTest("40 sqr sqrt 1/ / 61 sqr sqrt plusMinus =", "-4,098360655737705e-4", "1/( √( sqr( 40 ) ) ) ÷ negate( √( sqr( 61 ) ) ) = ");
        mouseInputTest("61 plusMinus plusMinus sqrt / 80 sqr 1/ sqrt =", "624,8199740725324", "√( 61 ) ÷ √( 1/( sqr( 80 ) ) ) = ");
        mouseInputTest("3 plusMinus sqr sqrt 1/ / 49 =", "0,0068027210884354", "1/( √( sqr( -3 ) ) ) ÷ 49 = ");
        mouseInputTest("617 plusMinus / 9087 sqr sqr sqr plusMinus =", "1,327152836497717e-29", "-617 ÷ negate( sqr( sqr( sqr( 9087 ) ) ) ) = ");
        mouseInputTest("27 plusMinus plusMinus sqrt sqr 1/ / 66 sqr plusMinus plusMinus sqrt =", "5,611672278338945e-4", "1/( sqr( √( 27 ) ) ) ÷ √( negate( negate( sqr( 66 ) ) ) ) = ");
        mouseInputTest("3290 sqr sqr sqr plusMinus / 7129 sqr sqr sqr sqr plusMinus =", "3,083964343891729e-34", "negate( sqr( sqr( sqr( 3290 ) ) ) ) ÷ negate( sqr( sqr( sqr( sqr( 7129 ) ) ) ) ) = ");
        mouseInputTest("1 plusMinus 1/ / 35 sqr 1/ =", "-1 225", "1/( -1 ) ÷ 1/( sqr( 35 ) ) = ");
        mouseInputTest("22 plusMinus sqr sqrt / 41 sqr 1/ =", "36 982", "√( sqr( -22 ) ) ÷ 1/( sqr( 41 ) ) = ");
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus / 2740 =", "-6,434468837989763e+117", "negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) ÷ 2740 = ");
        mouseInputTest("9405 sqr sqr sqr sqr / 455 plusMinus =", "-8,236247742629567e+60", "sqr( sqr( sqr( sqr( 9405 ) ) ) ) ÷ -455 = ");
        mouseInputTest("99 / 5298 sqr sqr sqr sqr plusMinus =", "-2,569472247049376e-58", "99 ÷ negate( sqr( sqr( sqr( sqr( 5298 ) ) ) ) ) = ");
        mouseInputTest("9191 / 4959 sqr sqr sqr sqr sqr =", "5,137493681899841e-115", "9191 ÷ sqr( sqr( sqr( sqr( sqr( 4959 ) ) ) ) ) = ");
        mouseInputTest("4575 plusMinus / 668 sqr sqr sqr =", "-1,153929825336643e-19", "-4575 ÷ sqr( sqr( sqr( 668 ) ) ) = ");
        mouseInputTest("10 / 22 sqr 1/ sqrt =", "220", "10 ÷ √( 1/( sqr( 22 ) ) ) = ");
        mouseInputTest("88 plusMinus 1/ / 16 sqrt plusMinus =", "0,0028409090909091", "1/( -88 ) ÷ negate( √( 16 ) ) = ");
        mouseInputTest("6280 sqr sqr sqr / 2235 sqr sqr =", "9,69542921595322e+16", "sqr( sqr( sqr( 6280 ) ) ) ÷ sqr( sqr( 2235 ) ) = ");
    }
}
