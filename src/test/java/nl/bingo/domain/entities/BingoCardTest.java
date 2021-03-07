package nl.bingo.domain.entities;

import nl.bingo.domain.builders.UserBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BingoCardTest {
    private BingoCard bingoCard;
    private BingoUser bingoUser;

    @BeforeEach
    void setUp() {
        bingoUser = new UserBuilder("UserTest");
        bingoCard = new BingoCard(bingoUser);
    }

    @AfterEach
    void tearDown() {
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