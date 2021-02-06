package Blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tarun
 */
public class Utility {
    
    static final Scanner sc = new Scanner(System.in);
        
    //method for asking if player wants to hit or stand
    //and return 'h' if hit and 's' if he stands
    public static String hitOrStand(Deck deck, Hand hand){
        
        while(true){
            System.out.println("Hit or Stand? Enter h or s: ");
            String choice = sc.nextLine();
            
            if(choice.toLowerCase().charAt(0) == 'h'){
                hit(deck,hand);
                return "h";
            }
            else if(choice.toLowerCase().charAt(0) == 's'){
                System.out.println("Player Stands Dealers Turn ");
                return "s";
            }
            else{
                System.out.println("Sorry, I did not understand that, Please enter h or s only!");
            }
        }
    }
    
    //method for hit functionality
    public static void hit(Deck deck,Hand hand){
        hand.addCard(deck.deal_one());
        hand.adjustForAce();
    }
    
    //method for taking players bet
    public static int takeBet(Chips chips){
        int bet;
        while(true){
            
            try{
                System.out.println("How many chips would you like to bet? ");
                bet = sc.nextInt();
                //if bet amount is smaller than 10 
                //then object of custom InvalidBetException class will be thrown
                if(bet < 10){
                    throw new InvalidBetException();
                }
                //if Bet amount is greater than players total amount
                else if(bet > chips.getTotal()){
                    System.out.println("Sorry, you do not have enough chips! You have: "+chips.getTotal()+" chips.");
                }
                else{
                    return bet;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Sorry please provide an integer.");
                sc.nextLine();
            }
            catch(InvalidBetException e){
                System.out.println("Please Bet an amount greater or equal to 10");
            }
        }
    }
    
    //if player cards value is greater than 21
    public static void playerBusts(int bet, Chips chips){
        System.out.println("BUST PLAYER!");
        chips.loseBet(bet);
    }
    
    //if player cards value is greater than dealers cards value
    public static void playerWins(int bet, Chips chips){
        System.out.println("PLAYER WINS!");
        chips.winBet(bet);
    }
    
    //if dealer cards value is greater than 21
    public static void dealerBusts(int bet, Chips chips){
        System.out.println("PLAYER WINS! DEALER BUSTED!");
        chips.winBet(bet);
    }
    
    //if dealer cards value is greater than players cards value
    public static void dealerWins(int bet, Chips chips){
        System.out.println("DEALER WINS!");
        chips.loseBet(bet);
    }
    
    //if both have same cards value
    public static void push(){
        System.out.println("Player and Dealer tie! PUSH");
    }
}
