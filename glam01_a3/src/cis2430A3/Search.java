package cis2430A3;

import java.awt.event.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.Border;

// This is the Search class which contains the GUI for searching products, implements the ActionLister, and has the necessary code for the listeners
/**
 * @author Giavinh
 */
public class Search implements ActionListener {
	public static JTextArea messageOutput;
	private JFrame myFrame;
	private JMenuBar command;
	private JMenuItem add, search, quit;
	private JMenu impMenu;
	private JLayeredPane layeredPane;
	private JPanel panelOne, panelTwo;
	private JLabel text, productID, keywords, startYear, endYear, message;
	private JTextField idInput, keywordsInput, startyearInput, endyearInput;
	private JScrollPane scrollPane;
	private JButton reset, searchItem;
	private int errorChecking = 0;
	
	public Search() {
		myFrame = new JFrame();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		myFrame.setSize(900, 780);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		myFrame.setLocation((screenSize.width - 900)/2, (screenSize.height - 780)/2);
		myFrame.setTitle("eStore Search");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		myFrame.setAlwaysOnTop(true); // Window always opens in the front
		myFrame.setResizable(false); // Prevents the user from stretching the window
		
		layeredPane = myFrame.getLayeredPane();

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
		
		panelOne = new JPanel();
		panelOne.setBackground(Color.LIGHT_GRAY); 
		panelOne.setLayout(new BoxLayout(panelOne, BoxLayout.Y_AXIS));
		panelOne.setBounds(0, 0, 900, 500);
		
		panelTwo = new JPanel();
		panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.X_AXIS)); 
		panelTwo.setBorder(blackline);
		panelTwo.setBounds(-5, 80, 905, 800);
		
		messageOutput = new JTextArea();
		messageOutput.setFont(new Font ("Agency FB", Font.BOLD, 25));
		messageOutput.setForeground(Color.DARK_GRAY);
		messageOutput.setBorder(BorderFactory.createCompoundBorder(blackline, BorderFactory.createEmptyBorder(5, 5, 5, 5))); // To make it easier to see text in output
		messageOutput.setWrapStyleWord(true);
		messageOutput.setLineWrap(true);
		messageOutput.setEditable(false);
		
		scrollPane = new JScrollPane(messageOutput);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Always see the scroll bars	
		scrollPane.setBounds(10, 400, 870, 330);
			
		message = new JLabel("Search Results"); 
		message.setFont(new Font ("Agency FB", Font.BOLD, 32));
		message.setForeground(Color.BLACK);
		message.setBounds(12, 340, 300, 70); //x,y,width,height
		
		text = new JLabel("Searching Products"); 
		text.setFont(new Font ("Agency FB", Font.BOLD, 32));
		text.setForeground(Color.BLACK);
		text.setBounds(10, 80, 400, 70); //x,y,width,height
		
		productID = new JLabel("ProductID:"); 
		productID.setFont(new Font ("Agency FB", Font.BOLD, 30));
		productID.setForeground(Color.DARK_GRAY);
		productID.setBounds(40, 130, 300, 70);
		
		keywords = new JLabel("Keywords:"); 
		keywords.setFont(new Font ("Agency FB", Font.BOLD, 30));
		keywords.setForeground(Color.DARK_GRAY);
		keywords.setBounds(40, 180, 300, 70);
		
		startYear = new JLabel("Start Year:"); 
		startYear .setFont(new Font ("Agency FB", Font.BOLD, 30));
		startYear .setForeground(Color.DARK_GRAY);
		startYear .setBounds(40, 230, 300, 70);
		
		endYear = new JLabel("End Year:"); 
		endYear.setFont(new Font ("Agency FB", Font.BOLD, 30));
		endYear.setForeground(Color.DARK_GRAY);
		endYear.setBounds(40, 280, 300, 70);
		
		searchItem = new JButton("Search");
		searchItem.setFont(new Font ("Agency FB", Font.BOLD, 30));
		searchItem.addActionListener(this);
		searchItem.setBounds(650, 150, 120, 40);
		
		reset = new JButton("Reset");
		reset.setFont(new Font ("Agency FB", Font.BOLD, 30));
		reset.addActionListener(this);
		reset.setBounds(790, 150, 90, 40);
		
		idInput = new JTextField();
		idInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		idInput.setForeground(Color.DARK_GRAY);
		idInput.setToolTipText("(Mandatory) Enter the product ID (6 digits).");
		idInput.setBorder(blackline);
		idInput.setBounds(150, 150, 90, 40);
		
		keywordsInput = new JTextField();
		keywordsInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		keywordsInput.setForeground(Color.DARK_GRAY);
		keywordsInput.setToolTipText("Enter product's price.");
		keywordsInput.setBorder(blackline);
		keywordsInput.setBounds(150, 200, 300, 40);
		
		startyearInput = new JTextField();
		startyearInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		startyearInput.setForeground(Color.DARK_GRAY);
		startyearInput.setToolTipText("(Mandatory) Enter product's year of manufacture.");
		startyearInput.setBorder(blackline);
		startyearInput.setBounds(150, 250, 90, 40);
		
		endyearInput = new JTextField();
		endyearInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		endyearInput.setForeground(Color.DARK_GRAY);
		endyearInput.setToolTipText("Enter product's author(s).");
		endyearInput.setBorder(blackline);
		endyearInput.setBounds(150, 300, 90, 40);
		
		layeredPane.add(panelOne, new Integer(0));
		layeredPane.add(panelTwo, new Integer(1));
		layeredPane.add(command, new Integer(2));
		layeredPane.add(text, new Integer(2));
		layeredPane.add(message, new Integer(2));
		layeredPane.add(scrollPane, new Integer(2));
		layeredPane.add(productID, new Integer(2));
		layeredPane.add(keywords, new Integer(2));
		layeredPane.add(startYear, new Integer(2));
		layeredPane.add(endYear, new Integer(2));
		layeredPane.add(idInput, new Integer(3));
		layeredPane.add(keywordsInput, new Integer(3));
		layeredPane.add(startyearInput, new Integer(3));
		layeredPane.add(endyearInput, new Integer(3));
		layeredPane.add(reset, new Integer(3));
		layeredPane.add(searchItem, new Integer(3));
		myFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		messageOutput.setText("");

		if (e.getSource() == add)
		{
			new Add();
			myFrame.dispose(); // close window, release resources associated with it
		}
		else if (e.getSource() == reset)
		{
			idInput.setText("");
			keywordsInput.setText("");
			startyearInput.setText("");
			endyearInput.setText("");
			messageOutput.setText("");
		}
		else if (e.getSource() == searchItem)
		{
			messageOutput.setText("");
			
			// Code for error checking prior to outputting search results
			if (!idInput.getText().isEmpty())
			{
				if (idInput.getText().matches("[0-9]+") == false || idInput.getText().length() != 6)
				{
					messageOutput.setText("Product ID must be composed of 6 digits.\n");
					messageOutput.append("Fix error in order to search.\n");
					errorChecking = 1;
				}
			}

			if (!startyearInput.getText().isEmpty())
			{
				if (startyearInput.getText().matches("[0-9]+") == false || !(Integer.valueOf(startyearInput.getText()) >= 1000 && Integer.valueOf(startyearInput.getText()) <= 9999))
				{
					messageOutput.setText("Start year value must be a whole number between 1000 and 9999 (inclusive).\n");
					messageOutput.append("Fix error in order to search.\n");
					errorChecking = 1;
				}
			}
			
			if (!endyearInput.getText().isEmpty())
			{
				if (endyearInput.getText().matches("[0-9]+") == false || !(Integer.valueOf(endyearInput.getText()) >= 1000 && Integer.valueOf(endyearInput.getText()) <= 9999))
				{
					messageOutput.setText("End year value must be a whole number between 1000 and 9999 (inclusive).\n");
					messageOutput.append("Fix error in order to search.\n");
					errorChecking = 1;
				}
			}
			
			if (startyearInput.getText().length() > 0 && endyearInput.getText().length() > 0)
			{
				if (Integer.valueOf(startyearInput.getText()) > Integer.valueOf(endyearInput.getText()))
				{
					messageOutput.setText("Start year value cannot be greater than end year value.\n");
					messageOutput.append("Fix error in order to search.\n");
					errorChecking = 1;
				}
			}
			
			// Code for outputting search results
			if (errorChecking != 1)
			{
				int j = 0;

				if (idInput.getText().isEmpty() && keywordsInput.getText().isEmpty() && startyearInput.getText().isEmpty() && endyearInput.getText().isEmpty()) {
					for (j = 0; j < Main.estore.returnArray().size(); j++) {
						messageOutput.append(Main.estore.returnArray().get(j).toString() + "\n\n");
					}
					return;
				}
				else
				{
					Main.estore.setKeyArray(EStoreSearch.productWord(Main.estore.returnMap(), Main.estore.returnArray(), keywordsInput.getText()));
					if (keywordsInput.getText().length() != 0) {
						if (startyearInput.getText().length() == 0 && endyearInput.getText().length() == 0 && idInput.getText().length() == 0) {
							if (Main.estore.returnKeyArray() != null) {
								for (j = 0; j < Main.estore.returnKeyArray().size(); j++) {
									messageOutput.append(Main.estore.returnKeyArray().get(j).toString() + "\n\n");
								}
							}
						}
						else
						{
							if (startyearInput.getText().length() > 0 && endyearInput.getText().length() > 0)
								EStoreSearch.noKeyWords(Main.estore.returnKeyArray(), idInput.getText(), startyearInput.getText()+"-"+endyearInput.getText(), 3);
							else if (startyearInput.getText().length() == 0 && endyearInput.getText().length() == 0)
								EStoreSearch.noKeyWords(Main.estore.returnKeyArray(), idInput.getText(), startyearInput.getText(), 0);
							else if (endyearInput.getText().isEmpty())
								EStoreSearch.noKeyWords(Main.estore.returnKeyArray(), idInput.getText(), startyearInput.getText()+"-", 2);
							else
								EStoreSearch.noKeyWords(Main.estore.returnKeyArray(), idInput.getText(), "-"+endyearInput.getText(), 1);
						}
					} 
					else {
						if (startyearInput.getText().length() > 0 && endyearInput.getText().length() > 0)
							EStoreSearch.noKeyWords(Main.estore.returnArray(), idInput.getText(), startyearInput.getText()+"-"+endyearInput.getText(), 3);
						else if (startyearInput.getText().length() == 0 && endyearInput.getText().length() == 0)
							EStoreSearch.noKeyWords(Main.estore.returnArray(), idInput.getText(), startyearInput.getText(), 0);
						else if (endyearInput.getText().isEmpty())
							EStoreSearch.noKeyWords(Main.estore.returnArray(), idInput.getText(), startyearInput.getText()+"-", 2);
						else
							EStoreSearch.noKeyWords(Main.estore.returnArray(), idInput.getText(), "-"+endyearInput.getText(), 1);
					}
				}
			}
			errorChecking = 0;
		}
		else if (e.getSource() == quit) // Save and exit
		{
			EStoreSearch.saveList(Main.f, Main.estore.returnArray());
			myFrame.dispose();
		}
	}
}
