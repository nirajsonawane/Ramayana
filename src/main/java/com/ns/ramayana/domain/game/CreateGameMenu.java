package com.ns.ramayana.domain.game;


import com.ns.ramayana.command.CreateGameCommand;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CreateGameMenu {

    private List<CreateGameMenuItem> menuOptions = new ArrayList<>();
    public CreateGameMenu(CreateGameCommand newGame, CreateGameCommand oldGameSupplier)    {
        addMenuOption(new CreateGameMenuItem(new MenuItem(1,"New Game"),newGame));
        addMenuOption(new CreateGameMenuItem(new MenuItem(2,"Load Previous Game"),oldGameSupplier));
    }
    private void addMenuOption(CreateGameMenuItem menuOption){
        this.menuOptions.add(menuOption);
    }
    public List<CreateGameMenuItem> getMenuOptions(){
        return menuOptions.stream().collect(Collectors.toList());
    }
}
