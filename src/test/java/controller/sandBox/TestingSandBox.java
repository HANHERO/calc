package controller.sandBox;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import org.junit.After;
import org.junit.Before;
import org.loadui.testfx.utils.FXTestUtils;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import view.Main;

import java.awt.*;
import java.util.concurrent.TimeoutException;

import static org.testfx.api.FxAssert.verifyThat;

public class TestingSandBox extends ApplicationTest {
    protected Clicker clicker;

    {
        try {
            clicker = new Clicker();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    protected static final String OVERFLOW = "Переполнение";
    protected static final String DIVISION_BY_ZERO = "Деление на ноль невозможно";
    protected static final String NEGATIVE_SQRT = "Неверный ввод";
    protected static final String RESULT_UNDEFINED = "Результат неопределен";
    protected static final String MAX_INPUT = "9999999999999999";
    protected static final String MIN_INPUT = "0,0000000000000001";
    protected static final String NEAREST_TO_ZERO_POSITIVE_NUMBER = MIN_INPUT + " sqr * 0,0000001 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,000000000000001 =";
    protected static final String MAX_NUMBER = "1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 9999999999999999 =" +
            " ms / 9999999999999999 * 0,5 = m+ / 5000000000000000 / 100 = m- c mr";

    public TestingSandBox() {
    }

    @Before
    public void setUpClass() throws Exception {
        ApplicationTest.launch(Main.class);
    }

    @After
    public void afterEachTest() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    public void mouseInputTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        String historyLabel = "#historyLabel";
        clicker.mouseClickExpression(expression);
        FXTestUtils.awaitEvents();
        verifyThat(historyLabel, (Label label) -> label.getText().equals(historyLabelExcepted));
        verifyThat(mainLabel, (Label label) -> label.getText().equals(mainLabelExcepted));
        clicker.clickMouse("mc");
        clicker.clickMouse("c");
        FXTestUtils.awaitEvents();
    }

    public void mainLabelTest(String expression, int size) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        clicker.mouseClickExpression(expression);
        FXTestUtils.awaitEvents();
        verifyThat(mainLabel, (javafx.scene.control.Label label) -> label.getFont().getSize() == size);
        clicker.clickMouse("c");
    }
    public void keyboardInputTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        String historyLabel = "#historyLabel";
        clicker.keyboardClickExpression(expression);
        verifyThat(historyLabel, (Label label) -> label.getText().equals(historyLabelExcepted));
        verifyThat(mainLabel, (Label label) -> label.getText().equals(mainLabelExcepted));
        clicker.clickKeyboard("mc");
        clicker.clickKeyboard("c");
    }

    public void alternativeKeyboardInputTest(String expression, String mainLabelExcepted, String historyLabelExcepted) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        String historyLabel = "#historyLabel";
        clicker.alternativeKeyboardClickExpression(expression);
        verifyThat(historyLabel, (Label label) -> label.getText().equals(historyLabelExcepted));
        verifyThat(mainLabel, (Label label) -> label.getText().equals(mainLabelExcepted));
        clicker.clickAlternativeKeyboard("mc");
        clicker.clickAlternativeKeyboard("c");
    }
}
