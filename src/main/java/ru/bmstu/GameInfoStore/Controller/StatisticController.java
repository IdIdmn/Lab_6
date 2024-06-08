package ru.bmstu.GameInfoStore.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.GameInfoStore.Entity.Map;
import ru.bmstu.GameInfoStore.Entity.Statistic;
import ru.bmstu.GameInfoStore.Service.StatisticService;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class StatisticController {

    private StatisticService statisticService;

    @GetMapping("/api/v1/Statistics/getAllStatistics")
    public HashMap<Statistic, Map> getAllStatistic(){
        return statisticService.findAllStatistics();
    }

    @GetMapping("/api/v1/Statistics/getStatisticsByLogin/{login}")
    public HashMap<Statistic, Map> getStatisticsByLogin(@PathVariable String login){
        return statisticService.findStatisticsByLogin(login);
    }

    @GetMapping("/api/v1/Statistics/getStatisticsByPlayerName/{name}")
    public HashMap<Statistic, Map> getStatisticsByPlayerName(@PathVariable String name){
        return statisticService.findStatisticsByPlayerName(name);
    }

    @PutMapping("/api/v1/Statistics/createStatistic")
    public String createStatistic(@RequestBody Statistic statistic){
        return statisticService.createStatistic(statistic);
    }

    @DeleteMapping("/api/v1/Statistics/deleteStatisticsById/{id}")
    public String deleteStatisticById(@PathVariable int id){
        return statisticService.deleteStatisticById(id);
    }

    @DeleteMapping("/api/v1/Statistics/deleteStatisticsByPlayerName/{name}")
    public String deleteStatisticByPlayerName(@PathVariable String name){
        return statisticService.deleteStatisticByPlayerName(name);
    }
}
