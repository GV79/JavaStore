package cis2430A3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 * The EStoreSearch program implements a GUI that allows a user to
 * manage a list of books and electronics, to search for certain
 * products through various search filters, and saves the information
 * at the end of the program's execution to be loaded for the next time.
 * Assignment 3 for the CIS2430 Course
 */
/**
* @author  Giavinh Lam
* @version 1.0
* @since   2016
*/
public class Main {
	public static EStoreSearch estore = new EStoreSearch(); // To give access for other classes
	public static File f;

	 /**
	   * This is the main method which runs the program.
	   * @param args Input File
	   */
	public static void main(String[] args) {
		Scanner file;
		try{ // Parse input file, obtain information, give errors if there are any
			f = new File(args[0]);
			file = new Scanner(f);
			try {
				estore.setArray(EStoreSearch.parseFile(estore.returnArray(), file));
			} catch (Exception e) {
				System.out.println("Error with input file formatting. Please fix and try again.");
				System.exit(0);
			}
		} catch (FileNotFoundException e){
			System.out.println("Unable to find input file.");
		    System.exit(0);
		}
		
		Main.estore.setMap(EStoreSearch.fillMap(Main.estore.returnArray())); // Create HashMap based off of input file
		new MainMenu(); // Begin program
	}
}
