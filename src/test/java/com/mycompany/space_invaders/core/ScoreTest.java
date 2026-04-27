package com.mycompany.space_invaders.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    @Test
    public void testScoreInitialization() {
        Score score = new Score(1600, 900, 5, 3, 500);
        
        assertEquals(1600, score.GAME_WIDTH);
        assertEquals(900, score.GAME_HEIGHT);
        assertEquals(5, score.level);
        assertEquals(3, score.lives);
        assertEquals(500, score.boss_lives);
    }

    @Test
    public void testBossHealthReduction() {
        Score score = new Score(1600, 900, 5, 3, 500);
        score.boss_health();
        
        assertEquals(495, score.boss_lives, "Boss health should decrease by 5");
    }

    @Test
    public void testWinCondition() {
        Score score = new Score(1600, 900, 5, 3, 5);
        
        assertTrue(score.win(), "Should return true because boss still has 5 health");
        
        score.boss_health(); // Health drops to 0
        
        assertFalse(score.win(), "Should return false because boss health is 0 (player won)");
    }
}
