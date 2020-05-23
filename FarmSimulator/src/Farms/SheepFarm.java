package Farms;
import Farmers.Farmer;

/**
 * 
 * @author Lachlan Reynolds, Conor Ansell.
 * This class implements a sheep farm which has certain boosts to farming sheep.
 */
public class SheepFarm extends Farm{

	/**
	 * Initialises a SheepFarm Object
	 * @param chosenName the name to be given to the sheep farm
	 * @param chosenFarmer the farmer to be given to the sheep farm
	 */
	public SheepFarm(String chosenName, Farmer chosenFarmer) {
		super(chosenName, chosenFarmer, "Sheep Farm");
	}
}
