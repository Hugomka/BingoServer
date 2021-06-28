package com.bingo.domain.entities;

import com.bingo.domain.enums.BingoCardType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity(name = "bingo_mill")
public class BingoMill {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy ="org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, unique = true, length = 36)
    @Type(type = "uuid-char")
    protected UUID id;

    public String drawNumbers;

    public long minimumNumber;

    public long maximumNumber;

    public BingoCardType bingoCardType;

    public UUID getId() { return id; }

    public void addDrawNumber(long drawNumber) {
        String s = "#" + drawNumber + ";";
        if (!drawNumbers.contains(s)) {
            drawNumbers += s;
        }
    }

    public String getDrawNumbers() {
        return drawNumbers;
    }


    public long getMinimumNumber() {
        return minimumNumber;
    }

    public long getMaximumNumber() {
        return maximumNumber;
    }

    public BingoCardType getBingoCardType() {
        return bingoCardType;
    }
}


