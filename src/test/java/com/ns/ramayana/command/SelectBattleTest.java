package com.ns.ramayana.command;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.service.PersistentService;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class SelectBattleTest extends BaseTest{

    @Test
    public void shouldPrintAllEligibleBattleAndSetSelectedBattleAsCurrentBattle(){
        BaseView baseView = super.factory.getBaseView();
        baseView.mockInput(new ByteArrayInputStream(String.valueOf(2).getBytes()));

        Player player = new Player("Niraj");
        player.getPlayerExperience().inCreaseLevel(100);
        Game game = new Game(player,123l);

        SelectBattleCommand selectBattleCommand = new SelectBattleCommand(baseView);
        selectBattleCommand.accept(game);
        String s = super.outContent.toString();
        String str1 = "Battle[level=6, battleDescription='BATTLE WITH RAVANA', battleId=1]";
        String str11 = "Battle[level=1, battleDescription='BATTLE WITH KUMBHAKARNA', battleId=2]";
        String str2 = "Battle[level=2, battleDescription='BATTLE WITH KHAR', battleId=3]";
        String str3 = "Battle[level=3, battleDescription='BATTLE WITH MEGHANAD', battleId=4]";
        String str4 = "Battle[level=4, battleDescription='BATTLE WITH AHIRAVANA', battleId=5]";
        String str5 = "Battle[level=5, battleDescription='BATTLE WITH SURPANAKHA', battleId=6]";
        String str6 = "Please Select Battle ID :";
        assertTrue(s.contains(str1));
        assertTrue(s.contains(str11));assertTrue(s.contains(str2));assertTrue(s.contains(str3));
        assertTrue(s.contains(str4));
        assertTrue(s.contains(str5));
        assertTrue(s.contains(str6));
        assertEquals(game.getCurrentBattle().getBattleId(),2);



    }
    @Test
    public void shouldPrintAnyBattle(){
        BaseView baseView = super.factory.getBaseView();
        baseView.mockInput(new ByteArrayInputStream(String.valueOf(2).getBytes()));

        Player player = new Player("Niraj");
        player.getPlayerExperience().inCreaseLevel(0);
        Game game = new Game(player,123l);

        SelectBattleCommand selectBattleCommand = new SelectBattleCommand(baseView);
        selectBattleCommand.accept(game);
        String s = super.outContent.toString();
        String str1 = "Battle[level=6, battleDescription='BATTLE WITH RAVANA', battleId=1]";
        String str11 = "Battle[level=1, battleDescription='BATTLE WITH KUMBHAKARNA', battleId=2]";
        String str2 = "Battle[level=2, battleDescription='BATTLE WITH KHAR', battleId=3]";
        String str3 = "Battle[level=3, battleDescription='BATTLE WITH MEGHANAD', battleId=4]";
        String str4 = "Battle[level=4, battleDescription='BATTLE WITH AHIRAVANA', battleId=5]";
        String str5 = "Battle[level=5, battleDescription='BATTLE WITH SURPANAKHA', battleId=6]";
        String str6 = "Please Select Battle ID :";
        assertFalse(s.contains(str1));
        assertFalse(s.contains(str11));
        assertFalse(s.contains(str2));
        assertFalse(s.contains(str3));
        assertFalse(s.contains(str4));
        assertFalse(s.contains(str5));





    }

}