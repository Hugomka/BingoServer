package domain.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class BingoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    protected UUID id;

    @ManyToOne
    protected User user;

    protected BingoCard() {
    }

    public BingoCard(User user) {
        this();
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
