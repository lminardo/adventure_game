/*
Name of File: Plane.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package adventure_game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plane
{
	Tile[][] plane;
	BufferedImage tileSet;
	
	/*
	 * This is a 2D array of Tiles.
	 * Should pass in the width and height.
	 */
	public Plane()
	{
		plane = new Tile[25][25];
		
		try
		{
			tileSet = ImageIO.read(getClass().getResource("/Tiles.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		for(int i=0;i<plane.length;i++)
		{
			for(int j=0;j<plane[i].length;j++)
			{
				plane[i][j] = new Tile(tileSet, (int)Math.floor(Math.random()*2));
			}
		}
	}
	
	public void render(Graphics g)
	{
		for(int i=0;i<plane.length;i++)
		{
			for(int j=0;j<plane[i].length;j++)
			{
				g.drawImage(plane[i][j].getSprite(), i*32, j*32, 32, 32, null);
			}
		}
	}
}
