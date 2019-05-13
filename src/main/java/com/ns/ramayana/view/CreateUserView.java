package com.ns.ramayana.view;

import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.domain.game.Player;

public class CreateUserView extends BaseView{

    private final CreatePlayerController createPlayerController;

    public CreateUserView(CreatePlayerController createPlayerController){
        this.createPlayerController=createPlayerController;
    }


    public  Player show() {
        super.printText("Please Enter User Name ");
        String name = super.readString();
        Player execute = createPlayerController.execute(name);
        return  execute;
    }
}
