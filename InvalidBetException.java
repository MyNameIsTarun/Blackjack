package Blackjack;

/**
 *
 * @author Tarun
 */

//Custom exception class for invalid Bet amount
public class InvalidBetException extends RuntimeException{
    
    public InvalidBetException(String s){
        super(s);
    }
    
    public InvalidBetException(){
        
    }
}
