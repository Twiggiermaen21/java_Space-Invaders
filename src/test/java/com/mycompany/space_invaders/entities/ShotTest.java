package com.mycompany.space_invaders.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShotTest {

    @Test
    public void testShotInitialization() {
        Shot s = new Shot(50, 500, 10, 10, 15);
        
        assertEquals(50, s.x_shot, "Shot X initialized correctly");
        assertEquals(500, s.y_shot, "Shot Y initialized correctly");
        assertEquals(15, s.speed, "Shot speed initialized correctly");
        assertFalse(s.goUp, "Shot should not be going up initially");
    }

    @Test
    public void testShotMovement() {
        Shot s = new Shot(50, 500, 10, 10, 15);
        s.goUp = true;
        s.move();
        
        assertEquals(485, s.y_shot, "Shot should move up by its speed (500 - 15 = 485)");
    }
    
    @Test
    public void testShotResetWhenOutOfBounds() {
        Shot s = new Shot(50, 10, 10, 10, 20);
        s.goUp = true;
        s.move(); // y_shot becomes -10
        s.move(); // y_shot is < 0, so it should trigger reset
        
        assertFalse(s.goUp, "Shot should stop going up after reset");
        assertEquals(10, s.y_shot, "Shot Y should be reset to initial setY");
    }
}
