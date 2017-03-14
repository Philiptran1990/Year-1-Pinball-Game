package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

//Flipper class used to create flippers for the player to control the ball with.
//Dynamicbody was the only option as staticbodies can not be moved.
//Staticbodies can be repositioned but as a result do to calculate the correct velocity of the ball after collision.
//These flippers are used in conjunction with 4 staticbody "anchors" which keep them in place but free to rotate.
//Another flipper design worked whereby the flipper had a hole in the middle of the axle.
//This allowed one pin the hold the flipper in place but this design was disgarded as this design felt more life like.
public class Flipper extends DynamicBody {

    //Width and height of the paddle section of the flippers
    private static final float Width = 2.1f;
    private static final float Height = 0.15f;
    
    //Size of the circular axle section of the flippers
    private static final float Axle = 0.5f;
    
    public Flipper(World world) {
        super(world);
        //The paddle section of the flipper is a boxshape placed -2
        //from the center of the flipper or the flipper would be a seesaw shape.
        Shape mainShape = new BoxShape(Width, Height, new Vec2(-2, 0));
        
        //Creates the circular axle which the flipper pivots around
        Shape axleShape = new CircleShape(Axle);
        
        //The main ficture makes up the paddle section
        SolidFixture mainFixture = new SolidFixture(this, mainShape, 5f);
        //this fixture makes up the axle section
        SolidFixture fixture = new SolidFixture(this, axleShape, 1f);
        
        //Sets the friction of the axle fixture to 0 to allow free rotation
        fixture.setFriction(0f);
        
        //Paddle has restitution of 0.5. Higher values made the ball bounce too quickly.
        mainFixture.setRestitution(0.5f);
        
        //Makes the flippers drop slghtly faster
        setGravityScale(2.2f);
    }
}
