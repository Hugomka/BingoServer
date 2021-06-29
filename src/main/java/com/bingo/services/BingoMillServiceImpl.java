package com.bingo.services;

import com.bingo.domain.entities.BingoMill;
import com.bingo.logic.BingoLogic;
import com.bingo.repos.BingoMillRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BingoMillServiceImpl implements BingoMillService {
    private final BingoMillRepository bingoMillRepository;
    private final BingoLogic bingoLogic = BingoLogic.init();

    public BingoMillServiceImpl(BingoMillRepository bingoMillRepository) {
        this.bingoMillRepository = bingoMillRepository;
    }

    @Override
    public BingoMill open(BingoMill bingoMill) {
        bingoLogic.openBingoMill(bingoMill);
        return bingoMillRepository.save(bingoLogic.getBingoMill());
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

    @Override
    public long draw(UUID bingoMillId) {
        return bingoLogic.drawNumber(bingoMillId);
    }

    @Override
    public void pause(boolean pause) {
        bingoLogic.pause(pause);
    }
}
