package ru.bmstu.GameInfoStore.Service.Impl;

import org.springframework.stereotype.Service;
import ru.bmstu.GameInfoStore.Service.AppStatusService;

@Service
public class AppStatusServiceImpl implements AppStatusService {


    @Override
    public String getStatus() {
        return "Сервис работает в штатном режиме.";
    }
}
