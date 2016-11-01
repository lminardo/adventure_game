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
	BufferedImage img2;
	
	public LocalizedFiles()
	{
		try
		{
			img = ImageIO.read(getClass().getResource("/Tiles.png"));
			img2 = ImageIO.read(getClass().getResource("/tiles/Tiles.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<img.getHeight()/16;i++)
		{
			for(int j=0;j<img.getWidth()/16;j++)
			{
				System.out.println(img.getRGB(j, i) + "Image 1");
			}
		}
		
		for(int i=0;i<img2.getHeight()/16;i++)
		{
			for(int j=0;j<img2.getWidth()/16;j++)
			{
				System.out.println(img2.getRGB(j, i) + "Image 2");
			}
		}
	}
    public static void main(String [] args)
    {
    	LocalizedFiles LF = new LocalizedFiles();
    }

}
