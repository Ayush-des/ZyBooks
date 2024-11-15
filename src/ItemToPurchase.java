import java.io.File;
import java.util.*;


public class ItemToPurchase {

	protected String itemName; 
	protected int itemPrice;
	protected int itemQuantity;
	protected String itemDescription; // this is going to be type (self care, dairy, vegetable, and fruits
	protected boolean inStock;
	protected int quantityInCart;
	
	
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
		inStock = false;
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
		if(itemQuantity > 0)
		{
			inStock = true;
		}else {
			inStock = false;
		}
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
	
	
	/**
	 * @return the quantityInCart
	 */
	public int getQuantityInCart() {
		return quantityInCart;
	}


	/**
	 * @param quantityInCart the quantityInCart to set
	 */
	public void setQuantityInCart(int quantityInCart) {
		this.quantityInCart = quantityInCart;
	}


	/**
	 * @return the inStock
	 */
	public boolean isInStock() {
		return inStock;
	}


	/**
	 * @param inStock the inStock to set
	 */
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public void printItemCost() // Fix to where it's only the amount customer has in cart
	{
		int sum = itemQuantity * itemPrice;
		System.out.println(itemName + " " + quantityInCart + " @ $" + itemPrice + " = $" + sum);
	}
	
	public void printItemDescription()
	{
		System.out.println(itemName + ": " + itemDescription);
	}
	
	
	public void printItem()
	{
		System.out.println("Name: " + itemName);
		System.out.println("Price: $" + itemPrice);
		System.out.println("Description: " + itemDescription); 
	}
	
	
	
}
