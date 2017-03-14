package pinball;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.*;

//Class used to repeatedly play music in the background.
public class BGMusic extends SoundClip {

    //Keeps track of whether the sound is paused
    private boolean paused = false;

    public BGMusic(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(fileName);
        
        //Soundclip immediately plays and loops
        this.play();
        this.loop();
    }

    //Checks whether music is paused or not
    public boolean isPaused() {
        return paused;
    }

    //Sets whether or not the music is paused (Just the variable)
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    //Pauses the music
    public void PauseMusic() {
        this.pause();
    }

    //Resumes the music
    public void ResumeMusic() {
        this.resume();
    }

//    public void RaiseVolume() {
//        this.setVolume(2);
//    }
//
//    public void LowerVolume() {
//        this.setVolume(-2);
//    }
}
