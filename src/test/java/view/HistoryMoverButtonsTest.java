package view;

import org.junit.Assert;
import org.junit.Test;

public class HistoryMoverButtonsTest extends ViewTestsSandbox {

    @Test
    public void historyMoveTest() {
        Assert.assertFalse(historyRightMover.isVisible());
        Assert.assertFalse(historyLeftMover.isVisible());
        robot.clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine")
                .clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine")
                .clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine")
                .clickOn("#nine").clickOn("#square").clickOn("#square").clickOn("#square").clickOn("#square")
                .clickOn("#square").clickOn("#sqrt").clickOn("#sqrt").clickOn("#sqrt").clickOn("#sqrt")
                .clickOn("#sqrt");
        Assert.assertTrue(historyLeftMover.isVisible());
        Assert.assertFalse(historyRightMover.isVisible());
        robot.clickOn("#historyLeftMover").clickOn("#historyLeftMover").clickOn("#historyLeftMover").clickOn("#historyLeftMover");
        Assert.assertTrue(historyRightMover.isVisible());
        Assert.assertFalse(historyLeftMover.isVisible());
        robot.clickOn("#historyRightMover").clickOn("#historyRightMover").clickOn("#historyRightMover").clickOn("#historyRightMover");
        Assert.assertFalse(historyRightMover.isVisible());
        Assert.assertTrue(historyLeftMover.isVisible());
        robot.clickOn("#C");
        Assert.assertFalse(historyRightMover.isVisible());
        Assert.assertFalse(historyLeftMover.isVisible());

    }
}