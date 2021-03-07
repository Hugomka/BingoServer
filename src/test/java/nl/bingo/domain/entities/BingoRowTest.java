package nl.bingo.domain.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BingoRowTest {

    private BingoRow bingoRow;

    @BeforeEach
    void setUp() {
        BingoCard bingoCard = new BingoCard();
        BingoMill bingoMill = new BingoMill();
        bingoRow = new BingoRow(bingoCard, bingoMill);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        UUID id = bingoRow.getId();
        assertNotNull(id);
    }

    @Test
    void getBingoCard() {
        BingoCard bingoCard = bingoRow.getBingoCard();
        assertNotNull(bingoCard);
    }

    @Test
    void getBingoMill() {
        BingoMill bingoMill = bingoRow.getBingoMill();
        assertNotNull(bingoMill);
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