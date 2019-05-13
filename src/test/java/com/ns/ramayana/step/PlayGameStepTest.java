package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayGameStepTest extends BaseTest {


    private BaseView baseView;
    private PersistentService persistentService;
    private Player player;


    private Game game;

    @BeforeEach
    public void setup() {
        baseView = super.factory.getBaseView();
        persistentService = super.factory.getPersistentService("testDataFile.txt");
        this.player = new Player("Niraj");
        player.getPlayerExperience().inCreaseLevel(100);
        this.game= new Game(this.player,111l);

    }



    @ParameterizedTest
    @ValueSource(strings = {"1\n6","2\n2\n6","3\n6","4\n6","5\n6"})
    public void shouldDisplayMenuTwoTimes_AndPerformAction(String input){


        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(input)
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game apply = playGameStep.apply(game);
        String s = super.outContent.toString();
        assertEquals(2,getCount(s));
    }
    @ParameterizedTest
    @ValueSource(strings = {"1\n1\n1\n1\n1\n6",})
    public void loopTest(String input){


        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(input)
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game apply = playGameStep.apply(game);
        String s = super.outContent.toString();
        assertEquals(6,getCount(s));
    }

    @ParameterizedTest
    @MethodSource("selectBattles")
    public void shouldSelectCorrectBattle(String input,int id){


        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(input)
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game updatedGame = playGameStep.apply(game);
          assertEquals(id,updatedGame.getCurrentBattle().getBattleId());

    }
    private static Stream<Arguments> selectBattles() {
        return Stream.of(Arguments.of("2\n1\n6", 1),Arguments.of("2\n2\n6", 2),Arguments.of("2\n3\n6", 3),Arguments.of("2\n4\n6", 4),Arguments.of("2\n5\n6", 5),Arguments.of("2\n6\n6", 6));
    }

    @Test
    public void shouldPrintProfile(){


        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("3\n6")
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game updatedGame = playGameStep.apply(game);
        String profile = super.outContent.toString();
        assertTrue(profile.contains("Player(playerExperience=PlayerExperience(level=100, reputation=10), name=Niraj)"));
    }
    @Test
    public void shouldSaveGame(){


        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("4\n6")
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game updatedGame = playGameStep.apply(game);
        String profile = super.outContent.toString();
        assertTrue(profile.contains( "Game Saved"));
    }
    @Test
    public void shouldPrintHelp(){
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("5\n6")
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game updatedGame = playGameStep.apply(game);
        String profile = super.outContent.toString();
        assertTrue(profile.contains( "The Game is based On Ancient India epic Ramayana"));
    }
    @Test
    public void shouldPrintThanks(){
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("6\n")
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game updatedGame = playGameStep.apply(game);
        String profile = super.outContent.toString();
        assertTrue(profile.contains( "Thanks For Playing Game!"));
    }

    private int getCount(String str) {

        Pattern p = Pattern.compile("Please Select ID Of Option");
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()){
            count +=1;
        }
        return count;
    }

}