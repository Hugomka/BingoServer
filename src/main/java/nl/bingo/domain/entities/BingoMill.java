package nl.bingo.domain.entities;

import javax.persistence.*;
import java.util.*;

@Entity(name = "bingo_mill")
public class BingoMill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    protected UUID id;

    @OneToMany
    public List<BingoCard> bingoCards;

    public String drawNumbers;

    public BingoMill() {}

    public UUID getId() { return id; }

    public String getDrawNumbers() {
        return drawNumbers;
    }

    public List<BingoCard> getBingoCards() {
        return bingoCards;
    }

    public void addDrawNumber(long drawNumber) {
        drawNumbers += "#" + drawNumber + ";";
    }
}


