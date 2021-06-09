package com.bingo.domain.builders;

import com.bingo.domain.entities.BingoRow;

import java.util.Random;
import java.util.UUID;

public class BingoRowBuilder extends BingoRow {
    public BingoRowBuilder() {
        this.id = UUID.randomUUID();
        this.numbers = generate();
    }

    private String generate() {
        Random random = new Random();
        int b = random.nextInt(15) + 1;
        int i = random.nextInt(15) + 16;
        int n = random.nextInt(15) + 31;
        int g = random.nextInt(15) + 46;
        int o = random.nextInt(15) + 61;
        return String.format("%d,%d,%d,%d,%d", b, i, n, g, o);
    }
}
