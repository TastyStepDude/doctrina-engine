package Viking;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public enum SoundEffect { //TODO: add mixer
    FIRE("audios/fire.wav"),
    MURLOC("audios/murloc.wav"),
    MUSIC("audios/music.wav");

    private final String audioFilePath;

    SoundEffect(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }

    public void play() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(audioFilePath));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
