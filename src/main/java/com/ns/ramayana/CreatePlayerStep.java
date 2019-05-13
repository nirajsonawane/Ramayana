package com.ns.ramayana;

import com.ns.ramayana.controller.CreatePlayerController;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.view.CreateUserView;

import java.util.function.Function;

public class CreatePlayerStep implements Function<Void,Player>{

    @Override
    public Player apply(Void aVoid) {
        CreatePlayerController createPlayerController= new CreatePlayerController();
        CreateUserView createUserView=new CreateUserView(createPlayerController);
        return  createUserView.show();
    }
}
