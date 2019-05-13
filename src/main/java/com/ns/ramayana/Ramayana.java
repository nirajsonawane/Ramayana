package com.ns.ramayana;

import com.ns.ramayana.command.*;
import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.controller.MainMenuController;
import com.ns.ramayana.controller.SubMenuController;
import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.domain.game.UpdateGameMenu;
import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.CreateUserView;
import com.ns.ramayana.view.MainMenuView;
import com.ns.ramayana.view.SubMenuView;
import com.ns.ramayana.view.WelcomeView;

public class Ramayana {

    public static void main(String[] args) {

        ConsoleService consoleService = new ConsoleService();
        PersistentService persistentService = new PersistentService();

        WelcomeView welcomeView= new WelcomeView();
       // welcomeView.show();


        CreatePlayerController createPlayerController= new CreatePlayerController();
        CreateUserView createUserView=new CreateUserView(createPlayerController);
        //Player player = createUserView.show();

        WelcomeStep welcomeStep = new WelcomeStep();
        CreatePlayerStep createPlayerStep= new CreatePlayerStep();
        CreateGameStep createGameStep = new CreateGameStep(consoleService,persistentService);
        PlayGameStep playGameStep=new PlayGameStep(consoleService,persistentService);



        welcomeStep
                .andThen(createPlayerStep)
                .andThen(createGameStep)
                .andThen(playGameStep)
                .apply(null);



        /*CreateGameCommand newGame = new CreateNewGameCommand(player,consoleService);
        LoadGameCommand loadGame = new LoadGameCommand(persistentService,consoleService);
        CreateGameMenu mainMenu = new CreateGameMenu(newGame,loadGame);
        MainMenuController mainMenuController= new MainMenuController();
        MainMenuView mainMenuView = new MainMenuView(mainMenu,mainMenuController);
        Game game = mainMenuView.show();*/


        /*StartBattleCommand startBattleCommand =new StartBattleCommand();
        SelectBattle selectBattle = new SelectBattle(consoleService);
        HelpCommand help = new HelpCommand(consoleService);
        ExitGameCommand exit = new ExitGameCommand(consoleService);
        SaveCommand saveCommand = new SaveCommand(consoleService,persistentService);
        ProfileCommand profileCommand = new ProfileCommand(consoleService);
        UpdateGameMenu updateGameMenu = new UpdateGameMenu(startBattleCommand,selectBattle,exit,help, profileCommand, saveCommand);

        SubMenuController subMenuController =new SubMenuController();
        SubMenuView subMenuView=new SubMenuView(game,subMenuController,updateGameMenu);
        subMenuView.show();
*/



    }
}
