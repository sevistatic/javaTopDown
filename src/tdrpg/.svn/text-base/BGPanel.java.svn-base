package tdrpg;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BGPanel extends JPanel implements KeyListener{
	
	public static Overworld overworld;
	public static boolean upPressed = false;
	public static boolean downPressed = false;
	public static boolean leftPressed = false;
	public static boolean rightPressed = false;
	public static boolean lTriggerPressed = false;
	public static boolean rTriggerPressed = false;
	
	BGPanel(){
		overworld = new Overworld();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {640};
		gridBagLayout.rowHeights = new int[] {640};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_overworld = new GridBagConstraints();
		gbc_overworld.gridx = 0;
		gbc_overworld.gridy = 0;
		overworld.setFocusable(true);
		overworld.addKeyListener(this);
		add(overworld, gbc_overworld);
		
		
	}//end constructor
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			//minimap.move(TDRPGConstants.RIGHT);
			rightPressed = true;
			break;
		case KeyEvent.VK_LEFT:
			//minimap.move(TDRPGConstants.LEFT);
			leftPressed = true;
			break;
		case KeyEvent.VK_UP:
			//minimap.move(TDRPGConstants.UP);
			upPressed = true;
			break;
		case KeyEvent.VK_DOWN:
			//minimap.move(TDRPGConstants.DOWN);
			downPressed = true;
			break;
		case KeyEvent.VK_NUMPAD6:
			rTriggerPressed = true;
			//minimap.rotate(TDRPGConstants.CLOCKWISE);
			break;
		case	KeyEvent.VK_NUMPAD4:
			lTriggerPressed = true;
			//minimap.rotate(TDRPGConstants.COUNTERCLOCKWISE);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			//minimap.move(TDRPGConstants.RIGHT);
			rightPressed = false;
			break;
		case KeyEvent.VK_LEFT:
			//minimap.move(TDRPGConstants.LEFT);
			leftPressed = false;
			break;
		case KeyEvent.VK_UP:
			//minimap.move(TDRPGConstants.UP);
			upPressed = false;
			break;
		case KeyEvent.VK_DOWN:
			//minimap.move(TDRPGConstants.DOWN);
			downPressed = false;
			break;
		case KeyEvent.VK_NUMPAD6:
			rTriggerPressed = false;
			//minimap.rotate(TDRPGConstants.CLOCKWISE);
			break;
		case	KeyEvent.VK_NUMPAD4:
			lTriggerPressed = false;
			//minimap.rotate(TDRPGConstants.COUNTERCLOCKWISE);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}//end class
