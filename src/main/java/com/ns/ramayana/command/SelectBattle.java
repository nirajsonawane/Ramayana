package com.ns.ramayana.command;

import com.ns.ramayana.domain.battle.Battle;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.factory.BattleFactory;
import com.ns.ramayana.view.BaseView;

import java.util.List;


public class SelectBattle implements UpdateGameCommand {

    private final BaseView baseView;

    public SelectBattle(BaseView baseView){
        this.baseView=baseView;
    }

    @Override
    public void accept(Game game) {

        Integer experience = game.getPlayer().getPlayerExperience().getLevel();
        List<Battle> allBattles = BattleFactory.getAllBattles(experience);
        baseView.printBattles(allBattles);
        baseView.printText("Please Select Battle ID :");
        int option = baseView.readInt();
        Battle battleById = BattleFactory.getBattleById(option);
        game.setCurrentBattle(battleById);


    }
}
