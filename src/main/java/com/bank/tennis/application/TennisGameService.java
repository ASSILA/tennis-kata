package com.bank.tennis.application;

import com.bank.tennis.domain.Player;
import com.bank.tennis.domain.Score;
import com.bank.tennis.domain.ScoreView;
import com.bank.tennis.port.ScorePort;

public final class TennisGameService {
    private final ScorePort output;

    private Score scoreA = Score.ZERO;
    private Score scoreB = Score.ZERO;
    private boolean finished = false;

    public TennisGameService(ScorePort output) {
        this.output = output;
    }

    public void handle(BallWonCommand ballWonCommand) {
        // ALREADY FINISHED
        if (finished) return;

        // INCREMENT SCORE FOR WINNER
        if (ballWonCommand.winner() == Player.A) {
            scoreA = scoreA.plusOne();
        } else {
            scoreB = scoreB.plusOne();
        }

        // CHECK VICTORY
        if ((scoreA.getValue() >= 4 || scoreB.getValue() >= 4) && Math.abs(scoreA.getValue() - scoreB.getValue()) >= 2) {
            finished = true;
            output.display(new ScoreView("Player " + ballWonCommand.winner() + " wins the game"));
            return;
        }

        // DEUCE / ADVANTAGE
        if (scoreA.getValue() >= 3 && scoreB.getValue() >= 3) {
            if (scoreA.getValue() == scoreB.getValue()) {
                output.display(new ScoreView("Deuce"));
            } else {
                Player adv = (scoreA.getValue() > scoreB.getValue()) ? Player.A : Player.B;
                output.display(new ScoreView("Advantage Player " + adv.label()));
            }
            return;
        }

        // ELSE DISPLAY CURRENT SCORE
        output.display(new ScoreView(
                "A : " + scoreA.getLabel() + " / B : " + scoreB.getLabel()
        ));
    }

    public boolean isFinished() {
        return finished;
    }

}
