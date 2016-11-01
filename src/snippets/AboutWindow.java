/*
Name of File: AboutWindow.java
Programmer: Tyler Dobbs
Start Date: Nov 1, 2016
 */
package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutWindow extends JFrame
{
	private int width = 200;
	private int height = 200;
	
	private final String information = "Copyright";
	private final String company = "Company";
	
	public AboutWindow()
	{
		init();
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(100, 100);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
	}
	public void init()
	{
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(width, height);
		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		setVisible(true);
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(120, 120, 120, 100));
		
		JLabel companyLabel = new JLabel(company);
		JLabel infoLabel = new JLabel(information);
		
		companyLabel.setHorizontalAlignment(JLabel.CENTER);
		companyLabel.setFont(new Font("Arial", Font.BOLD, 28));
		infoLabel.setHorizontalAlignment(JLabel.CENTER);
		infoLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		
		add(companyLabel, BorderLayout.CENTER);
		add(infoLabel, BorderLayout.SOUTH);
	}
	public static void main(String[] args)
	{
		new AboutWindow();
	}
}
