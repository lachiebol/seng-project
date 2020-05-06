package farms;
import farmers.Farmer;

/**
 * 
 * @author Lachlan Reynolds, Conor Ansell.
 * This class implements a sheep farm which has certain boosts to farming sheep.
 */
public class SheepFarm extends Farm{

	/**
	 * Initialises a SheepFarm Object
	 */
	public SheepFarm(String chosenName, Farmer chosenFarmer) {
		super(chosenName, chosenFarmer, "Sheep Farm");
	}
}
