package com.bingo.services;

import com.bingo.domain.builders.BingoRowBuilder;
import com.bingo.domain.entities.BingoRow;
import com.bingo.repos.BingoRowRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BingoRowServiceImpl implements BingoRowService {
    private final BingoRowRepository bingoRowRepository;

    public BingoRowServiceImpl(BingoRowRepository bingoRowRepository) {
        this.bingoRowRepository = bingoRowRepository;
    }

    @Override
    public BingoRow save(BingoRow bingoRow) {
        return bingoRowRepository.save(bingoRow);
    }

    @Override
    public void clearBingoRows() {
        bingoRowRepository.deleteAll();
    }
}

