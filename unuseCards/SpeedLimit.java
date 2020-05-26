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
public class SpeedLimit implements Card {
    boolean SpeedLimit;
    Game games;
    
    public SpeedLimit(boolean pSpeedlimit,Game pGames){
        SpeedLimit = pSpeedlimit ;
        games = pGames;
    }
    
    @Override
    public void execute(){
        if(games.getNextplayer().getSpeedlimit() == false){
            games.getNextplayer().speedLimit(SpeedLimit);
            games.getCurrentplayer().remove();
            games.nextPlayer();
        }else {
            System.out.println("Can't use this card!");
        }
        
    }
    
    @Override
    public String toString(){
        return "Speed Limit";
    }
}
