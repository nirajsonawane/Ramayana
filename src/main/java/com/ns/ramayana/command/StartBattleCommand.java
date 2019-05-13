package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;

public class StartBattleCommand implements UpdateGameCommand {

    @Override
    public void accept(Game game) {
        Boolean opponentStillExsits = game
                .getCurrentBattle()
                .fight();
        if(!opponentStillExsits){
            System.out.println("Congratulations!! You Won the Match , Reputation Points will be added to profile!! ");
            game.getPlayer().getPlayerExperience().addReputationForWinningMatch();
            game.getPlayer().getPlayerExperience().inCreaseLevel(game.getCurrentBattle().getLevel()+1);
        }
        game.resetCurrentBattle();

    }
}
