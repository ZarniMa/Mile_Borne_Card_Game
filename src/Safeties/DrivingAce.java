/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Safeties;

import hw2.Card;
import hw2.Game;

/**
 *
 * @author zarni
 */

// DRIVING ACE CARD: When displayed in your Safety Area, your
// opponents cannot play an Accident Card onto your Battle Pile.

public class DrivingAce implements Card {
    boolean Drivingace;
    Game games;
    
    public DrivingAce(Game pGames){
        Drivingace = true;
        games = pGames;
    }
    
    @Override
    public void execute(){
        
        games.getCurrentplayer().drivingAce(Drivingace);
        games.getCurrentplayer().remove();
        games.nextPlayer();
            
    }
    
    @Override
    public String toString(){
        return "Driving Ace";
    }
}
