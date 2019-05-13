package com.ns.ramayana.command;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.service.PersistentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveCommandTest extends BaseTest{


    @Test
    public void shouldSaveGameAndPrintMessageToConsol(){
        PersistentService persistentService = super.factory.getPersistentService("testDataFile.txt");
        SaveCommand saveCommand= new SaveCommand(super.factory.getBaseView(),persistentService);
        Player player = new Player("Niraj");
        Game game = new Game(player,123l);
        saveCommand.accept(game);
        String s = super.outContent.toString();
        String str = "Game Saved";
        assertEquals(str,s.trim());

    }
}