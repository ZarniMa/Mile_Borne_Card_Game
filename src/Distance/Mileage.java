/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distance;

import hw2.Card;
import hw2.Game;

/**
 *
 * @author zarni
 */

//for HW2, I use 'Mile Card' for distance type card

public class Mileage implements Card {
    int mile;
    Game games;
    
    public Mileage(int pMile,Game pGames){
        mile = pMile;
        games = pGames;
    }
    
    @Override
    public void execute(){
        if (games.getCurrentplayer().checkReady() == true ){
            
                games.getCurrentplayer().addMileage(mile);
                games.getCurrentplayer().remove();
                games.nextPlayer();
            
        
            }else {
                System.out.println(games.getCurrentplayer().getPlayername() + " needs a Roll Card.");
            }
    }
    
    @Override
    public String toString(){
        return "Mileage " + mile;
    }
    
}
