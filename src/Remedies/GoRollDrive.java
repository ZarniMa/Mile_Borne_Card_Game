/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remedies;

import hw2.Card;
import hw2.Game;

/**
 *
 * @author zarni
 */

// A ROLL! CARD (Green Light) must be displayed on your Battle Pile
// before your team can play any Distance Cards. (For the one
// exception to this rule, see paragraph on RIGHT OF WAY CARD.)

// for HW2, I use 'G0/Roll/Drive Card' for remedies type card
public class GoRollDrive implements Card {
    boolean ready;
    Game games;
    
    public GoRollDrive(Game pGames){
        ready = true;
        games = pGames;
    }
    
    @Override
    public void execute(){
        if(games.getCurrentplayer().checkReady() == false){ // if already use a card, doesn't allow to use again
            
            games.getCurrentplayer().goStop(ready);
            games.getCurrentplayer().remove();
            games.nextPlayer();

        }else {
            System.out.println("Can't use this card!");
        }
        
            }
    
    @Override
    public String toString(){
        return "Go/Roll/Drive";
    }
}
