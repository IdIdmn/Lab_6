package ru.bmstu.GameInfoStore.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.GameInfoStore.Entity.Map;
import ru.bmstu.GameInfoStore.Service.MapService;

import java.util.List;

@RestController
@AllArgsConstructor
public class MapController {

    private MapService mapService;

    @GetMapping("/api/v1/Maps/getAllMaps")
    public List<Map> getAllMaps(){
        return mapService.findAllMaps();
    }

    @GetMapping("/api/v1/Maps/getMapsByLogin/{login}")
    public List<Map> getMapsByLogin(@PathVariable String login){
        return mapService.findMapsByLogin(login);
    }

    @GetMapping("/api/v1/Maps/getMapsByName/{name}")
    public List<Map> getMapsByName(@PathVariable() String name){
        return mapService.findMapsByName(name);
    }

    @GetMapping("/api/v1/Maps/getMap/{login}/{name}")
    public Map getMap(@PathVariable(name = "login") String login,@PathVariable(name = "name") String name){
        return mapService.findConcreteMap(login, name);
    }

    @PutMapping("/api/v1/Maps/createMap")
    public String createMap(@RequestBody Map map){
        return mapService.createMap(map);
    }

    @DeleteMapping("/api/v1/Maps/deleteMapsByName/{name}")
    public String deleteMapsByName(@PathVariable() String name){
        return mapService.deleteMapsByName(name);
    }

    @DeleteMapping("/api/v1/Maps/deleteMap/{login}/{name}")
    public String deleteMap(@PathVariable(name = "login") String login,@PathVariable(name = "name") String name){
        return mapService.deleteConcreteMap(login, name);
    }


}
