package com.bingo.domain.entities;

import com.bingo.domain.builders.BingoCardBuilder;
import com.bingo.domain.builders.BingoUserBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class BingoCardTest {
    private BingoCard bingoCard;
    private BingoUser bingoUser;

    @Before
    public void setUp() {
        bingoUser = new BingoUserBuilder("BingoUserTest");
        bingoCard = new BingoCardBuilder(bingoUser);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getId() {
        UUID id = bingoCard.getId();
        assertNotNull(id);
    }

    @Test
    public void getUser() {
        BingoUser bingoUser = bingoCard.getUser();
        assertNotNull(bingoUser);
    }
}