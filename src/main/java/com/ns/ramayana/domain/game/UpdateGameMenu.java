package com.ns.ramayana.domain.game;

import com.ns.ramayana.command.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateGameMenu {

    private List<UpdateGameMenuItem> menuOptions = new ArrayList<>();

    public UpdateGameMenu(StartBattleCommand startBattleCommand, SelectBattleCommand selectBattleCommand, ExitGameCommand exit, HelpCommand help, ProfileCommand profileCommand, SaveCommand saveCommand){

        addMenuOption(  new UpdateGameMenuItem(new MenuItem(1,"Start Battle"), startBattleCommand));
        addMenuOption( new UpdateGameMenuItem(new MenuItem(2,"Select Battle"), selectBattleCommand));
        addMenuOption( new UpdateGameMenuItem(new MenuItem(3,"Profile "), profileCommand));
        addMenuOption( new UpdateGameMenuItem(new MenuItem(4,"Save "), saveCommand));
        addMenuOption( new UpdateGameMenuItem(new MenuItem(5,"Help "),help));
        addMenuOption( new UpdateGameMenuItem(new MenuItem(6,"Exit"),exit));


    }
    private void addMenuOption(UpdateGameMenuItem menuOption){
        this.menuOptions.add(menuOption);
    }
    public List<UpdateGameMenuItem> getMenuOptions(){
        return menuOptions.stream().collect(Collectors.toList());
    }
}
