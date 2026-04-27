package com.mycompany.space_invaders.entities;



import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class gwiazda {

    public int x = 0;
    public int y = 0;
    public int g_wysokosc;
    public int g_szerokosc;
    public int g_speed;
    private Random rand = new Random();
    private Random rgb = new Random();
    public int Game_szerokosc;
    public int Game_wysokosc;

    public gwiazda(int x, int y, int w, int h, int s, int game_szerokosc, int game_wysokosc) {
        this.x = x;
        this.y = y;
        this.Game_szerokosc = game_szerokosc;
        this.Game_wysokosc = game_wysokosc;
        this.g_szerokosc = w;
        this.g_wysokosc = h;
        this.g_speed = s;
    }

    public void losowanie() {
        x = rand.nextInt(Game_szerokosc);
        g_speed = rand.nextInt(5);
        y = rand.nextInt(Game_wysokosc) - Game_wysokosc;
        g_szerokosc = rand.nextInt(5) + 1;
        g_wysokosc = rand.nextInt(5) + 1;
    }

    public void move() {
        y = y + g_speed;
        if (y > 800) {
            y = 0;
            losowanie();
        }
    }

    public void draw(Graphics g) {
        int red = rgb.nextInt(100) + 150;
        int green = rgb.nextInt(100) + 150;
        int blue = rgb.nextInt(100) + 150;
        g.setColor(new Color(red, green, blue));
        g.fillOval(x, y, g_szerokosc, g_wysokosc);
    }
}
