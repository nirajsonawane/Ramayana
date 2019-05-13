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
            updateExperience(game);

        }else {
            System.out.println("Sorry You Lost the Match");
        }

        game.resetCurrentBattle();

    }

    private void updateExperience(Game game) {
        game.getPlayer().getPlayerExperience().addReputationForWinningMatch();
        Integer level = game
                .getPlayer()
                .getPlayerExperience()
                .getLevel();
        if(level<=game.getCurrentBattle().getBattleId()){
            game.getPlayer().getPlayerExperience().inCreaseLevel(game.getCurrentBattle().getLevel()+1);
        }
    }
}
