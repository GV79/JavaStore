package cis2430A3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the EStoreSearch which contains members (ex. ArrayLists, Hashmap) necessary for storing and retrieving book and electronic products
 * @author Giavinh
 */
public class EStoreSearch {
	private ArrayList<Product> arrayProduct;
	private ArrayList<Product> keyProduct;
	private HashMap <String, ArrayList<Integer>> map;

	public EStoreSearch() //Constructor
	{
		this.arrayProduct = new ArrayList<Product>();
		this.keyProduct = new ArrayList<Product>();
		this.map = new HashMap<>();
	}
	
	/**
	 * @param arrayProduct ArrayList
	 * @return Returns the object's arrayProduct member
	 */
	protected ArrayList<Product> setArray(ArrayList<Product> arrayProduct) // Accessor methods
	{
		this.arrayProduct = arrayProduct;
		return this.arrayProduct;
	}
	
	/**
	 * @param keyProduct ArrayList
	 * @return Returns the object's keyProduct member
	 */
	protected ArrayList<Product> setKeyArray(ArrayList<Product> keyProduct)
	{
		this.keyProduct = keyProduct;
		return this.keyProduct;
	}
	
	/**
	 * @param map HashMap
	 * @return Returns the object's map member
	 */
	protected HashMap <String, ArrayList<Integer>> setMap(HashMap <String, ArrayList<Integer>> map)
	{
		this.map = map;
		return this.map;
	}
	
	/**
	 * @return Returns object's arrayProduct member
	 */
	protected ArrayList<Product> returnArray() // Mutator methods
	{
		return arrayProduct;
	}
	
	/**
	 * @return Returns object's arrayProduct member
	 */
	protected ArrayList<Product> returnKeyArray()
	{
		return keyProduct;
	}
	
	/**
	 * @return Returns object's map member
	 */
	protected HashMap <String, ArrayList<Integer>> returnMap()
	{
		return map;
	}
	
	/**
	 * @param f Text file
	 * @param products ArrayList
	 */
	public static void saveList(File f, ArrayList<Product> products) // this function prints and saves the list's information to a text file before the program quits
	{
		PrintWriter fileWriter ;
		int i = 0;
		try {
			fileWriter = new PrintWriter(f, "UTF-8");
			
			while (i != products.size())
			{
				if (products.get(i) instanceof Book) // If object is of type class Book
				{
					fileWriter.println("type = \"book\"");
					fileWriter.println("productID = " + "\"" + products.get(i).getProductID() + "\"");
					fileWriter.println("name = " + "\"" + products.get(i).getName() + "\"");
					if (!products.get(i).getPrice().equals("N/A"))
					{
						fileWriter.println("price = " + "\"" + products.get(i).getPrice() + "\"");
					}
					fileWriter.println("year = " + "\"" + products.get(i).getYear() + "\"");
					
					if (!((Book) products.get(i)).getAuthor().equals("N/A"))
					{
						fileWriter.println("authors = " + "\"" + ((Book) products.get(i)).getAuthor() + "\"");
					}
					if (!((Book) products.get(i)).getPublisher().equals("N/A"))
					{
						fileWriter.println("publisher = " + "\"" + ((Book) products.get(i)).getPublisher() + "\"");
					}
				}
				else // class Electronics
				{
					fileWriter.println("type = \"electronics\"");
					fileWriter.println("productID = " + "\"" + products.get(i).getProductID() + "\"");
					fileWriter.println("name = " + "\"" + products.get(i).getName() + "\"");
					if (!products.get(i).getPrice().equals("N/A"))
					{
						fileWriter.println("price = " + "\"" + products.get(i).getPrice() + "\"");
					}
					fileWriter.println("year = " + "\"" + products.get(i).getYear() + "\"");
					if (!((Electronics) products.get(i)).getMaker().equals("N/A"))
					{
						fileWriter.println("maker = " + "\"" + ((Electronics) products.get(i)).getMaker() + "\"");
					}
				}
				i++;
				if (i != products.size())
				{
					fileWriter.println("");
				}
			}
			fileWriter.close(); // Releases resources once file finishes updating
			
		} catch (FileNotFoundException e){
			System.out.println("File was not found.");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encoding error.");
		} catch (Exception e) {
			System.out.println("Unknown error.");
		}
	}
	
	/**
	 * @param year First parameter of type string
	 * @return int
	 */
	public static int parseSearchYear(String year) {
		int symbol = 0;
		for (int i = 0; i < year.length(); i++) {
			if (year.charAt(i) == '-') {
				symbol++;
			}
		}

		if (symbol == 0) {
			return 0; // 0 signifies a single year
		}

		String[] token = year.split("-", -1); // -1 argument so that it takes every field (even empty ones)
		String firstYear = token[0];
		String secondYear = token[1];

		if (firstYear.length() == 0 && secondYear.length() != 0) {
			return 1; // 1 specifies -2005
		} else if (firstYear.length() != 0 && secondYear.length() == 0) {
			return 2; // 2 specifies 2005-
		} else {
			return 3; // 3 specifies range ex. 2004-2009
		}
	}
	
	/**
	 * @param product ArrayList
	 * @param productID Second parameter which is of type String
	 * @return Returns true or false
	 */
	public static boolean duplicateProductID(ArrayList<Product> product, String productID) {  // this function checks for a duplicate product ID
		int i;
		i = product.size();
		while (i != 0) {
			if (productID.equals((product.get(i - 1)).getProductID())) {
				return false;
			}
			i--;
		}
		return true;
	}
	
	/**
	 * @param product ArrayList
	 * @param productID Second parameter of type String
	 * @param year Third parameter of type String
	 * @param searchYear Fourth parameter of type Integer
	 */
	public static void noKeyWords(ArrayList<Product> product, String productID, String year, int searchYear) { // this function returns products for the product ID and year filters but ONLY IF user enters nothing for key words
		int validYear = 0; // 0 false, 1 true
		int productFound = 0;
		String[] token;
		if (product == null) // if arraylist is empty, no products will be matched (do not parse through)
		{
			return;
		}
		
		if (productID.length() != 0) {
			for (int k = 0; k < product.size(); k++) {
				if (productID.equals(product.get(k).getProductID())) {
					if (year.length() != 0) {
						if (searchYear == 0) // ex. 2005
						{
							if (year.equals(product.get(k).getYear())) {
								validYear = 1;
							}
						} else if (searchYear == 1) // ex. -2005
						{
							token = year.split("-", -1);
							String secondYear = token[1];
							if (Integer.valueOf(product.get(k).getYear()) <= Integer.valueOf(secondYear)) {
								validYear = 1;
							}
						} else if (searchYear == 2) // ex. 2005-
						{
							token = year.split("-", -1);
							String firstYear = token[0];
							if (Integer.valueOf(product.get(k).getYear()) >= Integer.valueOf(firstYear)) {
								validYear = 1;
							}
						} else if (searchYear == 3) // ex. 2004-2008
						{
							token = year.split("-", -1);
							String firstYear = token[0];
							String secondYear = token[1];

							if (Integer.valueOf(product.get(k).getYear()) >= Integer.valueOf(firstYear) && Integer.valueOf(product.get(k).getYear()) <= Integer.valueOf(secondYear)) {
								validYear = 1;
							}
						}
						
						if (validYear == 1) {
							productFound = 1;
							Search.messageOutput.append(product.get(k).toString() + "\n\n");
						}
						validYear = 0;
						
					} else {
						productFound = 1;
						Search.messageOutput.append(product.get(k).toString() + "\n\n");
					}
				}
			}
		} else {
			for (int k = 0; k < product.size(); k++) {
				if (searchYear == 0) // ex. 2005
				{
					if (year.equals(product.get(k).getYear())) {
						validYear = 1;
					}
				} else if (searchYear == 1) // ex. -2005
				{
					token = year.split("-", -1);
					String secondYear = token[1];
					if (Integer.valueOf(product.get(k).getYear()) <= Integer.valueOf(secondYear)) {
						validYear = 1;
					}
				} else if (searchYear == 2) // ex. 2005-
				{
					token = year.split("-", -1);
					String firstYear = token[0];
					if (Integer.valueOf(product.get(k).getYear()) >= Integer.valueOf(firstYear)) {
						validYear = 1;
					}
				} else {
					token = year.split("-", -1);
					String firstYear = token[0];
					String secondYear = token[1];

					if (Integer.valueOf(product.get(k).getYear()) >= Integer.valueOf(firstYear) && Integer.valueOf(product.get(k).getYear()) <= Integer.valueOf(secondYear)) {
						validYear = 1;
					}
				}
				
				if (validYear == 1) {
					productFound = 1;
					Search.messageOutput.append(product.get(k).toString() + "\n\n");
				}
				validYear = 0;
			}
		}
		
		if (productFound == 0)
		{
			Search.messageOutput.setText("No products found.\n");
		}
		return;
	}

	/**
	 * @param array ArrayList
	 * @return Returns a HashMap
	 */
	public static HashMap <String, ArrayList<Integer>> fillMap(ArrayList<Product> array) // this function creates hash map of names based off of the products in ArrayList<Product> array
	{
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		HashMap <String, ArrayList<Integer>> map = new HashMap<>();
		String word = "";
		String[] seperation;
		
		for (int a = 0; a < array.size(); a++) // tokenizes names of an element of the array list
		{
			word = array.get(a).getName();
			seperation = word.split(" ");
			
			for (int m = 0; m < seperation.length; m++) // seperation.length -> number of tokens
			{
				for (int n = 0; n < array.size(); n++)
				{
					if (array.get(n).getName().toLowerCase().contains(seperation[m].toLowerCase()))
					{
						intArray.add(n);
					}
				}

				if (!map.containsKey(seperation[m].toLowerCase()))
				{
					map.put(seperation[m].toLowerCase(), intArray); // Storing the ArrayList of Integers in the HashMap with a String key
				}
				intArray = new ArrayList<Integer>();
			}			
		}	
		return map;
	}
		
	/**
	 * @param map HashMap parameter
	 * @param array ArrayList second parameter
	 * @param keywords Key words user enters when searching (type String)
	 * @return Returns ArrayList or null (if empty)
	 */
	public static ArrayList<Product> productWord(HashMap <String, ArrayList<Integer>> map, ArrayList<Product> array, String keywords) // returns arraylist with products that matched key words
	{
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		ArrayList<Integer> duplicateArray = new ArrayList<Integer>(); //array list only composed of products that match ALL key words
		ArrayList<Product> modifiedProduct = new ArrayList<Product>();
		int keyWords = 0;
		String[] seperation;
		seperation = keywords.toLowerCase().split(" "); // space is delimiter
		
		for (int k = 0; k < seperation.length; k++)
		{
			if (map.containsKey(seperation[k]))
			{
				keyWords++;
				for (int a = 0; a < map.get(seperation[k].toLowerCase()).size(); a++)
				{
					intArray.add(map.get(seperation[k].toLowerCase()).get(a));
				}
			}
		}
		
		int repeats = 0;
		for (int n = 0; n < intArray.size(); n++)
		{
			for (int o = 0; o < intArray.size(); o++)
			{
				if (intArray.get(n) == intArray.get(o))
				{
					repeats++;
				}
			}

			if (repeats == seperation.length && !duplicateArray.contains(intArray.get(n))) // if one key word is missing, product does not match
			{
				duplicateArray.add(intArray.get(n));
			}
			repeats = 0;
		}
		
		if (keyWords == seperation.length)
		{
			for (int n = 0; n < duplicateArray.size(); n++)
			{
				modifiedProduct.add(array.get(duplicateArray.get(n)));
			}
			return modifiedProduct;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * @param array ArrayList parameter
	 * @param file Scanner file
	 * @return Returns ArrayList
	 * @throws Exception If any error with inputs is found
	 */
	public static ArrayList<Product> parseFile(ArrayList<Product> array, Scanner file) throws Exception // parses text file, retrieves information, stores into an ArrayList
	{
		Book book = new Book("111111", "N/A", "1000", "", "N/A", "N/A");
		Electronics electronic = new Electronics("111111", "N/A", "1000", "", "N/A");
		int type = 0;
		
		while (file.hasNextLine()) 
		{
			String fileLines = "";
			fileLines = file.nextLine();
			if (!fileLines.isEmpty()) // If line is not empty
			{
				String[] token = fileLines.split("=", 2);
				token[0] = token[0].trim();
				token[1] = token[1].trim();
				token[1] = token[1].substring(1, token[1].length()-1);
				
				if (type == 0)
				{
					if (token[0].equals("type"))
					{
						if (token[1].equals("book"))
						{
							type = 1;
							book = new Book("111111", "N/A", "1000", "", "N/A", "N/A");
						}
						else if (token[1].equals("electronics"))
						{
							type = 2;
							electronic = new Electronics("111111", "N/A", "1000", "", "N/A");
						}
						else
						{
							System.out.println("Invalid type. Must be 'book' or 'electronics'.");
							System.exit(0);
						}
					}
					else
					{
						System.out.println("Invalid type name in input file: "  + token[0] + ".");
						System.exit(0);
					}
				}
				else
				{
					switch(type)
					{
					case 1:
						book.setAuthor("N/A");
						book.setPublisher("N/A");
						
						switch (token[0])
						{
							case "name":
								book.setName(token[1]);
								break;
							case "productID":
								if (duplicateProductID(array, token[1]) == false)
								{
									System.out.println("Book " + token[1] + " from input file will not be added to the list.");
									type = 0; // Prevents adding this product
									break;
								}
								book.setProductID(token[1]);
								break;
							case "price":
								book.setPrice(token[1]);
								break;
							case "year":
								book.setYear(token[1]);
								break;
							case "authors":
								book.setAuthor(token[1]);
								break;
							case "publisher":
								book.setPublisher(token[1]);
								break;
							case "type":
								break;
							default:
								System.out.println("Invalid variable name: "  + token[0] + ". book objects can only have a 'name', 'productID', 'price', 'year', 'authors', or 'publisher'.");
								System.exit(0);
								break;
						}
						break;
					default: //type = 2
						electronic.setMaker("N/A");
						switch (token[0])
						{
							case "name":
								electronic.setName(token[1]);
								break;
							case "productID":
								if (duplicateProductID(array, token[1]) == false)
								{
									type = 0;
									System.out.println("Electronic " + token[1] + " from input file will not be added to the list.");
									break;
								}
								electronic.setProductID(token[1]);
								break;
							case "price":
								electronic.setPrice(token[1]);
								break;
							case "year":
								electronic.setYear(token[1]);
								break;
							case "maker":
								electronic.setMaker(token[1]);
								break;
							case "type":
								break;
							default:
								System.out.println("Invalid variable name: " + token[0]+ ". Electronics can only have a 'name', 'productID', 'price', 'year', or 'maker'." + token[0]);
								System.exit(0);
								break;
						}
						break;
					}
				}
				
				if (!file.hasNextLine())
				{
					if (type == 1) // Adding objects to the ArrayList
					{
						new Book(book.productID, book.name, book.year, book.price, book.getAuthor(), book.getPublisher());
						array.add(book);
					}
					else if (type == 2)
					{
					    new Electronics(electronic.productID, electronic.name, electronic.year, electronic.price, electronic.getMaker());
						array.add(electronic);
					}
					System.out.println();
				}
			}
			else
			{
				if (type == 1)
				{
					new Book(book.productID, book.name, book.year, book.price, book.getAuthor(), book.getPublisher());
					array.add(book);
				}
				else if (type == 2)
				{
					new Electronics(electronic.productID, electronic.name, electronic.year, electronic.price, electronic.getMaker());
					array.add(electronic);
				}
				type = 0;
			}
		}
		return array;
	}
	
	/**
	 * @param price Product's price (type String)
	 * @return Returns a string
	 */
	public static String verifyPrice(String price) { // This function verifies the price input from user
		if (price.length() == 0) {
			return "";
		}

		if (price.matches("[0-9.]*") == false) { // regex, found this code from an old program I coded
			return "Price can only contain digits. Product not added.";
		}

		if (price.charAt(0) == '0' && price.length() > 1) {
			return "Price cannot have leading zeroes. Product not added.";
		}
		return "";
	}

	/**
	 * @param productID Product's ID (type String)
	 * @return Returns Returns a string
	 */
	public static String verifyProductID(String productID) { // This function verifies productID input from user
		if (productID.length() == 0) {
			return "Product ID must be filled in. Product not added.";
		}

		if (productID.length() != 6 || productID.matches("[0-9]+") == false) {
			return "Product ID must be 6 digits. Product not added.";
		}
		return "";
	}

	/**
	 * @param year Product's year of manafacturing (type String)
	 * @return Returns a string
	 */
	public static String verifyYear(String year) { // This function verifies year input from user
		if (year.length() == 0) {
			return "Year must be filled in. Product not added.";
		}

		if (year.matches("[0-9]+") == false) {
			return "Year must consist of digits only. Product not added.";
		}

		if (!(Integer.valueOf(year) >= 1000 && Integer.valueOf(year) <= 9999)) {
			return "Year must be between 1000 and 9999 (inclusive). Please try again.";
		}
		return "";
	}
}
