package com.ns.ramayana.command;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StartBattleCommandTest extends BaseTest{

    @Test
    public void shouldWonTheBattleShouldIncreaseLevel(){
        BaseView baseView = super.factory.getBaseView();
        baseView.mockInput(new ByteArrayInputStream(String.valueOf(2).getBytes()));
        Player player = new Player("Niraj");
        Game game = new Game(player,123l);
        StartBattleCommand startBattleCommand = new StartBattleCommand();
        startBattleCommand.accept(game);
        String s = super.outContent.toString();
        assertTrue(s.contains("Congratulations!! You Won the Match , Reputation Points will be added to profile!!"));
        assertEquals(game.getPlayer().getPlayerExperience().getLevel(),2);
        assertEquals(game.getPlayer().getPlayerExperience().getReputation(),20);
    }


}