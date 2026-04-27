package com.mycompany.space_invaders.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShotAlienTest {

    @Test
    public void testShotAlienInitialization() {
        ShotAlien sa = new ShotAlien(100, 50, 10, 20, 10, true);
        
        assertEquals(100, sa.x_shot);
        assertEquals(50, sa.y_shot);
        assertFalse(sa.goDown, "Alien shot should not move down initially");
        assertTrue(sa.Vis);
        assertTrue(sa.free);
    }

    @Test
    public void testShotAlienMovement() {
        ShotAlien sa = new ShotAlien(100, 50, 10, 20, 10, true);
        sa.goDown = true;
        sa.move();
        
        assertEquals(60, sa.y_shot, "Alien shot should move down by its speed (50 + 10 = 60)");
    }

    @Test
    public void testShotAlienReset() {
        ShotAlien sa = new ShotAlien(100, 895, 10, 20, 10, true);
        sa.goDown = true;
        sa.move(); // y becomes 905, which is > 900
        
        assertFalse(sa.goDown, "Alien shot should stop moving down after reset");
        assertEquals(895, sa.y_shot, "Alien shot Y should be reset to initial setY");
    }
}
