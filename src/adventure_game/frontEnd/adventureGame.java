/*
Name of File: GameLoops.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package adventure_game.frontEnd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class adventureGame implements Runnable
{
	private short currentFPS = 0;
	private boolean running = false;
	private Display display;
	private int width;
	private int height;
	private String title;
	private double lastFpsTime;
	//Buffer Strategies allow for the drawing to be smooth
	//It prevents flickering between draws by not directly drawing to the screen
	//[buffer] > [buffer] > [buffer] > [screen]
	private BufferStrategy bs;
	//Used to actually draw the shapes and images
	private Graphics2D g;
	
	
	//Testing variables below
	int x;
	int y;
	boolean switchX = false;
	boolean switchY = false;
	
	public adventureGame(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init()
	{
		display = new Display(width, height, title);
		x = width/2;
		y = height/2;
	}
	
	private void update()
	{
		if(switchX)
			x-=3;
		else
			x+=6;
		if(switchY)
			y-=5;
		else
			y+=5;
		
		if(y > (height/2)+100)
			switchY = !switchY;
		if(y < (height/2)-100)
			switchY = !switchY;
		if(x > (width/2)+100)
			switchX = !switchX;
		if(x < (width/2)-100)
			switchX = !switchX;
		
	}
	private void render()
	{
		//Get buffer strategy from display
		bs = display.getCanvas().getBufferStrategy();
		//If it doesn't exist for some reason, create it
		if(bs == null)
		{
			//Should never need more than 3 buffers
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		//Set g to the buffers to draw on with g
		g = (Graphics2D)bs.getDrawGraphics();
		
		
		//Draw here *********************************
		
	    g.fillRect(0, 0, width, height);
	    g.setColor(Color.red);
	    g.fillRect(x, y, 16, 16);
		//End draw **********************************
	    
	    
		//show contents of g
		bs.show();
		//Safely ends graphics object
		g.dispose();
	}
	public void run() 
	{
		init();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		long lastLoopTime = System.nanoTime(); 

	   while (running)
	   {
		  long now = System.nanoTime();
		  long updateLength = now - lastLoopTime;
		  lastLoopTime = now;
		
		  lastFpsTime += updateLength;
		  currentFPS++;
		
		  if (lastFpsTime >= 1000000000)
		  {
			  display.getFrame().setTitle(title + " " + currentFPS +" FPS");
		      lastFpsTime = 0;
		      currentFPS = 0;
		  }
		  
		  update();
		  render();
		  
		  try
		  {
			  	Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
		  }catch(Exception e)
		  {
				  
		  }
		}
		stop();
	}
	public void stop()
	{
		if(!running)
			return;
		running = false;
	}
	public void start()
	{
		if(running)
			return;
		running = true;
	}
	public static void main(String[] args)
	{
		adventureGame gl = new adventureGame("Adventure", 800, 600);
		gl.start();
		gl.run();
	}
}
