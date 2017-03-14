package pinball;

import city.cs.engine.*;
import java.awt.*;
import javax.swing.*;

//UserView used to present view of world and place basic GUI.
public class MyView extends UserView {

    private Ball ball;
    private KeyControls key;
    private DropSensor sensor;
    private Pinball pinball;
    private PinballW pinballw;
    private int check;
    private int i;
    private int move = 1;
    private int timer;
    private int movement;
    private int power;
    
    public MyView(PinballW pinballw, Ball ball, DropSensor sensor, int width, int height) {
        super(pinballw, width, height);
        this.ball = ball;
        this.sensor = sensor;
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        
        ImageIcon syndra;
        syndra = new ImageIcon("data/syndragif.gif");
                  
        ImageIcon ballImage;
        ballImage = new ImageIcon("data/orbs.png");
        
        //Draws character in bottom right.
        g.drawImage(syndra.getImage(), 258, 358, this);
        //Sets text to white.
        g.setColor(Color.white);
        //Draws Score, Lives and a Timer on the side.
        g.drawString("Score is: " + this.ball.score, 560, 120);
        g.drawString("Lives Remaining: " + sensor.getLives(), 520, 80);
        timer++;
        g.drawString("Time: " + timer / 30, 520, 50);
        
        //Checks which direction the increment should go in.
        //As the increment increases and decreases movement value is calculated to provide Coordinates for the orbs to be drawn in.
        if (move == 1) {
            //Increases increment till it hits 50.
            i++;
            movement = i * i;
            if (i == 50) {
                move = 0;
            }
        } else if (move == 0) {
            //Decreases increment till it hits -50.
            i--;
            movement = i * i;
            if (i == -50) {
                move = 1;
            }
        }
        
        //Checks how many lives the player has.
        //Draws an Orb for each remaining life the player has and stops drawing them as the player loses lives.
        //Draws orbs using movement value to provide more interesting travel pattern.
        check = sensor.getLives();
        if (check > 0) {
            g.drawImage(ballImage.getImage(), 460 + (movement ^ 2) / 50, 550 - (i ^ 2) / 20, this);
        }
        if (check > 1) {
            g.drawImage(ballImage.getImage(), 420 - i / 5, 510 + movement / 40, this);
        }
        if (check > 2) {
            g.drawImage(ballImage.getImage(), 520 + i / 4, 280 + movement / 57, this);
        }
        if (check > 3) {
            g.drawImage(ballImage.getImage(), 530 + movement / 40, 560 - i / 5, this);
        }
        if (check > 4) {
            g.drawImage(ballImage.getImage(), 570 - i / 6, 320 + i / 4, this);
        }
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public DropSensor getSensor() {
        return sensor;
    }

    public void setSensor(DropSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        ImageIcon background;
        background = new ImageIcon("data/template.png");
        g.drawImage(background.getImage(), 0, 0, this);
    }
}
