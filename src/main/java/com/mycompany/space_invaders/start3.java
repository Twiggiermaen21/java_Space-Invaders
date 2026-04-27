
package com.mycompany.space_invaders;

import javax.swing.JFrame;


class start3 extends Space_Invaders{

    public static JFrame frame = new JFrame();

    public start3() {
  int poziom=3;
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
