/*
Name of File: KeyboardInput.java
Programmer: Tyler Dobbs
Start Date: Nov 3, 2016
 */
package com.adventureGame.IO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import adventure_game.world.Section;

public class KeyboardInput implements KeyListener
{
	private boolean[] keys;
	
	public boolean up;
	public boolean right;
	public boolean left;
	public boolean down;
	
	public KeyboardInput()
	{
		keys = new boolean[256];
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];
		left = keys[KeyEvent.VK_LEFT];
		down = keys[KeyEvent.VK_DOWN];
		right = keys[KeyEvent.VK_RIGHT];
		
		if(up)
		{
			Section.camera.y--;
		}
		if(left)
		{
			Section.camera.x--;
		}
		if(down)
		{
			Section.camera.y++;
		}
		if(right)
		{
			Section.camera.x++;
		}
	}
}
