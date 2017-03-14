package pinball;

import city.cs.engine.*;
import javax.swing.JOptionPane;

//Basic collision listener to reduce players score when hit.
public class NegativeBounce implements CollisionListener {

    private Ball ball;
    private Pinball pinball;
    private int check;

    public NegativeBounce(Pinball pinball) {
        this.pinball = pinball;
    }

    @Override
    public void collide(CollisionEvent e) {
        Ball ball = pinball.getActor();
        
        //Prevents player's score from going below 0.
        ball.getScore();
        if (e.getOtherBody() == ball) {
            if (ball.score >= 5) {
                ball.addScore(-5);
                ball.getScore();
                
                //Otherwise reduces player's score by 5.
            } else if (ball.score < 5) {
                ball.score = 0;
            }
        }
    }
}
