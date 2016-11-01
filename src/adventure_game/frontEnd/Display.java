/*
Name of File: Display.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package adventure_game.frontEnd;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display
{
	JFrame frame;
	Canvas canvas;
	
	int width, height;
	String title;
	
	public Display(int width, int height, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		createDisplay();
	}
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		//Closes JFrame when close button is pressed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//When set to null, centers the JFrame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		//Adds canvas to JFrame
		frame.add(canvas);
		//Resizes canvas to fully fit in JFrame without over stretching
		frame.pack();
	}
	public JFrame getFrame()
	{
		return frame;
	}
	public Canvas getCanvas()
	{
		return canvas;
	}
}
