package com.bank.tennis.adapter.console;

import com.bank.tennis.domain.ScoreView;
import com.bank.tennis.port.ScorePort;

public final class StdoutScore implements ScorePort {
    @Override
    public void display(ScoreView view) {
        System.out.println(view.text());
    }
}
