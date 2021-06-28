package com.bingo.services;

import com.bingo.domain.entities.BingoMill;

import java.util.UUID;

public interface BingoMillService {
    BingoMill open(BingoMill bingoMill);

    BingoMill save(BingoMill bingoMill);

    Iterable<BingoMill> findAll();

    BingoMill findById(UUID bingoMillId);

    boolean deleteById(UUID bingoMillId);

    long draw(UUID bingoMillId);
}
