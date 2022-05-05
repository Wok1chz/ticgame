package sample;

import javafx.scene.media.AudioClip;

public class MusicPlayer {
    MusicPlayer(){}

    void turnMusic() {
        new AudioClip(
                getClass()
                        .getResource("turn.mp3")
                        .toExternalForm())
                .play();
    }
    void winMusic() {
        new AudioClip(
                getClass()
                        .getResource("win.mp3")
                        .toExternalForm())
                .play();
    }
    void drawMusic() {
        new AudioClip(
                getClass()
                        .getResource("draw.mp3")
                        .toExternalForm())
                .play();
    }
}
