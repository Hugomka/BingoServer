package com.bingo.services;

import com.bingo.domain.entities.BingoCard;
import com.bingo.domain.entities.BingoRow;
import com.bingo.logic.BingoLogic;
import com.bingo.repos.BingoRowRepository;
import org.springframework.stereotype.Service;

@Service
public class BingoRowServiceImpl implements BingoRowService {
    private final BingoRowRepository bingoRowRepository;
    private final BingoLogic bingoLogic;

    public BingoRowServiceImpl(BingoRowRepository bingoRowRepository) {
        this.bingoRowRepository = bingoRowRepository;
        this.bingoLogic = BingoLogic.init();
    }

    @Override
    public BingoRow save(BingoRow bingoRow) {
        return bingoRowRepository.save(bingoRow);
    }

    @Override
    public void generateRows(BingoCard bingoCard) {
        bingoLogic.generateRows(bingoCard, bingoRowRepository);
    }

    @Override
    public void clearBingoRows() {
        bingoRowRepository.deleteAll();
    }
}

