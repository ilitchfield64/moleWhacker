/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.awt.event.MouseMotionAdapter;

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
class Hole extends JPanel{
    // Properties
    private static int holeID=0;
    private static int molesHit = 0;
    private static int molesMissed = 0;
    private boolean hasMole = false;
    private boolean hitMole = false; 
    private int location = 0;
    

// Methods
    public void setHasMole(){
        this.hasMole = true;
    }
    public void hitMole(boolean moleHit){
        if (moleHit){
        this.hasMole=false;
        molesHit++;
        }
        
    }
    public void missedMole(){
        this.hasMole=false;
        molesMissed++;
    }
     public void drawHole(int x) {
        Graphics g = getGraphics();
        g.setColor(Color.RED);
        g.drawRect(x, 300, 200, 200);
    }
    public Hole(){
        System.out.println("Hole "+holeID +" Created");
        this.location = holeID;
        holeID++;
        
    }
}


public class MoleWhackerbak extends JPanel {
    // Properties
   
    
    // Methods
        public void drawHole(int x) {
        Graphics g = getGraphics();
        g.setColor(Color.red);
        g.drawRect(x, 300, 200, 200);
    }
    public void hitMole(){
        
    }
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Whack-a-Mole");
        frame.getContentPane().add(new MoleWhackerbak(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setVisible(true);

    }
}

