package com.ns.ramayana.controller;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatePlayerControllerTest extends BaseTest{

    @Test
    public void shouldCreatePlayer(){
        CreatePlayerController createPlayerController = new CreatePlayerController();
        Player player = createPlayerController.execute("Niraj");
        assertEquals("Niraj",player.getName());
        assertEquals(1,player.getPlayerExperience().getLevel());
        assertEquals(10,player.getPlayerExperience().getReputation());

    }

}