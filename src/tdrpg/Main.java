package tdrpg;

import javax.swing.*;


/**
 *
 * @author Spencer Bryant
 */
public class Main {

	public static JFrame gameFrame;
    public static final int HEIGHT = 673;
    public static final int WIDTH = 646;
	public static int startTime = (int)System.currentTimeMillis() / 1000;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	setupFrame();
        try {
        	gameFrame.setVisible(true);
        	do{
        		pause(40);
        		gameFrame.getContentPane().repaint();
        	} while(true);
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
        	try {
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        }//end try-catch-finally
    } // End method main
    
    /**
     * sets default values for the JFrame and the background content pane
     */
    public static void setupFrame() {
    	gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(WIDTH, HEIGHT);
        BGPanel background = new BGPanel();
        gameFrame.setContentPane(background);
        gameFrame.setResizable(false);
    } // End method setupPanels
    
    /**
     * Pauses the game for a specific amount of time (in ms)
     * @param ms the number of milliseconds to pause the game
     */
    public static void pause (int ms) {
        try {
           Thread.sleep (ms);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    } // End method pause
	//--------------------------------------
}
