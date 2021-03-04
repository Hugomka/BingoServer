package Models.Builders;

import Models.Entities.User;

import java.awt.*;
import java.util.UUID;

public class UserBuilder extends User {
    public UserBuilder(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.backgroundColor = "#" + Integer.toHexString(Color.blue.getRGB());
    }
}
