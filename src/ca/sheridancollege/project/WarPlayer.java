package ca.sheridancollege.project;

public abstract class WarPlayer extends Player {

    public WarPlayer(String name) {
        super(name);
    }

    public Card playCard() {
        // Implement the logic to remove a card from the player's hand and return it
        return null;
    }

    public void win() {
        // Implement the logic for a win
    }

    public void lose() {
        // Implement the logic for a loss
    }
}
