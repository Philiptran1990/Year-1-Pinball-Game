package pinball;

import java.awt.Graphics;
import javax.swing.*;

public class Menu extends JPanel {

    private PinballW world;
    private final Pinball pinball;
    private final ImageIcon instructions;
    private JLayeredPane jLayeredPane2;
    private JLayeredPane jLayeredPane1;

    public Menu(Pinball pinball) {
        this.pinball = pinball;
        initComponents();
        this.instructions = new ImageIcon("data/instructions2.png");
    }

    //Code used from JPanel form Source and modified.
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );

        jLayeredPane2.setOpaque(true);
        jLayeredPane2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
    }

    //Paints instruction image in foreground.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(instructions.getImage(), 0, 0, null); // see javadoc for more info on the parameters            
    }
}
