package com.ns.ramayana.step;

import com.ns.ramayana.view.WelcomeView;

import java.util.function.Function;

public class WelcomeStep implements Function<String,Void> {
    @Override
    public Void apply(String  string) {
        WelcomeView welcomeView= new WelcomeView();
         return null;

    }
}
