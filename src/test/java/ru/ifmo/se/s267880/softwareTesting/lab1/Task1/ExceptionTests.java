package ru.ifmo.se.s267880.softwareTesting.lab1.Task1;

import org.junit.Test;

public class ExceptionTests {
    @Test(expected = IllegalArgumentException.class)
    public void testBigger() {
        MyMath.acos(1.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSmaller() {
        MyMath.acos(-1.00001);
    }
}
