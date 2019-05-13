package com.ns.ramayana.command;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileCommandTest extends BaseTest{


    @Test
    public void shouldPrintUserProfile(){
        ProfileCommand profileCommand= new ProfileCommand(super.factory.getBaseView());
        Player player = new Player("Niraj");
        Game game = new Game(player,123l);
        profileCommand.accept(game);
        String s = super.outContent.toString();
        String str = "Player(playerExperience=PlayerExperience(level=1, reputation=10), name=Niraj)";
        assertEquals(str,s.trim());

    }
}