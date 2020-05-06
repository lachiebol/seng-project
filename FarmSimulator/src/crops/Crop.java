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
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}

	public void useItem(CropItem item, Farm playerFarm) {
		if (playerFarm.actionsRemaining > 0) {
			 this.daysToHarvest -= item.timeBoost;
			 playerFarm.actionsRemaining -= 1;
			 System.out.println("You used " + item.name.toLowerCase() + " on " + name + ", -" + item.timeBoost + " days");
		}
		else {
			System.out.println("You have no actions remaining today");
		}
	}
}
