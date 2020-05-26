/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author zarni
 */

public class Player implements Card {
    int MAX_MILEAGE = 250;  
    String name;        // player name
    int totalMileage;   // travelled miles
    boolean GoStop = false; // boolean value for Go or Stop Card
                            // // default value is false until get a Go Card
    boolean Drivingace = false; // boolean value for DrivingAce 
    int removeCardIndex;    // helper 
    
   
    
    Game games;
    public List<Card>cards;
    
    
    public Player(String pName,Game pGames){
        name = pName;
        cards = new ArrayList<>();  // player holds 7 cards in the arrayList
        games = pGames;
    }
    
    
    
    // when player use DrivingAce card, this functin will change the 
    // boolean value of Drivingace
    public void drivingAce(boolean pDrivingace){
        Drivingace = pDrivingace;
    }
    public boolean getDrivingace(){ // get currentuser drivingAce boolean value
        return Drivingace;
    }
    
    // add mile into travelled miles
    public void addMileage(int pMile){
        totalMileage = totalMileage + pMile;
        
        if (totalMileage == MAX_MILEAGE ){ // if total mileage equal to 250, the player win
            System.out.println(name + " is Winner!");
            System.exit(0);
        }
        if(totalMileage >= MAX_MILEAGE){    // if total mileage over the 250, the player lose
            System.out.println(games.getNextplayer().getPlayername() + " is Winner!");
            System.exit(0);
        }
        
    }
    public int getCurrentmileage(){ // return current player travelled milleages
        return totalMileage;
    }
    
    
    
    // when player play 'Go Card' or 'Stop Card'
    // this function change the boolean value of 'GoStop'
    public void goStop(boolean pGo){
        GoStop = pGo;
    }
    public boolean checkReady(){
        return GoStop;
    }
    
    // add card from player card list
    public void add(Card pCard){
        cards.add(pCard);
    }
    // remove card from player card list
    public void remove(){
        cards.remove(removeCardIndex);
    }
    
    @Override
    public void execute(){
        
        // print out the player card list
        System.out.println("\n \n");
        System.out.println(name + " current mileage : " + totalMileage);
        System.out.println(name + " trun! \n" + name + "'s cards.");
        for(int i=0; i<cards.size(); i++){
            System.out.println(i+1 + ". " + cards.get(i) );
        }
        
        // player can choose a card to play or dismiss
        System.out.print("Press 'p' to play a card or");
        System.out.println(" Press 'd' to dismiss a card.");
        Scanner in = new Scanner(System.in);
        char ch = in.next().trim().charAt(0);
        if ( ch == 'p' || ch == 'P'){
            int i = getChoice();
            removeCardIndex = i;
            cards.get(i).execute(); // execute the card that user choose
            }
        if ( ch == 'd' || ch == 'D'){
            int i = getChoice();
            cards.remove(i);        // dismiss the card
            games.nextPlayer();
        }
        
    }
    
    // player choose a card by number.
    // helper function
    private int getChoice(){
        Scanner in = new Scanner(System.in);
        System.out.println( "Pick a card from : (0-" + (cards.size() - 1) + ")" );
        int choice = in.nextInt();
        return choice-1;
    }
    
    public String getPlayername(){
        return name;
    }
    
    
    
}
