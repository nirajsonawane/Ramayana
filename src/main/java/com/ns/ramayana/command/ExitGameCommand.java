package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.service.ConsoleService;

public class ExitGameCommand implements UpdateGameCommand {

    private final ConsoleService consoleService;

    public ExitGameCommand(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void accept(Game game) {
        consoleService.printText("Thanks For Playing Game!");
        System.exit(0);

    }
}
