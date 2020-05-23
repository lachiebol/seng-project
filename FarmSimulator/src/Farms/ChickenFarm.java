package Farms;
import Farmers.Farmer;

/**
 * 
 * @author Lachlan Reynolds, Conor Ansell.
 * This class implements a chicken farm which has certain boosts to farming chickens.
 */
public class ChickenFarm extends Farm {
	/**
	 * Initialises a ChickenFarm Object
	 * @param chosenName the name to be given to the chicken farm
	 * @param chosenFarmer the farmer to be given to the chicken farm
	 */
	public ChickenFarm(String chosenName, Farmer chosenFarmer) {
		super(chosenName, chosenFarmer, "Chicken Farm");
	}
}
