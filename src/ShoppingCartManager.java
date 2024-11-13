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
			
			char goodOptions [] = {'a','d','c','i','o','q'};
			String option = input.nextLine();
			char letter = option.charAt(0);
			
			boolean correctInput = false;
			
			
			
			
			for(int i=0; i<goodOptions.length; i++)
			{
		
				for(int j=0; j<goodOptions.length; j++)
				{
					if(letter == goodOptions[j])
					{
						correctInput = true;
						break;
					}
				}
				
				if(correctInput == false)
				{
					System.out.println("Choose an option:");
					option = input.nextLine();
					letter = option.charAt(0);
					i=0;
				}
				
			}
			
			if (letter == 'q') 
			{ 
				done = true; 
			}

			
			executeMenu(letter, cart, input);	
			
			
			if (!done)
				{
				System.out.println();
				}
		}
		

	}
	
	public static void printMenu()
	{
		System.out.println("MENU");
		System.out.println("a - Add item to cart\n"
				+ "d - Remove item from cart\n"
				+ "c - Change item quantity\n"
				+ "i - Output items' descriptions\n"
				+ "o - Output shopping cart\n"
				+ "q - Quit");
		System.out.println();
	}
	
	public static void executeMenu(char letter, ShoppingCart cart, Scanner input)
	{
		switch (letter)
		{
		case 'a':
		    System.out.println("ADD ITEM TO CART");
		    System.out.println("Enter the item name:");
		    String name = input.nextLine();

		    System.out.println("Enter the item description:");
		    String des = input.nextLine();

		    System.out.println("Enter the item price:");
		    int price = input.nextInt();
		    input.nextLine(); // Consume newline

		    System.out.println("Enter the item quantity:");
		    int quantity = input.nextInt();
		    input.nextLine(); // Consume newline

		    ItemToPurchase item = new ItemToPurchase(name, des, price, quantity);
		    
		    cart.addItem(item);
		    
		    
		    break;

		case 'd':
			System.out.println("REMOVE ITEM FROM CART");
			System.out.println("Enter name of item to remove:");
			String itemName = input.nextLine();
			cart.removeItem(itemName);
			break;
		case 'c':
			System.out.println("CHANGE ITEM QUANTITY");
			System.out.println("Enter the item name:");
			String changeItem = input.nextLine();
			System.out.println("Enter the new quantity:");
			int newQuantity = input.nextInt();
			input.nextLine();
			
			ItemToPurchase newItem = new ItemToPurchase();
			newItem.setName(changeItem);
			newItem.setQuantity(newQuantity);
			
			cart.modifyItem(newItem);
			
			break;
		case 'i':
			System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
			cart.printDescriptions();
			break;
		case 'o':
			System.out.println("OUTPUT SHOPPING CART");
			cart.printTotal();
			break;
		case 'q':
			break;
		default: 
			System.out.println("Choose an option");
		}
	}}
	

