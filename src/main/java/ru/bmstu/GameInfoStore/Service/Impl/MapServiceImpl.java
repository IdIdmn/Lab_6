package ru.bmstu.GameInfoStore.Service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.GameInfoStore.Entity.Map;
import ru.bmstu.GameInfoStore.Repository.MapRepository;
import ru.bmstu.GameInfoStore.Service.MapService;
import ru.bmstu.GameInfoStore.Service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class MapServiceImpl implements MapService {

    private MapRepository repository;

    private UserService userService;

    @Override
    public List<Map> findAllMaps() {
        return repository.findAll();
    }

    @Override
    public List<Map> findMapsByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public List<Map> findMapsByName(String name) {
        return repository.findByMapName(name);
    }

    @Override
    public Map findMapById(int mapId){
        return repository.findByMapId(mapId);
    }

    @Override
    public Map findConcreteMap(String login, String name){
        for (Map curMap : findMapsByLogin(login)){
            if (curMap.getMapName().equals(name)){
                return curMap;
            }
        }
        return null;
    }

    @Override
    public String createMap(Map newMap) {
        if(userService.findUserByLogin(newMap.getLogin()) != null){
            if(findConcreteMap(newMap.getLogin(), newMap.getMapName()) == null){
                repository.save(newMap);
                return "Новая карта была успешно сохранена.";
            }
            return "Карта с таким названием уже существует на данном аккаунте.";
        }
        return "Пользователя с таким логином не существует.";
    }

    @Override
    public String deleteMapsByName(String name){
        List<Map> deletedMaps = findMapsByName(name);
        if(!deletedMaps.isEmpty()){
            for(Map curMap : deletedMaps) {
                repository.delete(curMap);
            }
            return "Карты с заданным именем были успешно удалены.";
        }
        return "Не существует ни одной карты с таким названием.";
    }

    @Override
    public String deleteConcreteMap(String login, String name) {
        if(userService.findUserByLogin(login) != null){
            Map deletedMap = findConcreteMap(login, name);
            if(deletedMap != null){
                repository.delete(deletedMap);
                return "Карта была успешно удалена.";
            }
            return "Карты с таким названием не существует на данном аккаунте.";
        }
        return "Пользователя с таким логином не существует.";
    }

}
