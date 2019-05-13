package com.ns.ramayana.step;

import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.view.CreateUserView;

import java.util.function.Function;

public class CreatePlayerStep implements Function<Void, Player> {

    private final CreateUserView createUserView;

    public CreatePlayerStep(CreateUserView createUserView) {
        this.createUserView = createUserView;
    }

    @Override
    public Player apply(Void aVoid) {
        return createUserView.show();
    }
}
