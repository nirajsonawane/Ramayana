package com.ns.ramayana.domain.game;

import com.ns.ramayana.domain.battle.Battle;
import com.ns.ramayana.factory.BattleFactory;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;


@ToString
@Getter
@EqualsAndHashCode
public class Game implements Serializable{

    @EqualsAndHashCode.Exclude
    private Player player;
    @EqualsAndHashCode.Exclude
    private Battle battle;

    private Long gameId;



    @Builder
    public Game(Player player,Long gameId) {
        this.player = player;
        this.gameId=gameId;

        setCurrentBattle(BattleFactory.getBattleWithKumbhakarna());

    }

    public Battle getCurrentBattle(){
        return this.battle;
    }
    public void setCurrentBattle(Battle battle){
        this.battle=battle;
    }
    public void resetCurrentBattle(){
        this.battle=BattleFactory.getBattleWithKumbhakarna();

    }




}
