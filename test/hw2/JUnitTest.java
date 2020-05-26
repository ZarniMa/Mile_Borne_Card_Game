/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import Distance.Mileage;
import Hazards.Stop;
import Remedies.GoRollDrive;
import Safeties.DrivingAce;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zarni
 */
public class JUnitTest {
    
    Game games;
    Player player1,player2;
    
    @Before
    public void setUp() {
        games = new Game();
        player1 = new Player("Player1",games);
        player2 = new Player("Player2",games);
        games.add(player1);
        games.add(player2);
    }
    
    // Remeies
    @Test // test Go/Roll/Driver Card. player1 shoudl have true value after used Go/Roll/Card
    public void testGocard(){
        player1.add(new GoRollDrive(games));
        player1.cards.get(0).execute();
        assertTrue(player1.checkReady());
    }
    
    // Distance
    @Test   // test Mileage Card, player 1 should have 200 miles after use 200 mileage card
    public void testMileage(){
        player1.add(new Mileage(200,games));
        player1.goStop(true);
        player1.cards.get(0).execute();
        assertEquals(200,player1.getCurrentmileage());
    }
    
    @Test // without Go/Roll/Drive Card, player1 can't player mileageCard
            // so player1 currentmileage is still zero.
    public void testMileage2(){
        player1.add(new Mileage(200,games));
        player1.cards.get(0).execute();
        assertEquals(0,player1.getCurrentmileage());
    }
    
    // Hazards
    @Test // test Stop Card, player2 shoudl have false value after player1 used Stop Card
    public void testStop(){
        player1.add(new Stop(games));
        player1.cards.get(0).execute();
        assertFalse(player2.checkReady());
    }
    
    // Safeties 
    @Test // test Driving Ace Card, player1 should have true value after player1 use DrivingAce Card
    public void testDrivingace(){
        player1.add(new DrivingAce(games));
        player1.cards.get(0).execute();
        assertTrue(player1.getDrivingace());
    }
    
    @After
    public void tearDown() {
    }
    
}
