package com.ns.ramayana.step;

import com.ns.ramayana.view.HowToPlayView;
import com.ns.ramayana.view.WelcomeView;

import java.util.function.Function;



public class HowToPlayStep implements Function<Void,Void> {
    @Override
    public Void apply(Void  in) {
        HowToPlayView howToPlayView = new HowToPlayView();
        howToPlayView.show();
         return null;

    }
}
