package com.bank;

import com.bank.tennis.adapter.console.StdoutScore;
import com.bank.tennis.application.BallWonCommand;
import com.bank.tennis.application.TennisGameService;
import com.bank.tennis.domain.Player;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.printf("Erreur : la séquence est obligatoire et ne doit contenir que les lettres A ou B.%n " +
                    "Exemple : java Main ABABAA%n");
            return;
        }

        var stdoutScore = new StdoutScore();
        var service   = new TennisGameService(stdoutScore);

        for (char c : args[0].toCharArray()) {
            service.handle(new BallWonCommand(Player.fromChar(c)));
            if (service.isFinished()) break;
        }
    }
}