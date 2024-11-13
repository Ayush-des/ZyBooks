
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


	public Produce (String itemName,String itemDescription, int itemPrice, String expirationDate)
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = 0;
		this.itemDescription = itemDescription;
		this.expirationDate = expirationDate;
	}
	
	
	public void printItem()
	{
		super.printItem();
		System.out.println("Expiration date: " + expirationDate);
	}
	
	
	
}
