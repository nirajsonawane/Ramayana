package com.ns.ramayana.command;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.PlayerGameId;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;

import java.util.List;

public class LoadGameCommand implements CreateGameCommand {

    private final PersistentService persistentService;
    private final BaseView baseView;

    public LoadGameCommand(PersistentService persistentService, BaseView baseView) {
        this.persistentService = persistentService;
        this.baseView = baseView;
    }

    @Override
    public Game get() {

        List<PlayerGameId> allPlayerGameId = persistentService.getAllPlayerGameId();
        if(allPlayerGameId.isEmpty()){
            baseView.printText("Games Not Available");
            return null;
        }else {
            baseView.printPlayerGameId(allPlayerGameId);
            baseView.printText("Select Game ID To Load");
            Long gameId = baseView.readLong();
            System.out.println("Loading Game for id " + gameId);
            Game gameById = persistentService.getGameById(gameId);
            baseView.printText("Game Loaded Below are Game Details ");
            baseView.printGame(gameById);
            return gameById;
        }



    }


}
