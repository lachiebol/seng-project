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
	 * @param newName the name to be given to the crop item
	 * @param newPrice the price to be given to the crop item
	 * @param newTimeBoost the time boost to be given to the crop item
	 */
	
	public CropItem(String newName, int newPrice, int newTimeBoost) {
		name = newName;
		price = newPrice;
		timeBoost = newTimeBoost;
	}

	/**
	 * Returns a string representation of the item.
	 */
	
	public String toString() {
		return name;
	}
	
}
