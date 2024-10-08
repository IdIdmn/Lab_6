package ru.bmstu.GameInfoStore.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "maps")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mapId;

    private String mapName;

    private String login;

    private int size;

}
