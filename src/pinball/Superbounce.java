package pinball;

import city.cs.engine.*;
import javax.swing.JOptionPane;

//Basic Collision Listener to increase score by 10.
public class Superbounce implements CollisionListener {

    private Ball ball;
    private Pinball pinball;

    public Superbounce(Pinball pinball) {
        this.pinball = pinball;
    }

    @Override
    public void collide(CollisionEvent e) {
        Ball ball = pinball.getActor();
        //Adds 10 to current score on contact.
        if (e.getOtherBody() == ball) {
            ball.addScore(10);
            ball.getScore();
            //Checks if the level is compelete and moves on if true.
            if (pinball.isCurrentLevelCompleted() == true) {
                pinball.goNextLevel();
            }
        }
    }
}
