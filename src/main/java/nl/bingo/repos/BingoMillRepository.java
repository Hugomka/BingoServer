package nl.bingo.repos;

import nl.bingo.domain.entities.BingoMill;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BingoMillRepository extends CrudRepository<BingoMill, UUID> {
}
