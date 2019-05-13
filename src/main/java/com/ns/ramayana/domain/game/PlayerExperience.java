package com.ns.ramayana.domain.game;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class PlayerExperience implements Serializable {
    private Integer level;
    private Integer reputation;
    public  PlayerExperience()    {
        this.reputation =10;
        this.level=1;
    }
    public void addReputationForWinningMatch(){
        reputation=reputation+10;
    }
    public void inCreaseLevel(int level){
        this.level=level;
    }
}
