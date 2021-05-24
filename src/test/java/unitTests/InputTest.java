package unitTests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputTest {
    Clicker clicker = new Clicker();

    @Test
    public void scenarios(){
        test("1", "1");
    }

    public void test(String excepted, String input){
        assertEquals(excepted, clicker.run(input));
    }
}
