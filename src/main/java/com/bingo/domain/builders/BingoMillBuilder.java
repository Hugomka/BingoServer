package com.bingo.domain.builders;

import com.bingo.domain.entities.BingoMill;

import java.util.ArrayList;
import java.util.UUID;

public class BingoMillBuilder extends BingoMill {
    public BingoMillBuilder() {
        this.id = UUID.randomUUID();
        this.bingoCards = new ArrayList<>();
        this.drawNumbers = "";
    }
}
