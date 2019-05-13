package com.ns.ramayana.view;

import com.ns.ramayana.controller.MainMenuController;
import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;

public class MainMenuView extends BaseView<Game> {

    private final CreateGameMenu menu;
    private final MainMenuController mainMenuController;

    public MainMenuView(CreateGameMenu menu, MainMenuController mainMenuController){
        this.menu=menu;
        this.mainMenuController=mainMenuController;
    }

    @Override
    public Game show() {
        super.print(menu);
        super.printText("Please Select ID Of Option!");
        int option = super.readInt();
        Game game = mainMenuController.execute(option);
        super.printText("Active Game ID " + game.getGameId());
        return game;
    }
}
