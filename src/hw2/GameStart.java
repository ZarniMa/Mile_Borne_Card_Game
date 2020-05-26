/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import Remedies.GoRollDrive;
import Distance.Mileage;
import Hazards.Stop;
import Safeties.DrivingAce;
import java.util.Scanner;

/**
 *
 * @author zarni
 */
public class GameStart {
    // Game start from here
    public static void main(String[] args) {
        
        Game games = new Game();
        Player player1 = new Player("Player 1",games);
        Player player2 = new Player("Player 2",games);
        games.add(player1);
        games.add(player2);
        
        System.out.println("Please enter 0 for testing without randomized or");
        System.out.println("enter 1 for rendomized the cards.");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if ( num == 0){
            
            player1.add(new Mileage(250,games));
            player1.add(new Mileage(200,games));
            player1.add(new Mileage(100,games));
            player1.add(new Mileage(50,games));
            player1.add(new GoRollDrive(games));
            player1.add(new Stop(games));
            player1.add(new DrivingAce(games));
            
            player2.add(new Mileage(250,games));
            player2.add(new GoRollDrive(games));
            player2.add(new Stop(games));
            player2.add(new DrivingAce(games));
            
            while(true){
                games.play();
            }
            
            
        }else {
            
            ShuffleCard shuffleCard = new ShuffleCard();
        
        // adding card into the deck card
        // in the deck card class, these cards will shuffle and add into stack
        for(int i=0; i<4; i++){    // add 4, 200 mile cards
           shuffleCard.addTempcard(new Mileage(200,games));
        }
        
        for(int i=0; i<12; i++){    // add 12, 100 miles cards
            shuffleCard.addTempcard(new Mileage(100,games));
        }
        
        for(int i=0; i<10; i++){    // add 10, 75 miles cards
            shuffleCard.addTempcard(new Mileage(75,games));
        }
        
        for(int i=0; i<10; i++){    // add 10, 50 miles cards
            shuffleCard.addTempcard(new Mileage(50,games));
        }
        
        for(int i=0; i<10; i++){    // add 10, 25 miles cards
            shuffleCard.addTempcard(new Mileage(25,games));
        }
        
        // number of card will worng check it later
        for(int i=0; i<14; i++){    
            shuffleCard.addTempcard(new GoRollDrive(games));
        }
        for(int i=0; i<5; i++){    
            shuffleCard.addTempcard(new Stop(games));
        }
        for(int i=0; i<5; i++){    
            shuffleCard.addTempcard(new DrivingAce(games));
        }
        
        // after add into arrayList, shuffle the arrayList
        shuffleCard.shuffling();
        
        // deckCard that hold shuffled card 
        DeckCard deckCard = new DeckCard();
        for(int i=0; i<shuffleCard.getShufflecards(); i++) {   // add whole list
            deckCard.addDeckCard(shuffleCard.getShuffledcard().get(i));
        }
        
        // card distribution
        for(int i=0; i<=5; i++){ // for player 1
            player1.add(deckCard.getCard());
            deckCard.removeCard();
        }
        for(int i=0; i<=5; i++){ // for player 2
            player2.add(deckCard.getCard());
            deckCard.removeCard();
        }
        
        
        while (true){
            
            // player 1
        if( player1.cards.size() < 7 ){ // each player should have 7 cards
            player1.add(deckCard.getCard());    
            deckCard.removeCard();
        }   
            // player 2
        if( player2.cards.size() < 7 ){ // each player should have 7 cards
            player2.add(deckCard.getCard());
            deckCard.removeCard();
        }
        
        
        //System.out.println(player1.getPlayername() + " current mileage " + player1.getCurrentmileage());
        games.play();  // execute the player 1 first
        
        }
            
        } // end of else 
        
    } // end of main
    
} // end of GameStart
