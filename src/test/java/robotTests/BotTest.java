package robotTests;


import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class BotTest {
    Clicker clicker;

    {
        try {
            clicker = new Clicker();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void setUps() {
       // new Thread(() -> Main.main(new String[]{})).start();
    }

    @Test
    public void testTest() throws InterruptedException {
        Thread.sleep(3000);
        clicker.clickNumber(152);
        clicker.click("plus");
        clicker.clickNumber(165);
        clicker.click("equals");
        clicker.clickNumber(342342);
        clicker.click("minus");
        clicker.clickNumber(45435);
        clicker.click("equals");
        clicker.clickNumber(3423);
        clicker.click("divide");
        clicker.click("square");
        clicker.click("plus");
        clicker.clickNumber(754);
        clicker.click("equals");
        clicker.clickNumber(3);
        clicker.click("multiply");
        clicker.clickNumber(4235);
        clicker.click("equals");
        clicker.clickNumber(643);
        clicker.click("divide");
        clicker.clickNumber(23467);
        clicker.click("equals");
    }
}