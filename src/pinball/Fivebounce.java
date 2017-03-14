package pinball;

import city.cs.engine.*;
import javax.swing.JOptionPane;

//Basic collision listener which adds 5 points to the current score.
public class Fivebounce implements CollisionListener {

    private Ball ball;
    private Pinball pinball;

    public Fivebounce(Pinball pinball) {
        this.pinball = pinball;
    }

    @Override
    public void collide(CollisionEvent e) {
        Ball ball = pinball.getActor();
        
        //When collision is detected 5 points are added to the current score
        if (e.getOtherBody() == ball) {
            ball.addScore(5);
            ball.getScore();
            
            //Checks if the current score required to past the level has been met or exceeded.
            if (pinball.isCurrentLevelCompleted() == true) {
                
                //Moves onto the next level if true.
                pinball.goNextLevel();
            }
        }
    }
}
