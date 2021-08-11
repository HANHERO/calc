package view;

import controller.sandBox.Clicker;
import javafx.application.Platform;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.util.WaitForAsyncUtils;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SystemButtonsTest extends ViewTestsSandbox {
    @Test
    public void maximizeTest() {
        assertFalse(stage.isMaximized());
        robot.clickOn(fullScreenButton);
        assertTrue(stage.isMaximized());
        robot.clickOn(fullScreenButton);
        assertFalse(stage.isMaximized());
    }

    @Test
    public void hideTest() {
        assertFalse(stage.isIconified());
        robot.clickOn(minimizeButton);
        assertTrue(stage.isIconified());
        Platform.runLater(() -> stage.setIconified(false));
        WaitForAsyncUtils.waitForFxEvents();
        assertFalse(stage.isIconified());
    }

    @Test
    public void closeTest() throws AWTException, InterruptedException {
        Assert.assertTrue(stage.isShowing());
        Thread.sleep(250);
        new Clicker().clickMouse("close");
        Thread.sleep(250);
        Assert.assertFalse(stage.isShowing());
    }
}