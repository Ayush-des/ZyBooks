import java.util.Scanner;


public class ShoppingCartPrinter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      
      ItemToPurchase item1 = new ItemToPurchase();
      ItemToPurchase item2 = new ItemToPurchase();
      
      
      String name;
      int quantity;
      int price;
    	  
    	  System.out.println("Item " + 1);
    	  System.out.println("Enter the item name:");
    	  name = scnr.nextLine();
    	  item1.setName(name);
    	  
    	  System.out.println("Enter the item price:");
    	  price = scnr.nextInt();
    	  item1.setPrice(price);
    	  scnr.nextLine();
    	  
    	  System.out.println("Enter the item quantity:");
    	  quantity = scnr.nextInt();
    	  item1.setQuantity(quantity);
    	  scnr.nextLine();
    	  
          System.out.println();
    	  
    	  System.out.println("Item " + 2);
    	  System.out.println("Enter the item name:");
    	  name = scnr.nextLine();
    	  item2.setName(name);
    	  
    	  System.out.println("Enter the item price:");
    	  price = scnr.nextInt();
    	  item2.setPrice(price);
    	  scnr.nextLine();
    	  
    	  System.out.println("Enter the item quantity:");
    	  quantity = scnr.nextInt();
    	  item2.setQuantity(quantity);
    	  
    	  
      System.out.println();
      
      int sum = 0;
      
     System.out.println("TOTAL COST");

      
      
    	 price = item1.getPrice();
    	 int itemQuan = item1.getQuantity();
    	 int tempSum = price * itemQuan;
    	 System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" +  tempSum);
    	 sum += tempSum;
    	 
    	 price = item2.getPrice();
    	  itemQuan = item2.getQuantity();
    	  tempSum = price * itemQuan;
    	 System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" +  tempSum);
    	 sum += tempSum;
    	 
    	 
    	 
      System.out.println();
      System.out.println("Total: $" + sum);
      
   }
}
