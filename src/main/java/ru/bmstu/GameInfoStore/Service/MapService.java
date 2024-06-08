package ru.bmstu.GameInfoStore.Service;

import ru.bmstu.GameInfoStore.Entity.Map;

import java.util.List;

public interface MapService {

    List<Map> findAllMaps();

    List<Map> findMapsByLogin(String login);

    List<Map> findMapsByName(String name);

    Map findConcreteMap(String login, String name);

    Map findMapById(int mapId);

    String createMap(Map map);

    String deleteMapsByName(String name);

    String deleteConcreteMap(String login,String name);


}
