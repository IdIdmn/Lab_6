package ru.bmstu.GameInfoStore.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maps")
public class Map {

    @Id
    @Column(unique = true)
    private String mapName;

    private int size;

}
