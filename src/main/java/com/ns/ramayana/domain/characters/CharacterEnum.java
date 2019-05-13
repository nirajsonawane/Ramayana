package com.ns.ramayana.domain.characters;

import com.ns.ramayana.domain.battle.Weapon;
import com.ns.ramayana.factory.WeaponFactory;
import lombok.Getter;

import java.util.List;

@Getter
public enum CharacterEnum {

    RAMA("RAMA", WeaponFactory.getRamaWepons()),
    RAVANA("RAVANA",WeaponFactory.getRavanaWepons()),
    KUMBHAKARNA("KUMBHAKARNA",WeaponFactory.getKumbhakarnaWepons()),
    KHAR("KAHAR",WeaponFactory.getKumbhakarnaWepons()),
    MEGHANAD("MEGHANAD",WeaponFactory.getKumbhakarnaWepons()),
    AHIRAVANA("AHIRAVANA",WeaponFactory.getKumbhakarnaWepons()),
    SURPANAKHA("SURPANAKHA",WeaponFactory.getKumbhakarnaWepons());

    private String name;
    private List<Weapon> weapons;
    CharacterEnum(String name,List<Weapon> weapons){
        this.name = name;
        this.weapons=weapons;
    }
}
