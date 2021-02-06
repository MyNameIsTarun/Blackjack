package Blackjack;

import java.util.Scanner;

/**
 *
 * @author Tarun
 */
public class GamePlay {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Deck deck = new Deck();
        deck.shuffle();
        
        Hand hand = new Hand();
        
        System.out.println(Utility.hitOrStand(deck, hand));
        System.out.println(hand.getValue());
    }
}
