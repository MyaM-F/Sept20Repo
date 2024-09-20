/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Scanner;
import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */

public class CardTrick { 
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);  // Random card value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]);  // Random suit from SUITS array
            magicHand[i] = c;
        }
        
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a card (Enter a value between 1 and 13): ");
        int userValue = input.nextInt();
        System.out.println("Pick a suit (Enter 0 for Hearts, 1 for Diamonds, 2 for Spades, 3 for Clubs): ");
        int userSuitIndex = input.nextInt();
        String userSuit = Card.SUITS[userSuitIndex];
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                cardFound = true;
                break;
            }
        }
        
        if (cardFound) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is NOT in the magic hand.");
        }
        
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        System.out.println("The lucky card is: 2 of Clubs");
        
        if (userCard.getValue() == luckyCard.getValue() && userCard.getSuit().equals(luckyCard.getSuit())) {
            System.out.println("Congratulations! You picked the lucky card!");
        }
    }
}
