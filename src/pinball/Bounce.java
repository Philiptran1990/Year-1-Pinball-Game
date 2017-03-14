package pinball;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.*;
import javax.sound.sampled.*;

//Collision listener used to the current score when the ball collides with an object
public class Bounce implements CollisionListener {

    private Ball ball;
    private Pinball pinball;
    
    //bounceSound will hold the audioclip for when a collision is detected
    private SoundClip bounceSound;

    public Bounce(Pinball pinball) {
        
        this.pinball = pinball;
        try {
            bounceSound = new SoundClip("data/bounce.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Bounce.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Lowers the volume of the bounce soundclip to not drown out the background music
        bounceSound.setVolume(0.3);
    }

    @Override
    public void collide(CollisionEvent e) {
        Ball ball = pinball.getActor();
        //Adds 2 points on collision with ball.
        if (e.getOtherBody() == ball) {
            ball.addScore(2);
            ball.getScore();
            //Plays sound on collision.
            bounceSound.play();
            //Checks if level is complete and moves on if true.
            if (pinball.isCurrentLevelCompleted() == true) {
                pinball.goNextLevel();
            }
        }
    }
}
