package com.ns.ramayana.domain.battle;


import com.ns.ramayana.domain.characters.Character;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;


@EqualsAndHashCode
public class Battle implements Serializable {

    @Getter
    private final Integer level;
    private Character playerTeam;
    private Character computerTeam;

    @Getter
    private Integer minimumReputationNeededToPlay;

    private String battleDescription;

    @Getter
    private Integer battleId;

    public Battle(String battleDescription, Character playerTeam, Character computerTeam, Integer minimumReputationNeededToPlay, Integer battleId, Integer level) {
        this.playerTeam = playerTeam;
        this.computerTeam = computerTeam;
        this.minimumReputationNeededToPlay = minimumReputationNeededToPlay;
        this.battleDescription = battleDescription;
        this.battleId = battleId;
        this.level = level;
    }
    public Boolean fight() {
        while (playerTeam.isAlive() && computerTeam.isAlive()) {
            System.out.println("Attack by Ram");
            computerTeam.defendAttack(playerTeam.attack());
        }
        return computerTeam.isAlive();
    }

    @Override
    public String toString() {
        return "Battle[" +
                "level=" + level +
                ", battleDescription='" + battleDescription + '\'' +
                ", battleId=" + battleId +
                ']';
    }
}
