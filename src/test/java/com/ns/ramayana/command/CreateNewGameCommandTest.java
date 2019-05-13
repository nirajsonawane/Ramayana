package com.ns.ramayana.command;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.factory.BattleFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreateNewGameCommandTest extends BaseTest{

    @ParameterizedTest
    @ValueSource(strings = { "Niraj", "" })
    void shouldCreateGameWithDefaultVaues(String name) {
        Player player = new Player(name);
        CreateNewGameCommand createNewGameCommand= new CreateNewGameCommand(player);
        assertNotNull(createNewGameCommand.get());
        assertNotNull(createNewGameCommand.get().getGameId());
        assertNotNull(createNewGameCommand.get().getPlayer());
        assertTrue(createNewGameCommand.get().getPlayer().getName().equals(name));
        assertNotNull(createNewGameCommand.get().getCurrentBattle());
        assertTrue(createNewGameCommand.get().getCurrentBattle().equals(BattleFactory.getBattleWithKumbhakarna()));

    }

}
