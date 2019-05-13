package com.ns.ramayana.view;

import com.ns.ramayana.domain.game.Player;

public class WelcomeView extends BaseView<Void> {
    @Override
    public Void show() {
        super.printText("Welcome To Command Line Ramayana!!");
        return null;
    }
}
