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
	private int currPlane = 0;
	
	/*
	 * This will be the whole world.
	 * It has an array of planes that the player can traverse through.
	 *  [0	1	2	3	4	5	6]
	 *  Main plane should be length/2
	 *  every lower plane should be a "dungeon or cave"
	 *  every upper plane should be a 2nd floor to a building or area (maybe hills?)
	 */
	public World()
	{
		world = new Plane[1];
		
		for(int i=0;i<world.length;i++)
		{
			world[i] = new Plane();
		}
	}
	public void render(Graphics g)
	{
		world[currPlane].render(g);
	}
}
