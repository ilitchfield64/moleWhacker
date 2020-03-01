/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molewhacker;
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
import java.awt.geom.*;
import javax.imageio.ImageIO;

//User Input
import java.util.Scanner;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

// System I/O
import java.io.File;
import java.io.IOException;

// Math Functions
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
/**
 *
 * @author Ian
 */
public class MoleWhacker extends JPanel implements MouseListener, MouseMotionListener{
    final int SCREEN_WIDTH = 900;
    final int SCREEN_HEIGHT = 1600;
    
    Rectangle mouseRect;
    Rectangle holeRect1;
    Rectangle holeRect2;
    Rectangle holeRect3;
    Rectangle holeRect4;
    Rectangle holeRect5;
    
    
    public Random Gen = new Random();
    
    Clock updateClock = Clock.systemDefaultZone();
    
    public MoleWhacker(){ // Constructor. tracks movement, and creates data to be used by draw routine
        setPreferredSize(new Dimension(SCREEN_HEIGHT, SCREEN_WIDTH));
        setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);
      
        mouseRect = new Rectangle(0,0,1,1);
        holeRect1 = new Rectangle(100,300,200,200);
        holeRect2 = new Rectangle(400,300,200,200);
        holeRect3 = new Rectangle(700,300,200,200);
        holeRect4 = new Rectangle(1000,300,200,200);
        holeRect5 = new Rectangle(1300,300,200,200);

        
    }

    public void update() {
 
    }
    
    public void paint(Graphics g) { // Draw Routine, puts the thingys on the screen
        super.paint(g);
        g.setColor(Color.red);
        g.fillRect(holeRect1.x,holeRect1.y,holeRect1.width,holeRect1.height);
        g.fillRect(holeRect2.x,holeRect2.y,holeRect2.width,holeRect2.height);
        g.fillRect(holeRect3.x,holeRect3.y,holeRect3.width,holeRect3.height);
        g.fillRect(holeRect4.x,holeRect4.y,holeRect4.width,holeRect4.height);
        g.fillRect(holeRect5.x,holeRect5.y,holeRect5.width,holeRect5.height);
        g.fillRect(mouseRect.x, mouseRect.y, 10, 10);
       
        
    }
    
        public static void main(String[] args) { // Initializes the GUI. THAT'S IT!?
        MoleWhacker game = new MoleWhacker();
        JFrame frame = new JFrame();
        frame.setTitle("Whack-A-Mole");
        frame.add(game);
        frame.pack();
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    
    
    
    
    
    // Weird input stuff?
    @Override
    public void mouseClicked(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        mouseRect.x = e.getX();
        mouseRect.y = e.getY();
        System.out.println("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Moved");

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
