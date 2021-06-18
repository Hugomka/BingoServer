package com.bingo.domain.objects;

import java.util.UUID;

public class BingoCardDTO {
    private UUID bingoUserId;
    private UUID bingoMillId;

    protected BingoCardDTO() {}

    public BingoCardDTO(UUID bingoUserId, UUID bingoMillId) {
        this.bingoUserId = bingoUserId;
        this.bingoMillId = bingoMillId;
    }

    public UUID getBingoUserId() {
        return bingoUserId;
    }

    public UUID getBingoMillId() {
        return bingoMillId;
    }
}
