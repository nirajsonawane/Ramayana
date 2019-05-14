package com.ns.ramayana.view;

import com.ns.ramayana.domain.game.Game;

public class SummaryView {


    private final Game game;
    private final BaseView baseView;

    public SummaryView(Game game, BaseView baseView){
        this.game=game;
        this.baseView=baseView;
    }
    public void show() {
        baseView.printText("You Ended Game On Level " + game.getPlayer().getPlayerExperience().getLevel() + " With Reputation  Points " + game.getPlayer().getPlayerExperience().getReputation());

    }
}
