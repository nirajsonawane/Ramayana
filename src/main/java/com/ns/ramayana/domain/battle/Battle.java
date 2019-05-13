package com.ns.ramayana.domain.battle;


import com.ns.ramayana.domain.characters.Character;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class Battle implements Serializable {

    @Getter
    private final Integer level;
    @ToString.Exclude
    private Character playerTeam;
    @ToString.Exclude
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
}
