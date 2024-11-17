import java.util.ArrayList;

public class Shop {


	public static ArrayList<ItemToPurchase> store;
	
	public Shop()
	{
		store = new ArrayList<ItemToPurchase>();
	}
	
	public void allItems()
	{
		
		ItemToPurchase item1 = new ItemToPurchase("ToothBrush (10 pack)", "Self Care", 12, 6);
		addItemToShop(item1);
	
		ItemToPurchase item2 = new ItemToPurchase("Succulent", "Plant", 5, 10);
		addItemToShop(item2);
		
		Produce item6= new Produce("Milk (1 Gallon)", "Dairy", 4, 20, "11/30/2024");
		addItemToShop(item6);
		
		ItemToPurchase item3 = new ItemToPurchase("Wireless Earbuds", "Electronics", 45, 5);
		addItemToShop(item3);
		
		Produce item9 = new Produce("Chicken Breasts (1 lb)", "Poultry", 12, 5, "11/30/2024");
		addItemToShop(item9);
		
		ItemToPurchase item4 = new ItemToPurchase("Granola Bars (12 pack)", "Snack", 10, 7);
		addItemToShop(item4);
		
		Produce item7 = new Produce("Eggs (1 Dozen)", "Eggs", 6, 10, "12/13/2024");
		addItemToShop(item7);
		
		Produce item8 = new Produce("Butter (4 Pack)", "Dairy", 5, 0, "02/16/2025");
		addItemToShop(item8);
		
		ItemToPurchase item5 = new ItemToPurchase("Water Bottles (20 pack)", "Drinks", 12, 15);
		addItemToShop(item5);
		
		Produce item10 = new Produce("Vine-Ripe Tomatoes (6 pack)", "Fruit", 8, 10, "12/16/2024");
		addItemToShop(item10);
	
	}
	
	private void addItemToShop(ItemToPurchase item)
	{
		store.add(item);
	}
	
	public ArrayList<ItemToPurchase> getStore()
	{
		return store;
	}
	
	public static void printRealShop()
	{
		for(ItemToPurchase item : store)
		{
			item.printItem();
			System.out.println();
		}
	}
	
	public static void printProduce()
	{
		for(ItemToPurchase item : store)
		{
			if(item.getDescription().equals("Dairy") || 
					item.getDescription().equals("Fruit")|| 
					item.getDescription().equals("Vegetable")||
					item.getDescription().equals("Poultry")||
					item.getDescription().equals("Eggs"))
			{
				if(item.inStock) {
					item.printItem();
					System.out.println();
				}
			}
		}
	}
	

	
	public static void printInStockItems()
	{
		for(ItemToPurchase item : store)
		{
			if(item.inStock)
			{
				item.printItem();
				System.out.println();
			}
		}
	}
	
	
}
