package pinball;

import city.cs.engine.*;
import java.awt.Color;
import javax.swing.*;
import org.jbox2d.common.Vec2;

//First world. Only requires 10 points to pass.
public class World1 extends PinballW {

    private JFrame frame;
    private PowerupObject powerupobject;
    private Layout1 drawLayout;

            //Draws layout for this world.
    @Override
    public void fillWorld(Pinball pinball) {
        super.fillWorld(pinball);
        {
            drawLayout = new Layout1(this);
        }
        {
            powerupobject = new PowerupObject(this);
            powerupobject.setPosition(new Vec2(0, -2f));
            powerupobject.addCollisionListener(new Powerup(pinball));
        }
        {
            JOptionPane.showMessageDialog(frame, "Press Escape to Pause/Unpause and see instructions. Press Space Bar to launch your orb. Score points by hitting the pink bouncers at the top of the map. Score 10 points to move on");
        }
    }

    @Override
    public void setPaused(boolean paused) {
        super.setPaused(paused);
    }

    //10 Points required to pass this level
    @Override
    public boolean levelComplete() {
        return getActor().getScore() >= 10;
    }
}
