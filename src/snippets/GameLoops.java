/*
Name of File: GameLoops.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package snippets;

public class GameLoops implements Runnable
{
	//MAIN
	private short currentFPS = 0;
	private boolean running = false;
	
	private double lastFpsTime;
	
	private void init()
	{
		
	}
	
	private void update()
	{
		
	}
	private void render()
	{
		
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
			  System.out.println(currentFPS +" FPS");
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
		GameLoops gl = new GameLoops();
		gl.start();
		gl.run();
	}
}
