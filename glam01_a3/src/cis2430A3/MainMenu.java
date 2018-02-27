package cis2430A3;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

// This is the MainMenu class which contains the main menu GUI, implements the ActionLister, and has the necessary code for the listeners
/**
 * @author Giavinh
 */
public class MainMenu implements ActionListener {
	private JFrame myFrame;
	private JLayeredPane layeredPane;
	private JMenuBar command;
	private JMenu impMenu;
	private JMenuItem add, search, quit;
	private JPanel panelOne, panelTwo;
	private JLabel labelThree;
	private JTextArea textOne;
	
	public MainMenu() {
		myFrame = new JFrame();
		myFrame.setSize(900, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		myFrame.setLocation((screenSize.width - 900)/2, (screenSize.height - 500)/2); // Centers frame relative to user's screen
		myFrame.setTitle("eStore");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		myFrame.setAlwaysOnTop(true); // Window always opens in the front
		myFrame.setResizable(false); // Prevents the user from stretching the window (will cause GUI to look weird)
		
		layeredPane = myFrame.getLayeredPane();
		
		panelOne = new JPanel();
		panelOne.setBackground(Color.LIGHT_GRAY); 
		panelOne.setLayout(new BoxLayout(panelOne, BoxLayout.Y_AXIS));
		panelOne.setBounds(0, 0, 900, 500);
		
		panelTwo = new JPanel();
		panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.X_AXIS)); 
		Border blackline = BorderFactory.createLineBorder(Color.black);
		panelTwo.setBorder(blackline);
		panelTwo.setBounds(-5, 80, 905, 550);
		
		command = new JMenuBar();
		impMenu = new JMenu("                                                               Commands                                                               ");
		impMenu.setFont(new Font ("Agency FB", Font.BOLD, 30));
		
		add = new JMenuItem("                                                                                   Add");
		add.setPreferredSize(new Dimension(867, add.getPreferredSize().height+15));
		add.setFont(new Font ("Agency FB", Font.BOLD, 23));
		add.addActionListener(this);
		
		search = new JMenuItem("                                                                                 Search");
	    search.setFont(new Font ("Agency FB", Font.BOLD, 23));
	    search.addActionListener(this);
	    
	    quit = new JMenuItem("                                                                                   Quit");
	    quit.setFont(new Font ("Agency FB", Font.BOLD, 23));
	    quit.addActionListener(this);
	  
	    impMenu.add(add);
        impMenu.add(search);
        impMenu.add(quit);
        impMenu.setToolTipText("Click on 'Commands' to choose between 3 options: Add, Search, or Quit!");
        command.add(impMenu);
        command.setBounds(10, 15, 870, 50);

		labelThree = new JLabel("Welcome to eStore");
		labelThree.setFont(new Font ("Agency FB", Font.BOLD, 35));
		labelThree.setForeground(Color.DARK_GRAY);
		labelThree.setBounds(40, 140, 300, 70); //x,y,width,height
		
		textOne = new JTextArea("Choose a command from the \"Commands\" menu above for adding a product, searching products, or quitting the program.");
		textOne.setFont(new Font ("Agency FB", Font.BOLD, 35));
		textOne.setForeground(Color.DARK_GRAY);
		Color defaultColor = panelTwo.getBackground();
		textOne.setBackground(defaultColor);
		textOne.setBounds(40, 240, 750, 200);
		textOne.setWrapStyleWord(true);
		textOne.setLineWrap(true);
		textOne.setEditable(false);
		
		layeredPane.add(panelOne, new Integer(0));
		layeredPane.add(labelThree, new Integer(2));
		layeredPane.add(textOne, new Integer(2));
		layeredPane.add(panelTwo, new Integer(1));
		layeredPane.add(command, new Integer(3));
		
		myFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == add)
		{
			new Add(); // Opens new class and GUI
			myFrame.dispose(); // Closes frame, releases resources
		}
		else if (arg0.getSource() == search)
		{
			new Search();
			myFrame.dispose();
		}
		else if (arg0.getSource() == quit)
		{
			myFrame.dispose();
			System.exit(0);
		}
	}

}
