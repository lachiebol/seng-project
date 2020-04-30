package crops;
import Items.CropItem;
import Farms.Farm;

public class Crop {
	public String name;
	public int purchasePrice;
	public int sellingPrice;
	public int daysToHarvest;

	/**
	 * Initialises the Crop object
	 *
	 */

	public Crop(String newName, int newPurchasePrice, int newSellingPrice, int newDaysToHarvest) {
		name = newName;
		purchasePrice = newPurchasePrice;
		sellingPrice = newSellingPrice;
		daysToHarvest = newDaysToHarvest;
	}

	/**
	 * Uses CropItem on Crop which reduces the daysToHarvest
	 *
	 * @param item
	 */

	public void useItem(CropItem item, Farm playerFarm) {
		if (playerFarm.actionsRemaining > 0) {
			 daysToHarvest -= item.timeBoost;
			 playerFarm.actionsRemaining -= 1;
		}
		else {
			System.out.println("You have no actions remaining today");
		}
	}
}
