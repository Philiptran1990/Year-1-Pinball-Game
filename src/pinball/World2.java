package pinball;

import city.cs.engine.*;
import java.awt.Color;
import javax.swing.*;
import org.jbox2d.common.Vec2;

//Second world with more objects and harder requirements.
public class World2 extends PinballW {

    private BonusObjects bonusobjects;
    private Pinball pinball;
    private JFrame frame;
    private Layout2 drawLayout;

    @Override
    public void fillWorld(Pinball pinball) {
        super.fillWorld(pinball);
        {
            drawLayout = new Layout2(this);
        }
        //Creates higher value bouncers.
        {
            Body superbouncer = new Bouncers(this);
            superbouncer.setPosition(new Vec2(-7f, 5f));
            superbouncer.addCollisionListener(new Fivebounce(pinball));
            superbouncer.setFillColor(Color.WHITE);
            Body superbouncer2 = new Bouncers(this);
            superbouncer2.setPosition(new Vec2(-3f, 5f));
            superbouncer2.addCollisionListener(new Fivebounce(pinball));
            superbouncer2.setFillColor(Color.WHITE);
            Body superbouncer3 = new Bouncers(this);
            superbouncer3.setPosition(new Vec2(3f, 0f));
            superbouncer3.addCollisionListener(new Fivebounce(pinball));
            superbouncer3.setFillColor(Color.WHITE);
        }
        {
            Body powerupobject = new PowerupObject(this);
            powerupobject.setPosition(new Vec2(0, 11f));
            powerupobject.addCollisionListener(new Powerup(pinball));
        }
        {
            JOptionPane.showMessageDialog(frame, "Score 30 points to move on. White Bouncers are worth 5 points");
        }
        //Creates wormhole/teleporter.
        {
            Shape teleshape = new CircleShape(0.5f);
            Body teleporter = new StaticBody(this, teleshape);
            teleporter.setPosition(new Vec2(6f, 2f));
            teleporter.addCollisionListener(new Teleport(pinball));
            teleporter.setImage(new BodyImage("data/wormhole.gif", 3f));
        }
    }

    @Override
    public void setPaused(boolean paused) {
        super.setPaused(paused);
    }

    @Override
    public boolean levelComplete() {
        return getActor().getScore() >= 30;
    }
}
