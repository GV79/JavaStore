package cis2430A3;

/**
 * Child Class of Product
 * @author Giavinh
 */
public class Book extends Product {
	private String authors;
	private String publisher;
	
	/**
	 * @param productID String parameter
	 * @param name String parameter
	 * @param year String parameter
	 * @param price String parameter
	 * @param authors String parameter
	 * @param publisher String parameter
	 * @throws Exception If error with inputs is found
	 */
	public Book(String productID, String name, String year, String price, String authors, String publisher) throws Exception {
		super(productID, name, year, price);
		this.authors = authors;
		this.publisher = publisher;
		
		if (authors.isEmpty())
		{
			this.authors = "N/A";
		}
		
		if (publisher.isEmpty())
		{
			this.publisher = "N/A";
		}
	}

	@ Override
	public boolean equals(Object otherObject) // For error-checking and debugging
	{
		if (otherObject == null)
		{
			return false;
		}
		else if (getClass() != otherObject.getClass())
		{
			return false;
		}
		else
		{
			Book book = (Book)otherObject;
			return (productID.equals(book.productID) && name.equals(book.name) && year.equals(book.year) && price.equals(book.price) && authors.equals(book.authors) && publisher.equals(book.publisher));
		}
	}
	
	@ Override
	public String toString()
	{
		return super.toString() + "Author: " + this.authors + ", Publisher: " + this.publisher;
	}
	
	/**
	 * Mutator Methods (set a variable)
	 * @param input String parameter
	 * @return Returns object's authors (type String)
	 */
	public String setAuthor(String input)
	{
		authors = input;
		return authors;
	}
	
	/**
	 * @param input String parameter
	 * @return Returns object's publisher (type String)
	 */
	public String setPublisher(String input)
	{
		publisher = input;
		return publisher;
	}
	
	/**
	 * Accessor Methods (get a variable)
	 * @return Returns object's publisher (type String)
	 */
	public String getPublisher()
	{
		return publisher;
	}
	
	/**
	 * @return Returns object's author (type String)
	 */
	public String getAuthor()
	{
		return authors;
	}
}
