package Items;

/**
 * 
 * @author Lachlan Reynolds, Conor Ansell
 * This class implements crop items that can be used to boost the growth of the farms crops
 *
 */

public class CropItem {
	
	public int timeBoost;
	public int price;
	public String name;
	
	/**
	 * Initiates a Crop Item.
	 */
	
	public CropItem(String newName, int newPrice, int newTimeBoost) {
		name = newName;
		price = newPrice;
		timeBoost = newTimeBoost;
	}

}
