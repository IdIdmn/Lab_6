package ru.bmstu.GameInfoStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.GameInfoStore.Entity.Map;
import java.util.List;

public interface MapRepository extends JpaRepository<Map, Integer> {

    List<Map> findByLogin(String login);

    List<Map> findByMapName(String name);

    Map findByMapId(Integer mapId);

}
