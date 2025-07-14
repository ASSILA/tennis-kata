package com.bank.tennis.application;

import com.bank.tennis.domain.ScoreView;
import com.bank.tennis.port.ScorePort;

public class TennisGameService {
    private final ScorePort output;

    public TennisGameService(ScorePort output) {
        this.output = output;
    }

    public void handle(BallWonCommand ballWonCommand) {
        // TODO
        output.display(new ScoreView(""));
    }

    public boolean isFinished() {
        return false;
    }
}
