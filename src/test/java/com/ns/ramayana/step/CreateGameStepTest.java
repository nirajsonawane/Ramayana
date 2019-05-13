package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.exception.GameException;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.security.PrivateKey;

import static org.junit.jupiter.api.Assertions.*;

class CreateGameStepTest extends BaseTest {

    CreateGameStep createGameStep;
    private BaseView baseView;
    private PersistentService persistentService;
    private Player player;

    @BeforeEach
    public void setup() {
        baseView = super.factory.getBaseView();
        persistentService = super.factory.getPersistentService("testDataFile.txt");
        this.player = new Player("Niraj");
        this.createGameStep = new CreateGameStep(baseView, persistentService);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1"})
    public void shouldDisplayMainMenuAndPerfromSlectedAction_ShouldCreateNewGame(String input) {
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(input)
                .getBytes()));
        Game apply = createGameStep.apply(player);
        String s = super.outContent.toString();
        String str1 = "[ 1 ] - [ New Game ]";
        String str2 = "[ 2 ] - [ Load Previous Game ]";
        String str3 = "Please Select ID Of Option!";
        String str4 = "Active Game ID";
        assertTrue(s.contains(str1));
        assertTrue(s.contains(str2));
        assertTrue(s.contains(str3));
        assertTrue(s.contains(str4));
        assertNotNull(apply);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2\n7407"})
    public void shouldDisplayMainMenuAndPerfromSlectedAction_ShouldLoadOldGame(String input) {


        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(input)
                .getBytes()));

        Player player = new Player("Niraj");
        Game apply = createGameStep.apply(player);
        String s = super.outContent.toString();
        String str1 = "[ 1 ] - [ New Game ]";
        String str2 = "[ 2 ] - [ Load Previous Game ]";
        String str3 = "Please Select ID Of Option!";
        String str4 = "Active Game ID";
        assertTrue(s.contains(str1));
        assertTrue(s.contains(str2));
        assertTrue(s.contains(str3));
        assertTrue(s.contains(str4));
        assertTrue(s.contains("Active Game ID 7407"));
        assertNotNull(apply);
    }

    @ParameterizedTest
    @ValueSource(strings = {"99"})
    public void shouldDisplayMainMenuAndPerfromSlectedAction_InvalidInputSelected(String input) {

        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(input)
                .getBytes()));

        Exception exception = assertThrows(GameException.class, () -> createGameStep.apply(player));
        assertEquals("Invalid Option", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2\n740777"})
    public void shouldDisplayMainMenuAndPerfromSlectedAction_InvalidGameId(String input) {


        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(input)
                .getBytes()));


        Exception exception = assertThrows(GameException.class, () -> createGameStep.apply(player));
        assertEquals("Game Not Found", exception.getMessage());
    }

}