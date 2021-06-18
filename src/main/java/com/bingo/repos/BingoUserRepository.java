package com.bingo.repos;

import com.bingo.domain.entities.BingoUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BingoUserRepository extends CrudRepository<BingoUser, UUID> {
}
