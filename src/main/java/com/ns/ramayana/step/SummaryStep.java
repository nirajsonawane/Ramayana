package com.ns.ramayana.step;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.HowToPlayView;
import com.ns.ramayana.view.SummaryView;

import java.util.function.Function;


public class SummaryStep implements Function<Game,Void> {

    private final BaseView baseView;

    public SummaryStep(BaseView baseView){
        this.baseView=baseView;
    }
    @Override
    public Void apply(Game  game) {
        SummaryView summaryView = new SummaryView(game,baseView);
        summaryView.show();
        return null;
    }
}
