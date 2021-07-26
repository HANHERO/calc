package controller.robotTests;

import controller.sandBox.TestingSandBox;
import org.junit.Test;

public class AccuracyTest extends TestingSandBox {
    private final String SQRT_SQR = " sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt " +
            "sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt sqrt " +
            "sqrt sqrt sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" +
            " sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr";

    private final String START_HISTORY = "sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( sqr( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( √( ";
    private final String END_HISTORY = " ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) ) )";

    @Test
    public void accuracySqrtSqrScenarios() {
        mouseInputTest("3,1415" + SQRT_SQR, "3,1415", START_HISTORY + "3,1415" + END_HISTORY);
        mouseInputTest("2" + SQRT_SQR, "2", START_HISTORY + "2" + END_HISTORY);
        mouseInputTest(MAX_INPUT + SQRT_SQR, "9 999 999 999 999 999", START_HISTORY + "9999999999999999" + END_HISTORY);
        mouseInputTest(MIN_INPUT + SQRT_SQR, "0,0000000000000001", START_HISTORY + "0,0000000000000001" + END_HISTORY);
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + SQRT_SQR, "1e-9999", START_HISTORY + "1e-9999" + END_HISTORY);
        mouseInputTest(MAX_NUMBER + SQRT_SQR, "9,999999999999999e+9999", START_HISTORY + "9,999999999999999e+9999" + END_HISTORY);

        mouseInputTest("3,1415" + " sqrt" + SQRT_SQR + " sqr", "3,1415", "sqr( " + START_HISTORY + "√( " + "3,1415" + END_HISTORY + " ) )");
        mouseInputTest("2" + " sqrt" + SQRT_SQR + " sqr", "2", "sqr( " + START_HISTORY + "√( " +  "2" + END_HISTORY + " ) )");
        mouseInputTest(MAX_INPUT + " sqrt" + SQRT_SQR + " sqr", "9 999 999 999 999 999", "sqr( " + START_HISTORY + "√( " + "9999999999999999" + END_HISTORY + " ) )");
        mouseInputTest(MIN_INPUT + " sqrt" + SQRT_SQR + " sqr", "0,0000000000000001", "sqr( " + START_HISTORY + "√( " + "0,0000000000000001" + END_HISTORY + " ) )");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " sqrt" + SQRT_SQR + " sqr", "1e-9999", "sqr( " + START_HISTORY + "√( " + "1e-9999" + END_HISTORY + " ) )");
        mouseInputTest(MAX_NUMBER + " sqrt" + SQRT_SQR + " sqr", "Переполнение", "sqr( " + START_HISTORY + "√( " + "9,999999999999999e+9999" + END_HISTORY + " ) )");
    }

    @Test
    public void accuracyDivideMultiplyScenarios() {
        mouseInputTest("3,1415 / 15 = = = = = = = = = = = = = = = = = = = * 15 = = = = = = = = = = = = = = = = = = =", "3,1415", "0,2094333333333333 × 15 = ");
        mouseInputTest("3,1415 / 0,15 = = = = = = = = = = = = = = = = = = = * 0,15 = = = = = = = = = = = = = = = = = = =", "3,1415", "20,94333333333333 × 0,15 = ");
        mouseInputTest(MAX_INPUT + " / 54332 = = = = = = = = = = = = = = = = = = = * 54332 = = = = = = = = = = = = = = = = = = =", "9 999 999 999 999 999", "184053596407,2738 × 54332 = ");
        mouseInputTest(MAX_INPUT + " / 0,54332 = = = = = = = = = = = = = = = = = = = * 0,54332 = = = = = = = = = = = = = = = = = = =", "9 999 999 999 999 999", "1,840535964072738e+16 × 0,54332 = ");
        mouseInputTest(MIN_INPUT + " / 34235 = = = = = = = = = = = = = = = = = = = * 34235 = = = = = = = = = = = = = = = = = = =", "0,0000000000000001", "2,920987293705272e-21 × 34235 = ");
        mouseInputTest(MIN_INPUT + " / 0,34235 = = = = = = = = = = = = = = = = = = = * 0,34235 = = = = = = = = = = = = = = = = = = =", "0,0000000000000001", "2,920987293705272e-16 × 0,34235 = ");
        mouseInputTest(MAX_NUMBER + " / 86753224 = = = = = = = = = = = = = = = = = = = * 86753224 = = = = = = = = = = = = = = = = = = =", "9,999999999999999e+9999", "1,152694913102019e+9992 × 86753224 = ");
        mouseInputTest(MAX_NUMBER + " * 0,000867534 = = = = = = = = = = = = = = = = = = = / 0,000867534 = = = = = = = = = = = = = = = = = = =", "9,999999999999999e+9999", "8,67534e+9996 ÷ 0,000867534 = ");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " * 6432 = = = = = = = = = = = = = = = = = = = / 6432 = = = = = = = = = = = = = = = = = = =", "1e-9999", "6,432e-9996 ÷ 6432 = ");
        mouseInputTest(NEAREST_TO_ZERO_POSITIVE_NUMBER + " / 0,632 = = = = = = = = = = = = = = = = = = = * 0,632 = = = = = = = = = = = = = = = = = = =", "1e-9999", "1,582278481012658e-9999 × 0,632 = ");
    }
}
