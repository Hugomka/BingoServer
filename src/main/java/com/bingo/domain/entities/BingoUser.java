package com.bingo.domain.entities;

import com.bingo.domain.enums.BingoUserRole;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "bingo_user")
public class BingoUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy ="org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, unique = true, length = 36)
    @Type(type = "uuid-char")
    protected UUID id;
    protected String username;
    protected String backgroundColor;
    protected BingoUserRole userRole = BingoUserRole.Player;

    public static BingoUser create(UUID bingoUserId) {
        var bingoUser = new BingoUser();
        bingoUser.id = bingoUserId;
        return bingoUser;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public BingoUserRole getUserRole() {
        return userRole;
    }

    public void switchUserRole() {
        userRole = userRole == BingoUserRole.Player
                ? BingoUserRole.Master
                : BingoUserRole.Player;
    }
}
