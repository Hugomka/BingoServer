package nl.bingo.domain.builders;

import nl.bingo.domain.entities.BingoCard;
import nl.bingo.domain.entities.BingoUser;

import java.util.ArrayList;
import java.util.UUID;

public class BingoCardBuilder extends BingoCard {
    public BingoCardBuilder(BingoUser bingoUser) {
        this.id = UUID.randomUUID();
        this.bingoUser = bingoUser;
        this.bingoRows = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.bingoRows.add(new BingoRowBuilder());
        }
    }
}
