package sample;

import javafx.scene.media.AudioClip;

public class MusicPlayer {
    MusicPlayer(){}

    void turn_music(){
        new AudioClip(
                getClass()
                        .getResource("turn.mp3")
                        .toExternalForm())
                .play();
    }
    void win_music(){
        new AudioClip(
                getClass()
                        .getResource("win.mp3")
                        .toExternalForm())
                .play();
    }
    void draw_music(){
        new AudioClip(
                getClass()
                        .getResource("draw.mp3")
                        .toExternalForm())
                .play();
    }
}
