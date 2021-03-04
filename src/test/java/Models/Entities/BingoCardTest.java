package Models.Entities;

import Models.Builders.UserBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BingoCardTest {
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