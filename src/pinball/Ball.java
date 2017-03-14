package pinball;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.*;

//Ball class used to create the pinball and the hold the current score
public class Ball extends DynamicBody {
    
    //Holds current score. This is done to simplify things
    //and make it easier to reset the score each new level.
    public int score;
    private World world;
    private Pinball pinball;

    public Ball(World world) {
        super(world);
        
        //Pinball design
        Shape ballShape = new CircleShape(0.5f);
        setImage(new BodyImage("data/ball.png", 1f));
        
        //Makes the ball out of a fixture to allow adjustments to the balls restitution
        SolidFixture fixture = new SolidFixture(this, ballShape, 0.5f);
        fixture.setRestitution(0.85f);
        setPosition(new Vec2(10, -8));
        score = 0;
    }

    //Gets current score
    public int getScore() {
        return score;
    }

    //Adds to the current score and outputs the current score into the system output
    public void addScore(int score) {
        this.score = score + this.score;
        System.out.println("Scored " + score + " point! - Cureent Score = " + this.score);
    }
}
