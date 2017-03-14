package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

public class Layout3 {

    //Box Sizes
    private static final float thickness = 0.1f;
    private static final float midWidth = 1.25f;
    
    //Triangle corners
    private static final float botTriTopCoord = 2f;
    private static final float botTriRightCoord = 3f;
    private static final float botTriBotCoord = -5f;

    //Angles for mid box.
    private static final float angleUp = 90f;
    private static final float angleMid = 45f;

    //Positions
    private static final float midX = 3f;
    private static final float midY = 3.5f;
    private static final float botTriY = -5f;
    private static final float botTriX = 7f;

    //Shapes.
    //Shape for box in middle.
    Shape midShape = new BoxShape(midWidth, thickness);
    //Shapes for bottom triangles.
    Shape botTriangleShape1 = new PolygonShape(0f, 0f, 0f, botTriTopCoord, botTriRightCoord, botTriBotCoord);
    Shape botTriangleShape2 = new PolygonShape(0f, 0f, 0f, botTriTopCoord, -botTriRightCoord, botTriBotCoord);

    public Layout3(World world) {

        //Mid Box Walls.
        //Right Wall.
        Body mid1 = new StaticBody(world, midShape);
        mid1.setPosition(new Vec2(midX, midY));
        mid1.setAngleDegrees(angleUp);
        mid1.setFillColor(Color.BLACK);
        //Left Wall.
        Body mid2 = new StaticBody(world, midShape);
        mid2.setPosition(new Vec2(-midX, midY));
        mid2.setAngleDegrees(angleUp);
        mid2.setFillColor(Color.BLACK);
        //Top Right Wall.
        Body mid3 = new StaticBody(world, midShape);
        mid3.setPosition(new Vec2(midX - midWidth / 1.75f, midY + midWidth * 1.75f));
        mid3.setAngleDegrees(-angleMid);
        //Top Left Wall.
        Body mid4 = new StaticBody(world, midShape);
        mid4.setPosition(new Vec2(-midX + midWidth / 1.75f, midY + midWidth * 1.75f));
        mid4.setAngleDegrees(angleMid);
        //Bottom Right Wall.
        Body mid5 = new StaticBody(world, midShape);
        mid5.setPosition(new Vec2(midX - midWidth / 1.75f, midY - midWidth * 1.75f));
        mid5.setAngleDegrees(angleMid);
        //Bottom left Wall.
        Body mid6 = new StaticBody(world, midShape);
        mid6.setPosition(new Vec2(-midX + midWidth / 1.75f, midY - midWidth * 1.75f));
        mid6.setAngleDegrees(-angleMid);
        //Bottom Inner Wall.
        Body mid7 = new StaticBody(world, midShape);
        SolidFixture mid7fix = new SolidFixture(mid7, midShape);
        mid7.setPosition(new Vec2(0, 0.5f));
        mid7fix.setRestitution(2);
        //Bottom Outer Wall.
        Body mid8 = new StaticBody(world, midShape);
        mid8.setPosition(new Vec2(0, 0.2f));
        mid8.setFillColor(Color.BLACK);
        
        //Bottom Triangles.
        //Triangle 1 (Far Left).
        Body botTri1 = new StaticBody(world, botTriangleShape1);
        botTri1.setPosition(new Vec2(-botTriX, botTriY));
        botTri1.setFillColor(Color.MAGENTA);
        //Triangle 2 (Far Right).
        Body botTri2 = new StaticBody(world, botTriangleShape2);
        botTri2.setPosition(new Vec2(botTriX, botTriY));
        botTri2.setFillColor(Color.MAGENTA);
        //Triangle 3 (Inner Left).
        Body botTri3 = new StaticBody(world, botTriangleShape2);
        botTri3.setPosition(new Vec2(-botTriX+4, botTriY+2));
        botTri3.setFillColor(Color.MAGENTA);
        botTri3.setAngleDegrees(40);
        //Triangle 4 (Inner Rgiht).
        Body botTri4 = new StaticBody(world, botTriangleShape1);
        botTri4.setPosition(new Vec2(botTriX-4, botTriY+2));
        botTri4.setFillColor(Color.MAGENTA);
        botTri4.setAngleDegrees(-40);
    }
}
