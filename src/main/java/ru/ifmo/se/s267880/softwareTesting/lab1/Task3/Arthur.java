package ru.ifmo.se.s267880.softwareTesting.lab1.Task3;

import java.util.HashSet;
import java.util.Set;

public class Arthur {
    private static final int OBJECT_COUNT_NORMAL_LIMIT = 10;
    private Set<Feeling> feelings = new HashSet<>();
    private int sawObjectsCount = 0;

    public Arthur() {
    }

    public void addFeeling(Feeling feeling) {
        System.out.printf("Arthur expressed %s feeling.\n", feeling);
        feelings.add(feeling);
    }

    public boolean hasFeeling(Feeling feeling) {
        return feelings.contains(feeling);
    }

    public void see(AlienMan alienMan) {
        System.out.printf("Arthur saw an alien man %s.\n", alienMan);
        if (!hasFeeling(Feeling.ASTONISHED)) {
            addFeeling(Feeling.ASTONISHED);
        }
    }

    public void see(AlienThing thing) {
        System.out.printf("Arthur saw a thing called %s.\n", thing);
        ++sawObjectsCount;
        if (sawObjectsCount >= OBJECT_COUNT_NORMAL_LIMIT && !hasFeeling(Feeling.JAW_DROPPED)) {
            addFeeling(Feeling.JAW_DROPPED);
        }
    }

    public void resetSawObjectCount() {
        System.out.printf("Arthur did not see anything.\n");
        sawObjectsCount = 0;
        feelings.remove(Feeling.JAW_DROPPED);
    }
}
