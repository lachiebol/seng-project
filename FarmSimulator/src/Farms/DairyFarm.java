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
	 */
	DairyFarm(String chosenName, Farmer chosenFarmer) {
		super(chosenName, chosenFarmer, "Dairy Farm");
	}
}

