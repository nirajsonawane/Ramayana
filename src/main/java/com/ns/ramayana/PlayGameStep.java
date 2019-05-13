package com.ns.ramayana;

import com.ns.ramayana.command.*;
import com.ns.ramayana.controller.SubMenuController;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;
import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.SubMenuView;

import java.util.function.Consumer;
import java.util.function.Function;

public class PlayGameStep implements Function<Game,Void> {

    private final ConsoleService consoleService;
    private final PersistentService persistentService;

    public PlayGameStep(ConsoleService consoleService, PersistentService persistentService){
        this.consoleService=consoleService;
        this.persistentService=persistentService;
    }

    @Override
    public Void apply(Game game) {
        StartBattleCommand startBattleCommand =new StartBattleCommand();
        SelectBattle selectBattle = new SelectBattle(consoleService);
        HelpCommand help = new HelpCommand(consoleService);
        ExitGameCommand exit = new ExitGameCommand(consoleService);
        SaveCommand saveCommand = new SaveCommand(consoleService,persistentService);
        ProfileCommand profileCommand = new ProfileCommand(consoleService);
        UpdateGameMenu updateGameMenu = new UpdateGameMenu(startBattleCommand,selectBattle,exit,help, profileCommand, saveCommand);

        SubMenuController subMenuController =new SubMenuController();
        SubMenuView subMenuView=new SubMenuView(game,subMenuController,updateGameMenu);
        subMenuView.show();
        return null;
    }
}
