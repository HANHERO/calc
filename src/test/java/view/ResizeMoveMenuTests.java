package view;

import org.junit.Assert;
import org.junit.Test;

public class ResizeMoveMenuTests extends ViewTestsSandbox{
    @Test
    public void moveTest() {
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
    public void menuTest()  {
        Assert.assertFalse(menuPane.isVisible());
        robot.clickOn(optionButton);
        robot.sleep(50);
        Assert.assertTrue(menuPane.isVisible());
        robot.clickOn(optionButton);
        robot.sleep(50);
        Assert.assertFalse(menuPane.isVisible());
    }

    @Test
    public void resizeTest() {
        resizeTest(100, 0, "E");
        resizeTest(0, 50, "E");
        resizeTest(-123, 0, "E");
        resizeTest(-9876, 0, "E");
        resizeTest(-1765, 1399, "E");

        resizeTest(0, 0, "W");
        resizeTest(90, 0, "W");
        resizeTest(58, 0, "W");
        resizeTest(1043, 1027, "W");
        resizeTest(777, -666, "W");

        resizeTest(65, 0, "N");
        resizeTest(-10, 48, "N");
        resizeTest(-1740, 0, "N");
        resizeTest(-2111, 3399, "N");
        resizeTest(0, 1962, "N");

        resizeTest(2980, 0, "S");
        resizeTest(-1924, -2321, "S");
        resizeTest(0, -2432, "S");
        resizeTest(-1320, 0, "S");
        resizeTest(1777, -1446, "S");

        resizeTest(0, 0, "SE");
        resizeTest(-250, 22, "SE");
        resizeTest(-3924, -1321, "SE");
        resizeTest(0, -2974, "SE");
        resizeTest(-1769, 0, "SE");

        resizeTest(-50, 50, "SW");
        resizeTest(99, -87, "SW");
        resizeTest(-1993, 0, "SW");
        resizeTest(-2723, -1893, "SW");
        resizeTest(1636, -1828, "SW");

        resizeTest(0, 0, "NW");
        resizeTest(177, 78, "NW");
        resizeTest(127, 182, "NW");
        resizeTest(-6172, -3182, "NW");
        resizeTest(7641, -1932, "NW");

        resizeTest(50, -50, "NE");
        resizeTest(-99, 87, "NE");
        resizeTest(1993, 0, "NE");
        resizeTest(2723, 1893, "NE");
        resizeTest(-1636, 1828, "NE");
    }
}
