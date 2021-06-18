package com.bingo.domain.entities;

import com.bingo.domain.builders.BingoCardBuilder;
import com.bingo.domain.builders.BingoUserBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class BingoCardTest {
    private BingoCard bingoCard;
    private BingoUser bingoUser;

    @BeforeEach
    void setUp() {
        bingoUser = new BingoUserBuilder("BingoUserTest");
        bingoCard = new BingoCardBuilder(bingoUser);
    }


    @Test
    void getId() {
        UUID id = bingoCard.getId();
        assertNotNull(id);
    }

    @Test
    void getUser() {
        BingoUser bingoUser = bingoCard.getUser();
        assertNotNull(bingoUser);
    }
}