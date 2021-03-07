package nl.bingo.services;

import nl.bingo.domain.entities.BingoMill;

import java.util.UUID;

public interface BingoMillService {
    BingoMill save(BingoMill bingoMill);

    Iterable<BingoMill> findAll();

    BingoMill findById(UUID bingoMillId);

    boolean deleteById(UUID bingoMillId);
}
