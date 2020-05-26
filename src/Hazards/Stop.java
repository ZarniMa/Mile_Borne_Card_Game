/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hazards;

import hw2.Card;
import hw2.Game;

/**
 *
 * @author zarni
 */

// A STOP! CARD (Red Light) is played only onto your opponents’
// ROLL! Card, to prevent them from playing further Distance Cards
// until they can cover it with another ROLL! Card on a subsequent turn.

// for HW2, I use 'Stop Card' for hazards type card.

public class Stop implements Card {
    
    boolean ready;
    Game games;
    
    public Stop(Game pGames){
        ready = false ;
        games = pGames;
    }
    
    @Override
    public void execute(){
        if(games.getNextplayer().checkReady() == true){
            games.getNextplayer().goStop(ready);
            games.getCurrentplayer().remove();
            games.nextPlayer();
        }else {
            System.out.println("Can't use this card!");
        }
        
    }
    
    @Override
    public String toString(){
        return "Stop";
    }
}
