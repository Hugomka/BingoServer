package com.bingo.services;

import com.bingo.domain.builders.BingoRowBuilder;
import com.bingo.domain.entities.BingoRow;
import com.bingo.repos.BingoRowRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BingoRowServiceImpl implements BingoRowService {
    private final BingoRowRepository bingoRowRepository;
    private List<BingoRow> bingoRows;
    private Random random = new SecureRandom();

    public BingoRowServiceImpl(BingoRowRepository bingoRowRepository) {
        this.bingoRowRepository = bingoRowRepository;
    }

    @Override
    public BingoRow getNewRandomBingoRow() {
        BingoRow bingoRow = null;
        Optional<BingoRow> findBingoRow = Optional.empty();
        while (findBingoRow.isEmpty()) {
            bingoRow = new BingoRowBuilder();
            findBingoRow = bingoRowRepository.findByNumbers(bingoRow.getNumbers());
        }
        return bingoRowRepository.save(bingoRow);
    }

    @Override
    public void clearBingoRows() {
        bingoRowRepository.deleteAll();
    }
}

