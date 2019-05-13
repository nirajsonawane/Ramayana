package com.ns.ramayana.view;

import com.ns.ramayana.controller.SubMenuController;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;

public class SubMenuView extends  BaseView {

    private final Game game;
    private final SubMenuController subMenuController;
    private final UpdateGameMenu updateGameMenu;

    public SubMenuView(Game game, SubMenuController subMenuController, UpdateGameMenu updateGameMenu){
        this.game=game;
        this.subMenuController=subMenuController;
        this.updateGameMenu=updateGameMenu;
    }


    public void show() {
        while (true){
            super.print(updateGameMenu);
            super.printText("Please Select ID Of Option!");
            int subMenuselectedOption = super.readInt();
            subMenuController.execute(subMenuselectedOption);

        }
    }
}
