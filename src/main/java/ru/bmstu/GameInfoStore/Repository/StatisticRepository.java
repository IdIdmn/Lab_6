package ru.bmstu.GameInfoStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.GameInfoStore.Entity.Statistic;

import java.util.List;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {

    Statistic findByGameId(int gameId);

    List<Statistic> findByPlayerName(String name);

}
