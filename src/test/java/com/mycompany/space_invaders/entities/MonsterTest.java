package com.mycompany.space_invaders.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {

    @Test
    public void testMonsterInitialization() {
        monster m = new monster(100, 200, 40, 40, 5, 0, true);
        
        assertEquals(100, m.x_monster);
        assertEquals(200, m.y_monster);
        assertEquals(40, m.monsters_szerokosc);
        assertEquals(40, m.monsters_wysokosc);
        assertTrue(m.movePrawo, "Monster should move right by default");
        assertTrue(m.isVis, "Monster should be visible");
    }
}
