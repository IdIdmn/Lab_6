package ru.bmstu.GameInfoStore.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bmstu.GameInfoStore.Service.AppStatusService;

@RestController
@AllArgsConstructor
public class StatusController {

    private AppStatusService statusService;

    @GetMapping("/api/v1/getStatus")
    public String getStatus(){
        return statusService.getStatus();
    }

}
