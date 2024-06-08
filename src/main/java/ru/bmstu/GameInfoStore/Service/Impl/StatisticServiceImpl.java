package ru.bmstu.GameInfoStore.Service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.GameInfoStore.Entity.Map;
import ru.bmstu.GameInfoStore.Entity.Player;
import ru.bmstu.GameInfoStore.Entity.Statistic;
import ru.bmstu.GameInfoStore.Repository.StatisticRepository;
import ru.bmstu.GameInfoStore.Service.MapService;
import ru.bmstu.GameInfoStore.Service.PlayerService;
import ru.bmstu.GameInfoStore.Service.StatisticService;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private StatisticRepository repository;

    private MapService mapService;

    private PlayerService playerService;

    @Override
    public HashMap<Statistic, Map> findAllStatistics() {
        HashMap<Statistic, Map> response = new HashMap<>();
        for (Statistic curStatistic : repository.findAll()){
            response.put(curStatistic, mapService.findMapById(curStatistic.getMapId()));
        }
        return response;
    }

    @Override
    public HashMap<Statistic, Map> findStatisticsByPlayerName(String name){
        HashMap<Statistic, Map> response = new HashMap<>();
        for (Statistic curStatistic : repository.findByPlayerName(name)){
            response.put(curStatistic, mapService.findMapById(curStatistic.getMapId()));
        }
        return response;
    }

    @Override
    public HashMap<Statistic, Map> findStatisticsByLogin(String login){
        HashMap<Statistic, Map> response = new HashMap<>();
        for (Player curPlayer : playerService.findPlayersByLogin(login)){
            response.putAll(findStatisticsByPlayerName(curPlayer.getPlayerName()));
        }
        return response;
    }

    @Override
    public String createStatistic(Statistic statistic) {
        Player activePlayer = playerService.findPlayerByName(statistic.getPlayerName());
        if (activePlayer != null) {
            Map activemap = mapService.findMapById(statistic.getMapId());
            if(activemap != null) {
                if(activePlayer.getLogin().equals(activemap.getLogin())) {
                    repository.save(statistic);
                    return "Запись о проведённом матче была успешно занесена в базу данных.";
                }
                return "В списке карт пользователя, которому принадлежит указанный профиль игрока, нет карты с таким названием.";
            }
            return "Карты с таким названием не существует.";
        }
        return "Профиля игрока с таким именем не существует.";
    }

    @Override
    public String deleteStatisticById(int gameId){
        if (repository.findByGameId(gameId) != null){
            repository.deleteById(gameId);
            return "Запись об игре была успешно удалена.";
        }
        return "Игры с указанным Id нет в списке проведённым матчей.";
    }

    @Override
    public String deleteStatisticByPlayerName(String name){
        if(playerService.findPlayerByName(name) != null) {
            List<Statistic> deletedStatistics = repository.findByPlayerName(name);
            if (!deletedStatistics.isEmpty()) {
                for (Statistic curStatistic : repository.findByPlayerName(name)) {
                    repository.deleteById(curStatistic.getGameId());
                }
                return "Данные о матчах игрока были спешно удалены.";
            }
            return "Игрок с указанным именем не сыграл ещё ни одного матча.";
        }
        return "Профиля игрока с данным именем не существует.";
    }

}
