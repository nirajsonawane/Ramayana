package com.ns.ramayana;

import com.ns.ramayana.view.WelcomeView;

import java.util.function.Function;

public class WelcomeStep implements Function<Void,Void> {
    @Override
    public Void apply(Void aVoid) {
        WelcomeView welcomeView= new WelcomeView();
        return welcomeView.show();
    }
}
