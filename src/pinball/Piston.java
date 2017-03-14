package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

//Piston used for moving flippers and launching ball.
public class Piston extends DynamicBody {

    //Sizes
    private static final float mainHeight = 2.9f;
    private static final float mainWidth = 0.35f;
    private static final float baseHeight = 1f;
    private static final float baseWidth = 1f;

    public Piston(World world, float height) {
        super(world);
        
        //Allows size of Piston to be changed when created
        float mainHeight2 = mainHeight * height / 2;
        float baseHeight2 = baseHeight * height / 2;
        float mainWidth2 = mainWidth * height / 2;
        float baseWidth2 = baseWidth * height / 2;
        
        //Piston Shaped with narrow neck and Wide Body so it can be housed 
        //to limit what directions it can go in and the distance it can go.
        Shape shape = new BoxShape(mainWidth2, mainHeight2, new Vec2(0, mainHeight2));
        Shape flat = new BoxShape(baseWidth2, baseHeight2, new Vec2(0, baseHeight2));
        SolidFixture main = new SolidFixture(this, shape, 5);
        SolidFixture base = new SolidFixture(this, flat, 5);
        //Uses transparent image to conceal piston.
        setImage(new BodyImage("data/invisible.png"));
        //0 friction to allow the piston to move more freely.
        base.setFriction(0f);
        //Piston can not rotate.
        setFixedRotation(true);
    }
}
