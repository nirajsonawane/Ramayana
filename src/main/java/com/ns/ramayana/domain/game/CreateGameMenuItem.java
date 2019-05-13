package com.ns.ramayana.domain.game;

import com.ns.ramayana.command.CreateGameCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CreateGameMenuItem {
    private MenuItem menuItem;
    @ToString.Exclude
    private CreateGameCommand supplier;
}
