package com.mycompany.space_invaders.ui;



import java.awt.*;
import javax.swing.*;


public class Tlo extends JPanel {

    private Image image;
    private int tlo_szerokosc;
    private int tlo_wysokosc;

    public Tlo() {
        this.tlo_szerokosc = 1600;
        this.tlo_wysokosc = 900;
    }

    public void draw(Graphics g) {
        image = new ImageIcon("files/Menu.png").getImage();
        g.drawImage(image, 0, 0, tlo_szerokosc + 10, tlo_wysokosc + 10, this);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Engravers MT", Font.BOLD, 100));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Space Invaders", (tlo_szerokosc - metrics.stringWidth("Space Invaders")) / 2, g.getFont().getSize());
    }

}
