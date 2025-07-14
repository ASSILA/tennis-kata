package com.bank.tennis.domain;

/**
 * Tennis Score
 */
public final class Score {
    private static final String[] LABELS = {"0", "15", "30", "40"};
    public static final Score ZERO = Score.of(0);
    private final int value;

    private Score(int value) {
        this.value = value;
    }

    public static Score of(int value) {
        return new Score(value);
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return LABELS[value];
    }

    public Score plusOne() { return new Score(value + 1); }
}
