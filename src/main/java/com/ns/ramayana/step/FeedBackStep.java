package com.ns.ramayana.step;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.FeedBackView;
import com.ns.ramayana.view.SummaryView;

import java.util.function.Function;


public class FeedBackStep implements Function<Void,Void> {

    private final BaseView baseView;

    public FeedBackStep(BaseView baseView){
        this.baseView=baseView;
    }


    @Override
    public Void apply(Void  doNothing) {
        FeedBackView feedBackView = new FeedBackView(baseView);
        feedBackView.show();
        return null;
    }
}
