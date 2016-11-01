/*
Name of File: Tile.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package adventure_game.world;

import java.awt.image.BufferedImage;

public class Tile
{
	private BufferedImage sprite;
	
	/*
	 * A tile should receive a tileSet, and an id.
	 * The id is used to determine which subimage of the tileset should be used.
	 */
	public Tile(BufferedImage tileSet, int id)
	{
		switch(id)
		{
			case 1:
			{
				sprite = tileSet.getSubimage(0, 32, 15, 15);
				break;
			}
			default:
			{
				sprite = tileSet.getSubimage(0, 0, 15, 15);
			}
		
		}
	}
	public BufferedImage getSprite()
	{
		return sprite;
	}
}
