package Blackjack;

/**
 *
 * @author Tarun
 */

//This class is assumed as the players account
//from which he will take bets
public class Chips {
    
    //this can be assumed as the players total(initial) amount 
    //from which he will play the game
    private int total;
    
    //paramatresized constructor to initialize players total(initial) amount
    public Chips(int total){
        this.total = total;
    }
    
    //default constructor to initialize players total(initial) amount by 100
    public Chips(){
        total = 100;
    }
    
    public int getTotal(){
        return total;
    }
    
    //adding bet to the players total if he wins
    public void winBet(int bet){
        total += bet;
    }
    
    //reducing bet amount if player loose the game
    public void looseBet(int bet){
        total -= bet;
    }
}
