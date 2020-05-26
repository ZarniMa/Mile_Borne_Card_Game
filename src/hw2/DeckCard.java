/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author zarni
 */
public class DeckCard {
    
    private  ArrayDeque<Card> deckCards; // for distribution
    
    public DeckCard(){
        deckCards = new ArrayDeque<>();
        // deckCards = new ArrayDeque<>(ArrayList);
    }
    
    public void addDeckCard(Card pCard){
        deckCards.add(pCard);
    }
    
    // distribute the top card
    public Card getCard(){
        return deckCards.getFirst();
    }
    
    // after add into player card list, 
    // this card should remove from the Stack
    // call this function, after add into player card list
    public void removeCard(){
        deckCards.removeFirst();
    }
      
}
