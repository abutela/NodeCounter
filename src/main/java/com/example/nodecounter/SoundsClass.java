package com.example.nodecounter;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

public class SoundsClass
{
    public void playBloop(){
        playSound("src/main/resources/Sounds/bloop.wav");
    }

    public void playClick(){
        playSound("src/main/resources/Sounds/mouse_click.mp3");
    }

    public void playBlip(){
        playSound("src/main/resources/Sounds/little_blip.wav");
    }

    public void playConfirm() {
        playSound("src/main/resources/Sounds/confirmation.wav");
    }

    public void playBeep(){
        playSound("src/main/resources/Sounds/beep4.wav");
    }

    public void playBloop3(){
        playSound("src/main/resources/Sounds/bloop3.aiff");
    }

    public void playPop(){
        playSound("src/main/resources/Sounds/pop.wav");
    }

    public void playTada(){
        playSound("src/main/resources/Sounds/tada.wav");
    }
    public synchronized void playSound(String musicFile) {
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}