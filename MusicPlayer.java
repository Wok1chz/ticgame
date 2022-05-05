package sample;

import javafx.scene.media.AudioClip;

public class MusicPlayer {

    private AudioClip turnMusic = new AudioClip(
            getClass()
                    .getResource("turn.mp3")
                    .toExternalForm());

    private AudioClip winMusic = new AudioClip(
            getClass()
                    .getResource("win.mp3")
                    .toExternalForm());

    private AudioClip drawMsuic = new AudioClip(
            getClass()
                    .getResource("draw.mp3")
                    .toExternalForm());

    public MusicPlayer() { }

    void turnMusic() {
        turnMusic.play();
    }

    void winMusic() {
        winMusic.play();
    }

    void drawMusic() {
        drawMsuic.play();
    }
}
