import java.util.ArrayList;

public class Shop {


	public static ArrayList<ItemToPurchase> store;
	
	public Shop()
	{
		store = new ArrayList<ItemToPurchase>();
	}
	
	
	public void addItemToShop(ItemToPurchase item)
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
			if(item.getDescription().equals("Dairy") || item.getDescription().equals("Fruit")|| item.getDescription().equals("Vegetable"))
			{
				if(item.inStock) {
					item.printItem();
					System.out.println();
				}
			}
		}
	}
	
	public static void filterPrice()
	{
		
		int size = store.size(); 
		
		ItemToPurchase things [] = new ItemToPurchase[size];
		
		for(int i = 0; i<size; i++)
		{
			things[i] = store.get(i);
		}
		
		for(int i=0; i<size -1 ; i++)
		{
			for(int j = 0; j< size - i -1 ; j++) //ChatGPT
			{
				if(things[i].getPrice() > things[j].getPrice())
				{
					ItemToPurchase tempItem = things[j];
					things[j] = things[i];
					things[i] = tempItem;
				}
			}
		
		
		}
		
		for(ItemToPurchase item: things)
		{
			item.printItem();
			System.out.println();
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
