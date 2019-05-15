package com.ns.ramayana.step;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.view.BaseView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FeedBackStepTest extends BaseTest{
    private BaseView baseView;
    @BeforeEach
    public void setup() {
        this.baseView = super.factory.getBaseView();

    }

    @Test
    public void shouldPrintFeedBackMessage(){
        FeedBackStep feedBackStep= new FeedBackStep(baseView);
        feedBackStep.apply(null);
        String s = super.outContent.toString();
        assertTrue(s.contains("Hope you had a great Time!!!  "));
        assertTrue(s.contains("Please Share FeedBack To Niraj.Sonawane@Gamil.com"));


    }

}