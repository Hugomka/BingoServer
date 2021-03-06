package repos;

import domain.entities.BingoMill;
import domain.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    Iterable<User> getAllByBingoMillId(UUID bingoMillId);
}
