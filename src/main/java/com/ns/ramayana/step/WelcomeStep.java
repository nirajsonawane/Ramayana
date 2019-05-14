package com.ns.ramayana.step;

import com.ns.ramayana.view.WelcomeView;

import java.util.function.Function;

/**
 * Responsible For Connecting All components Of Welcome Message
 */
public class WelcomeStep implements Function<Void,Void> {
    @Override
    public Void apply(Void  v) {
        WelcomeView welcomeView= new WelcomeView();
         welcomeView.show();
         return null;

    }
}
