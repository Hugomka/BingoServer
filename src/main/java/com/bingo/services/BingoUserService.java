package com.bingo.services;

import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoUser;

import java.util.UUID;

public interface BingoUserService {
    BingoUser save(BingoUser bingoUser);

    Iterable<BingoUser> findAllByBingoMill(BingoMill bingoMill);

    BingoUser findById(UUID bingoUserId);

    boolean deleteById(UUID bingoUserId);
}
