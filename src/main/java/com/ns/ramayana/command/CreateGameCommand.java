package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;

import java.util.function.Supplier;

/**
 * Supplier interface for Game
 */
public interface CreateGameCommand extends Supplier<Game> {
      Game get();
}
