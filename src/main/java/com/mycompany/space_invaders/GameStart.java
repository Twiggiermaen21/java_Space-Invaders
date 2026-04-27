package com.mycompany.space_invaders;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameStart extends JPanel implements Runnable {
/////////////////////////////gra/////////////////////////////
    public boolean running;
    public int Game_szerokosc;
    public int Game_wysokosc;
    Thread gameThread;
    public int poziom;
/////////////////////////////Alien/////////////////////////////
    public int x_monster;
    public int y_monster;
    public int monsters_szerokosc;
    public int monsters_wysokosc;
    private int speed;
    public int png;
    public int liczba_monster = 0;
    public boolean Vis = true;
    monster[][] monsters;
    public int ilosc_monster;
/////////////////////////////Boss/////////////////////////////
    public int zycie_bosa;
/////////////////////////////Alien_pociski/////////////////////////////
    ShotAlien[] shotA;
    public boolean visA = true;
    public int speed_shotA;
    public int shotA_szerokosc;
    public int shotA_wysokosc;
/////////////////////////////Gracz//////////////////////////////
    private static final int player_szerokosc = 80;
    private static final int player_wysokosc = 80;
    player player;
    Score score;
    public int lives;
////////////////////////////////gracz_pocisk/////////////////////////////
    private static int numerstrzal = 0;
    Shot[] shot = new Shot[4];
//////////////////////////////////tlo//////////////////////////////////////////
    private static Image image2;
////////////////////////////////////gwiazdy///////////////////////////////
    private gwiazda[] Gwiazda = new gwiazda[50];
    private Random rand = new Random();
    public int x;
    public int y;
    public int g_wysokosc;
    public int g_szerokosc;
    public int g_speed;
    ////////////////////audio wybuchu/////////////////////
    private boomaudio audioboom = new boomaudio();
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    GameStart(int Game_szerokosc, int Game_wysokosc, int poziom) {
        this.Game_szerokosc = Game_szerokosc;
        this.Game_wysokosc = Game_wysokosc;
        this.poziom = poziom;
        level();
        gwiazdy();
        Dimension SCREEN_SIZE = new Dimension(Game_szerokosc, Game_wysokosc);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(Color.black);
        gameThread = new Thread(this);
        gameThread.start();
        Toolkit.getDefaultToolkit().sync();

    }

    public void level() {
        lives = 3;
        player = new player(Game_szerokosc / 2 - player_szerokosc / 2, Game_wysokosc - player_wysokosc - 20, player_szerokosc, player_wysokosc);
        for (int i = 0; i < shot.length; i++) {
            shot[i] = new Shot(-100, -100, 10, 10, 10);
        }
        if (poziom < 5) {
            png = 0;
            monsters_szerokosc = 40;
            monsters_wysokosc = 40;
            shotA_szerokosc = 10;
            shotA_wysokosc = 10;
            y_monster = 40;
            speed = 2;
        }
        if (poziom == 1) {
            ilosc_monster = 10;
            monsters = new monster[5][ilosc_monster];
            shotA = new ShotAlien[5];
            speed_shotA = 1;
        } else if (poziom == 2) {
            ilosc_monster = 15;
            monsters = new monster[5][ilosc_monster];
            shotA = new ShotAlien[10];
            speed_shotA = 2;
        } else if (poziom == 3) {
            ilosc_monster = 20;
            monsters = new monster[5][ilosc_monster];
            shotA = new ShotAlien[15];
            speed_shotA = 3;
        } else if (poziom == 4) {
            ilosc_monster = 25;
            monsters = new monster[5][ilosc_monster];
            shotA = new ShotAlien[20];
            speed_shotA = 5;
        } else if (poziom == 5) {
            monsters = new monster[1][1];
            shotA = new ShotAlien[5];
            speed = 2;
            speed_shotA = 6;
            ilosc_monster = 1;
            png = 10;
            monsters_szerokosc = 400;
            monsters_wysokosc = 100;
            y_monster = 120;
            shotA_szerokosc = 40;
            shotA_wysokosc = 40;
            zycie_bosa = 500;
        }
        score = new Score(Game_szerokosc, Game_wysokosc, poziom, lives, zycie_bosa);
        x_monster = Game_szerokosc / 2 - (monsters_szerokosc * ilosc_monster) / 2;
        visA = true;
        for (int i = 0; i < shotA.length; i++) {
            shotA[i] = new ShotAlien(-100, -10, shotA_szerokosc, shotA_wysokosc, speed_shotA, visA);
        }
        Vis = true;
        for (int j = 0; j < monsters.length; j++) {
            for (int i = 0; i < monsters[0].length; i++) {
                monsters[j][i] = new monster(x_monster, y_monster, monsters_szerokosc, monsters_wysokosc, speed, png, Vis);
                x_monster += monsters_szerokosc;
                liczba_monster++;
            }
            x_monster = Game_szerokosc / 2 - (monsters_szerokosc * ilosc_monster) / 2;
            y_monster += monsters_wysokosc;
            png++;

        }
        png = 0;
    }

    public void GameOver(Graphics g) {
        int pom = 0;
        for (int j = 0; j < monsters.length; j++) {
            for (int i = 0; i < monsters[0].length; i++) {
                if (monsters[j][i].isVis == false) {
                    pom++;
                }
                if (pom == liczba_monster) {
                    if (poziom == 1) {
                        start str = new start();
                        str.closing();
                    } else if (poziom == 2) {
                        start2 str = new start2();
                        str.closing();
                    } else if (poziom == 3) {
                        start3 str = new start3();
                        str.closing();
                    } else if (poziom == 4) {
                        start4 str = new start4();
                        str.closing();

                    }
                }
                if (poziom == 5 && score.win() == false) {
                    running = false;
                    koniec_gry(true);
                }
                if (monsters[j][i].isVis == true && player.y <= monsters[j][i].y_monster && player.y >= monsters[j][i].y_monster - monsters_wysokosc && player.x >= monsters[j][i].x_monster + monsters_szerokosc / 2 && player.x <= monsters[j][i].x_monster + monsters_szerokosc / 2) {
                    running = false;
                    koniec_gry(false);
                }
                if (monsters[j][i].isVis == true && monsters[j][i].y_monster + monsters_wysokosc >= Game_wysokosc) {
                    running = false;
                    koniec_gry(false);
                }
            }
        }
        if (score.lives <= 0) {
            running = false;
            koniec_gry(false);
        }
    }

    public void koniec_gry(boolean win) {
        Game_over_frame over = new Game_over_frame(0, 0, win);
        over.koniec();
        if (poziom == 1) {
            start str = new start();
            str.closing();
        } else if (poziom == 2) {
            start2 str = new start2();
            str.closing();
        } else if (poziom == 3) {
            start3 str = new start3();
            str.closing();
        } else if (poziom == 4) {
            start4 str = new start4();
            str.closing();
        } else if (poziom == 5) {
            start5 str = new start5();
            str.closing();
        }
    }

    public void monster_shot() {
        for (int x = 0; x < shotA.length; x++) {
            int pom1 = rand.nextInt(monsters[0].length);
            int pom2 = rand.nextInt(monsters.length);
            if (shotA[x].free && monsters[pom2][pom1].isVis) {
                shotA[x].free = false;
                shotA[x].goDown = true;
                shotA[x].x_shot = (monsters[pom2][pom1].x_monster + monsters_szerokosc / 2) - shotA[x].shot_szerokosc / 2;
                shotA[x].y_shot = monsters[pom2][pom1].y_monster + monsters_wysokosc;
            }
        }
        for (int i = 0; i < shotA.length; i++) {
            if (shotA[i].y_shot > 900) {
                shotA[i].free = true;
            }
        }
    }

    public void monster_move() {
        for (int j = 0; j < monsters.length; j++) {
            for (int i = 0; i < monsters[0].length; i++) {
                if (monsters[j][i].moveLewo == true) {
                    monsters[j][i].x_monster -= monsters[j][i].speed;
                }
                if (monsters[j][i].movePrawo == true) {
                    monsters[j][i].x_monster += monsters[j][i].speed;
                }
            }
        }

        for (int j = 0; j < monsters.length; j++) {
            for (int i = 0; i < monsters[0].length; i++) {
                if (monsters[j][i].x_monster > Game_szerokosc - monsters_szerokosc) {
                    movePrawoLewo(1);
                    break;
                }
                if (monsters[j][i].x_monster < 0) {
                    movePrawoLewo(2);
                    break;
                }
            }
        }
    }

    public void movePrawoLewo(int pom) {
        for (int j = 0; j < monsters.length; j++) {
            for (int i = 0; i < monsters[0].length; i++) {
                if (pom == 1) {
                    monsters[j][i].moveLewo = true;
                    monsters[j][i].movePrawo = false;
                } else {
                    monsters[j][i].moveLewo = false;
                    monsters[j][i].movePrawo = true;
                }
                monsters[j][i].y_monster += 5;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paint(g);
    }

    public void paint(Graphics g) {
        image2 = new ImageIcon("files/czarny.png").getImage();
        g.drawImage(image2, 0, 0, this);
        for (int i = 0; i < Gwiazda.length; i++) {
            Gwiazda[i].draw(g);
        }
        for (int i = 0; i < shot.length; i++) {
            shot[i].draw(g);
        }
        for (int i = 0; i < shotA.length; i++) {

            if (shotA[i].Vis = true) {
                shotA[i].draw(g);
            }
        }
        player.draw(g);
        score.draw(g);

        for (int j = 0; j < monsters.length; j++) {
            for (int i = 0; i < monsters[0].length; i++) {
                if (monsters[j][i].isVis) {
                    monsters[j][i].draw(g);
                }
            }
        }
        GameOver(g);
    }

    public void gwiazdy() {
        for (int i = 0; i < Gwiazda.length; i++) {
            x = rand.nextInt(Game_szerokosc);
            y = rand.nextInt(Game_wysokosc) - Game_wysokosc;
            g_speed = rand.nextInt(5);
            g_szerokosc = rand.nextInt(5) + 1;
            g_wysokosc = rand.nextInt(5) + 1;
            Gwiazda[i] = new gwiazda(x, y, g_szerokosc, g_wysokosc, g_speed, Game_szerokosc, Game_wysokosc);
        }
    }

    public void move() {
        player.move();

        monster_move();
        for (int i = 0; i < Gwiazda.length; i++) {
            Gwiazda[i].move();
        }
        for (int i = 0; i < shot.length; i++) {
            shot[i].move();
        }
        for (int i = 0; i < shotA.length; i++) {
            shotA[i].move();
        }
    }

    public void checkcollision() {
        if (player.x <= 0) {
            player.x = 0;
        }
        if (player.x >= (Game_szerokosc - player_szerokosc)) {
            player.x = Game_szerokosc - player_szerokosc;
        }
        for (int x = 0; x < shot.length; x++) {
            for (int j = 0; j < monsters.length; j++) {
                for (int i = 0; i < monsters[0].length; i++) {
                    if (monsters[j][i].isVis == true
                            && shot[x].x_shot + shot[x].shot_szerokosc >= monsters[j][i].x_monster
                            && shot[x].x_shot <= monsters[j][i].x_monster + monsters[j][i].monsters_szerokosc
                            && shot[x].y_shot + shot[x].shot_wysokosc >= monsters[j][i].y_monster
                            && shot[x].y_shot <= monsters[j][i].y_monster + monsters[j][i].monsters_wysokosc) {
                        audioboom.audio();
                        audioboom.volume();
                        audioboom.play();
                        score.player++;
                        if (poziom == 5) {
                            shot[x].x_shot = -100;
                            score.boss_health();
                        } else {
                            monsters[j][i].isVis = false;
                            shot[x].x_shot = -100;
                        }
                    }
                }
            }
        }
        for (int x = 0; x < shotA.length; x++) {
            if (shotA[x].Vis = true
                    && shotA[x].x_shot + shotA[x].shot_szerokosc >= player.x
                    && shotA[x].x_shot <= player.x + player_szerokosc
                    && shotA[x].y_shot + shotA[x].shot_wysokosc >= player.y
                    && shotA[x].y_shot <= player.y + player_wysokosc) {

                shotA[x].y_shot = Game_wysokosc + 10;
                score.lives--;
            }
        }
        for (int i = 0; i < shotA.length; i++) {
            for (int j = 0; j < shot.length; j++) {
                if (shot[j].x_shot + shot[j].shot_szerokosc >= shotA[i].x_shot
                        && shot[j].x_shot <= shotA[i].x_shot + shotA[i].shot_szerokosc
                        && shot[j].y_shot + shot[j].shot_wysokosc >= shotA[i].y_shot
                        && shot[j].y_shot <= shotA[i].y_shot + shotA[i].shot_wysokosc) {
                    if (poziom != 5) {
                        shotA[i].Vis = false;
                        shotA[i].x_shot = -100;
                    }
                    shot[j].x_shot = -100;
                }
            }
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = 0;
        int drawCount = 0;
        running = true;
        while (running == true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            timer += (now - lastTime);
            lastTime = now;
            if (delta >= 1) {
                move();
                monster_shot();
                checkcollision();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_SPACE && shot[numerstrzal].y_shot <= 0) {
                if (numerstrzal <= shot.length) {
                    shot[numerstrzal].goUp = true;
                    shot[numerstrzal].x_shot = (player.x + player_szerokosc / 2) - shot[numerstrzal].shot_szerokosc / 2;
                    shot[numerstrzal].y_shot = Game_wysokosc - player_wysokosc - 20;
                    numerstrzal++;
                    if (numerstrzal == shot.length) {
                        numerstrzal = 0;
                    }
                }
            }
        }
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}
