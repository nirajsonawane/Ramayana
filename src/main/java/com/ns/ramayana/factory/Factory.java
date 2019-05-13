package com.ns.ramayana.factory;

import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.step.CreateGameStep;
import com.ns.ramayana.step.CreatePlayerStep;
import com.ns.ramayana.step.PlayGameStep;
import com.ns.ramayana.step.WelcomeStep;
import com.ns.ramayana.view.CreateUserView;

import java.util.Optional;

public class Factory {

    private CreatePlayerStep createPlayerStep;
    private CreateGameStep createGameStep;
    private ConsoleService consoleService;
    private PersistentService persistentService;
    private  PlayGameStep playGameStep;
    private WelcomeStep welcomeStep;
    public WelcomeStep getWelcomeStep(){
        return Optional.ofNullable(welcomeStep).orElse(createWelcomeStep());
    }

    private WelcomeStep createWelcomeStep() {
        return new WelcomeStep();
    }

    public ConsoleService getConsoleService(){
        return Optional.ofNullable(consoleService).orElse(createConsoleService());
    }
    public PersistentService getPersistentService(){
        return Optional.ofNullable(persistentService).orElse(createPersistentService());
    }
    public PlayGameStep getPlayGameStep(){
        return Optional.ofNullable(playGameStep).orElse(createPlayGameStep());
    }

    private PlayGameStep createPlayGameStep() {
        this.playGameStep=new PlayGameStep(consoleService, persistentService);
        return this.playGameStep;
    }
    private ConsoleService createConsoleService() {
        this.consoleService=new ConsoleService();
        return this.consoleService;
    }
    private PersistentService createPersistentService() {
        this.persistentService=new PersistentService();
        return this.persistentService;
    }


    public CreatePlayerStep getCreatePlayerStep() {
        return Optional.ofNullable(createPlayerStep).orElse(createPlayerStep());
    }

    public CreateGameStep getCreateGameStep(){
        return Optional.ofNullable(createGameStep).orElse(createGameStep());
    }

    private CreateGameStep createGameStep() {
        this.createGameStep=new CreateGameStep(consoleService, persistentService);
        return this.createGameStep;
    }

    private CreatePlayerStep createPlayerStep() {
        CreatePlayerController createPlayerController = new CreatePlayerController();
        CreateUserView createUserView = new CreateUserView(createPlayerController);
        this.createPlayerStep=new CreatePlayerStep(createUserView);
        return this.createPlayerStep;
    }
}

