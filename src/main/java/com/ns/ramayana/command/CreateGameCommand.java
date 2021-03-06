package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;

/**
 * Supplier interface for Game
 */
@FunctionalInterface
public interface CreateGameCommand  {
      Game get();
}
