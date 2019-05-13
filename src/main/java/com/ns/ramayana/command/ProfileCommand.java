package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.view.BaseView;

public class ProfileCommand implements UpdateGameCommand {

    private final BaseView baseView;

    public ProfileCommand(BaseView baseView){
        this.baseView=baseView;
    }

    @Override
    public void accept(Game game) {
        baseView.print(game.getPlayer());
    }
}
