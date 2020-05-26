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
public class Gasoline implements Card {
    boolean Gas;
    Game games;
    
    public Gasoline(boolean pGas,Game pGames){
        Gas = pGas;
        games = pGames;
    }
    
    @Override
    public void execute(){
        if(games.getCurrentplayer().getGas() == false){
            games.getCurrentplayer().addGas(Gas); 
        
            games.getCurrentplayer().remove();  // remove the card after played
            games.nextPlayer(); // next player turn
        }else {
            System.out.println("Can't use this card!");
        }
        
        
    }
    
    @Override
    public String toString(){
        return "Gasoline";
    }
}
