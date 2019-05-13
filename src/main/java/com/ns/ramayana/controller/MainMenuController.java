package com.ns.ramayana.controller;

import com.ns.ramayana.domain.game.CreateGameMenu;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.exception.GameException;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.MainMenuView;

public class MainMenuController  {

    public Game execute(int option,CreateGameMenu menu){
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
