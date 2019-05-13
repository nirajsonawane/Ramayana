package com.ns.ramayana.view;

import com.ns.ramayana.domain.battle.Battle;
import com.ns.ramayana.domain.game.*;

import java.util.List;
import java.util.Scanner;

public class BaseView {

    Scanner in = new Scanner(System.in);

    public void print(CreateGameMenu menu) {
        menu
                .getMenuOptions()
                .stream()
                .forEach(System.out::println);
    }

    public void print(UpdateGameMenu menu) {
        menu
                .getMenuOptions()
                .stream()
                .forEach(System.out::println);
    }

    public void printText(String str) {
        System.out.println(str);
    }

    public String readString() {
        return in.nextLine();
    }

    public int readInt() {
        return in.nextInt();
    }

    public Long readLong() {
        return in.nextLong();
    }


    public void printPlayerGameId(List<PlayerGameId> playerGameId) {
        playerGameId.forEach(it -> printText(it.toString()));

    }

    public Player readPlayer() {
        printText("Please Enter Your Name :");
        return new Player(readString());
    }

    public void printGame(Game game) {
        System.out.println(game);

    }

    public void printHelp() {
        String str = "The Game is based On Ancient India epic Ramayana. For more details please check https://en.wikipedia.org/wiki/Ramayana. You Will BE playing this Game as Lord Ram and The Final Step is to Kill Ravana. The Game Has 6 levels " +
                "In Last Level You will be fighting with Ravana. You Can Check Your progress in ProfileCommand Section";
        System.out.println(str);


    }


    public void printBattles(List<Battle> allBattles) {
        allBattles.forEach(System.out::println);
    }

    public void print(Player player) {
        System.out.println(player);

    }


}
