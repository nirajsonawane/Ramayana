package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.PlayerGameId;
import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.service.PersistentService;

import java.util.List;

public class LoadGameCommand implements CreateGameCommand {

    private final PersistentService persistentService;
    private final ConsoleService consoleService;

    public LoadGameCommand(PersistentService persistentService, ConsoleService consoleService) {
        this.persistentService = persistentService;
        this.consoleService = consoleService;
    }

    @Override
    public Game get() {

        List<PlayerGameId> allPlayerGameId = persistentService.getAllPlayerGameId();
        consoleService.printPlayerGameId(allPlayerGameId);
        consoleService.printText("Select Game ID To Load");
        Long gameId = consoleService.readLong();
        System.out.println("Loading Game for id " + gameId);
        Game gameById = persistentService.getGameById(gameId);
        consoleService.printText("Game Loaded Below are Game Details ");
        consoleService.printGame(gameById);
        return gameById;


    }


}
