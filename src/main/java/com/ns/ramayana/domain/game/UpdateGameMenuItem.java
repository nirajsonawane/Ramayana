package com.ns.ramayana.domain.game;

import com.ns.ramayana.command.UpdateGameCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class UpdateGameMenuItem {
    private MenuItem menuItem;
    @ToString.Exclude
    private UpdateGameCommand consumer;
}
