package Blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tarun
 */

//this class provides all the functionalities required to play the game
//by providing static methods
public class Utility {
    
    static final Scanner sc = new Scanner(System.in);
        
    //method for asking if player wants to hit or stand
    //and returning h if he hits and s if player stands
    public static char hitOrStand(Deck deck, Hand hand){
        
        //till he provide right input
        while(true){
            System.out.println("Hit or Stand? Enter h or s: ");
            String choice = sc.nextLine();
            
            if(choice.toLowerCase().charAt(0) == 'h'){
                hit(deck,hand);
                return 'h';
            }
            else if(choice.toLowerCase().charAt(0) == 's'){
                System.out.println("Player Stands Dealers Turn ");
                return 's';
            }
            else{
                System.out.println("Sorry, I did not understand that, Please enter h or s only!");
            }
        }
    }
    
    //method for hit functionality
    //adding card to the hand
    public static void hit(Deck deck,Hand hand){
        hand.addCard(deck.dealOne());
        hand.adjustForAce();
    }
    
    //method for taking players bet
    public static int takeBet(Chips chips){
        int bet;
        //till he provide right amount
        while(true){
            
            try{
                System.out.println("How many chips would you like to bet? ");
                bet = sc.nextInt();
                //if bet amount is smaller than 5 
                //then object of custom InvalidBetException class will be thrown
                if(bet < 5){
                    throw new InvalidBetException();
                }
                //if Bet amount is greater than players total amount
                else if(bet > chips.getTotal()){
                    System.out.println("Sorry, you do not have enough chips! You have: "+chips.getTotal()+" chips.");
                    sc.nextLine();
                }
                else{
                    //to flush buffer before going to hitOrStand
                    //because there we will be taking string as input
                    sc.nextLine();
                    return bet;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Sorry please provide an integer.");
                sc.nextLine();
            }
            catch(InvalidBetException e){
                System.out.println("Please Bet an amount greater or equal to 5");
                sc.nextLine();
            }
        }
    }
    
    //if player cards value is greater than 21
    public static void playerBusts(int bet, Chips chips){
        System.out.println("PLAYER BUSTED!");
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
    
    //method for showing some cards of dealers hand
    //and all cards of players hand
    public static void showSome(Hand player, Hand dealer){
        System.out.println("\nDEALERS HAND: ");
        
        //showing first card of dealer and hiding the second
        System.out.print(dealer.getCards().get(0));
        System.out.println("       one card hidden!");
        
        //showing players all cards
        System.out.println("\nPLAYERS HAND: ");
        for(Card card : player.getCards()){
            System.out.print(card+"       ");
        }
        System.out.println("\n");
    }
    
    //method for showing all cards of dealer and player hands
    public static void showAll(Hand player, Hand dealer){
        System.out.println("\nDEALERS HAND: ");
        
        //showing dealers all cards
        for(Card card : dealer.getCards()){
            System.out.print(card+"       ");
        }
        
        //showing players all cards
        System.out.println("\n\nPLAYERS HAND: ");
        for(Card card : player.getCards()){
            System.out.print(card+"       ");
        }
        System.out.println("\n");
    }
}
