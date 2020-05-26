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
public class OutOfGas implements Card {
    boolean Gas;
    Game games;
    
    public OutOfGas(boolean pGas,Game pGames){
        Gas = pGas ;
        games = pGames;
    }
    
    // player will need roll card again afer outofGas
    @Override
    public void execute(){
        if(games.getNextplayer().checkReady() == true){
            games.getNextplayer().addGas(Gas);
            games.getCurrentplayer().remove();
            games.nextPlayer();
        }else {
            System.out.println("Can't use this card!");
        }
        
    }
    
    @Override
    public String toString(){
        return "Out of Gas";
    }
}
