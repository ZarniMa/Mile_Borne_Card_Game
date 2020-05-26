/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author zarni
 */
public class ShuffleCard {
    private  ArrayList<Card>shuffleCards;   // for shuffle
    
    public ShuffleCard(){
        shuffleCards = new ArrayList<>();
    }
    // add into temp list
    // this list should shuffle
    public void addTempcard(Card pTempcard){
        shuffleCards.add(pTempcard);
    }
    
    // shuffle the tempCards list
    public void shuffling(){
        Collections.shuffle(shuffleCards);
    }
    
    // return List that shuffled
    public ArrayList<Card> getShuffledcard(){
        return shuffleCards;
    }
    
    //return size of shuffleCards
    public int getShufflecards(){
        return shuffleCards.size();
    }
}
