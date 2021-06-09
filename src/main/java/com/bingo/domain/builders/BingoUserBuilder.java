package com.bingo.domain.builders;

import com.bingo.domain.entities.BingoUser;

import java.awt.*;
import java.util.UUID;

public class BingoUserBuilder extends BingoUser {
    public BingoUserBuilder(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.backgroundColor = "#" + Integer.toHexString(Color.blue.getRGB()).substring(2);
    }
}
