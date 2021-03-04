package Models.Entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class BingoMill {
    @Id
    protected UUID id;

    @OneToMany
    public List<BingoCard> bingoCards = new ArrayList<>();
    public String drawNumbers = "";

    public void createBingoCard(User user) {
        bingoCards.add(new BingoCard(user));
    }

    public int drawNumber() {
        Random random = new Random();
        int drawNumber;
        while(true) {
            drawNumber = random.nextInt(75) + 1;
            if (!drawNumbers.contains("#" + drawNumber + ";")) {
                drawNumbers += ("#" + drawNumber + ";");
                break;
            }
        }
        return drawNumber;
    }

    public List<BingoCard> getBingoCards() {
        return bingoCards;
    }

    public String getDrawNumbers() {
        return drawNumbers;
    }
}


