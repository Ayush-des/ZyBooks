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
					System.out.println("This item is not in stock.");
				}
				
				
			}
		}
		
		if(!found)
		{
			System.out.println("Please enter a valid item.");
		}
	}
	
	public void removeItem(String itemName)
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
	
	public void modifyItem(ItemToPurchase item) { // ChatGPT && fix it 
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
	        System.out.println("Item not found in cart.");
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
	
	
	
	
	
	
	
	
//	public void printDescriptions() { //not needed? 
//		System.out.println("" + getCustomerName() + "'s Shopping Cart - " + getDate());	
//		System.out.println();
//		System.out.println("Item Descriptions");
//		for(int i = 0; i < cartItems.size(); i++)
//			{
//			ItemToPurchase item = cartItems.get(i);
//			System.out.println(item.getName() + ": " + item.getDescription());
//			} 
//	}
	
//	private void readDataRegular() { // Used ChatGPT
//	    try {
//	        File data = new File("market.txt");
//	        fileReader = new Scanner(data);
//	        fileReader.useDelimiter(",|\\n"); // Use comma and newline as delimiters
//	    } catch (FileNotFoundException ex) {
//	        System.out.println("File not found: " + ex.getMessage());
//	        return; // Exit the method if the file is not found
//	    }
//
//	    while (fileReader.hasNext()) {
//	        try {
//	            String itemName = fileReader.next().trim();
//	            int itemPrice = fileReader.nextInt();
//	            fileReader.skip("\\s*,\\s*"); // Skip the comma and any spaces
//	            String itemDesc = fileReader.next().trim();
//
//	            // Debugging output to check values read
////	            System.out.println("Read Item: Name=" + itemName + ", Price=" + itemPrice + ", Description=" + itemDesc);
//
//	            ItemToPurchase item = new ItemToPurchase(itemName, itemDesc, itemPrice);
//	            
//	        } catch (InputMismatchException e) {
////	            System.out.println("Data format error: " + e.getMessage());
//	            if (fileReader.hasNext()) {
//	                fileReader.nextLine(); // Skip to the next line if there's a format error
//	            }
//	        }
//	    }
//	    fileReader.close();
//	}
//	
//	private void readDataPerish() { // Used ChatGPT
//	    try {
//	        File data = new File("realPerish.txt");
//	        fileReader = new Scanner(data);
//	        fileReader.useDelimiter(",|\\n"); // Use comma and newline as delimiters
//	    } catch (FileNotFoundException ex) {
//	        System.out.println("File not found: " + ex.getMessage());
//	        return; // Exit the method if the file is not found
//	    }
//
//	    while (fileReader.hasNext()) {
//	        try {
//	            String itemName = fileReader.next().trim();
//	            int itemPrice = fileReader.nextInt();
//	            String itemDesc = fileReader.next().trim();
//	            String expirationDate = fileReader.next().trim();
//
//	            // Debugging output to check values read
////	            System.out.println("Read Item: Name=" + itemName + ", Price=" + itemPrice + ", Description=" + itemDesc + ", Expiration Date=" + expirationDate);
//
//	            Produce item = new Produce(itemName, itemDesc, itemPrice, expirationDate);
//	            shopItems.add(item);
//	            fruitsAndVeg.add(item);
//	        } catch (InputMismatchException e) {
////	            System.out.println("Data format error: " + e.getMessage());
//	            if (fileReader.hasNext()) {
//	                fileReader.nextLine(); // Skip to the next line if there's a format error
//	            }
//	        }
//	    }
//	    fileReader.close();
//	}

	
	

	
	
//	public void printShop()
//	{
//		readDataRegular();
//		readDataPerish();
//		
//		for(ItemToPurchase itemz : shopItems)
//		{
//			itemz.printItem();
//			System.out.println();
//		}
//	}
//	
//	
//	public void addItemsToShop ()
//	{
//		
//	}
//	
//	public void filterByProduce() //FIX THIS TO JUST FILTER
//	{
//		for(ItemToPurchase items: fruitsAndVeg)
//		{
//			
//		}
//		
//	}
//	
//	public void filterByPrice()
//	{
//		
//		ArrayList<ItemToPurchase> copy = new ArrayList<ItemToPurchase>();
//		
//		for(ItemToPurchase items : shopItems)
//		{
//			copy.add(items);
//		}
//		
//		ItemToPurchase temp = null;
//		
//		for(int i = 0; i<shopItems.size(); i++)
//		{
//			
//			ItemToPurchase price1 = copy.get(i);
//			
//			
//			if(i == 0 )
//			{
//				temp = price1;
//			}
//			
//			for(int j=0; j<copy.size(); j++)
//			{
//				ItemToPurchase price2 = copy.get(j);
//				if(temp.getPrice() > price2.getPrice())
//				{
//					temp = price2;
//				}
//			}
//			
//			temp.printItem();
//			copy.remove(temp);
//			
//		}	
			
		
//	}
	
	
	



}
