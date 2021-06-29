package com.bingo.domain.objects;

import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoUser;

public class BingoCardDTO {
    private BingoUser bingoUser;
    private BingoMill bingoMill;

    public BingoUser getBingoUser() {
        return bingoUser;
    }

    public BingoMill getBingoMill() {
        return bingoMill;
    }
}
