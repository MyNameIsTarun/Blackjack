package Blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tarun
 */
public class GamePlay {
    
    //method for taking players bet
    public static int takeBet(Chips chips){
        Scanner sc = new Scanner(System.in);
        
        
        while(true){
            int bet;
            try{
                System.out.println("How many chips would you like to bet? ");
                bet = sc.nextInt();
                //if bet amount is smaller than 10 
                //then object of custom InvalidBetException class will be thrown
                if(bet < 10){
                    throw new InvalidBetException();
                }
                
                //if Bet amount is greater than players total amount
                if(bet > chips.getTotal()){
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chips chip = new Chips(200);
        
        System.out.println(takeBet(chip));
    }
}
