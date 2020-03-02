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
import java.awt.Font;
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

// Declarations
    //CONSTANTS
    final int SCREEN_HEIGHT = 900;
    final int SCREEN_WIDTH = 1600;
    final Color BROWN = new Color(102,51,0);

    //Game State Variables
    boolean mole1InHole;
    int score = 0;
    int miss = 0;
    int moleLocation = 0;
    
    // Clock Variables
    int timer = 0;
    int timerA = 0;
    int timerF = 0;
    Clock updateClock = Clock.systemDefaultZone();
    Clock temp = Clock.offset(updateClock, Duration.ofMillis(1));
    Instant update = temp.instant();
    
    // Objects on screen
    Rectangle mouseRect;
    Rectangle mole1;
    Rectangle holeRect1;
    Rectangle holeRect2;
    Rectangle holeRect3;
    Rectangle holeRect4;
    Rectangle holeRect5;
    Image mole;    
    // Random Number Generator
    public Random Gen = new Random();

// Methods
    public MoleWhacker(){ 
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); //sets the screen size
        setFocusable(true); // allows the window to be clicked on
        addMouseListener(this); //     // *vv
        addMouseMotionListener(this);  // *>>> Allows the mouse to be used for input

        // Set sizes of the Hitboxes
        mouseRect = new Rectangle(0,0,1,1);
        mole1     = new Rectangle(-200,-200,200,200);
        holeRect1 = new Rectangle(100,300,200,200);
        holeRect2 = new Rectangle(400,300,200,200);
        holeRect3 = new Rectangle(700,300,200,200);
        holeRect4 = new Rectangle(1000,300,200,200);
        holeRect5 = new Rectangle(1300,300,200,200);
        try {
            mole = ImageIO.read(new File("src/molewhacker/mole.png"));
        
        } 
        catch (IOException e) {
            System.out.println("Image missing");
        }
        
    }
    // Changing the mole to another hole
    public void molePlacer(){
        
        switch (Gen.nextInt(5)){
            case 0:
                mole1.x = holeRect1.x;
                mole1.y = holeRect1.y;
                break;
            case 1:
                mole1.x = holeRect2.x;
                mole1.y = holeRect2.y;
                break;
            case 2:
                mole1.x = holeRect3.x;
                mole1.y = holeRect3.y;
                break;
            case 3:
                mole1.x = holeRect4.x;
                mole1.y = holeRect4.y;
                break;            
            case 4:
                mole1.x = holeRect5.x;
                mole1.y = holeRect5.y;
                break;    
        }
    }
    public void removeMole(){
        mole1.x = -1000;
        mole1InHole = false;
        
    }

    // Resets the internal clock
    public void resetUpdateClock() {
        temp = Clock.offset(updateClock, Duration.ofMillis(4));
        update = temp.instant();
        //clock2 = clock2.plusSeconds(2);
    }
    public void update() { // the main loop that code happens in
        timer++; // after 1 second a mole should appear 
        timerF++;
        if (timer >= 500){
            if (!mole1InHole)
            molePlacer();
            
            timer = 0;
        }
        if (mole1InHole && timerF >= 200){
            miss++;
            removeMole();
            timerF = 0;
        }
    }
    
    public void paint(Graphics g) { // Draw Routine, puts the items onto the screen
        super.paint(g);
        // Draws background
        g.setColor(BROWN);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        //Write the score in the corner
        g.setColor(Color.WHITE);
        Font font = new Font("Comic Sans", Font.BOLD,36);
        g.setFont(font);
        g.drawString("Score: " + score, 15, 50);
        g.drawString("Misses: "+ miss, 14, 85);
        
        // Draws the holes that the moles appear out of
        g.setColor(Color.black);
        g.fillRect(holeRect1.x,holeRect1.y,holeRect1.width,holeRect1.height);
        g.fillRect(holeRect2.x,holeRect2.y,holeRect2.width,holeRect2.height);
        g.fillRect(holeRect3.x,holeRect3.y,holeRect3.width,holeRect3.height);
        g.fillRect(holeRect4.x,holeRect4.y,holeRect4.width,holeRect4.height);
        g.fillRect(holeRect5.x,holeRect5.y,holeRect5.width,holeRect5.height);
        // Draws the moles 
        //g.setColor(Color.blue);
        //g.fillRect(mouseRect.x, mouseRect.y, 10, 10);
        g.drawImage(mole, mole1.x, mole1.y, mole1.width , mole1.height, null);
        // Will Update the current clock cycle to prevent CPU speed
        if (updateClock.instant().compareTo(update) >= 0) { //updates clock cycle
            resetUpdateClock();
            update();
        }
        repaint(); // Redraws the screen
        
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
    public void mouseClicked(MouseEvent e) { // Detects when the mouse is clicked and not held
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void mousePressed(MouseEvent e) { // Detects the instant mouse is clicked and held
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      if (mouseRect.intersects(holeRect1)){
             System.out.println("Clicked 1");
        }
        if (mouseRect.intersects(holeRect2)){
            System.out.println("Clicked 2");
        }
        if (mouseRect.intersects(holeRect3)){
            System.out.println("Clicked 3");
        }
        if (mouseRect.intersects(holeRect4)){
            System.out.println("Clicked 4");
        }
        if (mouseRect.intersects(holeRect5)){
            System.out.println("Clicked 5");
        }
        if (mouseRect.intersects(mole1)){
            score++;
            removeMole();
        }
        else{
            miss++;
            removeMole();
        }
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
       
        mouseRect.x = e.getX();
        mouseRect.y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
