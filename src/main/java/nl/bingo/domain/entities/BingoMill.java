package nl.bingo.domain.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class BingoMill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    protected UUID id;

    @OneToMany
    public List<BingoCard> bingoCards = new ArrayList<>();
    public String drawNumbers = "";

    public BingoMill() {}

    public UUID getId() { return id; }

    public String getDrawNumbers() {
        return drawNumbers;
    }

    public void createBingoCard(BingoUser bingoUser) {
        bingoCards.add(new BingoCard(bingoUser));
    }

    public int drawNumber() {
        Random random = new Random();
        int drawNumber;
        while(true) {
            drawNumber = random.nextInt(75) + 1;
            if (!drawNumbers.contains("#" + drawNumber + ";")) {
                drawNumbers += ("#" + drawNumber + ";");
                break;
            }
        }
        return drawNumber;
    }

    public List<BingoCard> getBingoCards() {
        return bingoCards;
    }
}


