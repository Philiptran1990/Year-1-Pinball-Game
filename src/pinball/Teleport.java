package pinball;

import city.cs.engine.*;
import javax.swing.JOptionPane;
import org.jbox2d.common.Vec2;

//Collision listener used to teleport ball when contact is made.
public class Teleport implements CollisionListener {

    private Ball ball;
    private Pinball pinball;

    public Teleport(Pinball pinball) {
        this.pinball = pinball;
    }

    @Override
    public void collide(CollisionEvent e) {
        Ball ball = pinball.getActor();
        //On contact the balls position is changed.
        if (e.getOtherBody() == ball) {
            ball.setPosition(new Vec2(-7, 10));
        }
    }
}
