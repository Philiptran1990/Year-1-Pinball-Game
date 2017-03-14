package pinball;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;

//Basic dynamic objects which will be destroyable with a collision listener.
//Created as bonus objects for the level 2 powerup
public class BonusObjects extends DynamicBody {

    //Sizes
    private static final float circleSize = 0.6f;
    
    //Shape
    private static final Shape shape = new CircleShape(circleSize);
    private static int nextInt;

    public BonusObjects(World world) {
        super(world, shape);
        
        setGravityScale(0f);
        setImage(new BodyImage("data/blue.gif", 1.2f));
        
        //Setup random value
        Random random = new Random();
        int nextInt = random.nextInt(10);
        
        //Makes object shoot out of spawn in a slightly random way
        setLinearVelocity(new Vec2(10 + nextInt, -5 + nextInt));
    }
}
