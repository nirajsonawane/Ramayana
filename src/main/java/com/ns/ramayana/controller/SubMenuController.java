package com.ns.ramayana.controller;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;
import com.ns.ramayana.exception.GameException;

public class SubMenuController {

    public void execute(Game game, UpdateGameMenu updateGameMenu,int selectedOption){
        updateGameMenu
                .getMenuOptions()
                .stream()
                .filter(it -> it.getMenuItem().getShotCut() == selectedOption)
                .findFirst()
                .orElseThrow(() -> new GameException("Invalid Option"))
                .getConsumer()
                .accept(game);

    }
}
