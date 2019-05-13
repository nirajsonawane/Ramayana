package com.ns.ramayana.factory;

import com.ns.ramayana.domain.battle.Weapon;

import java.util.Arrays;
import java.util.List;

public class WeaponFactory {
    private  WeaponFactory(){

    }

    public static List<Weapon> getRamaWepons(){
        return Arrays.asList(new Weapon("RamaWepon1",100),new Weapon("RamaWepon2",100));
    }
    public static List<Weapon> getRavanaWepons(){
        return Arrays.asList(new Weapon("RavanaWepon1",50),new Weapon("RavanaWepon2",60));
    }
    public static List<Weapon> getKumbhakarnaWepons(){
        return Arrays.asList(new Weapon("KumbhakarnaWepon1",50),new Weapon("KumbhakarnaWepon2",60));
    }


}
