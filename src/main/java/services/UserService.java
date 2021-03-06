package services;

import domain.entities.BingoMill;
import domain.entities.User;

import java.util.UUID;

public interface UserService {
    User save(User user);

    Iterable<User> findAllByBingoMill(BingoMill bingoMill);

    User findById(UUID userId);

    boolean deleteById(UUID userId);
}
