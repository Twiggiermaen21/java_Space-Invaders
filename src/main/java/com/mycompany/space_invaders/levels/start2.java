
package com.mycompany.space_invaders.levels;

import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import javax.swing.JFrame;


public class start2 extends Space_Invaders{

    public static JFrame frame = new JFrame();

    public start2() {
 int poziom=2;
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
