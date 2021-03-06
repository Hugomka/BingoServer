package domain.entities;

import domain.enums.UserRole;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    protected UUID id;
    protected String username;
    protected String backgroundColor;
    protected UserRole userRole = UserRole.Player;

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void switchUserRole() {
        userRole = userRole == UserRole.Player
                ? UserRole.Master
                : UserRole.Player;
    }
}
