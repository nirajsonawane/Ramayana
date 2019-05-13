package com.ns.ramayana.factory;

import com.ns.ramayana.domain.battle.Battle;
import com.ns.ramayana.domain.battle.BattlesEnum;
import com.ns.ramayana.domain.characters.CharacterEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

;

public class BattleFactory {
    private  BattleFactory(){

    }

    public static Battle getBattleWithRavana() {
        return new Battle(BattlesEnum.BATTLE_WITH_RVANA.getDescription(), CharacterFactory.getCharacter(CharacterEnum.RAMA), CharacterFactory.getCharacter(CharacterEnum.RAVANA), BattlesEnum.BATTLE_WITH_RVANA.getBattleReputation(), BattlesEnum.BATTLE_WITH_RVANA.getBattleId(), BattlesEnum.BATTLE_WITH_RVANA.getLevelId());
    }

    public static Battle getBattleWithKumbhakarna() {
        return new Battle(BattlesEnum.BATTLE_WITH_KUMBHAKARNA.getDescription(), CharacterFactory.getCharacter(CharacterEnum.RAMA), CharacterFactory.getCharacter(CharacterEnum.KUMBHAKARNA), BattlesEnum.BATTLE_WITH_KUMBHAKARNA.getBattleReputation(), BattlesEnum.BATTLE_WITH_KUMBHAKARNA.getBattleId(),BattlesEnum.BATTLE_WITH_KUMBHAKARNA.getLevelId());
    }


    public static Battle getBattleWithKhar() {
        return new Battle(BattlesEnum.BATTLE_WITH_KHAR.getDescription(), CharacterFactory.getCharacter(CharacterEnum.RAMA), CharacterFactory.getCharacter(CharacterEnum.KHAR), BattlesEnum.BATTLE_WITH_KHAR.getBattleReputation(), BattlesEnum.BATTLE_WITH_KHAR.getBattleId(),BattlesEnum.BATTLE_WITH_KHAR.getLevelId());
    }

    public static Battle getBattleWithMeghanad() {
        return new Battle(BattlesEnum.BATTLE_WITH_MEGHANAD.getDescription(), CharacterFactory.getCharacter(CharacterEnum.RAMA), CharacterFactory.getCharacter(CharacterEnum.MEGHANAD), BattlesEnum.BATTLE_WITH_MEGHANAD.getBattleReputation(), BattlesEnum.BATTLE_WITH_MEGHANAD.getBattleId(),BattlesEnum.BATTLE_WITH_MEGHANAD.getLevelId());
    }

    public static Battle getBattleWithAhiravana() {
        return new Battle(BattlesEnum.BATTLE_WITH_AHIRAVANA.getDescription(), CharacterFactory.getCharacter(CharacterEnum.RAMA), CharacterFactory.getCharacter(CharacterEnum.AHIRAVANA), BattlesEnum.BATTLE_WITH_AHIRAVANA.getBattleReputation(), BattlesEnum.BATTLE_WITH_AHIRAVANA.getBattleId(),BattlesEnum.BATTLE_WITH_AHIRAVANA.getLevelId());
    }

    public static Battle getBattleWithSurpanakha() {
        return new Battle(BattlesEnum.BATTLE_WITH_SURPANAKHA.getDescription(), CharacterFactory.getCharacter(CharacterEnum.RAMA), CharacterFactory.getCharacter(CharacterEnum.SURPANAKHA), BattlesEnum.BATTLE_WITH_SURPANAKHA.getBattleReputation(), BattlesEnum.BATTLE_WITH_SURPANAKHA.getBattleId(),BattlesEnum.BATTLE_WITH_SURPANAKHA.getLevelId());
    }

    public static List<Battle> getAllBattles() {
        List<Battle> list = new ArrayList<>();
        list.add(getBattleWithRavana());
        list.add(getBattleWithKumbhakarna());
        list.add(getBattleWithKhar());
        list.add(getBattleWithMeghanad());
        list.add(getBattleWithAhiravana());
        list.add(getBattleWithSurpanakha());
        return list;
    }

    public static List<Battle> getAllBattles(Integer level) {
        return getAllBattles()
                .stream()
                .filter(it -> it.getLevel() <= level)
                .collect(Collectors.toList());
    }


    public static Battle getBattleById(Integer id) {
        Predicate<Battle> battlePredicate = it -> it.getBattleId() == id;
        return getAllBattles()
                .stream()
                .filter(battlePredicate)
                .findFirst()
                .get();
    }


}
