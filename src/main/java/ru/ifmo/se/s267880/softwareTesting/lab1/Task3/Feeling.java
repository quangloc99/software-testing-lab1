package ru.ifmo.se.s267880.softwareTesting.lab1.Task3;

public enum Feeling {
    NERVOUS, ASTONISHED, JAW_DROPPED, FOCUSED, HAPPY;

    @Override
    public String toString() {
        return name().toLowerCase().replace('_', ' ');
    }
}
