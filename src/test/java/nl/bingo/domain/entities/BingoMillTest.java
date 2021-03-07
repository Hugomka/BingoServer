package nl.bingo.domain.entities;

import nl.bingo.domain.builders.BingoUserBuilder;
import org.junit.jupiter.api.*;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class BingoMillTest {

    BingoMill bingoMill;
    BingoUser bingoUser;

    @BeforeEach
    void setUp() {
        bingoUser = new BingoUserBuilder("BingoUserTest");
        bingoMill = new BingoMill();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createBingoCard() {
        bingoMill.createBingoCard(bingoUser);
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