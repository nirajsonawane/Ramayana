package com.ns.ramayana.controller;

import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.exception.GameException;

public class MainMenuController  implements Controller<Integer,Game>  {

    private final CreateGameMenu menu;

    public MainMenuController(CreateGameMenu menu){
        this.menu=menu;
    }

    @Override
    public Game execute(Integer option){
        Game game = (Game) menu
                .getMenuOptions()
                .stream()
                .filter(it -> it.getMenuItem().getShotCut() == option)
                .findFirst()
                .orElseThrow(() -> new GameException("Invalid Option"))
                .getSupplier()
                .get();
        return game;
    }

}
