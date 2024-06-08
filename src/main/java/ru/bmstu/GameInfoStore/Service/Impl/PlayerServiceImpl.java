package ru.bmstu.GameInfoStore.Service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.GameInfoStore.Entity.Player;
import ru.bmstu.GameInfoStore.Repository.PlayerRepository;
import ru.bmstu.GameInfoStore.Service.PlayerService;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository repository;

    private UserServiceImpl userService;

    @Override
    public List<Player> findAllPlayers() {
        return repository.findAll();
    }

    @Override
    public List<Player> findPlayersByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public Player findPlayerByName(String name) {
        return repository.findByPlayerName(name);
    }

    @Override
    public String createPlayer(Player newPlayer) {
        if (userService.findUserByLogin(newPlayer.getLogin()) != null){
             if(findPlayerByName(newPlayer.getPlayerName()) != null){
                 return "Профиль игрока с таким именем уже существует.";
             }
            repository.save(newPlayer);
            return "Профиль игрока был успешно создан.";
        }
        return "Пользователя с таким именем не существует.";
    }

    @Override
    public String updatePlayer(Player newPlayer) {
        if (userService.findUserByLogin(newPlayer.getLogin()) != null){
            if(findPlayerByName(newPlayer.getPlayerName()) != null){
                repository.save(newPlayer);
                return "Профиль игрока был успешно обновлён.";
            }
            return "Профиля игрока с подобным именем не существует.";
        }
        return "Пользователя с таким именем не существует.";
    }

    @Override
    public String deletePlayer(String name) {
        Player deletedPlayer = findPlayerByName(name);
        if (findPlayerByName(name) != null) {
            repository.delete(deletedPlayer);
            return "Профиль игрока был успешно удалён.";
        }
        return "Профиля игрока с подобным именем не существует.";
    }
}
