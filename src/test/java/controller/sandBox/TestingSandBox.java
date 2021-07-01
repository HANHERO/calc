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

    public TestingSandBox() throws AWTException {
    }

    @Before
    public void setUpClass() throws Exception{
        ApplicationTest.launch(Main.class);
    }
    @After
    public void afterEachTest() throws TimeoutException{
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
        verifyThat(mainLabel, (Label label) -> label.getText().equals("0"));
        verifyThat(historyLabel, (Label label) -> label.getText().equals(""));
    }
    public void mainLabelTest(int size) {
        FXTestUtils.awaitEvents();
        String mainLabel = "#mainLabel";
        verifyThat(mainLabel, (javafx.scene.control.Label label) -> label.getFont().getSize() == size);
        clicker.click("c");
        clicker.click("mc");
    }
}
