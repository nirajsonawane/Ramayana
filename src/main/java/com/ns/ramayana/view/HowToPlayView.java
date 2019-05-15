package com.ns.ramayana.view;

public class HowToPlayView {

    private final BaseView baseView;

    public HowToPlayView(BaseView baseView){
        this.baseView=baseView;
    }



    public void show() {
        baseView.printText("The Game is Based on Ramayan and You Will be Playing as Lord Rama");
        baseView.printText("The Game Has Multiple Levels in terms of battles, To Unlock the Next Level You need to Clear Current Level");
        baseView.printText("On Each User Screen,You need to select appropriate option [Number]");


    }
}
