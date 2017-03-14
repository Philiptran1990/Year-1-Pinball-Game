package pinball;

import city.cs.engine.*;
import java.awt.*;
import javax.swing.*;

//Credits class. Used to produce the scrolling credits at the end of the game.
//Userview was used as it was simple to add an image of the credits screen.
//The image could then be continually painted slightly higher up to produce a scrolling effect.
//Switches to this view after the 3rd level is complete and disables "MyView"
public class Credits extends UserView {

    private PinballW pinballw;
    private int i;

    public Credits(PinballW pinballw, int width, int height) {
        super(pinballw, width, height);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        
        ImageIcon credits;
        credits = new ImageIcon("data/Creditsscreen.png");
        
        //Checks how far the image has scrolled. 
        //Once 3000 is reached the increment stops and the scrolling ends.
        if (i < 3300){
        i++;
        }
        
        //Draws the image with the Y axis position based on the current value of i.
        g.drawImage(credits.getImage(), 0, -i, this);
    }
}
