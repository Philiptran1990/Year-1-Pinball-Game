package pinball;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Basic collision listener to give the player powerup.
public class Powerup implements CollisionListener {

    private Ball ball;
    private Pinball pinball;
    private KeyControls key;
    private SoundClip powerupSound;

    public Powerup(Pinball pinball) {
        this.pinball = pinball;
        //Plays a sound when pickedup.
        try {
            powerupSound = new SoundClip("data/powerup.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Powerup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void collide(CollisionEvent e) {
        Ball ball = pinball.getActor();
        KeyControls key = pinball.getKeyControls();
        if (e.getOtherBody() == ball) {
            //Destroys powerup when contact is made.
            e.getReceivingBody().destroy();
            //Sets powerup ability for player.
            key.setPowerup(1);
            //Plays the sound on contact.
            powerupSound.play();
            System.out.println("Powerup received! Press G to activate and deactivate(One time usage)");
        }
    }
}
