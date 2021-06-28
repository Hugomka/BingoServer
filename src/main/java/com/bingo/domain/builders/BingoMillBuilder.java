package com.bingo.domain.builders;

import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.enums.BingoCardType;

import java.util.ArrayList;
import java.util.UUID;

public class BingoMillBuilder extends BingoMill {
    public BingoMillBuilder() {
        this.id = UUID.randomUUID();
        this.drawNumbers = "";
        this.minimumNumber = 1;
        this.maximumNumber = 75;
        this.bingoCardType = BingoCardType.normal;
    }

    public void setBingoCardType(BingoCardType bingoCardType) {
        this.bingoCardType = bingoCardType;
    }
}
