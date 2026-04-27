
package com.mycompany.space_invaders;

import java.io.*;
import javax.sound.sampled.*;


public class boomaudio {
    public File file;
    public Clip clip;

    public boomaudio() {
        file = new File("files/Small Bomb Explosion Sound Effect.wav");
    }

    public void audio() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
        }
    }

    public void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public void volume() {
        if (clip != null) {
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-20f);
        }
    }
}
