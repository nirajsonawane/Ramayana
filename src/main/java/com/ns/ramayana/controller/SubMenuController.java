package com.ns.ramayana.controller;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.UpdateGameMenu;
import com.ns.ramayana.exception.GameException;

/**
 * /**
 * Responsible For Calling appropriate command based on selected option on Sub Menu.
 *
 */

public class SubMenuController implements Controller<Integer,Game>{

    private final Game game;
    private final UpdateGameMenu updateGameMenu;

    public SubMenuController(Game game, UpdateGameMenu updateGameMenu) {
        this.game=game;
        this.updateGameMenu=updateGameMenu;
    }

    @Override
    public Game execute(Integer selectedOption){
        updateGameMenu
                .getMenuOptions()
                .stream()
                .filter(it -> it.getMenuItem().getShotCut() == selectedOption)
                .findFirst()
                .orElseThrow(() -> new GameException("Invalid Option"))
                .getConsumer()
                .accept(game);
        return game;

    }
}
