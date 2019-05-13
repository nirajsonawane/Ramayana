package com.ns.ramayana.controller;

import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.exception.GameException;

/**
 * Responsible For Calling appropriate command based on selected option on Main Menu.
 * Main Menu Includes Creating New Game or Loading Game from File
 */
public class MainMenuController  implements Controller<Integer,Game>  {

    private final CreateGameMenu menu;

    public MainMenuController(CreateGameMenu menu){
        this.menu=menu;
    }

    @Override
    public Game execute(Integer option){
        return  menu
                .getMenuOptions()
                .stream()
                .filter(it -> it.getMenuItem().getShotCut() == option)
                .findFirst()
                .orElseThrow(() -> new GameException("Invalid Option"))
                .getSupplier()
                .get();

    }

}
