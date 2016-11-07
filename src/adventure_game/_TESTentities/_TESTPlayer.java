/*
Name of File: _TESTPlayer.java
Programmer: Tyler Dobbs
Start Date: Nov 7, 2016
 */
package adventure_game._TESTentities;

import java.awt.Color;
import java.awt.Graphics;

import adventure_game.frontEnd.adventureGame;
import adventure_game.world.Section;
import adventure_game.world.Tile;

public class _TESTPlayer
{
	public int x;
	public int y;
	
	public _TESTPlayer()
	{
		x=0;
		y=0;
	}
	public void update()
	{
		if(adventureGame.keys.Pdown)
			y+=1;
		if(adventureGame.keys.Pup)
			y-=1;
		if(adventureGame.keys.Pleft)
			x-=1;
		if(adventureGame.keys.Pright)
			x+=1;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillRect(x*Tile.SCALED_TILE_SIZE - Section.camera.x*Tile.SCALED_TILE_SIZE, y*Tile.SCALED_TILE_SIZE - Section.camera.y*Tile.SCALED_TILE_SIZE, Tile.SCALED_TILE_SIZE, Tile.SCALED_TILE_SIZE);
	}
}
