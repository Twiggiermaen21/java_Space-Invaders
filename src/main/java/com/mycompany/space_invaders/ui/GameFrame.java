package com.mycompany.space_invaders.ui;

import com.mycompany.space_invaders.ui.*;
import com.mycompany.space_invaders.entities.*;
import com.mycompany.space_invaders.audio.*;
import com.mycompany.space_invaders.levels.*;
import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameFrame {

    public JFrame frame1 = new JFrame();

    public GameFrame(int Menu_szerokosc, int Menu_wysokosc) {
        GamePanel panel = new GamePanel(Menu_szerokosc, Menu_wysokosc);
        frame1.add(panel);
        frame1.setTitle("space_invaders");
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.pack();
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);
    }

    public void closing() {
        frame1.dispose();

    }
}
