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
    Clicker clicker = new Clicker();
    protected static final String OVERFLOW = "Переполнение";
    protected static final String DIVISION_BY_ZERO = "Деление на ноль невозможно";
    protected static final String NEGATIVE_SQRT = "Неверный ввод";
    protected static final String RESULT_UNDEFINED = "Результат неопределен";
    protected static final String MAX_INPUT = "9999999999999999";
    protected static final String MIN_INPUT = "0,0000000000000001";
    protected static final String NEAREST_TO_ZERO_POSITIVE_NUMBER = MIN_INPUT + " sqr * 0,0000001 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,000000000000001 =";
    protected static final String MAX_NUMBER = "1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * " + MAX_INPUT +
            " = m+ c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr m+ c " + NEAREST_TO_ZERO_POSITIVE_NUMBER +
            " m- c 1000000000000000 sqr * 1000000000 = sqr sqr sqr sqr sqr sqr sqr sqr * 0,5 = m- c mr";

    public TestingSandBox() throws AWTException {
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

    public void mainLabelAndHistoryTest(String mainLabelExcepted, String historyLabelExcepted) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        String historyLabel = "#historyLabel";

        verifyThat(historyLabel, (Label label) -> label.getText().equals(historyLabelExcepted));
        verifyThat(mainLabel, (Label label) -> label.getText().equals(mainLabelExcepted));
        clicker.click("c");
        clicker.click("mc");
    }

    public void mainLabelTest(int size) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        verifyThat(mainLabel, (javafx.scene.control.Label label) -> label.getFont().getSize() == size);
        clicker.click("c");
    }
}
