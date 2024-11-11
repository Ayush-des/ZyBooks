import java.util.*;


public class ShoppingCartManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter customer's name: ");
		String name = input.nextLine();
		
		System.out.println("Enter today's date:");
		String date = input.nextLine();
		
		ShoppingCart cart = new ShoppingCart(name, date);
		
		System.out.println("Customer name: " + cart.getCustomerName());
		System.out.println("Today's data: " + cart.getDate());
		System.out.println();
		
		
		
		boolean done = false;
		while (!done)
		{
			System.out.println("Choose an option:");
			String thing = input.nextLine();
			char letter = thing.charAt(0);
			char[] charArray = {'a','d','c','i','o','q'};
			
			for(int i=0; i<charArray.length; i++)
			{
				if(letter == charArray[i])
				{
					cart.executeMenu(letter, cart, input);
				}
			}
			
			if(letter == 'q')
			{
				done = true;
			}
			

		}

		
		
		
		

	}
	
	

}