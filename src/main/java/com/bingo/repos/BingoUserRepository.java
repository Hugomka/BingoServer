package com.bingo.repos;

import com.bingo.domain.entities.BingoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BingoUserRepository extends CrudRepository<BingoUser, UUID> {
    Iterable<BingoUser> findAllByBingoMillId(UUID bingoMillId);
}
