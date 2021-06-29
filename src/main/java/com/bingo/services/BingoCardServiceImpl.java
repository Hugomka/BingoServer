package com.bingo.services;

import com.bingo.domain.entities.BingoCard;
import com.bingo.logic.BingoLogic;
import com.bingo.repos.BingoCardRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BingoCardServiceImpl implements BingoCardService {
    private final BingoCardRepository bingoCardRepository;
    private final BingoLogic bingoLogic;

    BingoCardServiceImpl(BingoCardRepository bingoCardRepository) {
        this.bingoCardRepository = bingoCardRepository;
        this.bingoLogic = BingoLogic.init();
    }

    @Override
    public BingoCard create(BingoCard bingoCard) {
        bingoLogic.openBingoMill(bingoCard.getBingoMill());
        bingoCard.setBingoMill(bingoLogic.getBingoMill());
        bingoCard = bingoCardRepository.save(bingoCard);
        bingoLogic.joinBingo(bingoCard);
        return bingoCard;
    }

    @Override
    public BingoCard update(BingoCard bingoCard) {
        return bingoCardRepository.save(bingoCard);
    }

    @Override
    public Iterable<BingoCard> findAll() {
        return bingoCardRepository.findAll();
    }

    @Override
    public BingoCard findById(UUID bingoCardId) {
        return bingoCardRepository.findById(bingoCardId).orElse(null);
    }

    @Override
    public boolean deleteById(UUID bingoCardId) {
        bingoCardRepository.deleteById(bingoCardId);
        return true;
    }
}
