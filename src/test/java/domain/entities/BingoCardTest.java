package domain.entities;

import domain.builders.UserBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BingoCardTest {
    private BingoCard bingoCard;
    private User user;

    @BeforeEach
    void setUp() {
        user = new UserBuilder("UserTest");
        bingoCard = new BingoCard(user);
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
        User user = bingoCard.getUser();
        assertNotNull(user);
    }
}