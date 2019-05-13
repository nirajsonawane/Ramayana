package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.service.ConsoleService;

import java.util.Random;

public class CreateNewGameCommand implements CreateGameCommand {
    private long gameId = new Random().nextLong();
    private final ConsoleService consoleService;
    private Player player;


    public CreateNewGameCommand(Player player, ConsoleService consoleService){
        this.player=player;
        this.consoleService = consoleService;
    }
    @Override
    public Game get() {
        consoleService.printText("Game Created With Id " + gameId);
        return new Game(player,gameId);
    }


}
