/*
Name of File: Tile.java
Programmer: Tyler Dobbs
Start Date: Oct 31, 2016
 */
package adventure_game.world;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tile
{
	public static final int TILE_SIZE = 16;
	public static final int TILE_SCALE = 2;
	public static final int SCALED_TILE_SIZE = TILE_SIZE * TILE_SCALE;
	
	Image sprite;
	BufferedImage tileSheet;
	
	public Tile(BufferedImage tileSheet, int id)
	{
		this.tileSheet = tileSheet;
		World.tileCount+=1;
		setSprite(id);
	}
	public Image getSprite()
	{
		return sprite;
	}
	private void setSprite(int id)
	{
		switch(id)
		{
		case 0:
			sprite = this.tileSheet.getSubimage(0, 0, TILE_SIZE, TILE_SIZE);
			break;
		case 1:
			sprite =  this.tileSheet.getSubimage(16, 0, TILE_SIZE, TILE_SIZE);
			break;
		case 2:
			sprite =  this.tileSheet.getSubimage(0, 16, TILE_SIZE, TILE_SIZE);
			break;
		case 3:
			sprite =  this.tileSheet.getSubimage(16, 16, TILE_SIZE, TILE_SIZE);
			break;
		case 4:
			sprite =  this.tileSheet.getSubimage(0, 32, TILE_SIZE, TILE_SIZE);
			break;
		case 5:
			sprite =  this.tileSheet.getSubimage(16, 32, TILE_SIZE, TILE_SIZE);
			break;
		}
	}
}
