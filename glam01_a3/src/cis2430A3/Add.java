package cis2430A3;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.Border;

// This is the Add class which contains the GUI for adding products, implements the ActionLister, and has the necessary code for the listeners
/**
 * @author Giavinh
 */
public class Add implements ActionListener {
	private Book book;
	private Electronics electronic;
	private JFrame myFrame;
	private JMenuBar command;
	private JMenuItem add, search, quit;
	private JMenu impMenu;
	private JLayeredPane layeredPane;
	private JPanel panelOne, panelTwo;
	private JLabel text, type, productID, name, price, year, authors, publisher, maker, message;
	private JTextArea messageOutput;
	private JTextField idInput, nameInput, priceInput, yearInput, authorInput, publisherInput, makerInput;
	private JScrollPane scrollPane;
	private JComboBox<String> typeBox;
	private JButton reset, addItem;
	
	public Add() {
		myFrame = new JFrame();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		String [] products = { "book", "electronic" };
		
		myFrame.setSize(900, 780);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		myFrame.setLocation((screenSize.width - 900)/2, (screenSize.height - 780)/2);
		myFrame.setTitle("eStore Search");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		myFrame.setAlwaysOnTop(true); // Window always opens in the front
		myFrame.setResizable(false); // Prevents the user from stretching the window (will cause GUI to look weird)
		
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
		messageOutput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		messageOutput.setForeground(Color.DARK_GRAY);
		messageOutput.setBorder(BorderFactory.createCompoundBorder(blackline, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		messageOutput.setWrapStyleWord(true);
		messageOutput.setLineWrap(true);
		messageOutput.setEditable(false);
		
		scrollPane = new JScrollPane(messageOutput);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);	
		scrollPane.setBounds(10, 550, 870, 180);
		
		message = new JLabel("Messages"); 
		message.setFont(new Font ("Agency FB", Font.BOLD, 32));
		message.setForeground(Color.BLACK);
		message.setBounds(12, 490, 200, 70); //x,y,width,height
		
		text = new JLabel("Adding a product"); 
		text.setFont(new Font ("Agency FB", Font.BOLD, 32));
		text.setForeground(Color.BLACK);
		text.setBounds(10, 80, 200, 70); //x,y,width,height

		type = new JLabel("Type:"); 
		type.setFont(new Font ("Agency FB", Font.BOLD, 30));
		type.setForeground(Color.DARK_GRAY);
		type.setBounds(40, 130, 300, 70);
		
		productID = new JLabel("ProductID:"); 
		productID.setFont(new Font ("Agency FB", Font.BOLD, 30));
		productID.setForeground(Color.DARK_GRAY);
		productID.setBounds(40, 180, 300, 70);
		
		name = new JLabel("Name:"); 
		name.setFont(new Font ("Agency FB", Font.BOLD, 30));
		name.setForeground(Color.DARK_GRAY);
		name.setBounds(40, 230, 300, 70);
		
		price = new JLabel("Price:"); 
		price.setFont(new Font ("Agency FB", Font.BOLD, 30));
		price.setForeground(Color.DARK_GRAY);
		price.setBounds(40, 280, 300, 70);
		
		year = new JLabel("Year:"); 
		year.setFont(new Font ("Agency FB", Font.BOLD, 30));
		year.setForeground(Color.DARK_GRAY);
		year.setBounds(40, 330, 300, 70);
		
		authors = new JLabel("Authors:"); 
		authors.setFont(new Font ("Agency FB", Font.BOLD, 30));
		authors.setForeground(Color.DARK_GRAY);
		authors.setBounds(40, 380, 300, 70);
		
		publisher = new JLabel("Publisher:"); 
		publisher.setFont(new Font ("Agency FB", Font.BOLD, 30));
		publisher.setForeground(Color.DARK_GRAY);
		publisher.setBounds(40, 430, 300, 70);
		
		addItem = new JButton("Add");
		addItem.setFont(new Font ("Agency FB", Font.BOLD, 30));
		addItem.addActionListener(this);
		addItem.setBounds(690, 150, 90, 40);
		
		reset = new JButton("Reset");
		reset.setFont(new Font ("Agency FB", Font.BOLD, 30));
		reset.addActionListener(this);
		reset.setBounds(790, 150, 90, 40);
	
		maker = new JLabel("Maker:"); 
		maker.setFont(new Font ("Agency FB", Font.BOLD, 30));
		maker.setForeground(Color.DARK_GRAY);
		maker.setVisible(false);
		maker.setBounds(40, 380, 300, 70);
		
		typeBox = new JComboBox<>(products);
		typeBox.setFont(new Font ("Agency FB", Font.BOLD, 30));
		typeBox.setSelectedIndex(0);
		typeBox.addActionListener(this);
		typeBox.setBounds(150, 150, 300, 40);
		typeBox.setFocusable(false);
		
		idInput = new JTextField(); // row, column parameters
		idInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		idInput.setForeground(Color.DARK_GRAY);
		idInput.setToolTipText("(Mandatory) Enter the product ID (6 digits).");
		idInput.setBorder(blackline);
		idInput.setBounds(150, 200, 90, 40);

		nameInput = new JTextField();
		nameInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		nameInput.setForeground(Color.DARK_GRAY);
		nameInput.setToolTipText("(Mandatory) Enter name of product.");
		nameInput.setBorder(blackline);
		nameInput.setBounds(150, 250, 300, 40);
		
		priceInput = new JTextField();
		priceInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		priceInput.setForeground(Color.DARK_GRAY);
		priceInput.setToolTipText("Enter product's price (dollars).");
		priceInput.setBorder(blackline);
		priceInput.setBounds(150, 300, 300, 40);
		
		yearInput = new JTextField();
		yearInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		yearInput.setForeground(Color.DARK_GRAY);
		yearInput.setToolTipText("(Mandatory) Enter product's year of manufacture.");
		yearInput.setBorder(blackline);
		yearInput.setBounds(150, 350, 90, 40);
		
		authorInput = new JTextField();
		authorInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		authorInput.setForeground(Color.DARK_GRAY);
		authorInput.setToolTipText("Enter product's author(s).");
		authorInput.setBorder(blackline);
		authorInput.setBounds(150, 400, 300, 40);
		
		publisherInput = new JTextField(); 
		publisherInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		publisherInput.setForeground(Color.DARK_GRAY);
		publisherInput.setToolTipText("Enter product's publisher(s).");
		publisherInput.setBorder(blackline);
		publisherInput.setBounds(150, 450, 300, 40);
		
		makerInput = new JTextField();
		makerInput.setFont(new Font ("Agency FB", Font.BOLD, 30));
		makerInput.setToolTipText("Enter product's maker(s).");
		makerInput.setForeground(Color.DARK_GRAY);
		makerInput.setBorder(blackline);
		makerInput.setEditable(false);
		makerInput.setVisible(false);
		makerInput.setBounds(150, 400, 300, 40);
		
		layeredPane.add(panelOne, new Integer(0));
		layeredPane.add(panelTwo, new Integer(1));
		layeredPane.add(command, new Integer(2));
		layeredPane.add(text, new Integer(2));
		layeredPane.add(message, new Integer(2));
		layeredPane.add(scrollPane, new Integer(2));
		layeredPane.add(type, new Integer(2));
		layeredPane.add(productID, new Integer(2));
		layeredPane.add(name, new Integer(2));
		layeredPane.add(price, new Integer(2));
		layeredPane.add(year, new Integer(2));
		layeredPane.add(authors, new Integer(2));
		layeredPane.add(publisher, new Integer(2));
		layeredPane.add(maker, new Integer(2));
		layeredPane.add(typeBox, new Integer(3));
		layeredPane.add(idInput, new Integer(3));
		layeredPane.add(nameInput, new Integer(3));
		layeredPane.add(priceInput, new Integer(3));
		layeredPane.add(yearInput, new Integer(3));
		layeredPane.add(authorInput, new Integer(3));
		layeredPane.add(publisherInput, new Integer(3));
		layeredPane.add(makerInput, new Integer(3));
		layeredPane.add(reset, new Integer(3));
		layeredPane.add(addItem, new Integer(3));
		myFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		messageOutput.setText("");
		if (e.getSource() == search)
		{
			new Search();
			myFrame.dispose(); // close window, release resources associated with it
		}
		else if (e.getSource() == reset)
		{
			idInput.setText("");
			nameInput.setText("");
			yearInput.setText("");
			priceInput.setText("");
			publisherInput.setText("");
			authorInput.setText("");
			makerInput.setText("");
		}
		else if (e.getSource() == typeBox)
		{
			if (typeBox.getSelectedItem().equals("book"))
			{
				authors.setVisible(true);
				authorInput.setEditable(true);
				authorInput.setVisible(true);
				publisher.setVisible(true);
				publisherInput.setVisible(true);
				publisherInput.setEditable(true);
				maker.setVisible(false);
				makerInput.setVisible(false);
				makerInput.setEditable(false);
			}
			else
			{
				authors.setVisible(false);
				authorInput.setEditable(false);
				authorInput.setVisible(false);
				publisher.setVisible(false);
				publisherInput.setVisible(false);
				publisherInput.setEditable(false); //test do we need this?
				maker.setVisible(true);
				makerInput.setVisible(true);
				makerInput.setEditable(true);
			}
		}
		else if (e.getSource() == addItem)
		{
				try {
					if (typeBox.getSelectedItem().equals("book"))
						book = new Book(idInput.getText(), nameInput.getText(), yearInput.getText(), priceInput.getText(), authorInput.getText(), publisherInput.getText());
					else
						electronic = new Electronics(idInput.getText(), nameInput.getText(), yearInput.getText(), priceInput.getText(), makerInput.getText());

					if (EStoreSearch.duplicateProductID(Main.estore.returnArray(), idInput.getText()) == false)
					{
						messageOutput.append("A product already exists with that productID. Product not added.\n");
						return;
					}
					else
					{
						if (typeBox.getSelectedItem().equals("book"))
							Main.estore.returnArray().add(book);
						else
							Main.estore.returnArray().add(electronic);
						
						Main.estore.setMap(EStoreSearch.fillMap(Main.estore.returnArray()));
					}
					
					messageOutput.append("Product was successfully added.\n");	
				} catch (Exception e1) { // Exception Handling
					if (!EStoreSearch.verifyProductID(idInput.getText()).equals(""))
					{
						messageOutput.append(EStoreSearch.verifyProductID(idInput.getText()) + "\n");
						return;
					}
					
					if (nameInput.getText().isEmpty())
					{
						messageOutput.append("Product name must be filled in. Product not added." + "\n");
						return;
					}
					
					if (!EStoreSearch.verifyPrice(priceInput.getText()).equals(""))
					{
						messageOutput.append(EStoreSearch.verifyPrice(priceInput.getText()) + "\n");
						return;
					}
					
					
					if (!EStoreSearch.verifyYear(yearInput.getText()).equals(""))
					{
						messageOutput.append(EStoreSearch.verifyYear(yearInput.getText()) + "\n");
						return;
					}			
				}
		}
		else if (e.getSource() == quit)
		{
			EStoreSearch.saveList(Main.f, Main.estore.returnArray()); // Save the list 
			myFrame.dispose();
		}
	}
}
