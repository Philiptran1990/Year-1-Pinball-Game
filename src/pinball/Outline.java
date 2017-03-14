package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

//Outline for the Pinball
public class Outline {

    //Box Sizes
    private static final float thickness = 0.25f;
    
    private static final float groundWidth = 4.3f;
    private static final float ceilingWidth = 6f;
    private static final float wallWidth = 10f;
    
    private static final float anchorSize = 0.2f;
    
    private static final float pistonWidth = 2.5f;
    private static final float pistonGround = 2.5f;
    private static final float pistonLockHeight = 0.51f;
    private static final float pistonLockWidth = 0.25f;

    //Box Positions
    private static final float groundX = 6.6f;
    private static final float groundY = -9.4f;
    
    private static final float alignment = 1f;
    
    private static final float ceilingXdisposition = 8f;
    private static final float ceilingY = 14.5f;
    private static final float ceilingYdisposition = 2.2f;
    
    private static final float wallX = 10f;
    
    private static final float topAnchorY = -13.0f;
    private static final float botAnchorY = -14.2f;
    private static final float botLAnchorX = -5.4f;
    private static final float botRAnchorX = -4.5f;
    private static final float topLAnchorX = -4.8f;
    private static final float topRAnchorX = -5.2f;
    
    private static final float pistonX = 2.3f;
    private static final float pistonY = -19.5f;
    private static final float angle90 = 90f;
    
    private static final float pistonLockX = 2.7f;
    private static final float pistonLockY = -16.7f;
    
    private static final float launchX = 11.2f;
    private static final float launchY = -13;
    
    private static final float launchLockX = 10.8f;
    private static final float launchLockY = -10.2f;

    //Shapes
    Shape groundShape = new BoxShape(groundWidth, thickness);
    Shape ceilingShape = new BoxShape(ceilingWidth, thickness);
    Shape ceilingShape2 = new BoxShape(ceilingWidth / 2, thickness);
    Shape wallShape = new BoxShape(thickness, wallWidth);
    Shape wallShape2 = new BoxShape(thickness, wallWidth - 0.5f);
    Shape anchorShape = new CircleShape(anchorSize);
    Shape pistonHouseShape = new BoxShape(pistonWidth, thickness / 2);
    Shape pistonHouseGround = new BoxShape(pistonGround, thickness / 2);
    Shape pistonLockShape = new BoxShape(pistonLockWidth, pistonLockHeight);

    public Outline(World world) {

        //Ground walls.
        Body ground = new StaticBody(world, groundShape);
        ground.setPosition(new Vec2(-groundX, groundY));
        ground.setAngle(-1f);
        ground.setFillColor(Color.black);
        
        Body ground2 = new StaticBody(world, groundShape);
        ground2.setPosition(new Vec2(groundX, groundY));
        ground2.setAngle(1f);
        ground2.setFillColor(Color.black);
        
        //Ceiling walls.
        Body ceiling = new StaticBody(world, ceilingShape);
        ceiling.setPosition(new Vec2(alignment, ceilingY));
        ceiling.setFillColor(Color.black);
        
        Body ceiling1 = new StaticBody(world, ceilingShape2);
        ceiling1.setPosition(new Vec2(alignment - ceilingXdisposition, ceilingY - ceilingYdisposition));
        ceiling1.setAngle(0.8f);
        ceiling1.setFillColor(Color.black);
        
        Body ceiling2 = new StaticBody(world, ceilingShape2);
        ceiling2.setPosition(new Vec2(alignment + ceilingXdisposition, ceilingY - ceilingYdisposition));
        ceiling2.setAngle(-0.8f);
        ceiling2.setFillColor(Color.black);
        
        //Side walls.
        Body wall = new StaticBody(world, wallShape);
        wall.setPosition(new Vec2(alignment - wallX, 0));
        wall.setFillColor(Color.black);
        
        Body wall2 = new StaticBody(world, wallShape);
        wall2.setPosition(new Vec2(alignment + wallX, 0));
        wall2.setFillColor(Color.black);
        
        Body wall3 = new StaticBody(world, wallShape2);
        wall3.setPosition(new Vec2(wallX - 1, -1));
        wall3.setFillColor(Color.black);
        
        //Left anchors
        Body lAnchor = new StaticBody(world, anchorShape);
        Body lAnchor2 = new StaticBody(world, anchorShape);
        Body lAnchor3 = new StaticBody(world, anchorShape);
        Body lAnchor4 = new StaticBody(world, anchorShape);
        lAnchor.setPosition(new Vec2(topLAnchorX, topAnchorY));
        lAnchor2.setPosition(new Vec2(botRAnchorX, botAnchorY));
        lAnchor3.setPosition(new Vec2(topRAnchorX, topAnchorY));
        lAnchor4.setPosition(new Vec2(botLAnchorX, botAnchorY));
        lAnchor.setFillColor(Color.black);
        lAnchor2.setFillColor(Color.black);
        lAnchor3.setFillColor(Color.black);
        lAnchor4.setFillColor(Color.black);
        
        //Right anchors
        Body rAnchor = new StaticBody(world, anchorShape);
        Body rAnchor2 = new StaticBody(world, anchorShape);
        Body rAnchor3 = new StaticBody(world, anchorShape);
        Body rAnchor4 = new StaticBody(world, anchorShape);
        rAnchor.setPosition(new Vec2(-topLAnchorX, topAnchorY));
        rAnchor2.setPosition(new Vec2(-botRAnchorX, botAnchorY));
        rAnchor3.setPosition(new Vec2(-topRAnchorX, topAnchorY));
        rAnchor4.setPosition(new Vec2(-botLAnchorX, botAnchorY));
        rAnchor.setFillColor(Color.black);
        rAnchor2.setFillColor(Color.black);
        rAnchor3.setFillColor(Color.black);
        rAnchor4.setFillColor(Color.black);
        
        //Piston Platform
        Body rPiston = new StaticBody(world, pistonHouseGround);
        rPiston.setPosition(new Vec2(pistonX + 2.2f + thickness, pistonY - 3.5f));
        Body rPiston1 = new StaticBody(world, pistonHouseShape);
        rPiston1.setPosition(new Vec2(pistonX, pistonY));
        rPiston1.setAngleDegrees(angle90);
        Body rPiston2 = new StaticBody(world, pistonHouseShape);
        rPiston2.setPosition(new Vec2(pistonX + 2.2f + thickness, pistonY));
        rPiston2.setAngleDegrees(angle90);
        Body lPiston = new StaticBody(world, pistonHouseGround);
        lPiston.setPosition(new Vec2(-pistonX - 2.2f - thickness, pistonY - 3.5f));
        Body lPiston1 = new StaticBody(world, pistonHouseShape);
        lPiston1.setPosition(new Vec2(-pistonX, pistonY));
        lPiston1.setAngleDegrees(angle90);
        Body lPiston2 = new StaticBody(world, pistonHouseShape);
        lPiston2.setPosition(new Vec2(-pistonX - 2.2f - thickness, pistonY));
        lPiston2.setAngleDegrees(angle90);
        Body lPistonLock1 = new StaticBody(world, pistonLockShape);
        lPistonLock1.setPosition(new Vec2(-pistonLockX, pistonLockY));
        Body lPistonLock2 = new StaticBody(world, pistonLockShape);
        lPistonLock2.setPosition(new Vec2(-pistonLockX - 1.65f, pistonLockY));
        Body rPistonLock1 = new StaticBody(world, pistonLockShape);
        rPistonLock1.setPosition(new Vec2(pistonLockX, pistonLockY));
        Body rPistonLock2 = new StaticBody(world, pistonLockShape);
        rPistonLock2.setPosition(new Vec2(pistonLockX + 1.65f, pistonLockY));

        //Launcher Outline
        Body launcher = new StaticBody(world, pistonHouseGround);
        launcher.setPosition(new Vec2(launchX - thickness, launchY - 2.6f));
        launcher.setImage(new BodyImage("data/invisible.png"));
        Body launcher1 = new StaticBody(world, pistonHouseShape);
        launcher1.setPosition(new Vec2(launchX, launchY));
        launcher1.setAngleDegrees(angle90);
        launcher1.setImage(new BodyImage("data/invisible.png"));
        Body launcher2 = new StaticBody(world, pistonHouseShape);
        launcher2.setPosition(new Vec2(launchX - 2.2f - thickness, launchY));
        launcher2.setAngleDegrees(angle90);
        launcher2.setImage(new BodyImage("data/invisible.png"));
        Body launcherLock1 = new StaticBody(world, pistonLockShape);
        launcherLock1.setPosition(new Vec2(launchLockX, launchLockY));
        launcherLock1.setImage(new BodyImage("data/invisible.png"));
        Body launcherLock2 = new StaticBody(world, pistonLockShape);
        launcherLock2.setPosition(new Vec2(launchLockX - 1.65f, launchLockY));
        launcherLock2.setImage(new BodyImage("data/invisible.png"));
    }
}
