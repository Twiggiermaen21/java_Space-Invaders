package com.mycompany.space_invaders.ui;

import com.mycompany.space_invaders.levels.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
///////////////////////panel////////////////////////////
    public int Menu_szerokosc;
    public int Menu_wysokosc;
    public boolean button1_active;
    public boolean button2_active;
    public boolean button3_active;
    public boolean button4_active;
    public boolean button5_active;
    ///////////////////////tlo////////////////////////////
    private Tlo tlo;
    /////////////////////////buttons//////////////////////////////
    private final JButton button_wyj = new JButton("EXIT");
    public JButton button1 = new JButton("LEVEL 1");
    private JButton button2 = new JButton("LEVEL 2");
    private JButton button3 = new JButton("LEVEL 3");
    private JButton button4 = new JButton("LEVEL 4");
    public JButton button5 = new JButton("LEVEL 5");
    private static final int button_szerokosc = 600;
    private static final int button_wysokosc = 60;

    GamePanel(int Menu_szerokosc, int Menu_wysokosc) {
        this.button1_active = true;
        this.button2_active = true;
        this.button3_active = true;
        this.button4_active = true;
        this.button5_active = true;
        this.Menu_szerokosc = Menu_szerokosc;
        this.Menu_wysokosc = Menu_wysokosc;
        this.setPreferredSize(new Dimension(Menu_szerokosc, Menu_wysokosc));
        this.setBackground(Color.black);
        this.setFocusable(true);
        buttons();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        tlo = new Tlo();
        tlo.draw(g);
    }

    public void buttons() {

        button1.setBounds((Menu_szerokosc - button_szerokosc) / 2, 150 + button_wysokosc, button_szerokosc, button_wysokosc);
        button1.setBackground(Color.BLACK);
        button1.setFont(new Font("Engravers MT", Font.BOLD, 60));
        button1.setForeground(Color.LIGHT_GRAY);
        button1.setBorderPainted(false);
        button1.addActionListener(this);
        setLayout(null);
        add(button1);

        button2.setBounds((Menu_szerokosc - button_szerokosc) / 2, 180 + button_wysokosc * 2, button_szerokosc, button_wysokosc);
        button2.setBackground(Color.BLACK);
        button2.setFont(new Font("Engravers MT", Font.BOLD, 60));
        button2.setForeground(Color.LIGHT_GRAY);
        button2.setBorderPainted(false);
        button2.addActionListener(this);
        setLayout(null);
        add(button2);

        button3.setBounds((Menu_szerokosc - button_szerokosc) / 2, 210 + button_wysokosc * 3, button_szerokosc, button_wysokosc);
        button3.setBackground(Color.BLACK);
        button3.setFont(new Font("Engravers MT", Font.BOLD, 60));
        button3.setForeground(Color.LIGHT_GRAY);
        button3.setBorderPainted(false);
        button3.addActionListener(this);
        setLayout(null);
        add(button3);

        button4.setBounds((Menu_szerokosc - button_szerokosc) / 2, 240 + button_wysokosc * 4, button_szerokosc, button_wysokosc);
        button4.setBackground(Color.BLACK);
        button4.setFont(new Font("Engravers MT", Font.BOLD, 60));
        button4.setForeground(Color.LIGHT_GRAY);
        button4.setBorderPainted(false);
        button4.addActionListener(this);
        setLayout(null);
        add(button4);

        button5.setBounds((Menu_szerokosc - button_szerokosc) / 2, 270 + button_wysokosc * 5, button_szerokosc, button_wysokosc);
        button5.setBackground(Color.BLACK);
        button5.setFont(new Font("Engravers MT", Font.BOLD, 60));
        button5.setForeground(Color.LIGHT_GRAY);
        button5.setBorderPainted(false);
        button5.addActionListener(this);
        setLayout(null);
        add(button5);

        button_wyj.setBounds((Menu_szerokosc - button_szerokosc) / 2, 350 + button_wysokosc * 6, button_szerokosc, button_wysokosc);
        button_wyj.setBackground(Color.BLACK);
        button_wyj.setFont(new Font("Engravers MT", Font.BOLD, 60));
        button_wyj.setForeground(Color.LIGHT_GRAY);
        button_wyj.setBorderPainted(false);
        button_wyj.addActionListener(this);
        setLayout(null);
        add(button_wyj);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == button_wyj) {
            System.exit(0);
        }
        if (source == button1) {
            if (button1_active) {
                new start();
            }
            button1.setText("FINISHED");
            button1_active = false;
        }
        if (source == button2) {
            if (button2_active) {
                new start2();
            }
            button2.setText("FINISHED");
            button2_active = false;
        }
        if (source == button3) {
            if (button3_active) {
                new start3();
            }
            button3.setText("FINISHED");
            button3_active = false;
        }
        if (source == button4) {
            if (button4_active) {
                new start4();
            }
            button4.setText("FINISHED");
            button4_active = false;
        }
        if (source == button5) {
            if (button5_active) {
                new start5();
            }
            button5.setText("FINISHED");
            button5_active = false;
        }
    }
}
