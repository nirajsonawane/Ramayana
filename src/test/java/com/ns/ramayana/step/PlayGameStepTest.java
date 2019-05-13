package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class PlayGameStepTest extends BaseTest {


    private BaseView baseView;
    private PersistentService persistentService;
    private Player player;

    //@Rule
    //public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    private Game game;

    @BeforeEach
    public void setup() {
        baseView = super.factory.getBaseView();
        persistentService = super.factory.getPersistentService("testDataFile.txt");
        this.player = new Player("Niraj");
        this.game= new Game(this.player,111l);

    }

    @Disabled
    @Test
    public void shouldDisplayGameMenuAndPerfromAction(){
      //  exit.expectSystemExitWithStatus(0);
       String str = "1\n2" ;
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(str)
                .getBytes()));
        PlayGameStep playGameStep = new PlayGameStep(baseView,persistentService);
        Game apply = playGameStep.apply(game);


    }

}