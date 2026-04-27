
package com.mycompany.space_invaders.ui;

import com.mycompany.space_invaders.ui.*;
import com.mycompany.space_invaders.entities.*;
import com.mycompany.space_invaders.audio.*;
import com.mycompany.space_invaders.levels.*;
import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Game_over_Panel extends JPanel implements ActionListener {
  private  Image boss_image;
    JButton button_exit = new JButton("EXIT GAME");
    public boolean Win;

    public Game_over_Panel(boolean win) {
        this.Win = win;
        Dimension SCREEN_SIZE = new Dimension(600, 300);
        this.setFocusable(true);
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(Color.black);
        button_exit.setBounds(100, 200, 400, 60);
        button_exit.setBackground(Color.BLACK);
        button_exit.setFont(new Font("Engravers MT", Font.BOLD, 40));
        button_exit.setForeground(Color.LIGHT_GRAY);
        button_exit.setBorderPainted(false);
        button_exit.addActionListener(this);
        setLayout(null);
        add(button_exit);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        boss_image = new ImageIcon("files/boss.png").getImage();
        g.drawImage(boss_image, 100, 80, 400, 100, this);
        if (Win == false) {
            g.setColor(Color.RED);
            g.setFont(new Font("Engravers MT", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("GAME OVER", (600 - metrics.stringWidth("GAME OVER")) / 2, g.getFont().getSize() + 10);
        } else {
            g.setColor(Color.yellow);
            g.setFont(new Font("Engravers MT", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("YOU WIN", (600 - metrics.stringWidth("YOU WIN")) / 2, g.getFont().getSize() + 10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button_exit) {
            System.exit(0);
        }
    }
}
