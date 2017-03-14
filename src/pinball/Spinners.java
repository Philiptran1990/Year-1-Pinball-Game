package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

//Dynamic body made of fixtures which revolve around a pivot
public class Spinners extends DynamicBody {

    private static final float Width = 0.2f;
    private static final float Height = 0.1f;
    
    private static final float x = 5f;
    private static final float y = -13.7f;
    
    private static final float Axle = 0.9f;

    public Spinners(World world) {
        super(world);
        
        Shape topShape = new BoxShape(Width, Height, new Vec2(0, 0.3f));
        Shape botShape = new BoxShape(Width, Height, new Vec2(0, -0.3f));
        Shape rightShape = new BoxShape(Height, Width, new Vec2(0.3f, 0f));
        Shape leftShape = new BoxShape(Height, Width, new Vec2(-0.3f, 0f));
        
        Shape rightFlapShape = new BoxShape(0.5f, Height, new Vec2(0.9f, 0f));
        Shape leftFlapShape = new BoxShape(0.5f, Height, new Vec2(-0.9f, 0f));

        //Friction set to 0 for the middle pieces which revolve around the pivot.
        SolidFixture topFixture = new SolidFixture(this, topShape, 5f);
        topFixture.setFriction(0f);
        SolidFixture botFixture = new SolidFixture(this, botShape, 5f);
        botFixture.setFriction(0f);
        SolidFixture leftFixture = new SolidFixture(this, leftShape, 5f);
        leftFixture.setFriction(0f);
        SolidFixture rightFixture = new SolidFixture(this, rightShape, 5f);
        rightFixture.setFriction(0f);
        
        SolidFixture leftFlapFixture = new SolidFixture(this, leftFlapShape, 5f);
        SolidFixture rightFlapFixture = new SolidFixture(this, rightFlapShape, 5f);

        setGravityScale(0f);
    }
}
