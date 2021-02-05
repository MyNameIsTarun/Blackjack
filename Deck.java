package Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tarun
 */

//This class is used to create the deck object
//which consist of 52 card objects
//and provides some mehods to work on the deck object
public class Deck {
    
    //arrays for suits and ranks of cards
    //this will help to create deck of Card objects
    private final String []suits = {"Hearts","Diamonds","Spades","Clubs"};
    private final String []ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    
    //this will hold the 52 card objects
    private List<Card> deck = new ArrayList<>();
    
    public Deck(){
        //creating deck by adding card objects to deck list
        for(String suit : suits){
            for(String rank : ranks){
                deck.add(new Card(suit,rank));
            }
        }
    }
    
    public List<Card> getDeck(){
        return deck;
    }
    
    //this method shuffles the deck at inplace
    public void shuffle(){
        Collections.shuffle(deck);
    }
    
    //this will remove one card from the end of the deck
    public Card deal_one(){
        return deck.remove(deck.size()-1);
    }
}
