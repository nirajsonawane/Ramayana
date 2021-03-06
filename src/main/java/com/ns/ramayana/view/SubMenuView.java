package com.ns.ramayana.view;

import com.ns.ramayana.controller.SubMenuController;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;

/**
 * Responsible For  Displaying View for Sub Menu User
 */
public class SubMenuView {

    private final Game game;
    private final SubMenuController subMenuController;
    private final UpdateGameMenu updateGameMenu;
    private final BaseView baseView;

    public SubMenuView(Game game, SubMenuController subMenuController, UpdateGameMenu updateGameMenu,BaseView baseView){

        this.game=game;
        this.subMenuController=subMenuController;
        this.updateGameMenu=updateGameMenu;
        this.baseView=baseView;
    }


    public void show() {
        while (game.isGameActive()){
            baseView.print(updateGameMenu);
            baseView.printText("Please Select ID Of Option!");
            subMenuController.execute(baseView.readInt());
        }
    }
}
