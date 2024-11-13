
public class Produce extends ItemToPurchase {

	private String expirationDate; 
	/**
	 * @return the exprationDate
	 */
	public String getExprationDate() {
		return expirationDate;
	}
	/**
	 * @param exprationDate the exprationDate to set
	 */
	public void setExprationDate(String exprationDate) {
		this.expirationDate = exprationDate;
	}

	
	
	public void printItem()
	{
		super.printItem();
		System.out.println("Expiration date: " + expirationDate);
	}
	
	
	
}
