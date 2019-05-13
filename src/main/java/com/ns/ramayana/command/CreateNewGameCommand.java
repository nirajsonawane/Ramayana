package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;

import java.util.Random;

/**
 *
 */
public class CreateNewGameCommand implements CreateGameCommand {
    private long gameId = new Random().nextLong();
    private final Player player;


    public CreateNewGameCommand(Player player){
        this.player=player;

    }
    @Override
    public Game get() {
        return new Game(player,gameId);
    }


}
