import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    private final String rank;
    private final String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}

class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}

public class CardGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        // Simulate a simple card game
        while (deck.size() >= 2) {
            Card player1Card = deck.draw();
            Card player2Card = deck.draw();

            System.out.println("Player 1: " + player1Card);
            System.out.println("Player 2: " + player2Card);

            int comparison = player1Card.getRank().compareTo(player2Card.getRank());

            if (comparison > 0) {
                System.out.println("Player 1 wins!");
            } else if (comparison < 0) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println();
        }

        System.out.println("Game over!");
    }
}
