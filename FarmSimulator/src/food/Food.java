package food;

/**
 * @author Lachlan Reynolds, Conor Ansell
 *
 * This class implements a food item that has a health boost, price and name.
 *
 */

public class Food {
	
	public int healthBoost;
	public int price;
	public String name;
	
	/**
	 * Initialises the Food object
	 */
	
	public Food(int newHealthBoost, int newPrice, String newName) {
		healthBoost = newHealthBoost;
		price = newPrice;
		name = newName;
				
	}

}
