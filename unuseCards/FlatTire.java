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
public class FlatTire implements Card {
    boolean Tire;
    Game games;
    
    public FlatTire(boolean pTire,Game pGames){
        Tire = pTire ;
        games = pGames;
    }
    
    @Override
    public void execute(){
        if(games.getNextplayer().checkReady() == true){
            games.getNextplayer().fixTire(Tire);
            games.getCurrentplayer().remove();
            games.nextPlayer();
        }else {
            System.out.println("Can't use this card!");
        }
        
    }
    
    @Override
    public String toString(){
        return "Flat Tire";
    }
}
