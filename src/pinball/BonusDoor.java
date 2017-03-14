package pinball;

import city.cs.engine.*;
import java.awt.Color;

//Basic staticbody which will be given a collison listener to destroy
public class BonusDoor extends StaticBody {

    //Bouncer Sizes
    private static final float width = 1.2f;
    private static final float height = 0.1f;
    //Shape of the object
    private static final Shape shape = new BoxShape(width, height);

    public BonusDoor(World world) {
        super(world, shape);
        setFillColor(Color.WHITE);
    }
}
