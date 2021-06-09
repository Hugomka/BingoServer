package com.bingo.services;

import com.bingo.domain.entities.BingoCard;

import java.util.UUID;

public interface BingoCardService {

    BingoCard save(BingoCard bingoCard);

    Iterable<BingoCard> findAll();

    BingoCard findById(UUID bingoCardId);

    boolean deleteById(UUID bingoCardId);
}
