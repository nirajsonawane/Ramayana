package com.ns.ramayana.controller;

import com.ns.ramayana.domain.game.Player;

/**
 * Responsible For processing information received from  CreatePlayerView
 */
public class CreatePlayerController implements Controller<String,Player> {

    @Override
    public Player execute(String name){
            return new Player(name);
    }
}
