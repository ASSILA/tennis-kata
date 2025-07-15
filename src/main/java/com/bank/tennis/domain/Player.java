package com.bank.tennis.domain;

public enum Player {
    A("A"),
    B("B");

    private final String label;

    Player(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    public static Player fromChar(char c) {
        return switch (Character.toUpperCase(c)) {
            case 'A' -> A;
            case 'B' -> B;
            default  -> throw new IllegalArgumentException(
                    "Invalid rally winner '" + c + "' – must be A or B");
        };
    }
}
