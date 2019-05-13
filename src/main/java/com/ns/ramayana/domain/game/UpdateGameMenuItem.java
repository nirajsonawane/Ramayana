package com.ns.ramayana.domain.game;

import com.ns.ramayana.command.UpdateGameCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter

public class UpdateGameMenuItem {
    private MenuItem menuItem;
    private UpdateGameCommand consumer;

    @Override
    public String toString() {
        return menuItem.toString();
    }
}
