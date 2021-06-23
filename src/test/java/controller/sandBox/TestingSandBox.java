package controller.sandBox;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import org.junit.After;
import org.junit.Before;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import view.Main;

import java.util.concurrent.TimeoutException;

public class TestingSandBox extends ApplicationTest {
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
}
