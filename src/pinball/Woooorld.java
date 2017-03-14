package pinball;

import city.cs.engine.*;
import java.awt.Color;
import javax.swing.*;
import org.jbox2d.common.Vec2;

//Plain PinballW for credit view usage. As bare as possible. No Keyadapter usable in this world.
public class Woooorld extends PinballW {

    @Override
    public void fillWorld(Pinball pinball) {
        super.fillWorld(pinball);
    }

    @Override
    public void setPaused(boolean paused) {
        super.setPaused(paused);
    }
    
    @Override
    public boolean levelComplete() {
        return getActor().getScore() >= 10;
    }
}
