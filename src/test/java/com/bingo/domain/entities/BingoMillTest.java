package com.bingo.domain.entities;

import com.bingo.domain.builders.BingoMillBuilder;
import com.bingo.domain.builders.BingoUserBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BingoMillTest {

    private BingoMill bingoMill;

    @Before
    public void setUp() {
        bingoMill = new BingoMillBuilder();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getId() {
        assertNotNull(bingoMill.getId());
    }

    @Test
    public void getDrawNumbers() {
        assertNotNull(bingoMill.getDrawNumbers());
    }

    @Test
    public void getBingoCards() {
        assertNotNull(bingoMill.bingoCards);
    }

    @Test
    public void addDrawNumber() {
        assertEquals("", bingoMill.getDrawNumbers());
        bingoMill.addDrawNumber(10);
        assertEquals("#10;", bingoMill.getDrawNumbers());
    }
}