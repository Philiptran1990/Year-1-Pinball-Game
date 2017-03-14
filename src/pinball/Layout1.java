package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

//Holds the layout for level 1
public class Layout1 {

    //Box Sizes
    private static final float thickness = 0.125f;

    private static final float botWidth = 3f;
    private static final float topWidth = 1.5f;

    //Box Positions
    private static final float botY = -5f;
    private static final float botX = 5f;
    private static final float botAngle = 45f;

    private static final float topY = 5f;
    private static final float topX = 3f;

    private static final float obstacle1pos = -4;
    private static final float obstacleXanchor = 20;

    //Shapes
    Shape botShape = new BoxShape(botWidth, thickness);
    Shape topShape = new BoxShape(topWidth, thickness);
    Shape anchorShape = new BoxShape(0.485f, botWidth);
    Shape anchorCShape = new BoxShape(0.49f, 0.49f);

    public Layout1(World world) {

        //Bottom Left Object
        Body bot1 = new StaticBody(world, botShape);
        bot1.setPosition(new Vec2(-botX, botY));
        bot1.setAngleDegrees(-botAngle);
        bot1.setFillColor(Color.MAGENTA);
        //Bottom Right Object        
        Body bot2 = new StaticBody(world, botShape);
        bot2.setPosition(new Vec2(botX, botY));
        bot2.setAngleDegrees(botAngle);
        bot2.setFillColor(Color.MAGENTA);

        //Top Objects
        Body top1 = new StaticBody(world, topShape);
        top1.setPosition(new Vec2(-botX, topY));
        top1.setAngleDegrees(botAngle);
        top1.setFillColor(Color.MAGENTA);

        Body top2 = new StaticBody(world, topShape);
        top2.setPosition(new Vec2(-topX, topY));
        top2.setAngleDegrees(-botAngle);
        top2.setFillColor(Color.MAGENTA);

        Body top3 = new StaticBody(world, topShape);
        top3.setPosition(new Vec2(topX, topY));
        top3.setAngleDegrees(botAngle);
        top3.setFillColor(Color.MAGENTA);

        Body top4 = new StaticBody(world, topShape);
        top4.setPosition(new Vec2(botX, topY));
        top4.setAngleDegrees(-botAngle);
        top4.setFillColor(Color.MAGENTA);

        //Moving Obstacle objects.
        //Obstacle 1
        Obstacles obstacle1 = new Obstacles(world);
        obstacle1.setPosition(new Vec2(obstacle1pos, 0));
        //Obstacle 1 anchors
        Body obstacle1Lanchor = new StaticBody(world, anchorShape);
        obstacle1Lanchor.setPosition(new Vec2(-obstacleXanchor + obstacle1pos, 0));

        Body obstacle1Lanchor2 = new StaticBody(world, anchorShape);
        obstacle1Lanchor2.setPosition(new Vec2(-obstacleXanchor + obstacle1pos + 2, 0));

        Body obstacle1LCanchor = new StaticBody(world, anchorCShape);
        obstacle1LCanchor.setPosition(new Vec2(-obstacleXanchor + obstacle1pos + 1, 4));

        Body obstacle1LGanchor = new StaticBody(world, anchorCShape);
        obstacle1LGanchor.setPosition(new Vec2(-obstacleXanchor + obstacle1pos + 1, -4));

        Body obstacle1Ranchor = new StaticBody(world, anchorShape);
        obstacle1Ranchor.setPosition(new Vec2(obstacleXanchor + obstacle1pos, 0));

        Body obstacle1Ranchor2 = new StaticBody(world, anchorShape);
        obstacle1Ranchor2.setPosition(new Vec2(obstacleXanchor + obstacle1pos - 2, 0));

        Body obstacle1RCanchor = new StaticBody(world, anchorCShape);
        obstacle1RCanchor.setPosition(new Vec2(obstacleXanchor + obstacle1pos - 1, 4));

        Body obstacle1RGanchor = new StaticBody(world, anchorCShape);
        obstacle1RGanchor.setPosition(new Vec2(obstacleXanchor + obstacle1pos - 1, -4));

        //Obstacle 2
        Obstacles obstacle2 = new Obstacles(world);
        obstacle2.setPosition(new Vec2(-obstacle1pos, 0));
        //Obstacle 2 Anchors
        Body obstacle2Lanchor = new StaticBody(world, anchorShape);
        obstacle2Lanchor.setPosition(new Vec2(obstacleXanchor - obstacle1pos, 0));

        Body obstacle2Lanchor2 = new StaticBody(world, anchorShape);
        obstacle2Lanchor2.setPosition(new Vec2(obstacleXanchor - obstacle1pos - 2, 0));

        Body obstacle2LCanchor = new StaticBody(world, anchorCShape);
        obstacle2LCanchor.setPosition(new Vec2(obstacleXanchor - obstacle1pos - 1, 4));

        Body obstacle2LGanchor = new StaticBody(world, anchorCShape);
        obstacle2LGanchor.setPosition(new Vec2(obstacleXanchor - obstacle1pos - 1, -4));

        Body obstacle2Ranchor = new StaticBody(world, anchorShape);
        obstacle2Ranchor.setPosition(new Vec2(-obstacleXanchor - obstacle1pos, 0));

        Body obstacle2Ranchor2 = new StaticBody(world, anchorShape);
        obstacle2Ranchor2.setPosition(new Vec2(-obstacleXanchor - obstacle1pos + 2, 0));

        Body obstacle2RCanchor = new StaticBody(world, anchorCShape);
        obstacle2RCanchor.setPosition(new Vec2(-obstacleXanchor - obstacle1pos + 1, 4));

        Body obstacle2RGanchor = new StaticBody(world, anchorCShape);
        obstacle2RGanchor.setPosition(new Vec2(-obstacleXanchor - obstacle1pos + 1, -4));
    }
}
