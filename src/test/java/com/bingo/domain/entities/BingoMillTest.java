package com.bingo.domain.entities;

import com.bingo.domain.builders.BingoMillBuilder;
import com.bingo.domain.enums.BingoCardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BingoMillTest {

    private BingoMill bingoMill;

    @BeforeEach
    void setUp() {
        bingoMill = new BingoMillBuilder();
    }

    @Test
    void getId() {
        assertNotNull(bingoMill.getId());
    }

    @Test
    void addDrawNumber() {
        assertEquals("", bingoMill.getDrawNumbers());
        bingoMill.addDrawNumber(10);
        assertEquals("#10;", bingoMill.getDrawNumbers());
        bingoMill.addDrawNumber(20);
        assertEquals("#10;#20;", bingoMill.getDrawNumbers());
        // Double drawn numbers are not allowed
        int beforeSize = splitNumbers(bingoMill.getDrawNumbers()).size();
        bingoMill.addDrawNumber(10);
        int afterSize = splitNumbers(bingoMill.getDrawNumbers()).size();
        assertEquals(beforeSize, afterSize);
    }

    @Test
    void getDrawNumbers() {
        assertNotNull(bingoMill.getDrawNumbers());
    }

    @Test
    void getMinimumNumber() {
        assertEquals(1, bingoMill.getMinimumNumber());
    }

    @Test
    void getMaximumNumber() {
        assertEquals(75, bingoMill.getMaximumNumber());
    }

    @Test
    void getBingoCardType() {
        assertNotNull(bingoMill.getBingoCardType());
    }

    @Test
    void setBingoCardType() {
        ((BingoMillBuilder) bingoMill).setBingoCardType(BingoCardType.random);
        assertEquals(BingoCardType.random, bingoMill.getBingoCardType());
        ((BingoMillBuilder) bingoMill).setBingoCardType(BingoCardType.special);
        assertEquals(BingoCardType.special, bingoMill.getBingoCardType());
        ((BingoMillBuilder) bingoMill).setBingoCardType(BingoCardType.normal);
        assertEquals(BingoCardType.normal, bingoMill.getBingoCardType());
    }

    /**
     * This is not a test method.
     * An algorithm helps the test methods to get a list from string.
     *
     * @param numberString string with numbers
     * @return list of numbers
     */
    private List<Long> splitNumbers(String numberString) {
        List<Long> numberList = new ArrayList<>();
        if (!numberString.equals("")) {
            String[] split = numberString.replaceAll(";", "").split("#");
            numberList = Arrays.stream(split).map(Long::getLong).collect(Collectors.toList());
        }
        return numberList;
    }
}