package com.ns.ramayana.factory;


import com.ns.ramayana.domain.characters.Character;
import com.ns.ramayana.domain.characters.CharacterEnum;


/**
 * Responsible For Creating Characters of Game
 */
public class CharacterFactory {

    private CharacterFactory(){
    }
    public static Character getCharacter(CharacterEnum characterEnum){
        return new Character(characterEnum.getName(),characterEnum.getWeapons());
    }


}
