package tdrpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import tdrpg.Tile.type;

public class Overworld extends JPanel{

	private int spriteX = 8;
	private int spriteY = 8;
	private int envXStart = 0;
	private int envYStart = 0;
	private File file;
	private Tile[][] tiles = new Tile[153][153];
	private Tile tree;
	private Tile dirt;
	private Tile grass;
	
	private Tile waterN;
	private Tile waterS;
	private Tile waterE;
	private Tile waterW;
	private Tile waterC;
	private Tile waterNE;
	private Tile waterNW;
	private Tile waterSE;
	private Tile waterSW;
	private Tile waterNETurn;
	private Tile waterNWTurn;
	private Tile waterSETurn;
	private Tile waterSWTurn;
	
	private Character character;
	private Scanner scanner;
	
	public Overworld(){
		setBackground(Color.BLACK);
		try{
			file = new File("bgfile1.txt");
			
			tree = new Tile(ImageIO.read(new File("tree.png")), Tile.type.TREE);
			grass = new Tile(ImageIO.read(new File("grass.png")), Tile.type.GROUND);
			dirt = new Tile(ImageIO.read(new File("dirt.png")), Tile.type.GROUND);
			
			tree = new Tile(ImageIO.read(new File("tree.png")), Tile.type.TREE);
			
			character = new Character();
			
			waterN = new Tile(ImageIO.read(new File("waterTop.png")), Tile.type.WATER);
			waterS = new Tile(ImageIO.read(new File("waterBottom.png")), Tile.type.WATER);
			waterE = new Tile(ImageIO.read(new File("waterRight.png")), Tile.type.WATER);
			waterW = new Tile(ImageIO.read(new File("waterLeft.png")), Tile.type.WATER);
			waterC = new Tile(ImageIO.read(new File("waterCenter.png")), Tile.type.WATER);
			waterNE = new Tile(ImageIO.read(new File("waterNECorner.png")), Tile.type.WATER);
			waterNW = new Tile(ImageIO.read(new File("waterNWCorner.png")), Tile.type.WATER);
			waterSE = new Tile(ImageIO.read(new File("waterSECorner.png")), Tile.type.WATER);
			waterSW = new Tile(ImageIO.read(new File("waterSWCorner.png")), Tile.type.WATER);
			waterNETurn = new Tile(ImageIO.read(new File("waterNETurn.png")), Tile.type.WATER);
			waterNWTurn = new Tile(ImageIO.read(new File("waterNWTurn.png")), Tile.type.WATER);
			waterSETurn = new Tile(ImageIO.read(new File("waterSETurn.png")), Tile.type.WATER);
			waterSWTurn = new Tile(ImageIO.read(new File("waterSWTurn.png")), Tile.type.WATER);
			
			scanner = new Scanner(file);
		}catch(Exception e){
			System.out.println("no file");
		}
		readENVFile();
	}
	
	public void checkMovement(){
		if (BGPanel.leftPressed){
			//if not moving area past map boundary
			if (envXStart > 0 && 
					 //not moving into a tree
					!tiles[envYStart + spriteY][envXStart + spriteX -1]
							.getType().equals(type.TREE) &&
							//not moving into water without being able to swim
					(!tiles[envYStart + spriteY][envXStart + spriteX -1]
							.getType().equals(type.WATER)) || character.canSwim()){
				envXStart--;
			}
		}
		if (BGPanel.rightPressed){
			if (envXStart + 17 < 153 && 
				!tiles[envYStart + spriteY][envXStart + spriteX +1]
						.getType().equals(type.TREE) && 
				(!tiles[envYStart + spriteY][envXStart + spriteX +1]
						.getType().equals(type.WATER) || character.canSwim())){
				envXStart++;
			}
		}
		if (BGPanel.upPressed){
			if (envYStart > 0 && 
				!tiles[envYStart + spriteY - 1][envXStart + spriteX]
						.getType().equals(type.TREE) && 
				(!tiles[envYStart + spriteY - 1][envXStart + spriteX]
						.getType().equals(type.WATER) || character.canSwim())){
				envYStart -= 1;
			}
		}
		if (BGPanel.downPressed){
			if (envYStart + 17 < 153 && 
				!tiles[envYStart + spriteY + 1][envXStart + spriteX]
						.getType().equals(type.TREE) && 
				(!tiles[envYStart + spriteY + 1][envXStart + spriteX]
						.getType().equals(type.WATER) || character.canSwim())){
				envYStart += 1;
			}
		}
	}
	
	public void readENVFile(){
		String s;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int yIndex = 0; yIndex < 153; yIndex++){
			s = scanner.nextLine();
			if (s.equals("")){
				s = scanner.nextLine();//blank lines separate screens horizontally
			}
			for (int xIndex = 0; xIndex < 153; xIndex++){
				System.out.print(s.charAt(xIndex));
				if (s.charAt(xIndex) == 'd'){
					tiles[yIndex][xIndex] = dirt;
				} else if (s.charAt(xIndex) == 't'){
					tiles[yIndex][xIndex] = tree;
				} else if (s.charAt(xIndex) == 'g'){
					tiles[yIndex][xIndex] = grass;
				} else if (s.charAt(xIndex) == '7'){
					tiles[yIndex][xIndex] = waterNW;
				} else if (s.charAt(xIndex) == '9'){
					tiles[yIndex][xIndex] = waterNE;
				} else if (s.charAt(xIndex) == '1'){
					tiles[yIndex][xIndex] = waterSW;
				} else if (s.charAt(xIndex) == '3'){
					tiles[yIndex][xIndex] = waterSE;
				} else if (s.charAt(xIndex) == '8'){
					tiles[yIndex][xIndex] = waterN;
				} else if (s.charAt(xIndex) == '2'){
					tiles[yIndex][xIndex] = waterS;
				} else if (s.charAt(xIndex) == '6'){
					tiles[yIndex][xIndex] = waterE;
				} else if (s.charAt(xIndex) == '4'){
					tiles[yIndex][xIndex] = waterW;
				} else if (s.charAt(xIndex) == '5'){
					tiles[yIndex][xIndex] = waterC;
				}else if (s.charAt(xIndex) == 'y'){
					tiles[yIndex][xIndex] = waterNWTurn;
				} else if (s.charAt(xIndex) == 'u'){
					tiles[yIndex][xIndex] = waterNETurn;
				} else if (s.charAt(xIndex) == 'h'){
					tiles[yIndex][xIndex] = waterSWTurn;
				} else if (s.charAt(xIndex) == 'j'){
					tiles[yIndex][xIndex] = waterSETurn;
				}
			}
		}
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        checkMovement();
        for (int i = 0; i < 17; i++){
        	for (int j = 0; j < 17; j++){
        		g.drawImage(tiles[i + envYStart][j + envXStart].getImage(), j * tree.getWidth(), i * tree.getHeight(), null);
        	}
        }
		g.drawImage(character.getCurrentFrame(),  spriteX * tree.getWidth(),  spriteY * tree.getHeight(), null);
    }
	
}
