package nl.bingo.services;

import nl.bingo.domain.entities.BingoMill;
import nl.bingo.domain.entities.BingoUser;

import java.util.UUID;

public interface BingoUserService {
    BingoUser save(BingoUser bingoUser);

    Iterable<BingoUser> findAllByBingoMill(BingoMill bingoMill);

    BingoUser findById(UUID bingoUserId);

    boolean deleteById(UUID bingoUserId);
}
