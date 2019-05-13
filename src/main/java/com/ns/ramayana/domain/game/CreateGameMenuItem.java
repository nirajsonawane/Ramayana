package com.ns.ramayana.domain.game;

import com.ns.ramayana.command.CreateGameCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter

public class CreateGameMenuItem {
    private MenuItem menuItem;
    @ToString.Exclude
    private CreateGameCommand supplier;

    @Override
    public String toString() {
        return  menuItem.toString();
    }
}
