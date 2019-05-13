package com.ns.ramayana.domain.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
public class PlayerGameId {
    private String playerName;
    private Long gameId;

    @Override
    public String toString() {
        return
                "GameId= " + gameId + " PlayerName= " + playerName  ;
    }
}
