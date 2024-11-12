import java.util.*;

public class ShoppingCart {

	private String customerName;
	private String currentDate;
	private ArrayList <ItemToPurchase>cartItems = new ArrayList<ItemToPurchase> ();
	
	
	public ShoppingCart() 
	{
		// TODO Auto-generated constructor stub
		customerName = "none";
		currentDate = "January 1, 2016";		
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
	
	public void removeItem(String item)
	{
		
		for(int i = 0; i<cartItems.size(); i++)
		{
			ItemToPurchase thing = cartItems.get(i);
			
			if(thing.getName().equals(item) )
			{
				cartItems.remove(i);
				return;
			}
		}
		
		System.out.println("Item not found in cart. Nothing removed.");
		
	}
	
	public void modifyItem(ItemToPurchase item) {
	    boolean itemFound = false;
	    for (ItemToPurchase cartItem : cartItems) {
	        if (cartItem.getName().equals(item.getName())) {
	            if (!item.getDescription().equals("none")) {
	                cartItem.setDescription(item.getDescription());
	            }
	            if (item.getPrice() != 0) {
	                cartItem.setPrice(item.getPrice());
	            }
	            if (item.getQuantity() != 0) {
	                cartItem.setQuantity(item.getQuantity());
	            }
	            itemFound = true;
	            break;
	        }
	    }
	    if (!itemFound) {
	        System.out.println("Item not found in cart. Nothing modified.");
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
			int quantity = item.getQuantity();
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
			itemQuantity = cartItems.get(i).getQuantity();
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
				int quanity = item.getQuantity();
				int sum = price * quanity;
				System.out.println(item.getName() + " " + item.getQuantity() 
								+ " @ $" + item.getPrice() + " = $" + sum);
				} 
			
		
		}else {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		System.out.println();
		System.out.println("Total: $" + getCostOfCart());
		
	}
	
	public void printDescriptions() {
		System.out.println("" + getCustomerName() + "'s Shopping Cart - " + getDate());	
		System.out.println();
		System.out.println("Item Descriptions");
		for(int i = 0; i < cartItems.size(); i++)
			{
			ItemToPurchase item = cartItems.get(i);
			System.out.println(item.getName() + ": " + item.getDescription());
			} 
	}
	



}
