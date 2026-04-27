
package com.mycompany.space_invaders.core;

import com.mycompany.space_invaders.ui.*;
import com.mycompany.space_invaders.entities.*;
import com.mycompany.space_invaders.audio.*;
import com.mycompany.space_invaders.levels.*;
import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import java.awt.*;
import javax.swing.*;


public class Score extends Rectangle {

    private JPanel panel = new JPanel();
    public int GAME_WIDTH;
    public int GAME_HEIGHT;
    public int player;
    public int level;
    public int lives;
    public int boss_lives;

    Score(int GAME_WIDTH, int GAME_HEIGHT, int level, int lives, int zycie_bosa) {
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
        this.level = level;
        this.lives = lives;
        this.boss_lives = zycie_bosa;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Engravers MT", Font.BOLD, 20));
        FontMetrics metrics = panel.getFontMetrics(g.getFont());
        g.drawString("Score: " + String.valueOf(player / 10) + String.valueOf(player % 10), 10, 30);
        g.drawString("Level: " + String.valueOf(level), (GAME_WIDTH - metrics.stringWidth("Level: ")) / 2, 30);
        g.drawString("Lives: " + String.valueOf(lives), GAME_WIDTH - metrics.stringWidth("Lives: ") - metrics.stringWidth(String.valueOf(lives)) - 10, 30);
        if (level == 5) {
            g.drawString("BOOS HEALTH", (GAME_WIDTH - metrics.stringWidth("BOOS HEALTH")) / 2, 60);
            for (int i = 0; i < boss_lives; i++) {
                g.setColor(Color.white);
                g.drawRect((GAME_WIDTH - 500) / 2, 84, 502, 21);
                g.setColor(Color.red);
                g.drawString("|", (GAME_WIDTH - 500) / 2 + i, 100);
            }
        }
    }

    public void boss_health() {
        boss_lives = boss_lives - 5;
    }

    public boolean win() {
        if (boss_lives > 0) {
            return true;
        } else {
            return false;
        }
    }
}
