package nl.bingo.services;

import nl.bingo.domain.builders.BingoUserBuilder;
import nl.bingo.domain.entities.BingoCard;
import nl.bingo.domain.entities.BingoMill;
import nl.bingo.domain.entities.BingoRow;
import nl.bingo.repos.BingoCardRepository;
import nl.bingo.repos.BingoRowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BingoCardServiceImpl implements BingoCardService {
    private final BingoCardRepository bingoCardRepository;
    private final BingoRowRepository bingoRowRepository;

    BingoCardServiceImpl(BingoCardRepository bingoCardRepository, BingoRowRepository bingoRowRepository) {
        this.bingoCardRepository = bingoCardRepository;
        this.bingoRowRepository = bingoRowRepository;
    }

    @Override
    public BingoCard save(BingoCard bingoCard) {
        BingoMill bingoMill = new BingoMill();
        List<BingoRow> bingoRows = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            bingoRows.add(new BingoRow());
        }
        return bingoCard;
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
