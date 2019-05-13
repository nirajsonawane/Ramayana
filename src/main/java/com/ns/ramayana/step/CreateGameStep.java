package com.ns.ramayana.step;

import com.ns.ramayana.command.CreateGameCommand;
import com.ns.ramayana.command.CreateNewGameCommand;
import com.ns.ramayana.command.LoadGameCommand;
import com.ns.ramayana.controller.MainMenuController;
import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.MainMenuView;

import java.util.function.Function;

public class CreateGameStep implements Function<Player ,Game>{

    private BaseView baseView;
    private final PersistentService persistentService;


    public CreateGameStep(BaseView baseView, PersistentService persistentService){
        this.baseView=baseView;
        this.persistentService=persistentService;

    }
    @Override
    public Game apply(Player player) {
        CreateGameCommand newGame = new CreateNewGameCommand(player);
        LoadGameCommand loadGame = new LoadGameCommand(persistentService,baseView);
        CreateGameMenu mainMenu = new CreateGameMenu(newGame,loadGame);
        MainMenuController mainMenuController= new MainMenuController(mainMenu);
        MainMenuView mainMenuView = new MainMenuView(mainMenu,mainMenuController,baseView);
        return mainMenuView.show();
    }


}
