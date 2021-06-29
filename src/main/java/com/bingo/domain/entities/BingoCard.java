package com.bingo.domain.entities;

import com.bingo.domain.objects.BingoCardDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "bingo_card")
public class BingoCard {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy ="org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, unique = true, length = 36)
    @Type(type = "uuid-char")
    protected UUID id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected List<BingoRow> bingoRows = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    protected BingoMill bingoMill;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected BingoUser bingoUser;

    protected BingoCard() {}

    public static BingoCard create(BingoCardDTO bingoCardDTO) {
        var bingoCard = new BingoCard();
        bingoCard.bingoUser = bingoCardDTO.getBingoUser();
        bingoCard.bingoMill = bingoCardDTO.getBingoMill();
        return bingoCard;
    }

    public UUID getId() {
        return id;
    }

    public List<BingoRow> getBingoRows() {
        return bingoRows;
    }

    public BingoMill getBingoMill() {
        return bingoMill;
    }

    public BingoUser getUser() {
        return bingoUser;
    }

    public void setBingoRows(List<BingoRow> bingoRows) {
        this.bingoRows = bingoRows;
    }

    public void setBingoMill(BingoMill bingoMill) {
        this.bingoMill = bingoMill;
    }
}
