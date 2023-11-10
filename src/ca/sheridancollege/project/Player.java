package ca.sheridancollege.project;

public abstract class Player {
    private final String name;
    private GroupOfCards hand;

    public Player(String name) {
        this.name = name;
        this.hand = new GroupOfCards(0);
    }

    public String getName() {
        return name;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    public abstract Card playCard();

    public abstract void win();

    public abstract void lose();

    public abstract int compareHands(Player otherPlayer);
}
