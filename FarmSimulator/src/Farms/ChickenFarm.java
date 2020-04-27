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
	 */
	ChickenFarm(String chosenName, Farmer chosenFarmer) {
		super(chosenName, chosenFarmer, "Chicken Farm");
	}
}
