package pinball;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//Steplistener used to set new velocity of Piston.
public class PistonLift implements StepListener {

    private DynamicBody body;
    private float speed;

    PistonLift(DynamicBody body, float speed) {
        this.body = body;
        this.speed = speed;
    }

    //Gets current velocity and sets new velocity.
    @Override
    public void preStep(StepEvent e) {
        Vec2 v = body.getLinearVelocity();
        body.setLinearVelocity(new Vec2(speed, v.y));
    }

    @Override
    public void postStep(StepEvent e) {
    }
}
