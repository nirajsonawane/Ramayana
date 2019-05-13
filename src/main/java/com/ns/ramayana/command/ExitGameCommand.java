package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.view.BaseView;

public class ExitGameCommand implements UpdateGameCommand {

    private final BaseView baseView;

    public ExitGameCommand(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void accept(Game game) {
        baseView.printText("Thanks For Playing Game!");
        game.stopGame();

    }
}
