package com.ns.ramayana.factory;

import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.step.*;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.CreateUserView;

import java.util.Optional;

public class Factory {

    private CreatePlayerStep createPlayerStep;
    private CreateGameStep createGameStep;
    private BaseView baseView;
    private PersistentService persistentService;
    private PlayGameStep playGameStep;
    private WelcomeStep welcomeStep;
    private HowToPlayStep howToPlayStep;
    private SummaryStep summaryStep;
    private FeedBackStep feedBackStep;
    private final String fileName="gameDataFile.txt";

    public FeedBackStep getFeedBackStep(){
        return Optional.ofNullable(feedBackStep).orElse(createFeedBackStep());
    }

    private FeedBackStep createFeedBackStep() {
        this.feedBackStep=new FeedBackStep(getBaseView());
        return feedBackStep;
    }

    public SummaryStep getSummaryStep(){
        return Optional.ofNullable(summaryStep).orElse(CreateSummaryStep());
    }

    private SummaryStep CreateSummaryStep() {
        this.summaryStep=new SummaryStep(getBaseView());
        return this.summaryStep;
    }

    public HowToPlayStep getHowToPlayStep(){
        return Optional.ofNullable(howToPlayStep).orElse(createHowToPlayStep());
    }

    private HowToPlayStep createHowToPlayStep() {
        this.howToPlayStep=new HowToPlayStep(getBaseView());
        return this.howToPlayStep;

    }

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
        this.playGameStep=new PlayGameStep(getBaseView(), getPersistentService(fileName));
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
        this.createGameStep=new CreateGameStep(getBaseView(), getPersistentService(fileName));
        return this.createGameStep;
    }

    private CreatePlayerStep createPlayerStep() {
        CreatePlayerController createPlayerController = new CreatePlayerController();
        CreateUserView createUserView = new CreateUserView(createPlayerController,getBaseView());
        this.createPlayerStep=new CreatePlayerStep(createUserView);
        return this.createPlayerStep;
    }
}

