package com.ns.ramayana.domain.battle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
public class Weapon implements Serializable{

    private String weaponName;
    private Integer weaponStrength;

    public Weapon(String weaponName,Integer weaponStrength){
        this.weaponName=weaponName;
        this.weaponStrength=weaponStrength;
    }

}
