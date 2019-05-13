package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;

/**
 * Responsible For Saving Game.
 */
public class SaveCommand implements UpdateGameCommand {

    private final BaseView baseView;
    private final PersistentService persistentService;

    public SaveCommand(BaseView baseView, PersistentService persistentService) {
        this.baseView = baseView;
        this.persistentService = persistentService;
    }

    @Override
    public void accept(Game game) {
        persistentService.insertOrUpdateGame(game);
        baseView.printText("Game Saved");
    }
}
