import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * DrawTree.java
 *
 * Calvin Wong
 *
 * A class that draws Tree; Override paint method and use graphics object to draw
 */

public class DrawTree extends JFrame {

    public DrawTree() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {

        g.drawString(PersonsList.TreeList.get(0).name, 355, 80);
        g.setColor(Color.black);
        for (LineInfo e : LineInfo.edgeList) {
            try {
                g.drawLine(e.x1, e.y1, e.x2, e.y2);
                g.drawString(e.name1, e.x1 + 5, e.y1);
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(DrawTree.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
} // end of class