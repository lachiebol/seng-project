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
	 * @param newHealthBoost the health boost to be given to the food
	 * @param newPrice the price to be given to the food
	 * @param newName the name to be given to the food
	 */
	
	public Food(int newHealthBoost, int newPrice, String newName) {
		healthBoost = newHealthBoost;
		price = newPrice;
		name = newName;
				
	}

}
