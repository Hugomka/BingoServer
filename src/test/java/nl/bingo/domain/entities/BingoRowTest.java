package nl.bingo.domain.entities;

import nl.bingo.domain.builders.BingoRowBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class BingoRowTest {

    private BingoRow bingoRow;

    @Before
    public void setUp() {
        bingoRow = new BingoRowBuilder();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getId() {
        UUID id = bingoRow.getId();
        assertNotNull(id);
    }

    @Test
    public void getNumbers() {
        String numbers = bingoRow.getNumbers();
        String[] split = numbers.split(",");
        assertEquals(5, split.length);
    }

    @Test
    public void testToString() {
        String s = bingoRow.toString();
        assertTrue(s.contains(bingoRow.getNumbers()));
    }
}