package com.ns.ramayana;

import com.ns.ramayana.factory.Factory;
import com.ns.ramayana.step.*;
import lombok.extern.java.Log;

/**
 * Ramayana Class is Entry point for project. This class is Responsible For Creating Flow of a Game.
 */
public class Ramayana {

    public static void main(String[] args) {

        Factory factory = new Factory();
        WelcomeStep welcomeStep = factory.getWelcomeStep();
        Void doNothing =null;
        welcomeStep
                .andThen(factory.getHowToPlayStep())
                .andThen(factory.getCreatePlayerStep())
                .andThen(factory.getCreateGameStep())
                .andThen(factory.getPlayGameStep())
                .andThen(factory.getSummaryStep())
                .andThen(factory.getFeedBackStep())
                .apply(doNothing);


    }
}
