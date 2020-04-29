package animal;

import food.Food;


/**
 * @author Lachlan Reynolds, Conor Ansell
 *
 * This class implements an animal that is able to do actions
 *
 */
public class Animal {

	public int health = 100;
	public int happiness = 100;
	public int bonusEarnings = 5;
	public double tendToBoost = 1;

	public String favouriteFood;
	public int purchasePrice;

	/**
	 * Initialises the Animal object
	 *
	 */

	public Animal(String newFavouriteFood, int newPurchasePrice) {
		favouriteFood = newFavouriteFood;
		purchasePrice = newPurchasePrice;
	}

	/**
	* Feeds animal if food is favourite, or else prints message
	*
	* @param Food foodItem, food that will be fed to Animal
	*
	*/
	public void feed(Food foodItem) {
		if (playerFarm.actionsRemaining > 0) {
			if (health + (foodItem.healthBoost * 1.5) <= 100) {
				if(foodItem.name == favouriteFood) {
					health += foodItem.healthBoost * 1.5;
				} else {
					health += foodItem.healthBoost;
				}
				playerFarm.actionsRemaining -= 1;
			}
				else {
					System.out.println("This animal does not need to eat");
				}
			}
				else {
					System.out.println("You have no actions remaining today");
				}
			}

	/**
	* Calculates and sets bonusEarnings
	*
	*/
	public void setBonusEarnings() {
		bonusEarnings += (int) (((health + happiness) * tendToBoost) * 0.0167);
	}

	/**
	* Plays with animal, increasing their happiness
	*
	*/
	public void playWith() {
		if (playerFarm.actionsRemaining > 0) {
			if (happiness + 20 <= 100) {
				happiness += 20;
			}
			else {
				happiness = 100;
			}

			playerFarm.actionsRemaining -= 1

			tendToBoost = 1.5;

			setBonusEarnings();
			}
		else {
			System.out.println("You have no actions remaining today")
		}


	/**
	*Tends to animal, giving the player money.
	*/


}
