package pinball;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

//Holds the layout for 2nd Level
public class Layout2 {

    //Box Sizes
    private static final float thickness = 0.1f;

    private static final float botWidth = 2.5f;
    private static final float topWidth = 1.5f;

    //Positions.
    //Bottom triangle corners.
    private static final float botTriTopCoord = 2f;
    private static final float botTriRightCoord = 3f;
    private static final float botTriBotCoord = -5f;
    //Top triangle corners.
    private static final float topTriTopCoord = 5f;
    private static final float topTriRightXCoord = 1.5f;
    private static final float topTriTopYCoord = 2.5f;
    //Top left triangle corners.
    private static final float topTriTopXCoord = -5f;
    private static final float topTriBotXCoord = -1f;
    private static final float topTriYCoord = 4f;

    //Box Positions
    private static final float botTriY = -5f;
    private static final float botTriX = 5.7f;
    private static final float botAngle = 53f;

    private static final float topY = 5f;
    private static final float topX = 3f;
    private static final float botX = -5f;

    private static final float topTriY = 5f;
    private static final float topTriX = -8.7f;
    private static final float topTriY1 = 5f;
    private static final float topTriX1 = 0f;

    private static final float spinnerX = 7f;
    private static final float spinnerY = 5f;
    private static final float spinnerX2 = -6f;
    private static final float spinnerY2 = -0.5f;

    //Shapes
    Shape botShape = new BoxShape(botWidth, thickness);
    Shape topShape = new BoxShape(topWidth, thickness);

    Shape botTriangleShape1 = new PolygonShape(0f, 0f, 0f, botTriTopCoord, botTriRightCoord, botTriBotCoord);
    Shape botTriangleShape2 = new PolygonShape(0f, 0f, 0f, botTriTopCoord, -botTriRightCoord, botTriBotCoord);

    Shape topTriangleShape1 = new PolygonShape(0f, 0f, 0f, topTriTopCoord, topTriRightXCoord, topTriTopYCoord);
    Shape topTriangleShape2 = new PolygonShape(0f, 0f, topTriBotXCoord, 0f, topTriTopXCoord, topTriYCoord);
    Shape topTriangleShape3 = new PolygonShape(0f, 0f, topTriBotXCoord, 0f, topTriTopXCoord, -topTriYCoord);

    Shape portTriangleShape = new PolygonShape(0f, 0f, 0f, topTriTopCoord, -topTriRightXCoord, topTriTopYCoord);
    Shape port1TriangleShape1 = new PolygonShape(0f, 0f, topTriBotXCoord / 2, 0f, topTriTopXCoord / 2, topTriYCoord);

    public Layout2(World world) {

        Body top1 = new StaticBody(world, topShape);
        top1.setPosition(new Vec2(-botX, topY));
        top1.setAngleDegrees(botAngle);
        top1.setFillColor(Color.MAGENTA);

        Body top3 = new StaticBody(world, topShape);
        top3.setPosition(new Vec2(topX, topY));
        top3.setAngleDegrees(botAngle);
        top3.setFillColor(Color.MAGENTA);

        Body botTri1 = new StaticBody(world, botTriangleShape1);
        botTri1.setPosition(new Vec2(-botTriX, botTriY));
        botTri1.setFillColor(Color.MAGENTA);

        Body botTri2 = new StaticBody(world, botTriangleShape2);
        botTri2.setPosition(new Vec2(botTriX, botTriY));
        botTri2.setFillColor(Color.MAGENTA);

        Body topTri = new StaticBody(world, topTriangleShape1);
        topTri.setPosition(new Vec2(topTriX, topTriY - 5f));
        Body topTri1 = new StaticBody(world, topTriangleShape1);
        topTri1.setPosition(new Vec2(topTriX, topTriY));

        Body topTri2 = new StaticBody(world, topTriangleShape2);
        topTri2.setPosition(new Vec2(topTriX1, topTriY1));
        Body topTri3 = new StaticBody(world, topTriangleShape3);
        topTri3.setPosition(new Vec2(topTriX1, topTriY1));

        Body portTri = new StaticBody(world, portTriangleShape);
        portTri.setPosition(new Vec2(9, 0));
        Body portTri1 = new StaticBody(world, port1TriangleShape1);
        portTri1.setPosition(new Vec2(9.2f, -3.5f));

        Spinners spinner = new Spinners(world);
        Shape coorcle = new CircleShape(0.2f);
        Spinners spinner2 = new Spinners(world);

        StaticBody pin = new StaticBody(world, coorcle);
        pin.setPosition(new Vec2(spinnerX, spinnerY));
        
        spinner.setPosition(new Vec2(spinnerX, spinnerY));
        StaticBody pin2 = new StaticBody(world, coorcle);
        pin2.setPosition(new Vec2(spinnerX2, spinnerY2));
        spinner2.setPosition(new Vec2(spinnerX2, spinnerY2));
        spinner.setAngularVelocity(1.5f);
        spinner2.setAngularVelocity(-1.5f);

    }

}
