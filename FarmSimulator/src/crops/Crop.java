package crops;

import Farms.Farm;
import Items.CropItem;

public class Crop implements Cloneable {
	public String name;
	public int purchasePrice;
	public int sellingPrice;
	public int daysToHarvest;

	/**
	 * Initialises the Crop object
	 *@param newName the name to be given to the crop
	 *@param newPurchasePrice the purchase price to be given to the crop
	 *@param newSellingPrice the selling price to be given to the crop
	 *@param newDaysToHarvest the days to harvest to be given to the crop
	 */

	public Crop(String newName, int newPurchasePrice, int newSellingPrice, int newDaysToHarvest) {
		name = newName;
		purchasePrice = newPurchasePrice;
		sellingPrice = newSellingPrice;
		daysToHarvest = newDaysToHarvest;
	}


	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Uses CropItem on Crop which reduces the daysToHarvest
	 *
	 * @param item that will be used on the crop
	 * @param playerFarm current farm being used 
	 */

	public void useItem(CropItem item, Farm playerFarm) {
		if (playerFarm.actionsRemaining > 0) {
			if ((this.daysToHarvest - item.timeBoost) > 0) {
				this.daysToHarvest -= item.timeBoost;
				playerFarm.actionsRemaining -= 1;
				playerFarm.listOfItems.remove(item);
				System.out
					.println("You used " + item.name.toLowerCase() + " on " + name + ", -" + item.timeBoost + " days");
			}
			else {
				this.daysToHarvest = 0;
				playerFarm.actionsRemaining -= 1;
				playerFarm.listOfItems.remove(item);
				System.out
					.println("You used " + item.name.toLowerCase() + " on " + name + ", -" + item.timeBoost + " days");
			}
		} 
		else {
			System.out.println("You have no actions remaining today");
		}
	}
	
	/**
	 * Returns a string representation of the crop.
	 */
	
	public String toString() {
		return name;
	}
}
