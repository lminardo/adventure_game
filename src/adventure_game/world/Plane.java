/*
Name of File: Plane.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package adventure_game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Plane
{
	int currSectionX = 0;
	int currSectionY = 0;
	
	Section[][] plane;
	BufferedImage tileSheet;
	
	public Plane()
	{
		plane = new Section[10][10];
		
		plane[currSectionX][currSectionY] = new Section();
		
		/*
		for(int i=0;i<plane.length;i++)
		{
			for(int j=0;j<plane[i].length;j++)
			{
				plane[i][j] = new Section();
			}
		}
		*/
	}
	
	public void render(Graphics g)
	{
		plane[currSectionX][currSectionY].render(g);
	}
}
