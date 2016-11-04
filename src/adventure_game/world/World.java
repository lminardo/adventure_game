/*
Name of File: World.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package adventure_game.world;

import java.awt.Graphics;

public class World
{
	Plane[] world;
	int currPlane = 0;
	public static int tileCount = 0;
	
	public World()
	{
		world = new Plane[3];
		
		world[currPlane] = new Plane();
	}
	
	public void render(Graphics g)
	{
		world[currPlane].render(g);
	}
	public String toString()
	{
		return "Plane: " + currPlane + " Section: " + world[currPlane].currSectionX + "," + world[currPlane].currSectionY;
	}
}
