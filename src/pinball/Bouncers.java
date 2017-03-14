package pinball;

import city.cs.engine.*;
import java.awt.Color;
import javax.swing.*;
import org.jbox2d.common.Vec2;

//Basic staticbody which be used as objectives in the game for the player to target and collide with
public class Bouncers extends StaticBody {

    //Bouncer Size
    private static final float circleSize = 0.8f;
    
    //Bouncer shape
    private static final Shape shape = new CircleShape(circleSize);

    public Bouncers(World world) {
        super(world, shape);
        
        setFillColor(Color.MAGENTA);
        
        //Uses fixtures to allow bouncers to increase their restitution. 
        //This causes the pinball to bounce off the bouncer with increased speed.
        SolidFixture fixture = new SolidFixture(this, shape);
        fixture.setRestitution(1.5f);
    }
}
