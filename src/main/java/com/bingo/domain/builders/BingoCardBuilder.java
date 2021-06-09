package com.bingo.domain.builders;

import com.bingo.domain.entities.BingoCard;
import com.bingo.domain.entities.BingoUser;

import java.util.ArrayList;
import java.util.UUID;

public class BingoCardBuilder extends BingoCard {
    public BingoCardBuilder(BingoUser bingoUser) {
        this.id = UUID.randomUUID();
        this.bingoUser = bingoUser;
        this.bingoRows = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.bingoRows.add(new BingoRowBuilder());
        }
    }
}
