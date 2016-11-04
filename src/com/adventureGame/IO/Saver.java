/*
Name of File: Saver.java
Programmer: Tyler Dobbs
Start Date: Nov 3, 2016
 */
package com.adventureGame.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import adventure_game.world.World;


public class Saver
{
	private static String[] directories = 
		{
			DirectoryBoard.LOCAL_ROOT + "world/",
			DirectoryBoard.LOCAL_ROOT + "characters/",
			DirectoryBoard.LOCAL_ROOT + "items/",
			DirectoryBoard.LOCAL_ROOT + "objects/",
			DirectoryBoard.LOCAL_ROOT + "player/",
		};
	private static PrintWriter printer;
	private static File file;
	
	public static void saveWorld(World w)
	{
		file = new File(DirectoryBoard.LOCAL_ROOT + DirectoryBoard.LOCAL_WORLD + "world.txt");
		
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		try
		{
			printer = new PrintWriter(file);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		printer.write("World: \n");
		
		for(int i=0;i<100;i++)
		{
			if(i%10==0 && i !=0)
				printer.write("00" + Math.floor(Math.random()*10) + "2" + Math.floor(Math.random()*10)
						 + Math.floor(Math.random()*10) + "4" + Math.floor(Math.random()*10)
						 + Math.floor(Math.random()*10) + "76\n");
			else
				printer.write("00" + Math.floor(Math.random()*10) + "2" + Math.floor(Math.random()*10)
						 + Math.floor(Math.random()*10) + "4" + Math.floor(Math.random()*10)
						 + Math.floor(Math.random()*10) + "76\n");
		}
		
		printer.close();
	}
	public static void createGameDirectories()
	{
		for(int i=0;i<directories.length;i++)
		{
			File file = new File(directories[i]);
			file.mkdirs();
		}
	}

}
