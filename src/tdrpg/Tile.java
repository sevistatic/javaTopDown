package tdrpg;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tile{

	public enum type {WATER, ROCK, GROUND, TREE, BUSH, DOOR, UNMOVABLE};
	
	private BufferedImage image;
	private type tileType;
	
	public Tile(BufferedImage img, type t) {
		this.image = img;
		this.tileType = t;
	}

	public int getWidth(){
		return image.getWidth();
	}
	public int getHeight(){
		return image.getHeight();
	}
	public Image getImage(){
		return image;
	}
	public type getType(){
		return this.tileType;
	}
}
