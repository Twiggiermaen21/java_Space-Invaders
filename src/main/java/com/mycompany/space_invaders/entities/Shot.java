package com.mycompany.space_invaders.entities;

import com.mycompany.space_invaders.ui.*;
import com.mycompany.space_invaders.entities.*;
import com.mycompany.space_invaders.audio.*;
import com.mycompany.space_invaders.levels.*;
import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import java.awt.Graphics;
import java.awt.*;

import javax.swing.ImageIcon;

public class Shot extends Rectangle {

    public int setY;
    public int shot_szerokosc;
    public int shot_wysokosc;
    public int x_shot;
    public int y_shot;
    public int speed;
    public boolean goUp;
    private Image image5;
    public boolean moveRight;
    public boolean moveLeft;

    public Shot(int x, int y, int w, int h, int s) {
        this.goUp = false;
        this.setY = y;
        this.speed = s;
        this.shot_szerokosc = w;
        this.shot_wysokosc = h;
        this.x_shot = x;
        this.y_shot = y;
    }

    public void move() {
        if (y_shot < 0) {
            goUp = false;
            y_shot = setY;
        }
        if (goUp) {
            y_shot = y_shot - speed;
        }
    }

    public void draw(Graphics window) {
        image5 = new ImageIcon("files/ashot.png").getImage();
        window.drawImage(image5, x_shot, y_shot, 10, 10, null);
    }
}
