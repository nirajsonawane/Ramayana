package com.ns.ramayana.step;

import com.ns.ramayana.command.*;
import com.ns.ramayana.controller.SubMenuController;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.SubMenuView;

import java.util.function.Function;

public class PlayGameStep implements Function<Game,Game> {

    private final BaseView baseView;
    private final PersistentService persistentService;

    public PlayGameStep(BaseView baseView, PersistentService persistentService){
        this.baseView=baseView;
        this.persistentService=persistentService;
    }

    @Override
    public Game apply(Game game) {
        StartBattleCommand startBattleCommand =new StartBattleCommand();
        SelectBattle selectBattle = new SelectBattle(baseView);
        HelpCommand help = new HelpCommand(baseView);
        ExitGameCommand exit = new ExitGameCommand(baseView);
        SaveCommand saveCommand = new SaveCommand(baseView,persistentService);
        ProfileCommand profileCommand = new ProfileCommand(baseView);
        UpdateGameMenu updateGameMenu = new UpdateGameMenu(startBattleCommand,selectBattle,exit,help, profileCommand, saveCommand);

        SubMenuController subMenuController =new SubMenuController(game,updateGameMenu);
        SubMenuView subMenuView=new SubMenuView(game,subMenuController,updateGameMenu);
        subMenuView.show();
        return game;

    }
}
