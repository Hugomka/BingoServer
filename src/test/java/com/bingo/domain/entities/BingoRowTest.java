package com.bingo.domain.entities;

import com.bingo.domain.builders.BingoRowBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class BingoRowTest {

    private BingoRow bingoRow;

    @BeforeEach
    void setUp() {
        bingoRow = new BingoRowBuilder();
    }
    
    @Test
    void getId() {
        UUID id = bingoRow.getId();
        assertNotNull(id);
    }

    @Test
    void getNumbers() {
        String numbers = bingoRow.getNumbers();
        String[] split = numbers.split(",");
        assertEquals(5, split.length);
    }

    @Test
    void testToString() {
        String s = bingoRow.toString();
        assertTrue(s.contains(bingoRow.getNumbers()));
    }
}