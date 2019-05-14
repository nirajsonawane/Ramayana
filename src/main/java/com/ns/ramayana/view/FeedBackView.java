package com.ns.ramayana.view;

import com.ns.ramayana.domain.game.Game;

public class FeedBackView {



    private final BaseView baseView;

    public FeedBackView(BaseView baseView){

        this.baseView=baseView;
    }
    public void show() {
        baseView.printText("Hope you had a great Time!!!  ");
        baseView.printText("Please Share FeedBack To Niraj.Sonawane@Gamil.com");


    }
}
