package com.bingo.domain.objects;

import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoUser;

import java.util.UUID;

public class BingoCardDTO {
    private BingoUser bingoUser;
    private BingoMill bingoMill;

    public BingoUser getBingoUser() {
        return bingoUser;
    }

    public BingoMill getBingoMill() { return bingoMill; }
}
