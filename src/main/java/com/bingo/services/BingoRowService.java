package com.bingo.services;

import com.bingo.domain.entities.BingoRow;

public interface BingoRowService {
    BingoRow save(BingoRow bingoRow);

    void clearBingoRows();
}
