package Farms;
import Farmers.Farmer;

/**
 * 
 * @author Lachlan Reynolds, Conor Ansell.
 * This class implements a dairy farm which has certain boosts to farming cows.
 */
public class DairyFarm extends Farm {
	
	/**
	 * Initialises a DairyFarm Object
	 * @param chosenName the name to be given to the dairy farm
	 * @param chosenFarmer the farmer to be given to the dairy farm.
	 */
	public DairyFarm(String chosenName, Farmer chosenFarmer) {
		super(chosenName, chosenFarmer, "Dairy Farm");
	}
}

