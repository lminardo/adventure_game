/*
Name of File: LocalizedFiles.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package snippets;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LocalizedFiles
{
	BufferedImage img;
	
	public LocalizedFiles()
	{
		try
		{
			img = ImageIO.read(getClass().getResource("/Tiles.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<img.getHeight()/16;i++)
		{
			for(int j=0;j<img.getWidth()/16;j++)
			{
				System.out.print(img.getRGB(j, i));
			}
		}
	}
    public static void main(String [] args)
    {
    	LocalizedFiles LF = new LocalizedFiles();
    }

}
