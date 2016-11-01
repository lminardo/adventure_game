/*
Name of File: TabbedMainWindow.java
Programmer: Tyler Dobbs
Start Date: Oct 10, 2016
 */
package snippets;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedMainWindow extends JFrame
{
	
	JTabbedPane tabMaster;
	
	JPanel entityPanel;
	JPanel mapPanel;
    JPanel itemPanel;
    JPanel questPanel;
    
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
	
	public TabbedMainWindow()
	{
		initMainFrame();
		initGUIComponents();
	}
	public void initMainFrame()
	{
		setSize(600,800);
		setTitle("Adventure Engine");
		
        tabMaster = new JTabbedPane();
        
        getContentPane().add(tabMaster);
	}
	public void initGUIComponents()
	{
		entityPanel = new JPanel();
		mapPanel = new JPanel();
		itemPanel = new JPanel();
		questPanel = new JPanel();
		
		
		label1 = new JLabel("Create entities here.");
		label2 = new JLabel("Create maps here.");
		label3 = new JLabel("Create items here.");
		label4 = new JLabel("Create quests here.");
		
		populateTabs();
		addTabsToMaster();
	}
	public void populateTabs()
	{
		entityPanel.add(label1);
		entityPanel.setLayout(new BorderLayout());
		entityPanel.add(new JLabel("East"), BorderLayout.EAST);
		entityPanel.add(new JLabel("West"), BorderLayout.WEST);
		
		mapPanel.setLayout(new BorderLayout());
		mapPanel.add(new JLabel("North"), BorderLayout.NORTH);
		mapPanel.add(new JLabel("South"), BorderLayout.SOUTH);
        
		itemPanel.add(label3);
		
		
        questPanel.add(label4);
	}
	public void addTabsToMaster()
	{
        tabMaster.addTab("Entity Editor", entityPanel);
        tabMaster.addTab("Map Editor", mapPanel);
        tabMaster.addTab("Item Editor", itemPanel);
        tabMaster.addTab("*Quest Editor", questPanel);
	}
	public static void main(String[] args)
	{
	      TabbedMainWindow tp = new TabbedMainWindow();
	      tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      tp.setVisible(true);
	}
}
