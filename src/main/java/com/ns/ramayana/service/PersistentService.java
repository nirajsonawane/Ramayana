package com.ns.ramayana.service;

import com.ns.ramayana.domain.game.Game;
import com.ns.ramayana.domain.game.PlayerGameId;
import com.ns.ramayana.exception.GameException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersistentService {

    private String gameData = "gameDataFile.txt";

    public void insertOrUpdateGame(Game game)  {
        System.out.println("In SaveCommand Game!!");
        List<Game> list = readFilestoGame();
        if (list.contains(game)) {
            list.remove(game);
        }
        list.add(game);
        saveGameList(list);
    }

    public List<Game> readFilestoGame()  {
        List<Game> list = new ArrayList<>();
        File file= new File(gameData);
        if(file.exists())
        {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                list = (List<Game>) objectInputStream.readObject();
            }
            catch (Exception e){
                throw new GameException("Error While reading Game Data",e);
            }
        }
        return list;
    }

    private void saveGameList(List<Game> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(gameData)))) {
            objectOutputStream.writeObject(list);
        }
        catch (Exception e){
            throw new GameException("Exception While Saving the Game",e);

        }

    }
    public Game getGameById(Long id)  {
        return readFilestoGame().stream().filter(it->it.getGameId().equals(id)).findFirst().orElseThrow(()->new RuntimeException("Game Not Found"));

    }
    public List<PlayerGameId>   getAllPlayerGameId()  {
        return readFilestoGame().stream().map(it->new PlayerGameId(it.getPlayer().getName(),it.getGameId())).collect(Collectors.toList());

    }

}
