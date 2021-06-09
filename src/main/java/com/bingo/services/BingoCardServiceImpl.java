package com.bingo.services;

import com.bingo.domain.entities.BingoCard;
import com.bingo.repos.BingoCardRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BingoCardServiceImpl implements BingoCardService {
    private final BingoCardRepository bingoCardRepository;

    BingoCardServiceImpl(BingoCardRepository bingoCardRepository) {
        this.bingoCardRepository = bingoCardRepository;
    }

    @Override
    public BingoCard save(BingoCard bingoCard) { return bingoCardRepository.save(bingoCard); }

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
