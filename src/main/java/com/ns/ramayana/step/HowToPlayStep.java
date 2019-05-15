package com.ns.ramayana.step;

import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.HowToPlayView;
import com.ns.ramayana.view.WelcomeView;

import java.util.function.Function;



public class HowToPlayStep implements Function<Void,Void> {

    private final BaseView baseView;

    public HowToPlayStep(BaseView baseView){
        this.baseView=baseView;
    }
    @Override
    public Void apply(Void  in) {
        HowToPlayView howToPlayView = new HowToPlayView(baseView);
        howToPlayView.show();
         return null;

    }
}
