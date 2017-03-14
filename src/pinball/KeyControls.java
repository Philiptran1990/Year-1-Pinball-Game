package pinball;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.*;
import javax.sound.sampled.*;
import javax.swing.JFrame;

//Keyadapter class used to control inputs in the game
public class KeyControls extends KeyAdapter {

    //Controls aspects of the Flipper and Ball launcher pistons
    private static final float pistonS = 25;
    private PistonLift currentLift;
    private Piston launcher;

    private DropSensor flag;
    private DynamicBody body;
    private World world;
    private Ball ball;

    private int powerup;
    private boolean gravityPower = false;

    private Pinball pinball;
    private DynamicBody lPiston;
    private DynamicBody rPiston;
    private DynamicBody bPiston;

    private MyView view;
    private JFrame frame;
    private Menu control;
    private boolean isMenuOn = true;
    //  private Ball bawl;
    private PinballW pinballw;

    private BGMusic bgMusic;
    private SoundClip launchSound;
    private SoundClip gravitySound;
    private SoundClip powerSound;

    public KeyControls(Pinball pinball, DynamicBody body) {

        //Body refers to the 3 Pistons in the game 
        //controlling the left and right flipper and ball launcher.
        this.body = body;

        this.pinball = pinball;
        this.world = body.getWorld();

        this.lPiston = pinball.getWorld().leftFlipper();
        this.rPiston = pinball.getWorld().rightFlipper();
        this.bPiston = pinball.getWorld().ballLauncher();

        this.currentLift = null;
        this.launcher = null;
        this.bgMusic = pinball.getBgMusic();
        this.frame = pinball.getFrame();
        this.control = pinball.getControl();

        try {
            launchSound = new SoundClip("data/launch.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(KeyControls.class.getName()).log(Level.SEVERE, null, ex);
        }
        launchSound.setVolume(0.2);

        try {
            gravitySound = new SoundClip("data/antigrav.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(KeyControls.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            powerSound = new SoundClip("data/power.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(KeyControls.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.view = pinball.getView();
    }

    //Key Pressed events.
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //LEFT SLASH KEY - Used to control the left flipper piston.
        if (code == KeyEvent.VK_BACK_SLASH) {

            //Checks current velocity and only continues if the piston is stationary.
            Vec2 v = lPiston.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {

                //Fires the piston upwards based on the value of pistonS.
                lPiston.setLinearVelocity(new Vec2(v.x, pistonS));
                System.out.println("Left Bumper");
            }

            //RIGHT SLASH KEY - Used to control the right flipper piston.  
        } else if (code == KeyEvent.VK_SLASH) {

            //Checks current velocity and only continues if the piston is stationary.
            Vec2 v = rPiston.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {

                //Fires the piston upwards based on the value of pistonS.
                rPiston.setLinearVelocity(new Vec2(v.x, pistonS));
                System.out.println("Right Bumper");
            }

            //SPACE KEY - Used to control the ball launcher piston.
        } else if (code == KeyEvent.VK_SPACE) {

            //Checks current velocity and only continues if the piston is stationary.
            Vec2 v = bPiston.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {

                //Fires the piston upwards based on the value of pistonS.
                bPiston.setLinearVelocity(new Vec2(v.x, pistonS));

                //Plays a sound each time the ball launcher is used.
                launchSound.play();
            }

            //Q KEY - Closes the game.
        } else if (code == KeyEvent.VK_Q) {
            System.exit(0);

            //G KEY - Uses powerup ability.
        } else if (code == KeyEvent.VK_G) {

            //Checks if the user has powerup available
            if (powerup == 3) {
                //Launches extra balls
                pinball.getWorld().extraBalls(pinball);
                powerup = 0;
                //Plays sound when powerup used.
                powerSound.play();
                //If not enough for extra balls gravity is reversed.
                //If the user does not have a powerup saved or has just used it. 
                //The next use of G will set the world's gravity values back to 15f
            } else if (gravityPower == true) {
                world.setGravity(15f);
                gravityPower = false;

            } else if (powerup > 0) {
                if (gravityPower == false) {
                    powerup = powerup - 1;
                    //Sets the world's gravity to negative values and sets the players powerup ability to false
                    world.setGravity(-15);
                    gravityPower = true;
                    //Plays a soundclip
                    gravitySound.play();
                }
            }

            //S KEY - Pauses/Resumes the background music
        }
        if (code == KeyEvent.VK_S) {

            //Checks if background music is playing
            if (bgMusic.isPaused() == false) {

                //Pauses the music and changes the check value
                bgMusic.PauseMusic();
                bgMusic.setPaused(true);

                //If the background music is paused
            } else if (bgMusic.isPaused() == true) {

                //Resumes the music and changes the check value
                bgMusic.ResumeMusic();
                bgMusic.setPaused(false);
            }

            //P KEY = Cheat button to skip current level
        }
        if (code == KeyEvent.VK_P) {
            pinball.goNextLevel();

            //ESCAPE KEY - Pauses/Unpauses the game and brings up the instructions
        } else if (code == KeyEvent.VK_ESCAPE) {

            //Switches current panel.
            pinball.changeCard();

            //Checks if the menu is on or not and whether the game is still incomplete.
            if (pinball.getLevel() < 3) {

                //If the menu is not on then the game is paused as the instructions are brought up.
                if (isMenuOn == false) {
                    isMenuOn = true;
                    world.setPaused(true);

                    //If the menu is up then the game is unpaused and the UserView is brought back up.
                } else if (isMenuOn == true) {
                    isMenuOn = false;
                    world.setPaused(false);
                }
            }

            //2 KEY - Another cheat key which spawns bonus objects
        } else if (code == KeyEvent.VK_2) {
            pinball.getWorld().extraBalls(pinball);
        }
    }

    public int getPowerup() {
        return powerup;
    }

    public void setPowerup(int powerup) {
        this.powerup = powerup + this.powerup;
    }

    //Allows the powerups to be saved
    public void setGravityPower(boolean gravityPower) {
        this.gravityPower = gravityPower;
    }

    //Set body when changing world
    public void setBody(Pinball pinball, DynamicBody body) {
        if (currentLift != null) {
            world.removeStepListener(currentLift);
            currentLift = null;
        }
        this.lPiston = pinball.getWorld().leftFlipper();
        this.rPiston = pinball.getWorld().rightFlipper();
        this.bPiston = pinball.getWorld().ballLauncher();
        this.body = body;
        this.world = body.getWorld();
    }
}
