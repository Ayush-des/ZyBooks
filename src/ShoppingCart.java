import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ShoppingCart {

	private String customerName;
	private String currentDate;
	private ArrayList <ItemToPurchase>cartItems = new ArrayList<ItemToPurchase> ();
	private Scanner scan, fileReader;
	
	
	private ArrayList <ItemToPurchase> allItems = new ArrayList<ItemToPurchase>();
	
	public ShoppingCart() 
	{
		// TODO Auto-generated constructor stub
		customerName = "none";
		currentDate = "January 1, 2024";		
	}


	/**
	 * @param customerName
	 * @param currentDate
	 */
	public ShoppingCart(String customerName, String currentDate) {
		this.customerName = customerName;
		this.currentDate = currentDate;
	}
	
	
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public  String getDate()
	{
		return currentDate;
	}
	
	public void addItem(ItemToPurchase item)
	{
		cartItems.add(item);
	}
	
	public void addItem(String itemName , int quantity, Shop store)
	{
		boolean found = false;
	
		for(ItemToPurchase item : store.getStore())
		{
			if(item.getName().equals(itemName))
			{
				found = true;
				
				if(item.inStock) {
					cartItems.add(item);
					item.setQuantityInCart(quantity);
				}else {
					System.out.println("This item is not in stock. Or not in stock for the quantity");
				}
			}
		}
		
		if(!found)
		{
			System.out.println("Please enter a valid item.");
		}
	}
	
	public void removeItem(String itemName) // could make into a for each loop
	{
		
		for(int i = 0; i<cartItems.size(); i++)
		{
			ItemToPurchase thing = cartItems.get(i);
			
			if(thing.getName().equals(itemName))
			{
				cartItems.remove(i);
				return;
			}
		}
		
		System.out.println("Item not found in cart. Nothing removed.");
		
	}
	
	public void changeQuantity(String itemName, int newQuantity) { 
	    boolean found = false;
	    for (ItemToPurchase item : cartItems) {
	    	
	    	if(item.getName().equals(itemName))
	    	{
	    		item.setQuantityInCart(newQuantity);
	    		found = true;
	    	}
	    	
	    	
	    	if(!found) 
	    	{
	    		System.out.println("Item not found in cart.");
	    	}
	    }
	}

	
	public int getNumItemsInCart()
	{
		return cartItems.size();
	}
	
	public int getCostOfCart()
	{
		int sum = 0;
		
		for(int i=0; i<cartItems.size(); i++)
		{
			ItemToPurchase item = cartItems.get(i);
			
			int price = item.getPrice();
			int quantity = item.getQuantityInCart();
			int pq = price * quantity;
			sum += pq;
		}
		
		return sum;
	}
	
	public void printTotal()
	{
		
		System.out.println("" + getCustomerName() + "'s Shopping Cart - " + getDate());	
		
		int numItems = 0;
		int itemQuantity = 0;
		for(int i=0; i<cartItems.size(); i++)
		{
			itemQuantity = cartItems.get(i).getQuantityInCart();
			numItems += itemQuantity;
		}
		System.out.println("Number of Items: " + numItems);
		System.out.println();
	
		if((cartItems.size() > 0))
		{
			for(int i = 0; i < cartItems.size(); i++)
				{
				ItemToPurchase item = cartItems.get(i);
				int price = item.getPrice();
				int quanity = item.getQuantityInCart();
				int sum = price * quanity;
				System.out.println(item.getName() + " " + item.getQuantityInCart() 
									+ " @ $" + item.getPrice() + " = $" + sum);
				} 
			
		
		}else {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		System.out.println();
		System.out.println("Total: $" + getCostOfCart());	
	}
	
	public void printTicket()
	{
		
		System.out.println(getDate());	
		
		int numItems = 0;
		int itemQuantity = 0;
		for(int i=0; i<cartItems.size(); i++)
		{
			itemQuantity = cartItems.get(i).getQuantityInCart();
			numItems += itemQuantity;
		}
		System.out.println("Number of Items: " + numItems);
		System.out.println();
	
		if((cartItems.size() > 0))
		{
			for(int i = 0; i < cartItems.size(); i++)
				{
				ItemToPurchase item = cartItems.get(i);
				int price = item.getPrice();
				int quanity = item.getQuantityInCart();
				int sum = price * quanity;
				System.out.println(item.getName() + " " + item.getQuantityInCart() 
									+ " @ $" + item.getPrice() + " = $" + sum);
				} 
			
		
		}else {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		System.out.println();
		System.out.println("Total: $" + getCostOfCart());	
	}
	
	public void nuke()
	{
		cartItems.removeAll(cartItems);
	}
	
	
	
	



}
