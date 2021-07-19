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
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.util.WaitForAsyncUtils;

import java.awt.*;

public class ViewTests {
    private static final int MIN_WINDOW_WIDTH = 320;

    private static final int FRAME_WIGHT = 1;

    private static final int MIN_WINDOW_HEIGHT = 500;

    private static final int MAX_WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;

    private static final int MAX_WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    private final FxRobot robot = new FxRobot();

    private static Stage stage;

    private static AnchorPane menuPane;

    private static javafx.scene.control.Button menuShow;

    private static javafx.scene.control.Button menuClose;

    private static javafx.scene.control.Label title;

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
            menuShow = (javafx.scene.control.Button) scene.lookup("#option");
            menuClose = (Button) scene.lookup("#option");
        });
        WaitForAsyncUtils.waitForFxEvents();
    }

    @Test
    public void moveTest() {
        //handle tests
        moveTest(150, 100);
        moveTest(274, -182);
        moveTest(-530, 0);
        moveTest(0, 387);
        moveTest(123, -298);
        moveTest(-430, 257);
        moveTest(534, 341);
        moveTest(-27, -436);
    }

    @Test
    public void menuTest() throws Exception {
        Assert.assertEquals(0.0, menuPane.getTranslateX(), 0.1);
        robot.clickOn(menuShow);
        Thread.sleep(350);
        Assert.assertEquals(320.0, menuPane.getTranslateX(), 0.1);
        robot.clickOn(menuClose);
        Thread.sleep(350);
        Assert.assertEquals(0.0, menuPane.getTranslateX(), 0.1);
    }

    @Test
    public void resizeTest() {
        //resize from left border of window
        resizeTest(100, 0, "E");
        resizeTest(0, 50, "E");
        resizeTest(-123, 0, "E");
        resizeTest(-9876, 0, "E");
        resizeTest(-1765, 1399, "E");

        //resize from right border of window
        resizeTest(0, 0, "W");
        resizeTest(90, 0, "W");
        resizeTest(58, 0, "W");
        resizeTest(1043, 1027, "W");
        resizeTest(777, -666, "W");

        //resize from top border of window
        resizeTest(65, 0, "N");
        resizeTest(-10, 48, "N");
        resizeTest(-1740, 0, "N");
        resizeTest(-2111, 3399, "N");
        resizeTest(0, 1962, "N");

        //resize from bottom border of window
        resizeTest(2980, 0, "S");
        resizeTest(-1924, -2321, "S");
        resizeTest(0, -2432, "S");
        resizeTest(-1320, 0, "S");
        resizeTest(1777, -1446, "S");

        // resize from right bottom corner of window
        resizeTest(0, 0, "SE");
        resizeTest(-250, 22, "SE");
        resizeTest(-3924, -1321, "SE");
        resizeTest(0, -2974, "SE");
        resizeTest(-1769, 0, "SE");

        //resize from left bottom corner of window
        resizeTest(-50, 50, "SW");
        resizeTest(99, -87, "SW");
        resizeTest(-1993, 0, "SW");
        resizeTest(-2723, -1893, "SW");
        resizeTest(1636, -1828, "SW");

        //resize from left top corner of window
        resizeTest(0, 0, "NW");
        resizeTest(177, 78, "NW");
        resizeTest(127, 182, "NW");
        resizeTest(-6172, -3182, "NW");
        resizeTest(7641, -1932, "NW");
    }

    private void moveTest(int dx, int dy) {
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

    private double checkX(double beforeX, int dx, double offsetX) {
        double res = beforeX + dx;

        if (res > MAX_WINDOW_WIDTH) {
            res = MAX_WINDOW_WIDTH - offsetX - 1;
        } else if (res < 0) {
            res = -offsetX;
        }

        return res;
    }

    private double checkY(double beforeY, int dy, double offsetY) {
        double res = beforeY + dy;

        if (res > MAX_WINDOW_HEIGHT) {
            res = MAX_WINDOW_HEIGHT - offsetY - 1;
        } else if (res < 0) {
            res = -offsetY;
        }

        return res;
    }


    private void resizeTest(int dx, int dy, String pos) {
        returnNormalState();
        double beforeWidth = stage.getWidth();
        double beforeHeight = stage.getHeight();
        double beforeX = stage.getX();
        double beforeY = stage.getY();
        //initial approach of expected width and height
        double expectedWidth = stage.getWidth();
        double expectedHeight = stage.getHeight();
        //initial approach for drag
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

    private void returnNormalState() {
        WaitForAsyncUtils.waitForFxEvents();
        stage.setHeight(MIN_WINDOW_HEIGHT);
        stage.setWidth(MIN_WINDOW_WIDTH);
        stage.setX(500);
        stage.setY(150);
    }

    private double checkWidth(double width, double beforeWidth, double beforeX) {
        if (width < MIN_WINDOW_WIDTH) {
            width = MIN_WINDOW_WIDTH;
        } else if (stage.getX() == 0 && beforeWidth + beforeX < width) {
            width = beforeWidth + beforeX;
        } else if (stage.getX() + width > MAX_WINDOW_WIDTH) {
            width = MAX_WINDOW_WIDTH - stage.getX();
        }

        return width;
    }

    private double checkHeight(double height, double beforeHeight, double beforeY) {
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
