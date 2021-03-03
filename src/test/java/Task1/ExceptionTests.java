package Task1;

import org.junit.Test;

import ru.ifmo.se.s267880.softwareTesting.lab1.Task1;

public class ExceptionTests {
    @Test(expected = IllegalArgumentException.class)
    public void testBigger() {
        Task1.acos(1.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSmaller() {
        Task1.acos(-1.00001);
    }
}
