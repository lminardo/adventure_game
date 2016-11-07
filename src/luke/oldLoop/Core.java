package luke.oldLoop;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.Window;

public abstract class Core extends ScreenManager
{
    private short currentFPS = 0;
    private double lastFpsTime;

    private static DisplayMode modes[] =
            {
                    new DisplayMode(1920,1080,32,0),
                    new DisplayMode(1366,768,32,0),
                    new DisplayMode(800,600,24,0),
                    new DisplayMode(800,600,16,0),
                    new DisplayMode(640,480,32,0),
                    new DisplayMode(640,480,24,0),
                    new DisplayMode(640,480,16,0),
            };

    private boolean running;
    ScreenManager s;

    //stop method
    public void stop()
    {
        running = false;
    }

    //call init and gameloop
    void run()
    {
        try
        {
            init();
            gameLoop();
        }finally
        {
            s.restoreScreen();
        }
    }

    //set to full screen
    void init()
    {
        s = new ScreenManager();
        DisplayMode dm = s.findFirstCompatibleMode(modes);
        s.setFullScreen(dm);

        Window w = s.getFullScreenWindow();

        w.setForeground(Color.BLACK);
        w.setBackground(Color.BLACK);
        running = true;
    }

    public int getWindowWidth()
    {
        return super.getWidth();
    }

    public int getWindowHeight()
    {
        return super.getHeight();
    }

    //main game loop
    private void gameLoop()
    {
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        long lastLoopTime = System.nanoTime();

        while(running)
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
            Graphics2D g = s.getGraphics();
            draw(g);
            g.dispose();
            s.update();

            try
            {
                long x = (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000;
                if(x>0)
                    Thread.sleep(x);
            }catch(Exception e){e.printStackTrace();}
        }
    }

    //update animation
    void update()
    {
        Updater.update();
    }

    //draw to screen
    abstract void draw(Graphics2D g);
}