package com.ns.ramayana.view;

import com.ns.ramayana.controller.SubMenuController;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;

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
        while (true){
            baseView.print(updateGameMenu);
            baseView.printText("Please Select ID Of Option!");
            int subMenuselectedOption = baseView.readInt();
            subMenuController.execute(subMenuselectedOption);

        }
    }
}
