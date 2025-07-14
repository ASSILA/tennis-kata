package com.bank.tennis.application;

import com.bank.tennis.domain.Player;
import com.bank.tennis.domain.ScoreView;
import com.bank.tennis.port.ScorePort;

public final class TennisGameService {
    private final ScorePort output;

    private int scoreA = 0;
    private int scoreB = 0;
    private boolean finished = false;

    public TennisGameService(ScorePort output) {
        this.output = output;
    }

    public void handle(BallWonCommand ballWonCommand) {
        // ALREADY FINISHED
        if (finished) return;

        // INCREMENT SCORE FOR WINNER
        if (ballWonCommand.winner() == Player.A) scoreA++; else scoreB++;

        // CHECK VICTORY
        if ((scoreA >= 4 || scoreB >= 4) && Math.abs(scoreA - scoreB) >= 2) {
            finished = true;
            output.display(new ScoreView("Player " + ballWonCommand.winner() + " wins the game"));
            return;
        }

        // DEUCE / ADVANTAGE
        if (scoreA >= 3 && scoreB >= 3) {
            if (scoreA == scoreB) {
                output.display(new ScoreView("Deuce"));
            } else {
                Player adv = (scoreA > scoreB) ? Player.A : Player.B;
                output.display(new ScoreView("Advantage Player " + adv.label()));
            }
            return;
        }

        // ELSE DISPLAY CURRENT SCORE
        output.display(new ScoreView(
                "A : " + label(scoreA) + " / B : " + label(scoreB)
        ));
    }

    public boolean isFinished() {
        return finished;
    }

    private static String label(int raw) {
        return switch (raw) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            default -> "40";
        };
    }
}
