package cis2430A3;

// Parent Class of Book and Electronics
/**
 * @author Giavinh
 */
public abstract class Product {
	String productID;
	String name;
	String year;
	String price;

	/**
	 * @param productID String parameter
	 * @param name String parameter
	 * @param year String parameter
	 * @param price String parameter
	 * @throws Exception
	 */
	public Product(String productID, String name, String year, String price) throws Exception
	{
		if (productID.isEmpty() || productID.length() != 6 || productID.matches("[0-9]+") == false)
		{
			throw new Exception();
		}
		
		if (name.isEmpty())
		{
			throw new Exception();
		}
		
		if (year.isEmpty() || year.matches("[0-9]+") == false || !(Integer.valueOf(year) >= 1000 && Integer.valueOf(year) <= 9999))
		{
			throw new Exception();
		}
		
		if (price.length() != 0 && !price.equals("N/A"))
		{
			if (price.matches("[0-9.]*") == false || price.charAt(0) == '0' && price.length() > 1)
			{
				throw new Exception();
			}
		}
		
		this.productID = productID;
		this.name = name;
		this.year = year;
		this.price = price;
		if (price.isEmpty())
		{
			this.price = "N/A";
		}
	}
	/**
	 * @param otherObject Object parameter
	 * @return Returns true or false
	 */
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
			Product product = (Product)otherObject;
			return (productID.equals(product.productID) && name.equals(product.name) && year.equals(product.year) && price.equals(product.price));
		}
	}
	
	/**
	 * @return Returns a string
	 */
	public String toString() // For error-checking and debugging
	{
		return "Product ID: " + this.productID + ", " + "Name: " + this.name + ", " + "Price: " + this.price + ", " + "Year: " + this.year + ", ";
	}
	
	/**
	 * @param price String parameter
	 * @return Returns object's price
	 */
	public String setPrice(String price) // Setters
	{
		this.price = price;
		return this.price;
	}
	
	/**
	 * @param productID String parameter
	 * @return Returns object's product ID
	 */
	public String setProductID(String productID)
	{
		this.productID = productID;
		return this.productID;
	}
	
	/**
	 * @param year String parameter
	 * @return Returns object's year of manufacture
	 */
	public String setYear(String year)
	{
		this.year = year;
		return this.year;
	}
	
	/**
	 * @param name String parameter
	 * @return Returns object's name
	 */
	public String setName(String name)
	{
		this.name = name;
		return this.name;
	}
	
	/**
	 * @return Returns object's price
	 */
	public String getPrice() // Getters
	{
		return price;
	}
	
	/**
	 * @return Returns object's product ID
	 */
	public String getProductID()
	{
		return productID;
	}
	
	/**
	 * @return Returns object's year of manufacture
	 */
	public String getYear()
	{
		return year;
	}

	/**
	 * @return Returns object's name
	 */
	public String getName()
	{
		return name;
	}
}
