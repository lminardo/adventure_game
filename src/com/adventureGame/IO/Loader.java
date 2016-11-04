/*
Name of File: Loader.java
Programmer: Tyler Dobbs
Start Date: Nov 3, 2016
 */
package com.adventureGame.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader
{
	private static Scanner reader;
	private static File file;
	
	public static void loadWorld()
	{
		file = new File(DirectoryBoard.LOCAL_ROOT + DirectoryBoard.LOCAL_WORLD  + "world.txt");
		
		try
		{
			reader = new Scanner(file);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		String data;
		data = reader.nextLine();
		System.out.println(data);
		
	}

}
