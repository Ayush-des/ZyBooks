import java.util.*;


public class ShoppingCartManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter customer's name:");
		String name = input.nextLine();
		
		System.out.println("Enter today's date:");
		String date = input.nextLine();
		
		System.out.println();
		
		
		
		System.out.println("Customer name: " + name);
		System.out.println("Today's date: " + date);
		System.out.println();
		ShoppingCart cart = new ShoppingCart(name, date);
		
		
		boolean done = false;
		while (!done)
		{
			printMenu();
			System.out.println("Choose an option:");
			
			int goodOptions [] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
			int option = input.nextInt();
			
			
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
				
				if(correctInput == false)
				{
					System.out.println("Invalid Input. Please choose an option 1-9.");
					option = input.nextInt();
					
					i=0;
				}
				
			}
			
			

			
			executeMenu(option, cart, input);	
			
			
			if (!done)
				{
				System.out.println();
				}
		}
		

	}
	
	public static void printMenu()
	{
		System.out.println("MENU");
		System.out.println("Choose one of the following options:");
		System.out.println("1. View full catalogue");
		System.out.println("2. Filter");
		System.out.println("3. Output item descriptions");
		System.out.println("4. View cart");
		System.out.println("5. Add to cart");
		System.out.println("6. Remove from cart");
		System.out.println("7. Purchase items in cart"); 
		System.out.println("8. Apply Promo Code"); 
		System.out.println("9. Exit Shop");
		System.out.println();
	}
	
	public static void executeMenu(int number, ShoppingCart cart, Scanner input)
	{
		switch (number)
		{
		case 1:
		   System.out.println("Full catalogue of items: ");
		    //call to method to output all items
		    
		    break;

		case 2:
			System.out.println("Choose filter option: ");
			System.out.println("1. Price");
			System.out.println("2. Perishables");
			
			int filter = input.nextInt();
			//price logic
			//perishables logic 
			/*
			 * use if statement for this?
			 */
			break;
		case 3:
			System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
			cart.printDescriptions();
			
			break;
		case 4:
			System.out.println("OUTPUT SHOPPING CART");
			cart.printTotal();
			 
			break;
		case 5: //fix this to output the price and description when a name is entered
			System.out.println("ADD ITEM TO CART");
		    System.out.println("Enter the item name:");
		    String name = input.nextLine();
		  
			break;
		case 6:
			System.out.println("REMOVE ITEM FROM CART");
			System.out.println("Enter name of item to remove:");
			String itemName = input.nextLine();
			cart.removeItem(itemName);
			
			break;
			
		case 7: //purchasing items in cart
			System.out.println("PURCHASE ITEMS IN CART");
			System.out.println("Would you like to purchase these items? (y/n)");
			String option = input.next();
			if(option.equalsIgnoreCase("y"))
			{
				//call checkout method to check out items
			}
			else if(option.equalsIgnoreCase("n"))
			{
				System.out.println("Your purchase has been cancelled.");
			}
			else
			{
				System.out.println("Please enter a valid input. ");
			}
			break;
			
		case 8: //Apply a promo code
			break;
		case 9: //exit the store
			System.out.println("You are now exiting the store. Thank you for shopping with us!");
			break;
		default: 
			System.out.println("Choose an option");
		}
	}}
	

