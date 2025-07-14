package com.bank.tennis.domain;

public enum Player {
    A, B;

    public static Player fromChar(char c) {
        return (c == 'A' || c == 'a') ? A : B;
    }
}
