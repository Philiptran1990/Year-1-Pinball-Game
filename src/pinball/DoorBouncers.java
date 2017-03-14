package pinball;

import city.cs.engine.*;
import java.awt.Color;

//Basic staticbody used as an obstacle to protect the games highest value bouncer.
public class DoorBouncers extends StaticBody {

    //Bouncer Sizes
    private static final float width = 0.5f;
    private static final float height = 1f;
    
    //Shape
    private static final Shape shape = new BoxShape(width, height);

    public DoorBouncers(World world) {
        super(world, shape);
        
        //Color used to differentiate it from other staticbodies in the game
        setFillColor(Color.WHITE);
    }
}
