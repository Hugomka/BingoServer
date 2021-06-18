package com.bingo.services;

import com.bingo.domain.entities.BingoUser;
import com.bingo.domain.enums.BingoUserRole;
import com.bingo.logic.BingoLogic;
import com.bingo.repos.BingoUserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BingoUserServiceImpl implements BingoUserService {
    private final BingoUserRepository userRepository;
    private final BingoLogic bingoLogic = BingoLogic.init();

    public BingoUserServiceImpl(BingoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BingoUser save(BingoUser bingoUser) {
        if (bingoUser.getUserRole() == BingoUserRole.Master
                && !bingoLogic.becomeMaster(bingoUser)) {
            bingoUser.switchUserRole();
            return bingoUser;
        }
        return userRepository.save(bingoUser);
    }

    @Override
    public Iterable<BingoUser> findAll() {
        return userRepository.findAll();
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
