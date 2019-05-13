package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.util.RamayanaUtil;

/**
 *
 */
public class CreateNewGameCommand implements CreateGameCommand {

    private final Player player;


    public CreateNewGameCommand(Player player) {
        this.player = player;

    }

    @Override
    public Game get() {
        return new Game(player, RamayanaUtil.getRandomGameId());
    }


}
