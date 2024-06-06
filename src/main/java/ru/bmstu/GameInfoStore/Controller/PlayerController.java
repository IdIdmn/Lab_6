package ru.bmstu.GameInfoStore.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bmstu.GameInfoStore.Entity.Player;

@RestController
public class PlayerController {

    @PostMapping("/api/v1/createPlayerByLogin")
    public Player savePlayer(@RequestBody Player player){
        return player;
    }

}
