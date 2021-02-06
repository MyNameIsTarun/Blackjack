package Blackjack;

import java.util.Scanner;

/**
 *
 * @author Tarun
 */

//this is the class for final gameplay functioning
public class GamePlay {
    
    public static void main(String[] args) {
        
        while(true){
            System.out.println("WELCOME TO BLACKJACK!");
            
            //creating deck and shuffling
            Deck deck = new Deck();
            deck.shuffle();
            
            //creating hands of player and dealer
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            
            //adding 2 2 cards to both the hands
            for(int i=0;i<2;i++){
                playerHand.addCard(deck.dealOne());
                dealerHand.addCard(deck.dealOne());
            }
            
            //Initializing chips of player by default chips
            Chips playerChips = new Chips();
            
            //taking players bet
            int bet = Utility.takeBet(playerChips);
            
            //showing cards
            Utility.showSome(playerHand, dealerHand);
            
            //indicator of players turn that he can hit or stand
            boolean playing = true;
            //loop for players hit or stand
            while(playing){
                //asking for players hit or stand
                char choice = Utility.hitOrStand(deck, playerHand);
                
                //if player stand or busted(value > 21) then break
                if(choice == 's' || playerHand.getValue() > 21){
                    break;
                }
                
                //showing cards
                Utility.showSome(playerHand, dealerHand);
            }
            
            //if player hasn't busted, hit dealers hand until dealer reaches 17
            if(playerHand.getValue() < 21){
                while(dealerHand.getValue() < 17){
                    Utility.hit(deck, dealerHand);
                }
            }
            
            //showing all cards
            Utility.showAll(playerHand, dealerHand);
            
            //Run different winning scenarios
            if(playerHand.getValue() > 21){
                Utility.playerBusts(bet, playerChips);
            }
            else if(dealerHand.getValue() > 21){
                Utility.dealerBusts(bet, playerChips);
            }
            else if(dealerHand.getValue() > playerHand.getValue()){
                Utility.dealerWins(bet, playerChips);
            }
            else if(playerHand.getValue() > dealerHand.getValue()){
                Utility.playerWins(bet, playerChips);
            }
            else{
                Utility.push();
            }
            
            //showing players total chips
            System.out.println("\nPlayer total chips are : "+playerChips.getTotal());
            
            System.out.println("\nWould you like to play another hand? y/n : ");
            String newGame = (new Scanner(System.in)).nextLine();
            if(newGame.toLowerCase().charAt(0) == 'y'){
                continue;
            }
            else{
                System.out.println("Thank You for Playing!!!");
                break;
            }
        }
    }
}
