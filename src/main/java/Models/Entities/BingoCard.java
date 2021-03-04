package Models.Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class BingoCard {
    @Id
    protected UUID id;

    @ManyToOne
    protected User user;

    public BingoCard() {
    }

    public BingoCard(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
