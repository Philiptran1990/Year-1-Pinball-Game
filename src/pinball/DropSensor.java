package pinball;

import city.cs.engine.*;
import javax.swing.*;
import org.jbox2d.common.Vec2;

//An invisible sensor used to detect when the ball is lost from play.
//Also used to hold and reduce the remaining lives left.
public class DropSensor extends StaticBody implements SensorListener {

    //Shape of the sensor. Requires very little height
    //as it only needs to cover the mouth of the pinball game.
    private final Shape shape = new BoxShape(5f, 0.1f);
    
    //Holds the current lives
    private int lives;
    
    private World world;
    private Ball ball;
    private JFrame frame;

    public DropSensor(World world, Ball ball) {
        super(world);
        
        this.ball = ball;
        Sensor sensor = new Sensor(this, shape);
        sensor.addSensorListener(this);
        lives = 5;
    }

    //Detects when conatct with the sensor is made and prints out a line indictating a life has been lost.
    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() == ball) {
            System.out.println("Orb Lost");
        }
    }

    //Reduces 1 life from current lives total and reset the ball back to it's starting point with it's velocity removed
    @Override
    public void endContact(SensorEvent e) {
        if (e.getContactBody() == ball) {
            
            //Reduces current lives by 1.
            lives = lives - 1;
            
            //Resets the balls position and velocity
            ball.setPosition(new Vec2(10, -8));
            ball.setLinearVelocity(new Vec2(0, 0));
            
            //Prints out the remaining lives.
            System.out.println(lives + " Orbs remaining!");

            //Checks if the player has run out of lives
            if (lives == -1) {
                
                //If they have run out of lives then the player is informed and the game is exited.
                JOptionPane.showMessageDialog(frame, "You've run out of Orbs. Game Over");
                System.exit(0);
            }
        }
    }

    //Checks current amount of lives.
    public int getLives() {
        return lives;
    }

    //Allows current amount of lives to be altered.
    public void setLives(int lives) {
        this.lives = lives;
    }
}
