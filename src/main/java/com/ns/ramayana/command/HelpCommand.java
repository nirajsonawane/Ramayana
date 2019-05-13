package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.view.BaseView;

public class HelpCommand implements UpdateGameCommand {

    private final BaseView baseView;

    public HelpCommand(BaseView baseView){
        this.baseView=baseView;
    }

    @Override
    public void accept(Game game) {
        baseView.printHelp();

    }
}
