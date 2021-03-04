package Models.Entities;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Entity
public class BingoRow {
    @Id
    protected UUID id;

    @ManyToOne
    protected BingoCard bingoCard;

    @ManyToOne
    protected BingoMill bingoMill;

    @Column(unique = true)
    protected String numbers;

    public BingoRow() {
        Random random = new Random();
        int b = random.nextInt(15) + 1;
        int i = random.nextInt(15) + 16;
        int n = random.nextInt(15) + 31;
        int g = random.nextInt(15) + 46;
        int o = random.nextInt(15) + 61;
        numbers = String.format("%d,%d,%d,%d,%d", b, i, n, g, o);
    }

    public BingoRow(BingoCard bingoCard, BingoMill bingoMill) {
        this();
        this.bingoCard = bingoCard;
        this.bingoMill = bingoMill;
    }

    public UUID getId() {
        return id;
    }

    public BingoCard getBingoCard() {
        return bingoCard;
    }

    public BingoMill getBingoMill() {
        return bingoMill;
    }

    public String getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "BingoRow{" +
                "rowNumbers='" + numbers + '\'' +
                '}';
    }
}
