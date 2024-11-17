

public class Produce extends ItemToPurchase {

	private String expirationDate; 
	/**
	 * @return the exprationDate
	 */
	public String getExprationDate() {
		return expirationDate;
	}
	/**
	 * @param exprationDate the exprationDate to set
	 */
	public void setExprationDate(String exprationDate) {
		this.expirationDate = exprationDate;
	}


	public Produce (String itemName,String itemDescription, int itemPrice, int itemQuantity, String expirationDate)
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemDescription = itemDescription;
		this.expirationDate = expirationDate;
		if(itemQuantity > 0)
		{
			this.inStock = true;
		}else {
			this.inStock = false;
		}
	}
	
	public Produce() {
		// TODO Auto-generated constructor stub
		this.itemName = "none";
		this.itemPrice = 0;
		this.itemQuantity = 0;
		itemDescription = "none";
		expirationDate = "none";
		this.inStock = false;
		
	}
	@Override
	public void printItem()
	{
		super.printItem();
		System.out.println("Expiration date: " + expirationDate);
	}
	
	
	
}
