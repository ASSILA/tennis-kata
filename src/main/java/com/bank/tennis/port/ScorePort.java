package com.bank.tennis.port;

import com.bank.tennis.domain.ScoreView;
@FunctionalInterface
public interface ScorePort {
    void display(ScoreView view);
}
