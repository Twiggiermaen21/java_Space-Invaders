
package com.mycompany.space_invaders;


public class Space_Invaders {

    public static final int Menu_szerokosc = 1600;
    public static final int Menu_wysoksc = 900;
public static GameFrame frame_panel;
    public static void main(String[] args) {
     frame_panel= new GameFrame(Menu_szerokosc, Menu_wysoksc);
        audio audio = new audio();
        audio.play();
        audio.volume_normal();
        audio.loop();
    }
}
