package com.ns.ramayana;

import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.step.CreateGameStep;
import com.ns.ramayana.step.CreatePlayerStep;
import com.ns.ramayana.step.PlayGameStep;
import com.ns.ramayana.step.WelcomeStep;
import com.ns.ramayana.view.CreateUserView;
import com.ns.ramayana.view.WelcomeView;
import lombok.extern.java.Log;

@Log
public class Ramayana {

    public static void main(String[] args) {

        ConsoleService consoleService = new ConsoleService();
        PersistentService persistentService = new PersistentService();
        WelcomeStep welcomeStep = new WelcomeStep();
        CreatePlayerStep createPlayerStep = new CreatePlayerStep();
        CreateGameStep createGameStep = new CreateGameStep(consoleService, persistentService);
        PlayGameStep playGameStep = new PlayGameStep(consoleService, persistentService);

        welcomeStep
                .andThen(createPlayerStep)
                .andThen(createGameStep)
                .andThen(playGameStep)
                .apply(null);


    }
}
