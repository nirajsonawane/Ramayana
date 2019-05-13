package com.ns.ramayana.command;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.exception.GameException;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LoadGameCommandTest extends BaseTest {


    @ParameterizedTest
    @MethodSource("createTestInput")
    public void shouldLoadGameFromFileWithAllDetails(long gameId,String playerName,int playerLevel,int reputation,String battleDescription,int battleId) {

        BaseView baseView = super.factory.getBaseView();
        baseView.mockInput(new ByteArrayInputStream(String.valueOf(gameId).getBytes()));
        PersistentService persistentService = super.factory.getPersistentService("testDataFile.txt");
        LoadGameCommand loadGameCommand = new LoadGameCommand(persistentService, baseView);
        Game game = loadGameCommand.get();
        assertNotNull(game);
        assertNotNull(game.getGameId());
        assertNotNull(game.getPlayer());
        assertNotNull(game.getCurrentBattle());
        assertTrue(game.getGameId().equals(gameId));
        assertEquals(game.getPlayer().getName(),playerName);
        assertEquals(game.getPlayer().getPlayerExperience().getLevel(),playerLevel);
        assertEquals(game.getPlayer().getPlayerExperience().getReputation(),reputation);
        assertEquals(game.getCurrentBattle().getBattleId(),battleId);
    }

    private static Stream<Arguments> createTestInput() {
        return Stream.of(Arguments.of(6228, "Niraj",6,110,"BATTLE WITH KUMBHAKARNA",2),
                Arguments.of(8516, "Test",5,60,"BATTLE WITH KUMBHAKARNA",2));
    }

    @Test
    public void shouldGetExceptionForWrongGameId(){
        BaseView baseView = super.factory.getBaseView();
        baseView.mockInput(new ByteArrayInputStream(String.valueOf(12345).getBytes()));
        PersistentService persistentService = super.factory.getPersistentService("testDataFile.txt");
        LoadGameCommand loadGameCommand = new LoadGameCommand(persistentService, baseView);
        Exception exception = assertThrows(GameException.class, () -> loadGameCommand.get());
        assertEquals("Game Not Found", exception.getMessage());

    }


}