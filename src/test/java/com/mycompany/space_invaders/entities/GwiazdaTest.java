package com.mycompany.space_invaders.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GwiazdaTest {

    @Test
    public void testGwiazdaInitialization() {
        gwiazda g = new gwiazda(50, 50, 2, 2, 3, 800, 600);
        
        assertEquals(50, g.x);
        assertEquals(50, g.y);
        assertEquals(3, g.g_speed);
    }

    @Test
    public void testGwiazdaMoveAndReset() {
        gwiazda g = new gwiazda(50, 801, 2, 2, 5, 800, 600);
        g.move(); // y passes 800, so it calls losowanie()
        
        assertTrue(g.y <= 0, "Gwiazda Y should be reset to 0 or less (randomized) after passing 800");
    }
}
