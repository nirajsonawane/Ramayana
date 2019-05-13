package com.ns.ramayana.domain.game;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
public class Player implements Serializable {

    private final PlayerExperience playerExperience;
    private final String name;

    public Player(String name) {
        this.name = name;
        this.playerExperience = new PlayerExperience();
    }

}
