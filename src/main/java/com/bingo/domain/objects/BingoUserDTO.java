package com.bingo.domain.objects;

public class BingoUserDTO {
    private String id;
    private String username;
    private String backgroundColor;

    protected BingoUserDTO() {}

    public BingoUserDTO(String id, String username, String backgroundColor) {
        this.id = id;
        this.username = username;
        this.backgroundColor = backgroundColor;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }
}
