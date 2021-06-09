package com.bingo.services;

import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoUser;
import com.bingo.repos.BingoUserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BingoUserServiceImpl implements BingoUserService {
    private final BingoUserRepository userRepository;

    public BingoUserServiceImpl(BingoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BingoUser save(BingoUser bingoUser) {
        return userRepository.save(bingoUser);
    }

    @Override
    public Iterable<BingoUser> findAllByBingoMill(BingoMill bingoMill) {
        return userRepository.findAllByBingoMillId(bingoMill.getId());
    }

    @Override
    public BingoUser findById(UUID bingoUserId) {
        return userRepository.findById(bingoUserId).orElse(null);
    }

    @Override
    public boolean deleteById(UUID bingoUserId) {
        userRepository.deleteById(bingoUserId);
        return true;
    }
}
