package nl.bingo.domain.entities;

import nl.bingo.domain.builders.BingoUserBuilder;
import nl.bingo.domain.enums.BingoUserRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BingoUserTest {
    private BingoUser bingoUser;

    @Before
    public void setUp() {
        bingoUser = new BingoUserBuilder("BingoUserTest");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getId() {
        assertNotNull(bingoUser.getId());
    }

    @Test
    public void getUsername() {
        assertEquals("BingoUserTest", bingoUser.getUsername());
    }

    @Test
    public void getBackgroundColor() {
        assertEquals("#0000ff", bingoUser.getBackgroundColor());
    }

    @Test
    public void getUserRole() {
        assertEquals(BingoUserRole.Player, bingoUser.getUserRole());
    }

    @Test
    public void switchUserRole() {
        assertEquals(BingoUserRole.Player, bingoUser.getUserRole());
        bingoUser.switchUserRole();
        assertEquals(BingoUserRole.Master, bingoUser.getUserRole());
        bingoUser.switchUserRole();
        assertEquals(BingoUserRole.Player, bingoUser.getUserRole());
    }
}