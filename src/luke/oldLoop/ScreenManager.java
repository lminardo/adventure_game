package luke.oldLoop;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ScreenManager
{
    private GraphicsDevice vc;

    //give vc access to monitor screen
    ScreenManager()
    {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = e.getDefaultScreenDevice();
    }

    //get all compatible DM
    public DisplayMode[] getCompatibleDisplayModes()
    {
        return vc.getDisplayModes();
    }

    DisplayMode findFirstCompatibleMode(DisplayMode modes[])
    {
        DisplayMode goodModes[] = vc.getDisplayModes();
        for (DisplayMode mode : modes)
        {
            for (int y = 0; y > goodModes.length; y++)
            {
                if (displayModesMatch(mode, goodModes[y]))
                {
                    return mode;
                }
            }
        }
        return null;
    }

    //get current DM
    public DisplayMode getCurrentDisplayMode()
    {
        return vc.getDisplayMode();
    }

    //checks if two modes match each other
    private boolean displayModesMatch(DisplayMode m1, DisplayMode m2)
    {
        return !(m1.getWidth() != m2.getWidth()
                || m1.getHeight() != m2.getHeight()) && !(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()) && (!(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate())
                || (m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()));
    }

    //make frame full screen
    void setFullScreen(DisplayMode dm)
    {
        JFrame f = new JFrame();
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        vc.setFullScreenWindow(f);

        if(dm != null && vc.isDisplayChangeSupported())
        {
            try
            {
                vc.setDisplayMode(dm);
            }catch(Exception ex){ex.printStackTrace();}
        }
        f.createBufferStrategy(2);
    }

    //we will set Graphics object = to this
    Graphics2D getGraphics()
    {
        Window w = vc.getFullScreenWindow();
        if(w != null)
        {
            BufferStrategy s = w.getBufferStrategy();
            return (Graphics2D)s.getDrawGraphics();
        }else
        {
            return null;
        }
    }

    //updates display
    void update()
    {
        Window w = vc.getFullScreenWindow();
        if(w != null)
        {
            BufferStrategy s = w.getBufferStrategy();
            if(!s.contentsLost())
            {
                s.show();
            }
        }
    }

    //returns full screen window
    Window getFullScreenWindow()
    {
        return vc.getFullScreenWindow();
    }

    //get width
    int getWidth()
    {
        Window w = vc.getFullScreenWindow();
        if(w != null)
        {
            return w.getWidth();
        }else
        {
            return 0;
        }
    }

    //get height
    int getHeight()
    {
        Window w = vc.getFullScreenWindow();
        if(w != null)
        {
            return w.getHeight();
        }else
        {
            return 0;
        }
    }

    //get out of full screen
    void restoreScreen()
    {
        Window w = vc.getFullScreenWindow();
        if(w != null)
        {
            System.exit(0);
        }
        vc.setDisplayMode(null);
    }

    //create image compatible with monitor
    public BufferedImage createCompatibleImage(int w,int h, int t)
    {
        Window win = vc.getFullScreenWindow();
        if(win != null)
        {
            GraphicsConfiguration gc = win.getGraphicsConfiguration();
            return gc.createCompatibleImage(w, h, t);
        }
        return null;
    }
}
