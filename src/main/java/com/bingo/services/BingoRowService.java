package com.bingo.services;

import com.bingo.domain.entities.BingoRow;

public interface BingoRowService {
    BingoRow getNewRandomBingoRow();

    void clearBingoRows();
}
