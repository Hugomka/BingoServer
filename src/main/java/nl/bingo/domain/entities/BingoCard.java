package nl.bingo.domain.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class BingoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    protected UUID id;

    @OneToMany(mappedBy="BingoCardRow")
    protected List<BingoRow> bingoRows;

    @ManyToOne
    protected BingoUser bingoUser;

    protected BingoCard() {}

    public UUID getId() {
        return id;
    }

    public BingoUser getUser() {
        return bingoUser;
    }

    public List<BingoRow> getBingoRows() {
        return bingoRows;
    }
}
