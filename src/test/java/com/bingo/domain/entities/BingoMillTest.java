package com.bingo.domain.entities;

import com.bingo.domain.builders.BingoMillBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BingoMillTest {

    private BingoMill bingoMill;

    @BeforeEach
    void setUp() {
        bingoMill = new BingoMillBuilder();
    }

    @Test
    void getId() {
        assertNotNull(bingoMill.getId());
    }

    @Test
    void getDrawNumbers() {
        assertNotNull(bingoMill.getDrawNumbers());
    }

    @Test
    void getBingoCards() {
        assertNotNull(bingoMill.bingoCards);
    }

    @Test
    void addDrawNumber() {
        assertEquals("", bingoMill.getDrawNumbers());
        bingoMill.addDrawNumber(10);
        assertEquals("#10;", bingoMill.getDrawNumbers());
    }
}