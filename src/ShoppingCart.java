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
	
	public void modifyItem(ItemToPurchase item)
	{
		for(int i = 0; i<cartItems.size(); i++)
		{
			ItemToPurchase thing = cartItems.get(i);
			String name = thing.getName();
			
			if(name.equals(item) )
			{
				if(name.equals("none") && (thing.getPrice() == 0) && (thing.getQuantity() == 0) )
				{
					Scanner input = new Scanner(System.in);
					System.out.println("Type in item description");
					String modify = input.nextLine();
					thing.setDescription(modify);
					
					System.out.println("Type in new price");
					int price = input.nextInt();
					input.nextLine();
					thing.setPrice(price);
					
					System.out.println("Type in new quanity");
					int quanity = input.nextInt();
					input.nextLine();
					thing.setQuantity(quanity);
					
				}else {
					System.out.println("Item not found in cart. Nothing modified.");
				}
				
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
			int quantity = item.getQuantity();
			int pq = price * quantity;
			sum += pq;
			
			
		}
		
		return sum;
	}
	
	public void printTotal ()
	{
		if((cartItems.size() > 0))
		{
			System.out.println("" + getCustomerName() + "'s Shopping Cart - " + getDate());	
			System.out.println("Number of Items: " + cartItems.size());
			System.out.println();
		
			for(int i = 0; i < cartItems.size(); i++)
				{
				ItemToPurchase item = cartItems.get(i);
				int price = item.getPrice();
				int quanity = item.getQuantity();
				int sum = price * quanity;
				System.out.println(item.getDescription() + " " + item.getQuantity() 
								+ " @ " + item.getPrice() + " = " + sum);
				} 
			System.out.println("Total: $" + getCostOfCart());
		
		}else {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		
	}
	
	public void printDescriptions() {
		System.out.println("" + getCustomerName() + "'s Shopping Cart - " + getDate());	
		System.out.println("Item Description");
		for(int i = 0; i < cartItems.size(); i++)
			{
			ItemToPurchase item = cartItems.get(i);
			System.out.println(item.getName() + ": " + item.getDescription());
			} 
	}
	
	public void printMenu()
	{
		System.out.println("MENU");
		System.out.println("a - Add item to cart\n"
				+ "d - Remove item from cart\n"
				+ "c - Change item quantity\n"
				+ "i - Output items' descriptions\n"
				+ "o - Output shopping cart\n"
				+ "q - Quit");
		System.out.println();
		System.out.println("Choose an option:");
		
	}
	
	public void executeMenu(char letter, ShoppingCart cart, Scanner input)
	{
		switch (letter)
		{
		case 'a':
			System.out.println("ADD ITEM TO CART");
			System.out.println("Enter the item name:");
			
			break;
		case 'd':
			System.out.println("FIX ME");
			break;
		case 'c':
			System.out.println("FIX ME");
			break;
		case 'i':
			System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
			printDescriptions();
			break;
		case 'o':
			System.out.println("OUTPUT SHOPPING CART");
			printTotal();
			break;
		case 'q':
			break;
		default: 
			System.out.println("Choose an option");
		}
	}

	
	
	

}
