package nl.bingo.repos;

import nl.bingo.domain.entities.BingoRow;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BingoRowRepository extends CrudRepository<BingoRow, UUID> {
}
