package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.view.BaseView;
import com.ns.ramayana.view.HowToPlayView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HowToPlayStepTest extends BaseTest{
    private BaseView baseView;
    @BeforeEach
    public void setup() {
        this.baseView = super.factory.getBaseView();

    }

    @Test
    public void shouldPrintHowToPlayInstructions(){
        HowToPlayStep howToPlayStep = new HowToPlayStep(baseView);
        howToPlayStep.apply(null);
        String s = super.outContent.toString();
        assertTrue(s.contains("The Game is Based on Ramayan and You Will be Playing as Lord Rama"));
        assertTrue(s.contains("The Game Has Multiple Levels in terms of battles, To Unlock the Next Level You need to Clear Current Level"));
        assertTrue(s.contains("On Each User Screen,You need to select appropriate option [Number]"));


    }

}