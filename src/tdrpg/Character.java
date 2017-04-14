package tdrpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
private boolean canSwim = false;
private BufferedImage[] animationFrames;
private BufferedImage frame;

public Character(){
	
	try {
		animationFrames = new BufferedImage[]{ImageIO.read(new File("sprite.png"))};
				frame = animationFrames[0];
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void resetOverworldValues(){
	canSwim = false;
}

public BufferedImage getCurrentFrame(){
	return frame;
}

public boolean canSwim(){
	return canSwim;
}
}
