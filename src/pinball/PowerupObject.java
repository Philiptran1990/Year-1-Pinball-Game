package pinball;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;

//Basic Dynamic body to represent powerup object.
public class PowerupObject extends DynamicBody {

    private static final float circleSize = 1f;
    private static final Shape shape = new CircleShape(circleSize);
    

    public PowerupObject(World world) {
        super(world, shape);
        
        //0 Gravity so it can float
        setGravityScale(0f);
        setImage(new BodyImage("data/powerup.gif", 2f));
    }
}
