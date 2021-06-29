package com.bingo.domain.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "bingo_row")
public class BingoRow {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy ="org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, unique = true, length = 36)
    @Type(type = "uuid-char")
    protected UUID id;

    @Column(unique = true)
    protected String numbers;

    protected BingoRow() {}

    public BingoRow(String numbers) {
        this.numbers = numbers;
    }

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
