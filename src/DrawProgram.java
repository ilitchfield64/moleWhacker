

// Window
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
// Content
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.imageio.ImageIO;

//User Input
import java.util.Scanner;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

// System I/O
import java.io.File;
import java.io.IOException;

// Math Functions
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

@SuppressWarnings("serial")
public class DrawProgram extends JPanel{

    private Point lastPoint;
    
    public DrawProgram() {
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                lastPoint = new Point(e.getX(), e.getY());
                
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                Graphics g = getGraphics();
                g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                g.dispose();
            }
        });
        
    }
    
    public static void main(String args[]){
        JFrame frame = new JFrame("Draw Program");
        frame.getContentPane().add(new DrawProgram(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        
        
        
        
    }
    
    
    

}
// Layout




// Graphics



// User Input




        


