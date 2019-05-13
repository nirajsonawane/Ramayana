package com.ns.ramayana.domain.characters;

import com.ns.ramayana.domain.battle.Weapon;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString()
@EqualsAndHashCode
public class Character implements Serializable {


    @EqualsAndHashCode.Exclude
    private Random rand = new Random();
    private String name;

    private List<Weapon> weapons = new ArrayList<>();

    public Character(String name, List<Weapon> weapons) {
        this.name = name;
        this.weapons = weapons
                .stream()
                .sorted(Comparator.comparingInt(Weapon::getWeaponStrength))
                .collect(Collectors.toList());
    }

    public Boolean isAlive(){
        int sum = weapons
                .stream()
                .mapToInt(Weapon::getWeaponStrength)
                .sum();
        return sum>0;
    }

    public Weapon attack() {
        return this.fireWeapon();
    }

    public void defendAttack(Weapon weapon){
        Optional<Weapon> mostEfficientDefendingWeapon = getMostEfficientDefendingWeapon(weapon);
        if (mostEfficientDefendingWeapon.isPresent()) {
            System.out.println("Can Defend Attack !!!!");
            this.weapons.remove(mostEfficientDefendingWeapon.get());
        }else {
            this.weapons.clear();
        }
    }
    private Optional<Weapon> getMostEfficientDefendingWeapon(Weapon weapon) {
        return this.weapons
                .stream()
                .filter(it -> it.getWeaponStrength() > weapon.getWeaponStrength())
                .findFirst();
    }
    private Weapon fireWeapon() {
        int randomIndex = rand.nextInt(this.weapons.size());
        Weapon weapon = this.weapons.get(randomIndex);
        System.out.println("Weapon Fired by " + this.name + " " + "Weapon Name" + weapon);
        this.weapons.remove(randomIndex);
        return weapon;
    }



}
