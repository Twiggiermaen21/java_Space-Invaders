package com.mycompany.space_invaders;

import java.awt.Color;
import java.awt.Graphics;


public class ShotAlien {

    public int setY;
    public int shot_szerokosc;
    public int shot_wysokosc;
    public int x_shot;
    public int y_shot;
    public int speed;
    boolean goDown;
    public boolean Vis;
    public boolean free;

    public ShotAlien(int x, int y, int w, int h, int s, boolean vis) {
        this.free = true;
        this.Vis = vis;
        this.goDown = false;
        this.setY = y;
        this.speed = s;
        this.shot_szerokosc = w;
        this.shot_wysokosc = h;
        this.x_shot = x;
        this.y_shot = y;
    }

    public void move() {
        if (y_shot > 900) {
            goDown = false;
            y_shot = setY;
        }
        if (goDown) {
            y_shot = y_shot + speed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x_shot, y_shot, shot_szerokosc, shot_wysokosc);
    }
}
