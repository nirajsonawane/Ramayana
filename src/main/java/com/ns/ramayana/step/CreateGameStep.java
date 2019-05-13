package com.ns.ramayana.step;

import com.ns.ramayana.command.CreateGameCommand;
import com.ns.ramayana.command.CreateNewGameCommand;
import com.ns.ramayana.command.LoadGameCommand;
import com.ns.ramayana.controller.MainMenuController;
import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.MainMenuView;

import java.util.function.Function;

public class CreateGameStep implements Function<Player ,Game>{

    private final ConsoleService consoleService;
    private final PersistentService persistentService;

    public CreateGameStep(ConsoleService consoleService, PersistentService persistentService){
        this.consoleService=consoleService;
        this.persistentService=persistentService;
    }
    @Override
    public Game apply(Player player) {
        CreateGameCommand newGame = new CreateNewGameCommand(player,consoleService);
        LoadGameCommand loadGame = new LoadGameCommand(persistentService,consoleService);
        CreateGameMenu mainMenu = new CreateGameMenu(newGame,loadGame);
        MainMenuController mainMenuController= new MainMenuController(mainMenu);
        MainMenuView mainMenuView = new MainMenuView(mainMenu,mainMenuController);
        return mainMenuView.show();
    }
}
