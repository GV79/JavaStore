package cis2430A3;


// Child class of Product
/**
 * @author Giavinh
 */
public class Electronics extends Product {
	private String maker;
	
	/**
	 * @param productID String parameter
	 * @param name String parameter
	 * @param year String parameter
	 * @param price String parameter
	 * @param maker String parameter
	 * @throws Exception If error with inputs found
	 */
	public Electronics(String productID, String name, String year, String price, String maker) throws Exception {
		super(productID, name, year, price);
		this.maker = maker;
		if (maker.isEmpty())
		{
			this.maker = "N/A";
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
			Electronics electronic = (Electronics)otherObject;
			return (productID.equals(electronic.productID) && name.equals(electronic.name) && year.equals(electronic.year) && price.equals(electronic.price) && maker.equals(electronic.maker));
		}
	}
	
	@ Override
	public String toString()
	{
		return super.toString() + "Maker: " + this.maker;
	}
	
	/**
	 * @param maker String parameter
	 * @return Returns object's maker (type String)
	 */
	public String setMaker(String maker) // Mutator Method (set a variable)
	{
		this.maker = maker;
		return this.maker;
	}	
	
	/**
	 * @return Returns object's maker (type String)
	 */
	public String getMaker() // Accessor Method (get a variable)
	{
		return maker;
	}
}
