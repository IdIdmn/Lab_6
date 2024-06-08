package ru.bmstu.GameInfoStore.Service;

import ru.bmstu.GameInfoStore.Entity.Map;
import ru.bmstu.GameInfoStore.Entity.Statistic;

import java.util.HashMap;

public interface StatisticService {

    HashMap<Statistic, Map> findAllStatistics();

    HashMap<Statistic, Map> findStatisticsByPlayerName(String name);

    HashMap<Statistic, Map> findStatisticsByLogin(String login);

    String createStatistic(Statistic statistic);

    String deleteStatisticById(int gameId);

    String deleteStatisticByPlayerName(String name);

}
