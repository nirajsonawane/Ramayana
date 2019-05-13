package com.ns.ramayana.factory;

import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.step.CreateGameStep;
import com.ns.ramayana.step.CreatePlayerStep;
import com.ns.ramayana.step.PlayGameStep;
import com.ns.ramayana.step.WelcomeStep;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.CreateUserView;

import java.util.Optional;

public class Factory {

    private CreatePlayerStep createPlayerStep;
    private CreateGameStep createGameStep;
    private BaseView baseView;
    private PersistentService persistentService;
    private  PlayGameStep playGameStep;
    private WelcomeStep welcomeStep;
    public WelcomeStep getWelcomeStep(){
        return Optional.ofNullable(welcomeStep).orElse(createWelcomeStep());
    }

    private WelcomeStep createWelcomeStep() {
         this.welcomeStep=new WelcomeStep();
         return this.welcomeStep;
    }

    public BaseView getBaseView(){
        return Optional.ofNullable(baseView).orElse(createBaseView());
    }

    private BaseView createBaseView() {
        this.baseView=new BaseView();
        return  this.baseView;

    }

    public PersistentService getPersistentService(String fileName){
        return Optional.ofNullable(persistentService).orElse(createPersistentService(fileName));
    }
    public PlayGameStep getPlayGameStep(){
        return Optional.ofNullable(playGameStep).orElse(createPlayGameStep());
    }

    private PlayGameStep createPlayGameStep() {
        this.playGameStep=new PlayGameStep(baseView, persistentService);
        return this.playGameStep;
    }


    private PersistentService createPersistentService(String fileName) {
        this.persistentService=new PersistentService(fileName);
        return this.persistentService;
    }


    public CreatePlayerStep getCreatePlayerStep() {
        return Optional.ofNullable(createPlayerStep).orElse(createPlayerStep());
    }

    public CreateGameStep getCreateGameStep(){
        return Optional.ofNullable(createGameStep).orElse(createGameStep());
    }

    private CreateGameStep createGameStep() {
        this.createGameStep=new CreateGameStep(baseView, persistentService);
        return this.createGameStep;
    }

    private CreatePlayerStep createPlayerStep() {
        CreatePlayerController createPlayerController = new CreatePlayerController();
        CreateUserView createUserView = new CreateUserView(createPlayerController,baseView);
        this.createPlayerStep=new CreatePlayerStep(createUserView);
        return this.createPlayerStep;
    }
}

