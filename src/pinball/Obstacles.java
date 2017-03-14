package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

//Dynamic bodies which move back and forth on the level to block the ball.
public class Obstacles extends DynamicBody {

    private static final float Width = 0.2f;
    private static final float Height = 0.5f;
    
    public Obstacles(World world) {
        super(world);
        
        Shape topShape = new BoxShape(Width, Height, new Vec2(0, 0.3f));
        Shape botShape = new BoxShape(Width, Height, new Vec2(0, -0.3f));
        Shape rightShape = new BoxShape(Height, Width, new Vec2(0.3f, 0f));
        Shape leftShape = new BoxShape(Height, Width, new Vec2(-0.3f, 0f));
        
        Shape rightFlapShape = new BoxShape(Height, Height, new Vec2(19f, 0f));
        Shape leftFlapShape = new BoxShape(Height, Height, new Vec2(-19f, 0f));

        SolidFixture topFixture = new SolidFixture(this, topShape, 5f);
        topFixture.setFriction(0f);
        SolidFixture botFixture = new SolidFixture(this, botShape, 5f);
        botFixture.setFriction(0f);
        SolidFixture leftFixture = new SolidFixture(this, leftShape, 5f);
        leftFixture.setFriction(0f);
        SolidFixture rightFixture = new SolidFixture(this, rightShape, 5f);
        rightFixture.setFriction(0f);
        
        //Set restitution of side parts to 1 to allow it to bounce perfectly.
        //Friction also reduced to prevent the object form slowing down
        SolidFixture leftFlapFixture = new SolidFixture(this, leftFlapShape, 15f);
        leftFlapFixture.setFriction(0);
        leftFlapFixture.setRestitution(1);
        SolidFixture rightFlapFixture = new SolidFixture(this, rightFlapShape, 15f);
        rightFlapFixture.setFriction(0);
        rightFlapFixture.setRestitution(1);
        
        //Gravity disabled to allow the object to float
        setGravityScale(0f);
        
        //Starts gentle movement for the objects
        this.setLinearVelocity(new Vec2(0,4));
        
        //Prevents rotation
        setFixedRotation(true);
    }
}
