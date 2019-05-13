package com.ns.ramayana.domain.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MenuItem {
    private Integer shotCut;
    private String optionDescription;
    @Override
    public String toString() {
        return  "[ " + shotCut + " ] - [ " + optionDescription + " ]" ;
    }
}
