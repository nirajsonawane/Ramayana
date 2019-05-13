package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.domain.game.Player;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreatePlayerStepTest extends BaseTest{
    private BaseView baseView;
    private CreatePlayerStep createPlayerStep;
    @BeforeEach
    public void setup() {
        baseView = super.factory.getBaseView();
         this.createPlayerStep= super.factory.getCreatePlayerStep();
    }

    @Test
    public void shouldCreatePlayer(){

        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("Niraj")
                .getBytes()));
        Player player = createPlayerStep.apply(null);
        String s = super.outContent.toString();
        assertNotNull(player);
        assertEquals("Niraj",player.getName());
        assertEquals(1,player.getPlayerExperience().getLevel());
        assertEquals(10,player.getPlayerExperience().getReputation());
        assertEquals("Please Enter User Name",s.trim());


    }

}