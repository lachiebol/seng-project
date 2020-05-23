package Farms;
import Farmers.Farmer;

/**
 *
 * @author Lachlan Reynolds, Conor Ansell.
 * This class implements a crop farm which has certain boosts to farming crops.
 */
public class CropFarm extends Farm{
	/**
	 * Initialises a CropFarm Object
	 * @param chosenName the name to be given to the crop farm
	 * @param chosenFarmer the farmer to be given to the crop farm.
	 */
	public CropFarm(String chosenName, Farmer chosenFarmer) {
		super(chosenName, chosenFarmer, "Crop Farm");
	}
}
