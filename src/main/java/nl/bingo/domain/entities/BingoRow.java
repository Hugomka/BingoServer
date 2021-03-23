package nl.bingo.domain.entities;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Entity
public class BingoRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    protected UUID id;

    @Column(unique = true)
    protected String numbers;

    public BingoRow() {}

    public UUID getId() {
        return id;
    }

    public String getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "BingoRow{" +
                "rowNumbers='" + numbers + '\'' +
                '}';
    }
}
