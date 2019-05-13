package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;

public interface UpdateGameCommand {
    void accept(Game game);
}
