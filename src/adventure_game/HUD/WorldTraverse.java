/*
Name of File: WorldTraverse.java
Programmer: Tyler Dobbs
Start Date: Nov 3, 2016
 */
package adventure_game.HUD;

import java.awt.Color;
import java.awt.Graphics;

import adventure_game.world.World;

public class WorldTraverse
{
	World world;
	public WorldTraverse(World w)
	{
		world = w;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.CYAN);
		g.drawString(world.toString() + " peanut butter.", 0, 15);
	}
}
