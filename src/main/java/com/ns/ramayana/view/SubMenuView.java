package com.ns.ramayana.view;

import com.ns.ramayana.controller.SubMenuController;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;
import com.ns.ramayana.exception.GameException;

public class SubMenuView extends  BaseView<Void>  {

    private final Game game;
    private final SubMenuController subMenuController;
    private final UpdateGameMenu updateGameMenu;

    public SubMenuView(Game game, SubMenuController subMenuController, UpdateGameMenu updateGameMenu){
        this.game=game;
        this.subMenuController=subMenuController;
        this.updateGameMenu=updateGameMenu;
    }

    @Override
    public Void show() {
        while (true){
            super.print(updateGameMenu);
            int subMenuselectedOption = super.readInt();
            subMenuController.execute(game,updateGameMenu,subMenuselectedOption);
        }
    }
}
