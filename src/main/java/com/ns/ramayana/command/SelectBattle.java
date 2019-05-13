package com.ns.ramayana.command;

import com.ns.ramayana.service.ConsoleService;
import com.ns.ramayana.domain.battle.Battle;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.factory.BattleFactory;

import java.util.List;


public class SelectBattle implements UpdateGameCommand {

    private final ConsoleService consoleService;

    public SelectBattle(ConsoleService consoleService){
        this.consoleService=consoleService;
    }

    @Override
    public void accept(Game game) {

        Integer experience = game.getPlayer().getPlayerExperience().getLevel();
        List<Battle> allBattles = BattleFactory.getAllBattles(experience);
        consoleService.printBattles(allBattles);
        consoleService.printText("Select Option ");
        int option = consoleService.readInt();
        Battle battleById = BattleFactory.getBattleById(option);
        game.setCurrentBattle(battleById);


    }
}
