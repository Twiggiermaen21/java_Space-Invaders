package com.mycompany.space_invaders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class player extends Rectangle {

    int xVelocity;
    int speed = 10;
    public int player_szerokosc;
    public int player_wysokosc;
    private Image img;

    player(int x, int y, int player_szerokosc, int player_wysokosc) {
        super(x, y, player_szerokosc, player_wysokosc);
        this.player_szerokosc = player_szerokosc;
        this.player_wysokosc = player_wysokosc;
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(-speed);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(speed);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setXDirection(-speed);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setXDirection(speed);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setXDirection(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setXDirection(0);
        }
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void move() {
        if (x > 0 || x < 800) {
            x = x + xVelocity;
        }
    }

    public void draw(Graphics g) {
        img = new ImageIcon("files/statek.png").getImage();
        g.drawImage(img, x, y, player_szerokosc, player_wysokosc, null);
    }
}
