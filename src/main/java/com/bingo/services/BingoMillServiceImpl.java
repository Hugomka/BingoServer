package com.bingo.services;

import com.bingo.domain.entities.BingoMill;
import com.bingo.repos.BingoMillRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BingoMillServiceImpl implements BingoMillService {
    private final BingoMillRepository bingoMillRepository;

    public BingoMillServiceImpl(BingoMillRepository bingoMillRepository) {
        this.bingoMillRepository = bingoMillRepository;
    }

    @Override
    public BingoMill save(BingoMill bingoMill) {
        return bingoMillRepository.save(bingoMill);
    }

    @Override
    public Iterable<BingoMill> findAll() {
        return bingoMillRepository.findAll();
    }

    @Override
    public BingoMill findById(UUID bingoMillId) {
        return bingoMillRepository.findById(bingoMillId).orElse(null);
    }

    @Override
    public boolean deleteById(UUID bingoMillId) {
        bingoMillRepository.deleteById(bingoMillId);
        return true;
    }
}
