package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WarGame {
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("Enter the number of matches you want to play:");
            int numMatches = Integer.parseInt(input.nextLine());

            System.out.println("How many continues ties do want to be allowed before going to the next match?");
            int maxTies = input.nextInt();
            input.nextLine();
            for (int j = 0; j < numMatches; j++) {
                Deck deck = new Deck();

            // shuffle the deck before dealing the cards
            Collections.shuffle(deck.getCards());

            List<Card> player1Cards = new ArrayList<>();
            List<Card> player2Cards = new ArrayList<>();

            // deal the cards to players
            for (int i = 0; i < deck.getCards().size(); i++) {
                if (i % 2 == 0) {
                    player1Cards.add(deck.getCards().get(i));
                } else {
                    player2Cards.add(deck.getCards().get(i));
                }
            }
        

            // play the game
            int round = 1;
            int numTies = 0;

            while (!player1Cards.isEmpty() && !player2Cards.isEmpty()) {
                System.out.println("Match: " + numMatches);
                System.out.println("\nRound " + round + ":");
                System.out.println("Player 1: " + player1Cards.get(0));
                System.out.println("Player 2: " + player2Cards.get(0));

                int result = player1Cards.get(0).getRank().getRankValue() - player2Cards.get(0).getRank().getRankValue();

                if (result > 0) {
                    player1Cards.add(player2Cards.get(0));
                    player2Cards.remove(0);
                    System.out.println("Player 1 wins the round.");
                    numTies=0;
                } else if (result < 0) {
                    player2Cards.add(player1Cards.get(0));
                    player1Cards.remove(0);
                    System.out.println("Player 2 wins the round.");
                    numTies=0;
                } else {
                    System.out.println("It's a tie!");
                    numTies++;
                }

                round++;
                input.nextLine();
                if (numTies >= maxTies){
                    System.out.println("There were a lot of continuous Ties. \nGoing to next Game.");
                    break;
                }
            }

            if (player1Cards.isEmpty()) {
                System.out.println("Player 2 wins the game!");
            } else {
                System.out.println("Player 1 wins the game!");
            }
        }
        
            
            System.out.println("Do you want to play again? (Y/N)");
        } while (input.nextLine().equalsIgnoreCase("Y"));

        input.close();
    
    }
}
