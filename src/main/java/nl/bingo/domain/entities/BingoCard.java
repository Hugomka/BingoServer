package nl.bingo.domain.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class BingoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    protected UUID id;

    @ManyToOne
    protected BingoUser bingoUser;

    protected BingoCard() {
    }

    public BingoCard(BingoUser bingoUser) {
        this();
        this.bingoUser = bingoUser;
    }

    public UUID getId() {
        return id;
    }

    public BingoUser getUser() {
        return bingoUser;
    }
}
