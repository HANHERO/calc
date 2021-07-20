package view;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.testfx.api.FxRobot;
import org.testfx.util.WaitForAsyncUtils;

import java.awt.*;

public class ViewTestsSandbox {
    private static final int MIN_WINDOW_WIDTH = 320;
    private static final int FRAME_WIGHT = 1;
    private static final int MIN_WINDOW_HEIGHT = 500;
    private static final int MAX_WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int MAX_WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    protected final FxRobot robot = new FxRobot();
    protected static Button fullScreenButton;
    protected static Button minimizeButton;
    protected static Button optionButton;
    protected static Button closeButton;
    protected static Stage stage;
    protected static AnchorPane menuPane;
    protected static javafx.scene.control.Label title;

    @BeforeClass
    public static void initJFX() {
        new JFXPanel();

        Platform.runLater(() -> {
            stage = new Stage();
            try {
                new Main().start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Scene scene = stage.getScene();
            title = (javafx.scene.control.Label) scene.lookup("#calcLabel");
            menuPane = (AnchorPane) scene.lookup("#menu");
            optionButton = (Button) scene.lookup("#option");
            fullScreenButton = (Button) scene.lookup("#fullScreenButton");
            minimizeButton = (Button) scene.lookup("#minimizeButton");
            closeButton = (Button) scene.lookup("#closeButton");
        });
        WaitForAsyncUtils.waitForFxEvents();
    }

    protected void moveTest(int dx, int dy) {
        double beforeX = stage.getX();
        double beforeY = stage.getY();
        robot.drag(title, MouseButton.PRIMARY);
        Point point = MouseInfo.getPointerInfo().getLocation();
        double offsetX = Math.abs(stage.getX() - point.getX());
        double offsetY = Math.abs(stage.getY() - point.getY());
        robot.moveBy(dx, dy);
        robot.drop();
        double afterX = stage.getX();
        double afterY = stage.getY();
        Assert.assertEquals(checkX(beforeX, dx, offsetX), afterX, 1);
        Assert.assertEquals(checkY(beforeY, dy, offsetY), afterY, 1);
    }

    protected double checkX(double beforeX, int dx, double offsetX) {
        double res = beforeX + dx;

        if (res > MAX_WINDOW_WIDTH) {
            res = MAX_WINDOW_WIDTH - offsetX - 1;
        } else if (res < 0) {
            res = -offsetX;
        }

        return res;
    }

    protected double checkY(double beforeY, int dy, double offsetY) {
        double res = beforeY + dy;

        if (res > MAX_WINDOW_HEIGHT) {
            res = MAX_WINDOW_HEIGHT - offsetY - 1;
        } else if (res < 0) {
            res = -offsetY;
        }

        return res;
    }

    protected void resizeTest(int dx, int dy, String pos) {
        returnNormalState();
        double beforeWidth = stage.getWidth();
        double beforeHeight = stage.getHeight();
        double beforeX = stage.getX();
        double beforeY = stage.getY();
        double expectedWidth = stage.getWidth();
        double expectedHeight = stage.getHeight();
        double x = stage.getX();
        double y = stage.getY();

        switch (pos) {
            case "E" -> {
                x += beforeWidth - FRAME_WIGHT;
                y += Math.random() * beforeHeight;
                expectedWidth = beforeWidth + dx;
            }
            case "W" -> {
                x += FRAME_WIGHT;
                y += Math.random() * beforeHeight;
                expectedWidth = beforeWidth - dx;
            }
            case "N" -> {
                x += Math.random() * beforeWidth;
                y += FRAME_WIGHT;
                expectedHeight = beforeHeight - dy;
            }
            case "S" -> {
                x += Math.random() * beforeWidth;
                y += beforeHeight - FRAME_WIGHT;
                expectedHeight = beforeHeight + dy;
            }
            case "NE" -> {
                x += beforeWidth - FRAME_WIGHT;
                expectedWidth = beforeWidth + dx;
                expectedHeight = beforeHeight - dy;
            }
            case "SE" -> {
                x += beforeWidth - FRAME_WIGHT;
                y += beforeHeight - FRAME_WIGHT;
                expectedWidth = beforeWidth + dx;
                expectedHeight = beforeHeight + dy;
            }
            case "SW" -> {
                y += beforeHeight - FRAME_WIGHT;
                expectedWidth = beforeWidth - dx;
                expectedHeight = beforeHeight + dy;
            }
            case "NW" -> {
                x += FRAME_WIGHT;
                y += FRAME_WIGHT;
                expectedWidth = beforeWidth - dx;
                expectedHeight = beforeHeight - dy;
            }
        }

        robot.drag(x, y, MouseButton.PRIMARY);
        robot.moveBy(dx, dy);
        robot.drop();
        expectedWidth = checkWidth(expectedWidth, beforeWidth, beforeX);
        expectedHeight = checkHeight(expectedHeight, beforeHeight, beforeY);

        Assert.assertEquals(expectedWidth, stage.getWidth(), 5.0);
        Assert.assertEquals(expectedHeight, stage.getHeight(), 5.0);
    }

    protected void returnNormalState() {
        WaitForAsyncUtils.waitForFxEvents();
        stage.setHeight(MIN_WINDOW_HEIGHT);
        stage.setWidth(MIN_WINDOW_WIDTH);
        stage.setX(500);
        stage.setY(150);
    }

    protected double checkWidth(double width, double beforeWidth, double beforeX) {
        if (width < MIN_WINDOW_WIDTH) {
            width = MIN_WINDOW_WIDTH;
        } else if (stage.getX() == 0 && beforeWidth + beforeX < width) {
            width = beforeWidth + beforeX;
        } else if (stage.getX() + width > MAX_WINDOW_WIDTH) {
            width = MAX_WINDOW_WIDTH - stage.getX();
        }

        return width;
    }

    protected double checkHeight(double height, double beforeHeight, double beforeY) {
        if (height < MIN_WINDOW_HEIGHT) {
            height = MIN_WINDOW_HEIGHT;
        } else if (stage.getY() == 0 && beforeHeight + beforeY < height) {
            height = beforeHeight + beforeY;
        } else if (stage.getY() + height > MAX_WINDOW_HEIGHT) {
            height = MAX_WINDOW_HEIGHT - stage.getY();
        }

        return height;
    }

}
