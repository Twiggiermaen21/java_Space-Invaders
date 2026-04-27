package com.mycompany.space_invaders.audio;

import com.mycompany.space_invaders.ui.*;
import com.mycompany.space_invaders.entities.*;
import com.mycompany.space_invaders.audio.*;
import com.mycompany.space_invaders.levels.*;
import com.mycompany.space_invaders.core.*;
import com.mycompany.space_invaders.Space_Invaders;


import java.io.*;
import javax.sound.sampled.*;

public class audio {
    public static File file;
    private static Clip clip;

    public audio() {
        file = new File("files/Just Breathing (Instrumental) - NEFFEX.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public void volume_normal() {
        if (clip != null) {
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-25f);
        }
    }
}
