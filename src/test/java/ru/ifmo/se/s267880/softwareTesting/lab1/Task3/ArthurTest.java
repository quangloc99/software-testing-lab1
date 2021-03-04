package ru.ifmo.se.s267880.softwareTesting.lab1.Task3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArthurTest extends StdoutCapture {
    private Arthur arthur;

    @Before
    public void setupTest() {
        arthur = new Arthur();
    }

    @Test
    public void testFeeling() {
        // only one feeling at a time
        assertFalse(arthur.hasFeeling(Feeling.NERVOUS));
        arthur.addFeeling(Feeling.NERVOUS);
        assertTrue(arthur.hasFeeling(Feeling.NERVOUS));
        assertCurrentStdoutThenReset("Arthur expressed nervous feeling.\n");

        // add two at a time
        assertFalse(arthur.hasFeeling(Feeling.HAPPY));
        assertFalse(arthur.hasFeeling(Feeling.FOCUSED));
        arthur.addFeeling(Feeling.HAPPY);
        arthur.addFeeling(Feeling.FOCUSED);
        assertTrue(arthur.hasFeeling(Feeling.HAPPY));
        assertTrue(arthur.hasFeeling(Feeling.FOCUSED));
        assertTrue(arthur.hasFeeling(Feeling.NERVOUS));
        assertCurrentStdoutThenReset(
                "Arthur expressed happy feeling.\n" +
                "Arthur expressed focused feeling.\n");
    }

    @Test
    public void testSeeAlienMan() {
        assertFalse(arthur.hasFeeling(Feeling.ASTONISHED));
        arthur.see(new AlienMan());
        assertTrue(arthur.hasFeeling(Feeling.ASTONISHED));
        assertCurrentStdoutThenReset(
                "Arthur saw an alien man without name.\n" +
                "Arthur expressed astonished feeling.\n");
        arthur.see(new AlienMan("Darth Vader"));
        assertTrue(arthur.hasFeeling(Feeling.ASTONISHED));
        assertCurrentStdoutThenReset("Arthur saw an alien man Darth Vader.\n");
    }

    @Test
    public void testSeeAlienThings() {
        // Arthur must see 10 things before being jaw dropped.
        // 1
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("door"));
        assertCurrentStdoutThenReset("Arthur saw a thing called door.\n");
        // 2
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("chair"));
        assertCurrentStdoutThenReset("Arthur saw a thing called chair.\n");
        // 3
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("table"));
        assertCurrentStdoutThenReset("Arthur saw a thing called table.\n");
        // 4
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("control panel"));
        assertCurrentStdoutThenReset("Arthur saw a thing called control panel.\n");
        // 5
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("pen"));
        assertCurrentStdoutThenReset("Arthur saw a thing called pen.\n");
        // 6
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("hoe"));
        assertCurrentStdoutThenReset("Arthur saw a thing called hoe.\n");
        // 7
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("red hammer"));
        assertCurrentStdoutThenReset("Arthur saw a thing called red hammer.\n");
        // 8
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("your mom"));
        assertCurrentStdoutThenReset("Arthur saw a thing called your mom.\n");
        // 9
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("chest"));
        assertCurrentStdoutThenReset("Arthur saw a thing called chest.\n");
        // 10
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("programming language"));
        assertCurrentStdoutThenReset(
                "Arthur saw a thing called programming language.\n" +
                        "Arthur expressed jaw dropped feeling.\n"
                );

        assertTrue(arthur.hasFeeling(Feeling.JAW_DROPPED));
        arthur.see(new AlienThing("IDE"));
        assertCurrentStdoutThenReset("Arthur saw a thing called IDE.\n");
        assertTrue(arthur.hasFeeling(Feeling.JAW_DROPPED));

        arthur.resetSawObjectCount();
        assertFalse(arthur.hasFeeling(Feeling.JAW_DROPPED));
        assertCurrentStdoutThenReset("Arthur did not see anything.\n");
    }
}
