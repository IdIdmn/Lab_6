package ru.bmstu.GameInfoStore.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(unique = true)
    private String playerName;

    private String login;

    private int level;


}
