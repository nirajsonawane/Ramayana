package com.ns.ramayana.command;

import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.domain.game.Game;

public class ProfileCommand implements UpdateGameCommand {

    private final ConsoleService consoleService;

    public ProfileCommand(ConsoleService consoleService){
        this.consoleService=consoleService;
    }

    @Override
    public void accept(Game game) {
        consoleService.print(game.getPlayer());
    }
}
