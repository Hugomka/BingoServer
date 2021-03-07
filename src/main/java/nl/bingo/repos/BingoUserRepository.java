package nl.bingo.repos;

import nl.bingo.domain.entities.BingoUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BingoUserRepository extends CrudRepository<BingoUser, UUID> {
    Iterable<BingoUser> findAllByBingoMillId(UUID bingoMillId);
}
