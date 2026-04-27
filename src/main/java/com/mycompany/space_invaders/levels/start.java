package com.mycompany.space_invaders.levels;

import com.mycompany.space_invaders.ui.*;
import com.mycompany.space_invaders.entities.*;
import com.mycompany.space_invaders.audio.*;
import com.mycompany.space_invaders.levels.*;
import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import javax.swing.JFrame;

public class start extends Space_Invaders {

    public static JFrame frame = new JFrame();

    public start() {
        int poziom = 1;
        GameStart gameStart = new GameStart(1600, 900, poziom);
        frame.add(gameStart);
        frame.setTitle("Gra");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public void closing() {
        frame.dispose();
    }
}
