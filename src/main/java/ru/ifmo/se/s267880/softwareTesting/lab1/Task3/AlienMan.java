package ru.ifmo.se.s267880.softwareTesting.lab1.Task3;

import java.util.HashSet;
import java.util.Set;

// https://en.wikipedia.org/wiki/Zaphod_Beeblebrox
public class AlienMan {
    private Set<Feeling> leftHeadFeelings = new HashSet<>(), rightHeadFeelings = new HashSet<>();
    private String name;

    public AlienMan(String name) {
        this.name = name;
    }

    public AlienMan() {
        this("without name");
    }

    @Override
    public String toString() {
        return name;
    }

    public void sitOn(Object thing) {
        System.out.printf("Alien man %s sat on %s.\n", name, thing);
    }

    public void putHand(Object thing) {
        System.out.printf("Alien man %s put his hand on %s.\n", name, thing);
    }

    public void putLeg(Object thing) {
        System.out.printf("Alien man %s put his leg on %s.\n", name, thing);
    }

    public void addLeftHeadFeelings(Feeling feeling) {
        System.out.printf("Alien man %s expressed %s feeling on his left head.\n", name, feeling);
        leftHeadFeelings.add(feeling);
    }

    public void addRightHeadFeeling(Feeling feeling) {
        System.out.printf("Alien man %s expressed %s feeling on his right head.\n", name, feeling);
        rightHeadFeelings.add(feeling);
    }

    public boolean hasFeeling(Feeling feeling) {
        return leftHeadFeelings.contains(feeling) || rightHeadFeelings.contains(feeling);
    }
}
