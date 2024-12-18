import java.util.*;

public class ShoppingCartManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//calls all items in the store
		Shop store = new Shop();
		allItems(store);

		//Scanner takes customer input
		ShoppingCart cart = customerDetails(input);
		
		//customer presented with options
		OptionMenu(input, cart, store);
		
		
	}
	
	
	public static void printMenu()
	{
		System.out.println("MENU");
		System.out.println("Choose one of the following options:");
		System.out.println("1. View full catalogue");
		System.out.println("2. Filter");
		System.out.println("3. Output item descriptions"); //IDK about this one 
		System.out.println("4. View cart");
		System.out.println("5. Add to cart");
		System.out.println("6. Remove from cart");
		System.out.println("7. Purchase items in cart"); 
		System.out.println("8. Apply Promo Code"); 
		System.out.println("9. Exit Shop");
		System.out.println();
	}

	
	
	public static void executeMenu(int number, ShoppingCart cart, Scanner input, Shop store)
	{
		switch (number)
		{
		case 1:
		   System.out.println("Full catalogue of items: ");
		    //call to method to output all items
		   
		   Shop.printRealShop();

		    break;

		case 2:
			System.out.println("Choose filter option: ");
			System.out.println("1. Price (highest to lowest)");
			System.out.println("2. Perishables in stock");
			System.out.println("3. Only in stock items");
			
			int filter = input.nextInt();
	
			
			if(filter == 1)
			{
				Shop.filterPrice();
			}else if(filter == 2)
			{
				Shop.printProduce();
			}else if(filter ==3 )
			{
				Shop.printInStockItems();
			}else {
				System.out.println("Invalid input");
			}
			
			break;
		case 3:
			System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
//			cart.printDescriptions();
			
			break;
		case 4:
			System.out.println("OUTPUT SHOPPING CART");
			cart.printTotal();
			 
			break;
		case 5: //fix this to output the price and description when a name is entered
			System.out.println("ADD ITEM TO CART");
		    System.out.println("Enter the item name:");
		    String name = input.nextLine();
		    System.out.println("Enter the item quantity:");
		    int quantity = input.nextInt();
		    input.nextLine();
		    cart.addItem(name,quantity,store);
		  
			break;
		case 6:
			System.out.println("REMOVE ITEM FROM CART");
			System.out.println("Enter name of item to remove:");
			String itemName = input.nextLine();
			cart.removeItem(itemName);
			
			break;
			
		case 7: //purchasing items in cart
			System.out.println("PURCHASE ITEMS IN CART");
			
			cart.printTotal();
			
			if(cart.getNumItemsInCart() > 0)
			{
				System.out.println("Would you like to purchase these items? (yes/no)");
				String option = input.nextLine();
				if(option.equalsIgnoreCase("yes"))
				{
					//call checkout method to check out items
					Checkout purhase = new Checkout();
					purhase.checkout(cart,input);
				}
				else if(option.equalsIgnoreCase("no"))
				{
					System.out.println("Checkout cancelled.");
				}
				else
				{
					System.out.println("Please enter a valid input. ");
				}
			}else {
				System.out.println("There are no items in the cart. Please add items to checkout.");
			}
			break;
		case 9: //exit the store
			System.out.println("You are now exiting the store. Thank you for shopping with us!");
			break;
		default: 
			System.out.println("Choose an option");
		}
	}
	public static void allItems(Shop store)
	{
		//non-perishable
		ItemToPurchase item1 = new ItemToPurchase("ToothBrush (10 pack)", "Self Care", 12, 6);
		store.addItemToShop(item1);
	
	ItemToPurchase item2 = new ItemToPurchase("Succulent", "Plant", 5, 10);
	store.addItemToShop(item2);
	
	Produce item6= new Produce("Milk (1 Gallon)", "Dairy", 4, 20, "11/30/2024");
	store.addItemToShop(item6);
	
	ItemToPurchase item3 = new ItemToPurchase("Wireless Earbuds", "Electronics", 45, 5);
	store.addItemToShop(item3);
	
	Produce item9 = new Produce("Chicken Breasts (1 lb)", "Poultry", 12, 5, "11/30/2024");
	store.addItemToShop(item9);
	
	ItemToPurchase item4 = new ItemToPurchase("Granola Bars (12 pack)", "Snack", 10, 7);
	store.addItemToShop(item4);
	
	Produce item7 = new Produce("Eggs (1 Dozen)", "Eggs", 6, 10, "12/13/2024");
	store.addItemToShop(item7);
	
	Produce item8 = new Produce("Butter (4 Pack)", "Dairy", 5, 13, "02/16/2025");
	store.addItemToShop(item8);
	
	ItemToPurchase item5 = new ItemToPurchase("Water Bottles (20 pack)", "Drinks", 12, 15);
	store.addItemToShop(item5);
	
	Produce item10 = new Produce("Vine-Ripe Tomatoes (6 pack)", "Fruit", 8, 10, "12/16/2024");
	store.addItemToShop(item10);
	
	}
	private static ShoppingCart customerDetails(Scanner input)
	{
	System.out.println("Enter customer's name:");
	String name = input.nextLine();
	
	System.out.println("Enter today's date:");
	String date = input.nextLine();
	
	System.out.println();
	
	
	
	System.out.println("Customer name: " + name);
	System.out.println("Today's date: " + date);
	System.out.println();
	return new ShoppingCart(name, date);
	}
	
	private static void OptionMenu(Scanner input, ShoppingCart cart, Shop store)
	{
		boolean done = false;
	while (!done)
	{
		printMenu();
		System.out.println("Choose an option:");
		
		int goodOptions [] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int option = input.nextInt();
		input.nextLine();
				
		boolean correctInput = false;
		
		for(int i=0; i<goodOptions.length; i++)
		{
	
			for(int j=0; j<goodOptions.length; j++)
			{
				if(option == goodOptions[j])
				{
					correctInput = true;
					break;
				}
			}

			// Poultry Eggs
			
			if(correctInput == false)
			{
				System.out.println("Invalid Input. Please choose an option 1-9.");
				option = input.nextInt();
				
				i=0;
			}
			
		}
		
		
		if (option == 9) 
		{ 
			done = true; 
		}
		
		executeMenu(option, cart, input, store);	
		
		if (!done)
			{
			System.out.println();
			}
	}
	
}
}
	