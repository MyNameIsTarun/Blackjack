package Blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tarun
 */

//This class can be thought as the players hand
//which contain some cards 
//and provide useful methods and functionalities
public class Hand {
    
    //value will hold the sum of values of cards
    private int value;
    //aces will hold the count of the aces in players Hand
    private int aces;
    //cards list will hold the players hands cards
    private List<Card> cards;
    
    public Hand(){
        value = 0;
        aces = 0;
        cards = new ArrayList();
    }
    
    public void addCard(Card card){
        value += card.getValue();
        
        if(card.getRank().equals("Ace")){
            aces += 1;
        }
        
        cards.add(card);
    }
    
    public void adjustForAce(){
        //If total value > 21 and I still hava an Ace
        //Then change the my Ace to 1 instead of 11
        while(value > 21 && aces > 0){
            value -= 10;
            aces--;
        }
    }
}
