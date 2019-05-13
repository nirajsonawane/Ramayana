package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.service.PersistentService;

public class SaveCommand implements UpdateGameCommand {

    private final ConsoleService consoleService;
    private final PersistentService persistentService;

    public SaveCommand(ConsoleService consoleService, PersistentService persistentService) {
        this.consoleService = consoleService;
        this.persistentService = persistentService;
    }

    @Override
    public void accept(Game game) {
        persistentService.insertOrUpdateGame(game);
        consoleService.printText("Game Saved");
    }
}
