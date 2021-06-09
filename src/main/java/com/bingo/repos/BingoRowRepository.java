package com.bingo.repos;

import com.bingo.domain.entities.BingoRow;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface BingoRowRepository extends CrudRepository<BingoRow, UUID> {
    Optional<BingoRow> findByNumbers(String numbers);
}
