package com.mycompany.space_invaders.entities;



import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class monster {

    public int monsters_szerokosc;
    public int monsters_wysokosc;
    public int x_monster;
    public int y_monster;
    private Image img_monster1, img_monster2, img_monster3, img_boss;
    public boolean moveLewo;
    public boolean movePrawo;
    public int speed;
    public int png;
    public boolean isVis;

    public monster(int x_monster, int y_monster, int monsters_szerokosc, int monsters_wysokosc, int speed, int png, boolean Vis) {
        this.monsters_szerokosc = monsters_szerokosc;
        this.monsters_wysokosc = monsters_wysokosc;
        this.x_monster = x_monster;
        this.y_monster = y_monster;
        this.isVis = Vis;
        this.movePrawo = true;
        this.png = png;
        this.speed = speed;
        this.img_monster1 = new ImageIcon("files/enemy1.png").getImage();
        this.img_monster2 = new ImageIcon("files/enemy2.png").getImage();
        this.img_monster3 = new ImageIcon("files/enemy3.png").getImage();
        this.img_boss = new ImageIcon("files/boss.png").getImage();
    }
    
    public void draw(Graphics g) {
        if (png == 0) {
            g.drawImage(img_monster1, x_monster, y_monster, monsters_szerokosc, monsters_wysokosc, null);
        } else if (png % 2 == 1) {
            g.drawImage(img_monster2, x_monster, y_monster, monsters_szerokosc, monsters_wysokosc, null);
        } else if (png % 2 == 0 && png != 10) {
            g.drawImage(img_monster3, x_monster, y_monster, monsters_szerokosc, monsters_wysokosc, null);
        } else if (png == 10) {
            g.drawImage(img_boss, x_monster, y_monster, monsters_szerokosc, monsters_wysokosc, null);
        }
    }
}
