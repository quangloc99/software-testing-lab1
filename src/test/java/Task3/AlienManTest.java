package Task3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ru.ifmo.se.s267880.softwareTesting.lab1.Task3.AlienMan;
import ru.ifmo.se.s267880.softwareTesting.lab1.Task3.AlienThing;
import ru.ifmo.se.s267880.softwareTesting.lab1.Task3.Feeling;

public class AlienManTest extends StdoutCapture {
    private AlienMan alienMan;

    @Before
    public void setupTest() {
        alienMan = new AlienMan();
    }

    @Test
    public void testPutActions() {
        alienMan.putHand("table");
        alienMan.putLeg(new AlienThing("papers"));
        alienMan.sitOn("the top");

        assertCurrentStdoutThenReset(
                "Alien man without name put his hand on table.\n" +
                "Alien man without name put his leg on papers.\n" +
                "Alien man without name sat on the top.\n"
        );

        alienMan.putHand(new AlienThing("lazer gun"));
        alienMan.putLeg(new AlienThing("banana peel"));
        alienMan.sitOn(new AlienThing("robot horse"));

        assertCurrentStdoutThenReset(
                "Alien man without name put his hand on lazer gun.\n" +
                        "Alien man without name put his leg on banana peel.\n" +
                        "Alien man without name sat on robot horse.\n"
        );
    }

    @Test
    public void testHeadFeelings() {
        assertFalse(alienMan.hasFeeling(Feeling.HAPPY));
        assertFalse(alienMan.hasFeeling(Feeling.NERVOUS));
        assertFalse(alienMan.hasFeeling(Feeling.FOCUSED));
        assertFalse(alienMan.hasFeeling(Feeling.ASTONISHED));

        alienMan.addLeftHeadFeelings(Feeling.NERVOUS);
        assertTrue(alienMan.hasFeeling(Feeling.NERVOUS));
        assertCurrentStdoutThenReset("Alien man without name expressed nervous feeling on his left head.\n");

        alienMan.addRightHeadFeeling(Feeling.HAPPY);
        assertTrue(alienMan.hasFeeling(Feeling.HAPPY));
        assertCurrentStdoutThenReset("Alien man without name expressed happy feeling on his right head.\n");
    }
}
