package pinball;

import city.cs.engine.*;
import javax.swing.JOptionPane;

//Collision listener which destroys the object that gets collided with by the ball.
public class Destroy implements CollisionListener {

    private Ball ball;
    private Pinball pinball;

    public Destroy(Pinball pinball) {
        this.pinball = pinball;
    }

    @Override
    public void collide(CollisionEvent e) {
        
        Ball ball = pinball.getActor();
        
        if (e.getOtherBody() == ball) {
            //Destroys the body the collision listener is attached to
            
            e.getReceivingBody().destroy();
            //Adds 1 point to the current score
            
            ball.addScore(1);
            ball.getScore();
            
            //Checks if the current score requirements for the level are complete
            if (pinball.isCurrentLevelCompleted() == true) {
                
                //Moves onto the next level if this is true
                pinball.goNextLevel();
            }
        }
    }
}
