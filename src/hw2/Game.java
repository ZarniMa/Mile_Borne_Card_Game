/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.ArrayDeque;

/**
 *
 * @author zarni
 */
public class Game {
    //private boolean makeReady = false;
    ArrayDeque<Player> games;
    //checkWinner winnerCheck;
    
    public Game(){
        games = new ArrayDeque<>();
        
    }
    
    public void add(Player pPlayer){
        games.addLast(pPlayer);
    }
    
    public Player getCurrentplayer(){
        return games.getFirst();
    }
    
    // it will have problem when more than 2 player.
    public Player getNextplayer(){
        return games.getLast();
    }
    
    // let the next player play 
    public void nextPlayer(){
        games.addLast(getCurrentplayer());
        games.removeFirst();
    }
    
    // remove current first player
    public void removeFirst(){
        games.removeFirst();
    }
    
    
    public void play(){
        
        getCurrentplayer().execute();
        
    }
    
    
}
