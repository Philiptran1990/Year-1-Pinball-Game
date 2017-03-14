package pinball;

import city.cs.engine.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class Pinball {

    private PinballW world;
    private MyView view;
    private Menu control;
    private int level;
    private final JFrame frame;
    private KeyControls keyControls;
    private BGMusic bgMusic;
    private Credits credits;
    private BGMusic creditMusic;
    private CardLayout cardLayout;
    private JPanel panel;
    
    public Pinball() {
        
        level = 0;
        world = new World1();
        world.fillWorld(this);
        
        panel = new JPanel();
        cardLayout = new CardLayout();
        view = new MyView(world, world.getActor(), world.getSensor(), 650, 650);
        control = new Menu(this);

        //Plays looping background music.
        try {
            bgMusic = new BGMusic("data/music.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Pinball.class.getName()).log(Level.SEVERE, null, ex);
        }

        // display the view in a frame
        frame = new JFrame("Pinball");
        panel.setLayout(cardLayout);
        //view.setGridResolution(1);
        
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        // display the world in the window
        frame.add(panel);
        cardLayout.show(panel, "frame");
        panel.add(control);
        panel.add(view);
        
        
        //resize
        frame.setResizable(false);
        //fit world view
        frame.pack();
        
        // make the window visible
        frame.setVisible(true);
        
        //Keylisteners
        keyControls = new KeyControls (this, world.ballLauncher());
        keyControls = new KeyControls (this, world.leftFlipper());
        keyControls = new KeyControls (this, world.rightFlipper());
        frame.addKeyListener(keyControls);
        
        
        //debugging view
        //JFrame debugView = new DebugViewer(world, 700, 700);
        
        // start!
        world.start();
    }

    public KeyControls getKeyControls() {
        return keyControls;
    }

    public MyView getView() {
        return view;
    }

    public BGMusic getBgMusic() {
        return bgMusic;
    }

    public PinballW getWorld() {
        return world;
    }
    
    public DropSensor getSensor() {
        return world.getSensor();
    }
    
    public Ball getActor() {
        return world.getActor();
    }

    //Goes to next world from current.
    public void goNextLevel() {
        //pauses current world.
        world.setPaused(true);
        //Remembers current level by recording it in level variable.
        level++;
        //Checks which world its currently in.
        if (level == 1) {
            //Starts new world
            world = new World2();
            world.fillWorld(this);
            //Sets keyadapter to various bodies
            keyControls.setBody(this, world.leftFlipper());
            keyControls.setBody(this, world.rightFlipper());
            keyControls.setBody(this, world.ballLauncher());
            view.setWorld(world);
            view.setBall(world.getActor());
            view.setSensor(world.getSensor());
            world.start();
        }
        if (level == 2) {
            world = new World3();
            world.fillWorld(this);
            keyControls.setBody(this, world.leftFlipper());
            keyControls.setBody(this, world.rightFlipper());
            keyControls.setBody(this, world.ballLauncher());
            view.setWorld(world);
            view.setBall(world.getActor());
            view.setSensor(world.getSensor());
            world.start();
        }
        //After final level
        if (level == 3) {
            //Shows message confirming game is complete
            JOptionPane.showMessageDialog(null, "You have succesfully completed the game");
            credits = new Credits(world, 650, 650);
            //Plays a new background song.
            bgMusic.PauseMusic();
            try {
                creditMusic = new BGMusic("data/quinn.wav");
            } catch (    UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Pinball.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Creates a new plain PinballWorld.
            world = new Woooorld();
            //removes keyadapter and previous panels.
            frame.remove(panel);
            frame.removeKeyListener(keyControls);
            frame.add(credits, BorderLayout.CENTER);
            frame.setVisible(true);
            //Sets credit view.
            credits.setWorld(world);
            credits.setVisible(true);
            world.start();
        }
    }

    public int getLevel() {
        return level;
    }

    public Menu getControl() {
        return control;
    }

    public JFrame getFrame() {
        return frame;
    }

    public boolean isCurrentLevelCompleted() {
        return world.levelComplete();
    }

    public void changeCard() {
        cardLayout.next(panel);
    }

    public static void main(String[] args) {
        new Pinball();
    }
}
