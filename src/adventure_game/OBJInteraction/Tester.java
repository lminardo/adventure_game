/*
Name of File: Tester.java
Programmer: Tyler Dobbs
Start Date: Nov 13, 2016
 */
package adventure_game.OBJInteraction;

public class Tester
{
	public NPC Player;
	public NPC npc1;
	public NPC npc2;
	public NPC npc3;
	
	public random tree;
	public random rock;
	public random poop;
	public random scissors;
	public random hpPotion;
	public random mpPotion;
	
	public Tester()
	{
		Player = new NPC("Dovahkiin");
		npc1 = new NPC("Mercer Gray");
		npc2 = new NPC("Flame Wizard");
		npc3 = new NPC("Frost Wizard");

		tree = new random("Tree");
		rock = new random("Rock");
		poop = new random("Poop");
		scissors = new random("Scissors");
		hpPotion = new random("HP Potion");
		mpPotion = new random("MP Potion");
		
		doActions();
	}
	
	public void doActions()
	{
		Player.interact(tree);
		Player.interact(rock);
		Player.interact(poop);
		System.out.println("\n" + Player.invCount + " total items in " + Player.name + "'s inventory.\n\n");
		
		npc1.interact(tree);
		System.out.println("\n" + npc1.invCount + " total items in  " + npc1.name + "'s inventory.\n");
		
		npc3.interact(npc2);
		Player.interact(npc3);
		npc1.interact(npc2);
		Player.interact(npc1);
		
	}
	
	
	public static void main(String[] args)
	{
		Tester t = new Tester();
	}
	
	
	public class random extends Misc
	{

		public random(String name)
		{
			super(name);
		}
		
		public void doAction(NPC c)
		{
			if(c instanceof NPC)
			{
				System.out.println("\"" + c.name + "\" performed an action on \"" + this.name + "\".");
				c.addToInventory(this);
			}
		}
	}
	public class NPC extends Character
	{
		int invCount = 0;
		
		public NPC(String name)
		{
			super(name);
		}
		public void addToInventory(random r)
		{
			if(r instanceof Misc)
			{
				System.out.println("Added " + r.name + " to " + this.name + "'s inventory.");
				invCount++;
			}
		}
		public void interact(random d)
		{
			d.doAction(this);
		}
		
		public void interact(Character d)
		{
			if(this.name == "Dovahkiin" && d.name == "Mercer Gray")
				System.out.println(d.name + " -> " + this.name + ": Hello.\n" + this.name + ": FUS RO DAH!\n");
			else
				System.out.println(d.name + " -> " + this.name + ": Hello.\n" + this.name + ": Hello there!\n");
		}
	}
}
