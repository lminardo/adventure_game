package snippets.oldLoop;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Core implements KeyListener
{
    public static void main(String[] args)
    {
        new Main().run();
    }

    public void init()
    {
        super.init();
        Window w = s.getFullScreenWindow();
        w.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {}

    @Override
    public void keyReleased(KeyEvent e)
    {}

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            s.restoreScreen();
            System.exit(1);
        }
    }

    public synchronized void draw(Graphics2D g){}
}
