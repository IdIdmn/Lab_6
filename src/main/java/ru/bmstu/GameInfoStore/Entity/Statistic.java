package ru.bmstu.GameInfoStore.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "statistics")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;

    private String gameStatus;

    private String playerName;

    private int mapId;

}
