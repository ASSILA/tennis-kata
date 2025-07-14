package tennis;

import com.bank.tennis.application.BallWonCommand;
import com.bank.tennis.application.TennisGameService;
import com.bank.tennis.domain.Player;
import com.bank.tennis.domain.ScoreView;
import com.bank.tennis.port.ScorePort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisKataTest {


    @Test
    void ABABAA_shouldMatch() {
        List<ScoreView> scoreViews = new ArrayList<>();
        ScorePort scoreCollector = scoreViews::add;
        TennisGameService service = new TennisGameService(scoreCollector);

        for (char c : "ABABAA".toCharArray()) {
            service.handle(new BallWonCommand(Player.fromChar(c)));
            if (service.isFinished()) break;
        }

        List<String> expected = List.of(
                "A : 15 / B : 0",
                "A : 15 / B : 15",
                "A : 30 / B : 15",
                "A : 30 / B : 30",
                "A : 40 / B : 30",
                "Player A wins the game"
        );

        assertEquals(expected,
                scoreViews.stream().map(ScoreView::text).toList());
    }
}
