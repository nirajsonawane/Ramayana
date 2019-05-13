package com.ns.ramayana;

import com.ns.ramayana.factory.Factory;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.step.CreateGameStep;
import com.ns.ramayana.step.CreatePlayerStep;
import com.ns.ramayana.step.PlayGameStep;
import com.ns.ramayana.step.WelcomeStep;
import com.ns.ramayana.view.BaseView;
import lombok.extern.java.Log;

@Log
public class Ramayana {

    public static void main(String[] args) {

        Factory factory= new Factory();
        BaseView baseView = factory.getBaseView();
        PersistentService persistentService = factory.getPersistentService();
        WelcomeStep welcomeStep = factory.getWelcomeStep();
        CreatePlayerStep createPlayerStep = factory.getCreatePlayerStep();
        CreateGameStep createGameStep =factory.getCreateGameStep();
        PlayGameStep playGameStep =factory.getPlayGameStep();

        welcomeStep
                .andThen(createPlayerStep)
                .andThen(createGameStep)
                .andThen(playGameStep)
                .apply(null);


    }
}
