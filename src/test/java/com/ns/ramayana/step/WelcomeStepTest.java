package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WelcomeStepTest extends BaseTest{
    private BaseView baseView;
    @BeforeEach
    public void setup() {
        this.baseView = super.factory.getBaseView();

    }

    @Test
    public void shouldPrintWelcomeMessage(){
        WelcomeStep welcomeStep= new WelcomeStep();
        welcomeStep.apply(null);
        String s = super.outContent.toString();
        assertEquals("Welcome To Command Line Ramayana!!",s.trim());

    }

}