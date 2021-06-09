package com.bingo.repos;

import com.bingo.domain.entities.BingoCard;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BingoCardRepository extends CrudRepository<BingoCard, UUID> {
}
