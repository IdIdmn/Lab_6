package ru.bmstu.GameInfoStore.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import ru.bmstu.GameInfoStore.Entity.Player;
import ru.bmstu.GameInfoStore.Service.PlayerService;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("/api/v1/Players/getAllPlayers")
    public List<Player> getAllPlayers(){
        return playerService.findAllPlayers();
    }

    @GetMapping("/api/v1/Players/getPlayersByLogin/{login}")
    public List<Player> getPlayersByLogin(@PathVariable String login){
        return playerService.findPlayersByLogin(login);
    }

    @GetMapping("/api/v1/Players/getPlayer/{name}")
    public Player getPlayer(@PathVariable() String name){
        return playerService.findPlayerByName(name);
    }

    @PutMapping("/api/v1/Players/createPlayer")
    public String createPlayer(@RequestBody Player player){
        return playerService.createPlayer(player);
    }

    @DeleteMapping("/api/v1/Players/deletePlayer/{name}")
    public String deletePlayer(@PathVariable() String name){
        return playerService.deletePlayer(name);
    }

}
