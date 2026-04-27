
package com.mycompany.space_invaders.ui;

import com.mycompany.space_invaders.ui.*;
import com.mycompany.space_invaders.entities.*;
import com.mycompany.space_invaders.audio.*;
import com.mycompany.space_invaders.levels.*;
import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import javax.swing.JFrame;


public class Game_over_frame extends GameFrame {

    public static JFrame frame_napis = new JFrame();

    public Game_over_frame(int Menu_szerokosc, int Menu_wysokosc,boolean win) {
        super(Menu_szerokosc, Menu_wysokosc);
        Game_over_Panel over = new Game_over_Panel(win);
        frame_napis.add(over);
        frame_napis.setTitle("Gra");
        frame_napis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_napis.setResizable(false);
        frame_napis.pack();
        frame_napis.setVisible(true);
        frame_napis.setLocationRelativeTo(null);
    }

    public void koniec() {
        frame1.dispose();
    }
}
