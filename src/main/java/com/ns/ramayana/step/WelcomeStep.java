package com.ns.ramayana.step;

import com.ns.ramayana.view.WelcomeView;

import java.util.function.Function;

/**
 * Responsible For Connecting All components Of Welcome Message
 */
public class WelcomeStep implements Function<String,Void> {
    @Override
    public Void apply(String  string) {
        WelcomeView welcomeView= new WelcomeView();
         welcomeView.show();
         return null;

    }
}
