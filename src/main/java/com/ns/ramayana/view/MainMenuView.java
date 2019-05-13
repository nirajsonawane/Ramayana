package com.ns.ramayana.view;

import com.ns.ramayana.controller.MainMenuController;
import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;

public class MainMenuView {

    private final CreateGameMenu menu;
    private final MainMenuController mainMenuController;
    private final BaseView baseView;

    public MainMenuView(CreateGameMenu menu, MainMenuController mainMenuController,BaseView baseView){
        this.menu=menu;
        this.baseView=baseView;
        this.mainMenuController=mainMenuController;
    }


    public Game show() {
        baseView.print(menu);
        baseView.printText("Please Select ID Of Option!");
        int option = baseView.readInt();
        Game game = mainMenuController.execute(option);
        baseView.printText("Active Game ID " + game.getGameId());
        return game;
    }
}
