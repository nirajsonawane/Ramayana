package com.ns.ramayana.domain.battle;

import lombok.Getter;

@Getter

public enum BattlesEnum {

    BATTLE_WITH_RVANA("BATTLE WITH RAVANA",150,1,6),
    BATTLE_WITH_KUMBHAKARNA("BATTLE WITH KUMBHAKARNA", 10,2,1),
    BATTLE_WITH_KHAR("BATTLE WITH KHAR", 20,3,2),
    BATTLE_WITH_MEGHANAD("BATTLE WITH MEGHANAD", 30,4,3),
    BATTLE_WITH_AHIRAVANA("BATTLE WITH AHIRAVANA", 40,5,4),
    BATTLE_WITH_SURPANAKHA ("BATTLE WITH SURPANAKHA", 50,6,5);

    private String description;
    private Integer battleReputation;
    private  Integer battleId;
    private Integer levelId;

    BattlesEnum(String description, Integer battleReputation, Integer battleId,Integer level) {
        this.battleReputation = battleReputation;
        this.description = description;
        this.battleId=battleId;
        this.levelId=level;
    }

}
