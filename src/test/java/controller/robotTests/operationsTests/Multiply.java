package controller.robotTests.operationsTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class Multiply extends TestingSandBox {

    @Test
    public void simpleScenarios() {
        mouseInputTest("5 * 1 =", "5", "5 × 1 = ");
        mouseInputTest("5 * 3 =", "15", "5 × 3 = ");
        mouseInputTest("1 * 4 =", "4", "1 × 4 = ");
        mouseInputTest("1 * 9 =", "9", "1 × 9 = ");
        mouseInputTest("10 * 5 =", "50", "10 × 5 = ");
        mouseInputTest("5 * 8 =", "40", "5 × 8 = ");
        mouseInputTest("9 * 5 =", "45", "9 × 5 = ");
        mouseInputTest("3 * 1 =", "3", "3 × 1 = ");
        mouseInputTest("4 * 1 =", "4", "4 × 1 = ");
        mouseInputTest("9 * 10 =", "90", "9 × 10 = ");
        mouseInputTest("6 * 85 =", "510", "6 × 85 = ");
        mouseInputTest("56 * 7 =", "392", "56 × 7 = ");
        mouseInputTest("79 * 16 =", "1 264", "79 × 16 = ");
        mouseInputTest("69 * 43 =", "2 967", "69 × 43 = ");
        mouseInputTest("83 * 71 =", "5 893", "83 × 71 = ");
        mouseInputTest("97 * 60 =", "5 820", "97 × 60 = ");
        mouseInputTest("76 * 35 =", "2 660", "76 × 35 = ");
        mouseInputTest("94 * 28 =", "2 632", "94 × 28 = ");
        mouseInputTest("99 * 58 =", "5 742", "99 × 58 = ");
        mouseInputTest("10 * 68 =", "680", "10 × 68 = ");
        mouseInputTest("0,87 * 0,14 =", "0,1218", "0,87 × 0,14 = ");
        mouseInputTest("1,6 * 70 plusMinus =", "-112", "1,6 × -70 = ");
        mouseInputTest("2,9 * 0,5 =", "1,45", "2,9 × 0,5 = ");
        mouseInputTest("0,83 * 0,73 =", "0,6059", "0,83 × 0,73 = ");
        mouseInputTest("0,26 * 0,13 =", "0,0338", "0,26 × 0,13 = ");
        mouseInputTest("90 plusMinus * 8,1 =", "-729", "-90 × 8,1 = ");
        mouseInputTest("1,5 * 3,8 =", "5,7", "1,5 × 3,8 = ");
        mouseInputTest("2,1 * 0,4 =", "0,84", "2,1 × 0,4 = ");
        mouseInputTest("0,42 * 0,32 =", "0,1344", "0,42 × 0,32 = ");
        mouseInputTest("7,9 * 0,99 =", "7,821", "7,9 × 0,99 = ");
    }

    @Test
    public void subjectAreaScenarios() {
        mouseInputTest("0,78 * 85 =", "66,3", "0,78 × 85 = ");
        mouseInputTest("74 * 0,5 =", "37", "74 × 0,5 = ");
        mouseInputTest("69,58 * 47,58 =", "3 310,6164", "69,58 × 47,58 = ");
        mouseInputTest("324 * 0,26 =", "84,24", "324 × 0,26 = ");
        mouseInputTest("50,6 * 1,14 =", "57,684", "50,6 × 1,14 = ");
        mouseInputTest("231 * 211 =", "48 741", "231 × 211 = ");
        mouseInputTest("4,2 * 534 =", "2 242,8", "4,2 × 534 = ");
        mouseInputTest("229 * 8,31 =", "1 902,99", "229 × 8,31 = ");
        mouseInputTest("1,49 * 223 =", "332,27", "1,49 × 223 = ");
        mouseInputTest("795 * 2,19 =", "1 741,05", "795 × 2,19 = ");
        mouseInputTest("8,08 * 441 =", "3 563,28", "8,08 × 441 = ");
        mouseInputTest("0,66 * 3,84 =", "2,5344", "0,66 × 3,84 = ");
        mouseInputTest("29,4 * 0,244 =", "7,1736", "29,4 × 0,244 = ");
        mouseInputTest("5,57 * 0,585 =", "3,25845", "5,57 × 0,585 = ");
        mouseInputTest("4,73 * 6,2 =", "29,326", "4,73 × 6,2 = ");
        mouseInputTest("198 * 798 =", "158 004", "198 × 798 = ");
        mouseInputTest("147 * 29 =", "4 263", "147 × 29 = ");
        mouseInputTest("513 * 936 =", "480 168", "513 × 936 = ");
        mouseInputTest("347 * 802 =", "278 294", "347 × 802 = ");
        mouseInputTest("89 * 63 =", "5 607", "89 × 63 = ");
        mouseInputTest("229 * 370 =", "84 730", "229 × 370 = ");
        mouseInputTest("52 * 472 =", "24 544", "52 × 472 = ");
        mouseInputTest("966 * 133 =", "128 478", "966 × 133 = ");
        mouseInputTest("2 * 2 =", "4", "2 × 2 = ");
        mouseInputTest("12 * 24 =", "288", "12 × 24 = ");
        mouseInputTest("300 * =", "90 000", "300 × 300 = ");
        mouseInputTest("300 * = =", "27 000 000", "90000 × 300 = ");
        mouseInputTest("1234 * 265 =", "327 010", "1234 × 265 = ");
        mouseInputTest("421,87 * 0,42 =", "177,1854", "421,87 × 0,42 = ");
        mouseInputTest("2341 * 54 =", "126 414", "2341 × 54 = ");
        mouseInputTest("0,421 * ,353 =", "0,148613", "0,421 × 0,353 = ");
        mouseInputTest("57899 * 543213 =", "31 451 489 487", "57899 × 543213 = ");
        mouseInputTest("5456,74 * 532,34 =", "2 904 840,9716", "5456,74 × 532,34 = ");
        mouseInputTest("65,432 * 322 =", "21 069,104", "65,432 × 322 = ");
        mouseInputTest("543 * 5432 =", "2 949 576", "543 × 5432 = ");
        mouseInputTest("324,43 * 56,64 =", "18 375,7152", "324,43 × 56,64 = ");
        mouseInputTest("245,6 * 1212222 =", "297 721 723,2", "245,6 × 1212222 = ");
        mouseInputTest("0,54 * 0,057 =", "0,03078", "0,54 × 0,057 = ");
        mouseInputTest("362 * 17 =", "6 154", "362 × 17 = ");
        mouseInputTest("5981 * 0,7 =", "4 186,7", "5981 × 0,7 = ");
        mouseInputTest("3,14 * 24 =", "75,36", "3,14 × 24 = ");
        mouseInputTest("14,7 * 21 =", "308,7", "14,7 × 21 = ");
        mouseInputTest("194 * 108 =", "20 952", "194 × 108 = ");
        mouseInputTest("286 * 385 =", "110 110", "286 × 385 = ");
    }

    @Test
    public void randomMultiplyScenarios() {
        mouseInputTest("5674567456745443 * 3776888765467886 =", "2,143221007627154e+31", "5674567456745443 × 3776888765467886 = ");
        mouseInputTest("23422144564356 * 1235675564637327 =", "2,89421717095777e+28", "23422144564356 × 1235675564637327 = ");
        mouseInputTest("123421,4256434532 * 1234,223456435367 =", "152 329 618,5558434", "123421,4256434532 × 1234,223456435367 = ");
        mouseInputTest("75693847567321456 * 16394,44527286028 =", "1,24095864143468e+20", "7569384756732145 × 16394,44527286028 = ");
        mouseInputTest("9677,466776654330 * 492115243664,6449 =", "4 762 428 920 849 751", "9677,46677665433 × 492115243664,6449 = ");
        mouseInputTest("3215677877654432 * 8675645353783743 =", "2,789808083853784e+31", "3215677877654432 × 8675645353783743 = ");
        mouseInputTest("87675646355654 * 9685746464646463 =", "8,492040817248693e+29", "87675646355654 × 9685746464646463 = ");
        mouseInputTest("4543,4345354534 * 54532,3231233448 =", "247 764 040,1771088", "4543,4345354534 × 54532,3231233448 = ");
        mouseInputTest("99686757775,32312 * 66654,34534544434 =", "6 644 555 579 124 046", "99686757775,32312 × 66654,34534544434 = ");
        mouseInputTest("8796,323456776665 * 766565787867,4344 =", "6 742 960 620 980 798", "8796,323456776665 × 766565787867,4344 = ");
        mouseInputTest("8796776767676858 * 8675767565574873 =", "7,631879056261345e+31", "8796776767676858 × 8675767565574873 = ");
        mouseInputTest("44332356775332 * 987867685544334 =", "4,37945026823729e+28", "44332356775332 × 987867685544334 = ");
        mouseInputTest("342342,2545323230 * 7432,425435667768 =", "2 544 433 280,289887", "342342,254532323 × 7432,425435667768 = ");
        mouseInputTest("18643435640,05436 * 163544345353028 =", "3,049028476884001e+24", "18643435640,05436 × 163544345353028 = ");
        mouseInputTest("5654,6134534533 * 492536776464,6449 =", "2 785 105 082 517 502", "5654,6134534533 × 492536776464,6449 = ");
    }

    @Test
    public void severalOperationsScenarios() {
        mouseInputTest("5 * 4 * 3 * 6 =", "360", "60 × 6 = ");
        mouseInputTest("5,43554 * 43,455 * =", "55 791,09696861405", "236,2013907 × 236,2013907 = ");
        mouseInputTest("23112 * 43223 = * 12331 * 55644 =", "6,854394169835721e+17", "12318298774056 × 55644 = ");
        mouseInputTest("2,4463 * 545,345 * 533,2 = * 6,54665 * 66,43 =", "309 353 167,5581273", "4656829,257235095 × 66,43 = ");
        mouseInputTest("552 * 332 = * 12 = * 554 = * 665 = * 456 = * 463 =", "1,710549519094886e+17", "369449140193280 × 463 = ");
        mouseInputTest("433344 * 566654 * 554566 * 344323 = * 445335 =", "2,088126710407034e+28", "4,688889735608101e+22 × 445335 = ");
        mouseInputTest("1 * 23 = * 12 =", "276", "23 × 12 = ");
        mouseInputTest("33 * 33 = * 6 * 2 * 10 = * 10 * =", "1 707 726 240 000", "1306800 × 1306800 = ");
        mouseInputTest("21 * 2 = * 23 = * 76 = * 56 = * 54 = * 34 = * 54 = * 66 =", "26 902 281 821 184", "407610330624 × 66 = ");
        mouseInputTest("6,6545 * 65,45 * 65,545 * 65,443 = * 44,322 * 34,323 * 234,34 * 32,3445 =", "21 541 666 853 301,3", "666007106410,7129 × 32,3445 = ");
        mouseInputTest("10 * = = = = =", "1 000 000", "100000 × 10 = ");
    }

    @Test
    public void formatterMultiplyScenarios() {
        mouseInputTest("6151 sqr sqr sqr sqr sqr plusMinus * 2740 =", "-4,830741824809194e+124", "negate( sqr( sqr( sqr( sqr( sqr( 6151 ) ) ) ) ) ) × 2740 = ");
        mouseInputTest("9405 sqr sqr sqr sqr * 455 plusMinus =", "-1,705109188917886e+66", "sqr( sqr( sqr( sqr( 9405 ) ) ) ) × -455 = ");
        mouseInputTest("3290 sqr sqr sqr plusMinus * 7129 sqr sqr sqr sqr plusMinus =", "6,109772213082546e+89", "negate( sqr( sqr( sqr( 3290 ) ) ) ) × negate( sqr( sqr( sqr( sqr( 7129 ) ) ) ) ) = ");
        mouseInputTest("6280 sqr sqr sqr * 2235 sqr sqr =", "6,036528560888174e+43", "sqr( sqr( sqr( 6280 ) ) ) × sqr( sqr( 2235 ) ) = ");
        mouseInputTest("7833 sqr sqr sqr * 8916 sqr sqr sqr sqr =", "2,260195309289423e+94", "sqr( sqr( sqr( 7833 ) ) ) × sqr( sqr( sqr( sqr( 8916 ) ) ) ) = ");
        mouseInputTest("3476 sqr sqr plusMinus * 5451 sqr sqr sqr =", "-1,137964010878942e+44", "negate( sqr( sqr( 3476 ) ) ) × sqr( sqr( sqr( 5451 ) ) ) = ");
        mouseInputTest("99 * 5298 sqr sqr sqr sqr plusMinus =", "-3,814401969608687e+61", "99 × negate( sqr( sqr( sqr( sqr( 5298 ) ) ) ) ) = ");
        mouseInputTest("4575 plusMinus * 668 sqr sqr sqr =", "-1,813855967705296e+26", "-4575 × sqr( sqr( sqr( 668 ) ) ) = ");
        mouseInputTest("617 plusMinus * 9087 sqr sqr sqr plusMinus =", "2,868463899038315e+34", "-617 × negate( sqr( sqr( sqr( 9087 ) ) ) ) = ");
        mouseInputTest("9191 * 4959 sqr sqr sqr sqr sqr =", "1,644274158382252e+122", "9191 × sqr( sqr( sqr( sqr( sqr( 4959 ) ) ) ) ) = ");
        mouseInputTest("3 plusMinus sqr sqrt 1/ * 49 =", "16,33333333333333", "1/( √( sqr( -3 ) ) ) × 49 = ");
        mouseInputTest("22 plusMinus sqr sqrt  * 41 sqr 1/ =", "0,0130874479476502", "√( sqr( -22 ) ) × 1/( sqr( 41 ) ) = ");
        mouseInputTest("40 sqr sqrt 1/ * 61 sqr sqrt plusMinus =", "-1,525", "1/( √( sqr( 40 ) ) ) × negate( √( sqr( 61 ) ) ) = ");
        mouseInputTest("88 plusMinus 1/ * 16 sqrt plusMinus =", "0,0454545454545455", "1/( -88 ) × negate( √( 16 ) ) = ");
        mouseInputTest("10 * 22 sqr 1/ sqrt =", "0,4545454545454545", "10 × √( 1/( sqr( 22 ) ) ) = ");
        mouseInputTest("1 plusMinus 1/ * 35 sqr 1/ =", "-8,163265306122449e-4", "1/( -1 ) × 1/( sqr( 35 ) ) = ");
        mouseInputTest("27 plusMinus plusMinus sqrt sqr 1/ * 66 sqr plusMinus plusMinus sqrt =", "2,444444444444444", "1/( sqr( √( 27 ) ) ) × √( negate( negate( sqr( 66 ) ) ) ) = ");
        mouseInputTest("61 plusMinus plusMinus sqrt * 80 sqr 1/ sqrt =", "0,0976281209488332", "√( 61 ) × √( 1/( sqr( 80 ) ) ) = ");
    }
}
