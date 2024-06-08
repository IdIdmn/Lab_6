package ru.bmstu.GameInfoStore.Service;


import ru.bmstu.GameInfoStore.Entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> findAllPlayers();

    List<Player> findPlayersByLogin(String login);

    Player findPlayerByName(String name);

    String createPlayer(Player newPlayer);

    String updatePlayer(Player newPlayer);

    String deletePlayer(String name);

}
