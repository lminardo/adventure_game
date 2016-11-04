/*
Name of File: Section.java
Programmer: Tyler Dobbs
Start Date: Nov 3, 2016
 */
package adventure_game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import adventure_game.mechanics.Camera;

public class Section
{
	Tile[][] section;
	BufferedImage tileSheet;
	public static Camera camera;
	
	public Section()
	{
		section = new Tile[32][24];
		camera = new Camera();
		
		try
		{
			tileSheet = ImageIO.read(getClass().getResource("/Tiles.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		for(int i=0;i<section.length;i++)
		{
			for(int j=0;j<section[i].length;j++)
			{
				section[i][j] = new Tile(tileSheet, (int)Math.floor(Math.random()*2));
			}
		}
	}
	
	public void render(Graphics g)
	{
		for(int x=camera.x;x < camera.x + camera.width;x++)
		{
			for(int y=camera.y;y < camera.y + camera.height;y++)
			{
				try
				{
				g.drawImage(section[x][y].getSprite(),
						x*Tile.SCALED_TILE_SIZE - camera.x*Tile.SCALED_TILE_SIZE,
						y*Tile.SCALED_TILE_SIZE - camera.y*Tile.SCALED_TILE_SIZE,
						Tile.SCALED_TILE_SIZE,
						Tile.SCALED_TILE_SIZE, null);
				}catch(Exception e)
				{
					g.setColor(Color.BLUE);
					g.fillRect(
							x*Tile.SCALED_TILE_SIZE - camera.x*Tile.SCALED_TILE_SIZE,
							y*Tile.SCALED_TILE_SIZE - camera.y*Tile.SCALED_TILE_SIZE,
							Tile.SCALED_TILE_SIZE,
							Tile.SCALED_TILE_SIZE);
				}
			}
		}
	}
}
