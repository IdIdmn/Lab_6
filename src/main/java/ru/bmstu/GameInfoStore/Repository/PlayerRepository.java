package ru.bmstu.GameInfoStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.GameInfoStore.Entity.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, String> {

    List<Player> findByLogin(String login);

    Player findByPlayerName(String name);

}
