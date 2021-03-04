package ru.ifmo.se.s267880.softwareTesting.lab1.Task3;

import org.junit.Test;

public class TestScript extends StdoutCapture {
    @Test
    public void testScript() {
        Arthur arthur = new Arthur();
        AlienMan zaphod = new AlienMan("Zaphod");

        arthur.addFeeling(Feeling.NERVOUS);
        arthur.see(zaphod);
        zaphod.sitOn(new AlienThing("chair"));
        zaphod.putLeg(new AlienThing("control panel"));
        zaphod.putHand("his right head");
        zaphod.addRightHeadFeeling(Feeling.FOCUSED);
        zaphod.addLeftHeadFeelings(Feeling.HAPPY);
        arthur.see(new AlienThing("chair"));
        arthur.see(new AlienThing("table"));
        arthur.see(new AlienThing("control panel"));
        arthur.see(new AlienThing("pen"));
        arthur.see(new AlienThing("keyboard"));
        arthur.see(new AlienThing("mouse"));
        arthur.see(new AlienThing("monitor"));
        arthur.see(new AlienThing("window"));
        arthur.see(new AlienThing("linux"));
        arthur.see(new AlienThing("rice cooker"));

        assertCurrentStdout(
                "Arthur expressed nervous feeling.\n" +
                        "Arthur saw an alien man Zaphod.\n" +
                        "Arthur expressed astonished feeling.\n" +
                        "Alien man Zaphod sat on chair.\n" +
                        "Alien man Zaphod put his leg on control panel.\n" +
                        "Alien man Zaphod put his hand on his right head.\n" +
                        "Alien man Zaphod expressed focused feeling on his right head.\n" +
                        "Alien man Zaphod expressed happy feeling on his left head.\n" +
                        "Arthur saw a thing called chair.\n" +
                        "Arthur saw a thing called table.\n" +
                        "Arthur saw a thing called control panel.\n" +
                        "Arthur saw a thing called pen.\n" +
                        "Arthur saw a thing called keyboard.\n" +
                        "Arthur saw a thing called mouse.\n" +
                        "Arthur saw a thing called monitor.\n" +
                        "Arthur saw a thing called window.\n" +
                        "Arthur saw a thing called linux.\n" +
                        "Arthur saw a thing called rice cooker.\n" +
                        "Arthur expressed jaw dropped feeling.\n"
        );
    }
}
