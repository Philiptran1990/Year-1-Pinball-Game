package pinball;

import city.cs.engine.*;
import java.awt.Color;
import javax.swing.*;
import org.jbox2d.common.Vec2;

//3rd Level
public class World3 extends PinballW {

    private Ball ball;
    private BonusObjects bonusobjects;
    private Pinball pinball;
    private JFrame frame;
    private Bouncers superbouncer;
    private DoorBouncers doorbouncer;
    private BonusDoor bonusdoor;

    @Override
    public void fillWorld(Pinball pinball) {
        super.fillWorld(pinball);
        {
            Layout3 drawLayout = new Layout3(this);
        }
        {
            bonusdoor = new BonusDoor(this);
            bonusdoor.setPosition(new Vec2(0f, 6.5f));
            bonusdoor.addCollisionListener(new DestroyDoors(pinball));
        }
        {
            doorbouncer = new DoorBouncers(this);
            doorbouncer.setPosition(new Vec2(-1f, 5f));
            doorbouncer.setAngleDegrees(135);
            doorbouncer.addCollisionListener(new DestroyDoors(pinball));
            Body doorbouncer1 = new DoorBouncers(this);
            doorbouncer1.setPosition(new Vec2(1f, 5f));
            doorbouncer1.setAngleDegrees(45);
            doorbouncer1.addCollisionListener(new DestroyDoors(pinball));
        }
        {
            // Bonus Object worth 10 points
            Body superbouncer = new Bouncers(this);
            superbouncer.setPosition(new Vec2(0f, 3.5f));
            superbouncer.addCollisionListener(new Superbounce(pinball));
            superbouncer.setFillColor(Color.BLACK);
        }
        {
            // Negative Object worth reduces 5 points
            Body superbouncer = new Bouncers(this);
            superbouncer.setPosition(new Vec2(0f, 13f));
            superbouncer.addCollisionListener(new NegativeBounce(pinball));
            superbouncer.setFillColor(Color.ORANGE);
        }
        {
            Body powerupobject = new PowerupObject(this);
            powerupobject.setPosition(new Vec2(-6, 1f));
            powerupobject.addCollisionListener(new Powerup(pinball));
        }
        {
            JOptionPane.showMessageDialog(frame, "Score 150 points to move on. Unlock the central bouncer in the centre by hitting all 3 white blocks. But watch out for the Orange bouncer which will reduce your score by 5.");
        }
    }

    @Override
    public void setPaused(boolean paused) {
        super.setPaused(paused);
    }

    //Requires score of over 150 too pass.
    @Override
    public boolean levelComplete() {
        return getActor().getScore() >= 150;
    }
}
