package pinball;

import city.cs.engine.*;
import javax.swing.JOptionPane;
import org.jbox2d.common.Vec2;

//Very simple collision listener used to destroy the receiving body.
//Used for objects which are blocking the way to the highest value bouncer in the game.
public class DestroyDoors implements CollisionListener {

    private Ball ball;
    private Pinball pinball;

    public DestroyDoors(Pinball pinball) {
        this.pinball = pinball;
    }

    @Override
    public void collide(CollisionEvent e) {
        
        Ball ball = pinball.getActor();
        
        //If the current levels ball collides then this object is destroyed.
        if (e.getOtherBody() == ball) {
            e.getReceivingBody().destroy();
        }
    }
}
