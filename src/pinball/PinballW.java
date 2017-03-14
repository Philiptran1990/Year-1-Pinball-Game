package pinball;

import city.cs.engine.*;
import javax.management.timer.Timer;
import org.jbox2d.common.Vec2;

//Abstract PinballWorld for the levels to be based off.
public abstract class PinballW extends World {

    private Ball ball;
    private Bouncers bouncer;
    private Piston lPiston;
    private Piston rPiston;
    private Piston launcher;
    private DropSensor sensor;
    private Pinball pinball;

    public DynamicBody ballLauncher() {
        return launcher;
    }

    public DynamicBody leftFlipper() {
        return lPiston;
    }

    public DynamicBody rightFlipper() {
        return rPiston;
    }

    public int getScore() {
        return ball.getScore();
    }

    public DropSensor getSensor() {
        return sensor;
    }

    public Ball getActor() {
        return ball;
    }

    public void fillWorld(Pinball pinball) {

        this.setGravity(15f);

        //Used for testing puposes.
//        BoxShape debugshape = new BoxShape(5f, 0.5f);
//        Body debugger = new StaticBody(this, debugshape);
//        debugger.setPosition(new Vec2(-4f, 1.1f));
//        debugger.setAngle(-0.2f);
//        Body debugger2 = new StaticBody(this, debugshape);
//        debugger2.setPosition(new Vec2(4f, 1.1f));
//        debugger2.setAngle(0.2f);
//        SolidFixture debug = new SolidFixture(debugger, debugshape);
//        debug.setRestitution(8.5f);
//        SolidFixture debug2 = new SolidFixture(debugger, debugshape);
//        debug2.setRestitution(8.5f);
        //Draws the Outline.
        Outline drawOutline = new Outline(this);

        //Draw Flippers.
        Flipper rightflipper = new Flipper(this);
        rightflipper.setPosition(new Vec2(5f, -13.7f));
        Flipper leftflipper = new Flipper(this);
        leftflipper.setPosition(new Vec2(-5f, -13.7f));
        leftflipper.setAngleDegrees(180);

        //Draws the Bouncers.
        for (int i = 0; i < 2; i++) {
            Body bouncers = new Bouncers(this);
            bouncers.setPosition(new Vec2(i * 5 - 2.5f, 11));
            bouncers.addCollisionListener(new Bounce(pinball));
        }

        //Creates pinball
        ball = new Ball(this);

        //Ball Launcher
        launcher = new Piston(this, 2);
        launcher.setPosition(new Vec2(10f, -17f));

        //Pistons to move flippers
        rPiston = new Piston(this, 2);
        rPiston.setPosition(new Vec2(3.5f, -22f));
        lPiston = new Piston(this, 2);
        lPiston.setPosition(new Vec2(-3.5f, -22f));

        //Creates sensor to detect balls lost.
        sensor = new DropSensor(this, ball);
        sensor.setPosition(new Vec2(0f, -15.5f));
    }
    
    //Used to spawn extra balls from powerup.
    public void extraBalls(Pinball pinball) {
        for (int row = 0; row < 7; row++) {
            for (int pos = row; pos < 5; pos++) {
                Body bonusobjects = new BonusObjects(this);
                bonusobjects.setPosition(new Vec2(-7 + row, 10 - pos));
                bonusobjects.addCollisionListener(new Destroy(pinball));
        }
    }
}

    //Checks level is complete
public abstract boolean levelComplete();

}
