package com.mycompany.space_invaders.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        player p = new player(100, 200, 50, 60);
        
        // Assertions for initial state
        assertEquals(100, p.x, "Initial X should be 100");
        assertEquals(200, p.y, "Initial Y should be 200");
        assertEquals(50, p.player_szerokosc, "Width should be 50");
        assertEquals(60, p.player_wysokosc, "Height should be 60");
    }

    @Test
    public void testPlayerMovement() {
        player p = new player(100, 200, 50, 50);
        
        // Move right
        p.setXDirection(10);
        p.move();
        assertEquals(110, p.x, "Player should move 10 pixels to the right");
        
        // Move left
        p.setXDirection(-20);
        p.move();
        assertEquals(90, p.x, "Player should move 20 pixels to the left");
    }
}
