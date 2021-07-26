package view;

import org.junit.Assert;
import org.junit.Test;

public class HistoryMoverButtonsTest extends ViewTestsSandbox {

    @Test
    public void historyMoveTest() {
        //Checks the visibility of history buttons.
        Assert.assertFalse(historyRightMover.isVisible());
        Assert.assertFalse(historyLeftMover.isVisible());
        //Enters a scenario in which the left story button appears.
        robot.clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine")
                .clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine")
                .clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine").clickOn("#nine")
                .clickOn("#nine").clickOn("#square").clickOn("#square").clickOn("#square").clickOn("#square")
                .clickOn("#square").clickOn("#sqrt").clickOn("#sqrt").clickOn("#sqrt").clickOn("#sqrt")
                .clickOn("#sqrt");
        //Checks the visibility of history buttons.
        Assert.assertTrue(historyLeftMover.isVisible());
        Assert.assertFalse(historyRightMover.isVisible());
        //Clicks the left button until it disappears.
        robot.clickOn("#historyLeftMover").clickOn("#historyLeftMover").clickOn("#historyLeftMover").clickOn("#historyLeftMover");
        //Checks the visibility of history buttons.
        Assert.assertTrue(historyRightMover.isVisible());
        Assert.assertFalse(historyLeftMover.isVisible());
        //Clicks the right button until it disappears.
        robot.clickOn("#historyRightMover").clickOn("#historyRightMover").clickOn("#historyRightMover").clickOn("#historyRightMover");
        //Checks the visibility of history buttons.
        Assert.assertFalse(historyRightMover.isVisible());
        Assert.assertTrue(historyLeftMover.isVisible());
        robot.clickOn("#C");
        //Checks the visibility of history buttons.
        Assert.assertFalse(historyRightMover.isVisible());
        Assert.assertFalse(historyLeftMover.isVisible());

    }
}