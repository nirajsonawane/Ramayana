package com.ns.ramayana.view;

import com.ns.ramayana.domain.battle.Battle;
import com.ns.ramayana.domain.game.*;
import com.ns.ramayana.exception.GameException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BaseView {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


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
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new GameException("Error While Reading Data, Not a Number", e);
        }
    }

    public Integer readInt() {
        try {
            return Integer.parseInt(in.readLine());
        } catch (NumberFormatException | IOException e) {
            throw new GameException("Invalid Input , Not a Number ", e);
        }
    }

    public Long readLong() {
        try {
            return Long.parseLong(in.readLine());
        } catch (NumberFormatException|IOException e) {
            throw new GameException("Invalid Input , Not a Number ", e);
        }

    }


    public void printPlayerGameId(List<PlayerGameId> playerGameId) {
        playerGameId.forEach(it -> printText(it.toString()));

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

    public void mockInput(ByteArrayInputStream mock) {
        this.in = new BufferedReader(new InputStreamReader(mock));
    }


}
