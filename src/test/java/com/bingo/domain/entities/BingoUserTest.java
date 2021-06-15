package com.bingo.domain.entities;

import com.bingo.domain.builders.BingoUserBuilder;
import com.bingo.domain.enums.BingoUserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BingoUserTest {
    private BingoUser bingoUser;

    @BeforeEach
    void setUp() {
        bingoUser = new BingoUserBuilder("BingoUserTest");
    }

    @Test
    void getId() {
        assertNotNull(bingoUser.getId());
    }

    @Test
    void getUsername() {
        assertEquals("BingoUserTest", bingoUser.getUsername());
    }

    @Test
    void getBackgroundColor() {
        assertEquals("#0000ff", bingoUser.getBackgroundColor());
    }

    @Test
    void getUserRole() {
        assertEquals(BingoUserRole.Player, bingoUser.getUserRole());
    }

    @Test
    void switchUserRole() {
        assertEquals(BingoUserRole.Player, bingoUser.getUserRole());
        bingoUser.switchUserRole();
        assertEquals(BingoUserRole.Master, bingoUser.getUserRole());
        bingoUser.switchUserRole();
        assertEquals(BingoUserRole.Player, bingoUser.getUserRole());
    }
}