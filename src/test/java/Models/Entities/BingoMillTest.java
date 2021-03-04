package Models.Entities;

import Models.Builders.UserBuilder;
import org.junit.jupiter.api.*;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class BingoMillTest {

    BingoMill bingoMill;
    User user;

    @BeforeEach
    void setUp() {
        user = new UserBuilder("UserTest");
        bingoMill = new BingoMill();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createBingoCard() {
        bingoMill.createBingoCard(user);
        Assert.isTrue(bingoMill.getBingoCards().size() > 0, "createBingoCard");
    }

    @Test
    void drawNumber() {
        List<Integer> drawNumbers = new ArrayList<>();
        for (int i = 0; i < 75; i++) {
            int drawNumber = bingoMill.drawNumber();
            drawNumbers.add(drawNumber);
            Assert.hasText("#" + drawNumber + ";", bingoMill.drawNumbers);
            Assert.isTrue(Collections.frequency(drawNumbers, drawNumber) == 1, "Check duplicated numbers");
        }
        Assert.isTrue(drawNumbers.size() == 75, "Check if 75 numbers are drawn");
        System.out.print("Drawn numbers:" + drawNumbers);
    }
}