package services;

import domain.entities.BingoMill;
import domain.entities.User;
import repos.UserRepository;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> findAllByBingoMill(BingoMill bingoMill) {
        return userRepository.getAllByBingoMillId(bingoMill.getId());
    }

    @Override
    public User findById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean deleteById(UUID userId) {
        userRepository.deleteById(userId);
        return true;
    }
}
