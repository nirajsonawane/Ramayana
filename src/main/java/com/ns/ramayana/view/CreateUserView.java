package com.ns.ramayana.view;

import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.domain.game.Player;

/**
 * Responsible For  Displaying View for Creating User
 */
public class CreateUserView {

    private final CreatePlayerController createPlayerController;
    private final BaseView baseView;

    public CreateUserView(CreatePlayerController createPlayerController,BaseView baseView){
        this.createPlayerController=createPlayerController;
        this.baseView=baseView;
    }


    public  Player show() {
        baseView.printText("Please Enter User Name ");
        String name = baseView.readString();
        return createPlayerController.execute(name);

    }
}
