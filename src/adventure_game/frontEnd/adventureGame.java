/*
Name of File: adventureGame.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package adventure_game.frontEnd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import adventureGame.HUD.WorldTraverse;
import adventureGame.IO.KeyboardInput;
import adventureGame.IO.Saver;
import adventure_game._TESTentities._TESTPlayer;
import adventure_game.world.Tile;
import adventure_game.world.World;


public class adventureGame implements Runnable
{
	//Essential
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
	
	//What we want
	public static KeyboardInput keys = new KeyboardInput();
	
	
	
	
	//What we're testing
	int x;
	int y;
	boolean switchX = false;
	
	int x2;
	int y2;
	boolean switchY2 = false;
	World world;
	WorldTraverse wt;
	_TESTPlayer player;
	
	public adventureGame(String title, int width, int height)
	{
		//What we want
		this.width = width;
		this.height = height;
		this.title = title;
		
		
		
		//What we're testing
		
		
		
	}
	
	/*
	 * Do anything before the main game loop starts
	 * Add any listeners
	 * Initialize any objects
	 */
	private void init()
	{
		//What we want
		display = new Display(width, height, title);
		display.getFrame().addKeyListener(keys);
		//Saver.createGameDirectories();
		
		
		
		Saver.createGameDirectories();
		//What we're testing
		player = new _TESTPlayer();
		x = width/2;
		y = height/2;
		x2 = width/4;
		y2 = height/4;
		
		world = new World();
		wt = new WorldTraverse(world);
		System.out.println(World.tileCount);
		Saver.saveWorld(new World());
	}
	
	private void update()
	{
		//What we want
		keys.update();
		player.update();
		
		
		//What we're testing
		if(switchX)
			x-=6;
		else
			x+=6;
		if(x > (width/2)+100)
			switchX = !switchX;
		if(x < (width/2)-100)
			switchX = !switchX;
		
		if(switchY2)
			y2-=6;
		else
			y2+=6;
		if(y2 > (height/4)+125)
			switchY2 = !switchY2;
		if(y2 < (height/4)-125)
			switchY2 = !switchY2;
		
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
		
		/*
		 * Should render by lowest depth first
		 * World
		 * Then objects
		 */
		//Draw here *********************************
		//What we want
		
		
		
		
		//What we're testing
	    g.fillRect(0, 0, width, height);
	    world.render(g);
	    player.render(g);
	    
	    g.setColor(Color.red);
	    
	    
	    for(int i=0;i<width;i+=Tile.SCALED_TILE_SIZE)
	    {
	    	g.drawLine(i, 0, i, height);
	    }
	    for(int j=0;j<height;j+=Tile.SCALED_TILE_SIZE)
	    {
	    	g.drawLine(0, j, width, j);
	    }
	    
	    g.setColor(Color.blue);
	    g.fillRect(x, y, Tile.SCALED_TILE_SIZE, Tile.SCALED_TILE_SIZE);
	    
	    g.setColor(Color.orange);
	    g.fillRect(x2, y2, Tile.SCALED_TILE_SIZE, Tile.SCALED_TILE_SIZE);
	    
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
	/*
	 * Will eventually get rid of main method
	 * We should create a launcher class that creates a new adventureGame object
	 * It should send the width and height from there
	 */
	public static void main(String[] args)
	{
		adventureGame gl = new adventureGame("Adventure", 1024, 768);
		gl.start();
		gl.run();
	}
}
