
public class ItemToPurchase {

	private String itemName; 
	private int itemPrice;
	private int itemQuantity;
	private String itemDescription;
	
	
	/**
	 * @param itemName
	 * @param itemPrice
	 * @param itemQuantity
	 */
	public ItemToPurchase() {
		this.itemName = "none";
		this.itemPrice = 0;
		this.itemQuantity = 0;
		itemDescription = "none";
	}


	/**
	 * @param itemName
	 * @param itemPrice
	 * @param itemQuantity
	 * @param itemDescription
	 */
	public ItemToPurchase(String itemName,String itemDescription, int itemPrice, int itemQuantity ) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemDescription = itemDescription;
	}


	/**
	 * @return the itemName
	 */
	public String getName() {
		return itemName;
	}


	/**
	 * @param itemName the itemName to set
	 */
	public void setName(String itemName) {
		this.itemName = itemName;
	}


	/**
	 * @return the itemPrice
	 */
	public int getPrice() {
		return itemPrice;
	}


	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}


	/**
	 * @return the itemQuantity
	 */
	public int getQuantity() {
		return itemQuantity;
	}


	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	/**
	 * @return the itemDescription
	 */
	public String getDescription() {
		return itemDescription;
	}


	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void printItemCost()
	{
		int sum = itemQuantity * itemPrice;
		System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + sum);
	}
	
	public void printItemDescription()
	{
		System.out.println(itemName + ": " + itemDescription);
	}
	
	
	
}
