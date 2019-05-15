package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SummaryStepTest extends BaseTest{
    private BaseView baseView;
    @BeforeEach
    public void setup() {
        this.baseView = super.factory.getBaseView();
    }

    @Test
    public void shouldPrintFeedBackMessage(){
        SummaryStep summaryStep = new SummaryStep(baseView);
        Game game = new Game(new Player("Niraj"),123l);
        summaryStep.apply(game);
        String s = super.outContent.toString();
        baseView.printText("You Ended Game On Level " + game.getPlayer().getPlayerExperience().getLevel() + " With Reputation  Points " + game.getPlayer().getPlayerExperience().getReputation());
        assertTrue(s.contains("You Ended Game On Level"));
        assertTrue(s.contains("1"));
        assertTrue(s.contains("With Reputation  Points "));
        assertTrue(s.contains("10"));



    }

}