import java.util.*;

public class Checkout {
    private HashSet<String> memberIds;
    private HashMap<String, String> memberDetails; // Name -> DOB
//    private  ArrayList<ItemToPurchase> memberHistory;

    public Checkout() {
        // Predefined member data
        memberIds = new HashSet<>();
        memberDetails = new HashMap<>();

        // Add members
        memberIds.add("12345");
        memberIds.add("67890");
        memberIds.add("54321");

        memberDetails.put("Alice Smith", "01/15/1990");
        memberDetails.put("Bob Johnson", "05/22/1985");
        memberDetails.put("Carol White", "12/08/1975");
    }

    public void checkout(ShoppingCart cart, Scanner input) { 
        boolean isMember = false;
        String name = cart.getCustomerName(); 
        String currentDate = cart.getDate(); 
        double total = cart.getCostOfCart();
        

        System.out.println("Are you a member? (yes/no)");
        String response = input.nextLine().toLowerCase();
        
        boolean finsihed = false;
        

        if (response.equalsIgnoreCase("yes")) {
        	
        	
            System.out.println("How would you like to prove membership?");
            System.out.println("1. Enter Membership ID");
            System.out.println("2. Enter Name and Date of Birth");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline
            boolean correct = false;
            while (!correct)
            {
            	if(choice == 1 || choice ==2 )
            	{
            		correct = true;
            	}else if(choice == -1)
            	{
            		return;
            	}else {
            		System.out.println("Invalid input. Please try again or to go back type -1. ");
            		choice = input.nextInt();
            		input.nextLine();
            	}
            }

            if (choice == 1) {
                System.out.println("Please enter your membership ID:");
                boolean done = false;
                while (!done) { 
                    String memberId = input.nextLine();
                    if (memberIds.contains(memberId)) {
                        isMember = true;
                        break;
                    } else if (memberId.equals("cancel")){
                    	return;
                        
                    }else {
                    	System.out.println("Invalid membership ID. Please try again.");
                        System.out.println("To return to menu type in 'cancel'");
                    }
                }
            } else if (choice == 2) {
                System.out.println("Please enter your name:");
                String enteredName = input.nextLine();
                System.out.println("Please enter your date of birth (mm/dd/yyyy):");
                String enteredDob = input.nextLine();

                if (memberDetails.containsKey(enteredName) && memberDetails.get(enteredName).equals(enteredDob)) {
                    isMember = true;
                } else {
                    System.out.println("No matching member found. Please try again.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }else if(response.equalsIgnoreCase("no"))
        {
        	ItemToPurchase item = new ItemToPurchase("Non MemberFee", "Fee",5,1);
        	item.setQuantityInCart(1);
        	cart.addItem(item);
        }else {  // if an invalid choice is made then returns to main menu. 
        	System.out.println("Invalid choice. Returning to main menu.");
        	return;
        }
        
         
        money(cart,input); 
    }
    
  
    
    
    
    private void money(ShoppingCart cart, Scanner input)
    {
    	System.out.println("Please enter your credit card number (16 digits):");
        double creditCard;
        boolean correct = false;
        while (!correct) {
        	creditCard = input.nextDouble(); 
        	if (creditCard >= 1000000000000000.0 && creditCard <=99999999999999999.0) { 
        		
        		String date = cart.getDate();
        		String month = date.substring(0, 2);
        		int num = Integer.parseInt(month);
        		num += 1;
        		month = date.substring(2);
        		
        		Random randGen = new Random();
        		int rando = randGen.nextInt(10000,99999);
        		
        		System.out.println();
        		System.out.println("Order Confirmation #" + rando);
        		System.out.println("Thank you for your purchase!");
        		System.out.println("Items only eliblle for refund before: " + num + "/" + month);
        		
//        		memberHistory = new ArrayList<itemToPurchase>();
//        		for(itemToPurchase item: memberHistory)
        		cart.printTicket();
        		cart.nuke();
        		correct = true;
        		
        
        	} else {
        		System.out.println("Invalid card number. Please enter a 16-digit number.");
        	}
        	}
    }
    
    
    
}
