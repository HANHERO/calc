package model.unaryTests;

import model.*;
import controllers.OverflowException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class Sqr {
    Calculator testModel = new Calculator();

    @Test
    public void sqrScenarios() throws OverflowException, DivisionByZeroException, NegativeSqrtException {
        assertSQR("0", "0");
        assertSQR("1", "1");
        assertSQR("2", "4");
        assertSQR("3", "9");
        assertSQR("4", "16");
        assertSQR("5", "25");
        assertSQR("6", "36");
        assertSQR("7", "49");
        assertSQR("8", "64");
        assertSQR("9", "81");
        assertSQR("10", "100");
        assertSQR("11", "121");
        assertSQR("43", "1849");
        assertSQR("98", "9604");
        assertSQR("152", "23104");
        assertSQR("278", "77284");
        assertSQR("367", "134689");
        assertSQR("547", "299209");
        assertSQR("562", "315844");
        assertSQR("679", "461041");
        assertSQR("742", "550564");
        assertSQR("893", "797449");
        assertSQR("935", "874225");
        assertSQR("952", "906304");
        assertSQR("999", "998001");
        assertSQR("1008", "1016064");
        assertSQR("2256", "5089536");
        assertSQR("3173", "10067929");
        assertSQR("3477", "12089529");
        assertSQR("3889", "15124321");
        assertSQR("4378", "19166884");
        assertSQR("4647", "21594609");
        assertSQR("5448", "29680704");
        assertSQR("6271", "39325441");
        assertSQR("7118", "50665924");
        assertSQR("8072", "65157184");
        assertSQR("9112", "83028544");
        assertSQR("9214", "84897796");
        assertSQR("55555", "3086358025");
        assertSQR("82534", "6811861156");
        assertSQR("72324911", "5230892751157921");
        assertSQR("123456789", "15241578750190521");
        assertSQR("1E+17", "1E+34");
        assertSQR("5.647753E+11", "3.1897113949009E+23");
        assertSQR("7.7655779E+52", "6.030420012096841E+105");
        assertSQR("6.48586754E+98", "4.20664777464256516E+197");
        assertSQR("1E+170", "1E+340");
        assertSQR("5.647753E+511", "3.1897113949009E+1023");
        assertSQR("7.7655779E+552", "6.030420012096841E+1105");
        assertSQR("6.48586754E+598", "4.20664777464256516E+1197");
        assertSQR("1E+1170", "1E+2340");
        assertSQR("5.647753E+1511", "3.1897113949009E+3023");
        assertSQR("7.7655779E+1552", "6.030420012096841E+3105");
        assertSQR("6.48586754E+1598", "4.20664777464256516E+3197");
        assertSQR("1E+2170", "1E+4340");
        assertSQR("5.647753E+2511", "3.1897113949009E+5023");
        assertSQR("7.7655779E+2552", "6.030420012096841E+5105");
        assertSQR("6.48586754E+2598", "4.20664777464256516E+5197");
        assertSQR("1E+3170", "1E+6340");
        assertSQR("5.647753E+3511", "3.1897113949009E+7023");
        assertSQR("7.7655779E+3552", "6.030420012096841E+7105");
        assertSQR("6.48586754E+3598", "4.20664777464256516E+7197");
        assertSQR("1E+4170", "1E+8340");
        assertSQR("5.647753E+4511", "3.1897113949009E+9023");
        assertSQR("7.7655779E+4552", "6.030420012096841E+9105");
        assertSQR("6.48586754E+4598", "4.20664777464256516E+9197");
        assertSQR("1E+5170", "1E+10340");
        assertSQR("5.647753E+5511", "3.1897113949009E+11023");
        assertSQR("7.7655779E+5552", "6.030420012096841E+11105");
        assertSQR("6.48586754E+5598", "4.20664777464256516E+11197");
        assertSQR("1E+6170", "1E+12340");
        assertSQR("5.647753E+6511", "3.1897113949009E+13023");
        assertSQR("7.7655779E+6552", "6.030420012096841E+13105");
        assertSQR("6.48586754E+6598", "4.20664777464256516E+13197");
        assertSQR("1E+7170", "1E+14340");
        assertSQR("5.647753E+7511", "3.1897113949009E+15023");
        assertSQR("7.7655779E+7552", "6.030420012096841E+15105");
        assertSQR("6.48586754E+7598", "4.20664777464256516E+15197");
        assertSQR("1E+8170", "1E+16340");
        assertSQR("5.647753E+8511", "3.1897113949009E+17023");
        assertSQR("7.7655779E+8552", "6.030420012096841E+17105");
        assertSQR("6.48586754E+8598", "4.20664777464256516E+17197");
        assertSQR("1E+9170", "1E+18340");
        assertSQR("5.647753E+9511", "3.1897113949009E+19023");
        assertSQR("7.7655779E+9552", "6.030420012096841E+19105");
        assertSQR("6.48586754E+9598", "4.20664777464256516E+19197");
        assertSQR("1E+10170", "1E+20340");
        assertSQR("5.647753E+10511", "3.1897113949009E+21023");
        assertSQR("7.7655779E+10552", "6.030420012096841E+21105");
        assertSQR("6.48586754E+10598", "4.20664777464256516E+21197");
        assertSQR("1E+9999", "1E+19998");
        assertSQR("1000000000000000", "1000000000000000000000000000000");

        assertSQR("0.01", "0.0001");
        assertSQR("0.02", "0.0004");
        assertSQR("0.03", "0.0009");
        assertSQR("0.04", "0.0016");
        assertSQR("0.05", "0.0025");
        assertSQR("0.06", "0.0036");
        assertSQR("0.07", "0.0049");
        assertSQR("0.08", "0.0064");
        assertSQR("0.09", "0.0081");
        assertSQR("0.0010", "0.00000100");
        assertSQR("0.0011", "0.00000121");
        assertSQR("0.0043", "0.00001849");
        assertSQR("0.0098", "0.00009604");
        assertSQR("0.000152", "2.3104E-8");
        assertSQR("0.000278", "7.7284E-8");
        assertSQR("0.000367", "1.34689E-7");
        assertSQR("0.000547", "2.99209E-7");
        assertSQR("0.000562", "3.15844E-7");
        assertSQR("0.000679", "4.61041E-7");
        assertSQR("0.000742", "5.50564E-7");
        assertSQR("0.000893", "7.97449E-7");
        assertSQR("0.000935", "8.74225E-7");
        assertSQR("0.000952", "9.06304E-7");
        assertSQR("0.000999", "9.98001E-7");
        assertSQR("0.00001008", "1.016064E-10");
        assertSQR("0.00002256", "5.089536E-10");
        assertSQR("0.00003173", "1.0067929E-9");
        assertSQR("0.00003477", "1.2089529E-9");
        assertSQR("0.00003889", "1.5124321E-9");
        assertSQR("0.00004378", "1.9166884E-9");
        assertSQR("0.00004647", "2.1594609E-9");
        assertSQR("0.00005448", "2.9680704E-9");
        assertSQR("0.00006271", "3.9325441E-9");
        assertSQR("0.00007118", "5.0665924E-9");
        assertSQR("0.00008072", "6.5157184E-9");
        assertSQR("0.00009112", "8.3028544E-9");
        assertSQR("0.00009214", "8.4897796E-9");
        assertSQR("0.0000055555", "3.086358025E-11");
        assertSQR("0.0000082534", "6.811861156E-11");
        assertSQR("0.72324911", "0.5230892751157921");
        assertSQR("0.123456789", "0.015241578750190521");
        assertSQR("1E-17", "1E-34");
        assertSQR("5.647753E-11", "3.1897113949009E-21");
        assertSQR("7.7655779E-52", "6.030420012096841E-103");
        assertSQR("6.48586754E-98", "4.20664777464256516E-195");
        assertSQR("1E-170", "1E-340");
        assertSQR("5.647753E-511", "3.1897113949009E-1021");
        assertSQR("7.7655779E-552", "6.030420012096841E-1103");
        assertSQR("6.48586754E-598", "4.20664777464256516E-1195");
        assertSQR("1E-1170", "1E-2340");
        assertSQR("5.647753E-1511", "3.1897113949009E-3021");
        assertSQR("7.7655779E-1552", "6.030420012096841E-3103");
        assertSQR("6.48586754E-1598", "4.20664777464256516E-3195");
        assertSQR("1E-2170", "1E-4340");
        assertSQR("5.647753E-2511", "3.1897113949009E-5021");
        assertSQR("7.7655779E-2552", "6.030420012096841E-5103");
        assertSQR("6.48586754E-2598", "4.20664777464256516E-5195");
        assertSQR("1E-3170", "1E-6340");
        assertSQR("5.647753E-3511", "3.1897113949009E-7021");
        assertSQR("7.7655779E-3552", "6.030420012096841E-7103");
        assertSQR("6.48586754E-3598", "4.20664777464256516E-7195");
        assertSQR("1E-4170", "1E-8340");
        assertSQR("5.647753E-4511", "3.1897113949009E-9021");
        assertSQR("7.7655779E-4552", "6.030420012096841E-9103");
        assertSQR("6.48586754E-4598", "4.20664777464256516E-9195");
        assertSQR("1E-5170", "1E-10340");
        assertSQR("5.647753E-5511", "3.1897113949009E-11021");
        assertSQR("7.7655779E-5552", "6.030420012096841E-11103");
        assertSQR("6.48586754E-5598", "4.20664777464256516E-11195");
        assertSQR("1E-6170", "1E-12340");
        assertSQR("5.647753E-6511", "3.1897113949009E-13021");
        assertSQR("7.7655779E-6552", "6.030420012096841E-13103");
        assertSQR("6.48586754E-6598", "4.20664777464256516E-13195");
        assertSQR("1E-7170", "1E-14340");
        assertSQR("5.647753E-7511", "3.1897113949009E-15021");
        assertSQR("7.7655779E-7552", "6.030420012096841E-15103");
        assertSQR("6.48586754E-7598", "4.20664777464256516E-15195");
        assertSQR("1E-8170", "1E-16340");
        assertSQR("5.647753E-8511", "3.1897113949009E-17021");
        assertSQR("7.7655779E-8552", "6.030420012096841E-17103");
        assertSQR("6.48586754E-8598", "4.20664777464256516E-17195");
        assertSQR("1E-9170", "1E-18340");
        assertSQR("5.647753E-9511", "3.1897113949009E-19021");
        assertSQR("7.7655779E-9552", "6.030420012096841E-19103");
        assertSQR("6.48586754E-9598", "4.20664777464256516E-19195");
        assertSQR("1E-10170", "1E-20340");
        assertSQR("5.647753E-10511", "3.1897113949009E-21021");
        assertSQR("7.7655779E-10552", "6.030420012096841E-21103");
        assertSQR("6.48586754E-10598", "4.20664777464256516E-21195");
        assertSQR("1E-9999", "1E-19998");
        assertSQR("0.0000000000000001", "1E-32");
    }

    private void assertSQR(String number, String expectedAnswer) throws DivisionByZeroException, NegativeSqrtException {
        assertEquals(expectedAnswer, testModel.calculate(new BigDecimal(number), UnaryOperations.SQUARE).toString());
        assertEquals(expectedAnswer, testModel.calculate(new BigDecimal("-" + number), UnaryOperations.SQUARE).toString());
    }
}