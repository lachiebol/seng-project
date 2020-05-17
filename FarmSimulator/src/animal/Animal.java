package animal;

import Farms.Farm;
import food.Food;

/**
 * @author Lachlan Reynolds, Conor Ansell
 *
 * This class implements an animal that is able to do actions
 *
 */
public class Animal implements Cloneable {
	
	

	public int health = 100;
	public int happiness = 100;
	public double earningsBoost = 2;
	
	public int baseEarnings;
	public String name;
	public String favouriteFood;
	public int purchasePrice;
	public String output;

	/**
	 * Initialises the Animal object
	 *
	 */

	public Animal(String newFavouriteFood, int newPurchasePrice, String newName, int newBaseEarnings) {
		favouriteFood = newFavouriteFood;
		purchasePrice = newPurchasePrice;
		name = newName;
		baseEarnings = newBaseEarnings;
		
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}

	/**
	* Feeds animal if food is favourite, or else prints message
	*
	* @param Food foodItem, food that will be fed to Animal
	*
	*/
	public void feed(Food foodItem, Farm playerFarm) {
		if (playerFarm.actionsRemaining > 0) {
			if (health + (foodItem.healthBoost * 1.5) <= 100) {
				if(foodItem.name == favouriteFood) {
					health += foodItem.healthBoost * 1.5;
					playerFarm.output = "The animal loved that";
				} else {
					health += foodItem.healthBoost;
					playerFarm.output = "The animal ate that begrudgingly";
				}
				playerFarm.actionsRemaining -= 1;
			}
				else {
					playerFarm.output = ("This animal does not need to eat");
				}
			}
				else {
					playerFarm.output = ("You have no actions remaining today");
				}
			}

	/**
	* Calculates and sets earningsBoost
	*
	*/
	public void setEarningsBoost() {
		earningsBoost = (((double) (health + happiness)) / 100);
	}

	/**
	* Plays with animal, increasing their happiness
	*
	*/
	public void playWith(Farm playerFarm) {
		if (playerFarm.actionsRemaining > 0) {
			if (happiness + 20 < 100) {
				happiness += 20;
				playerFarm.actionsRemaining -= 1;
				output = "You played with the animal";
			}
			else {
				if (happiness == 100) {
					output = "The animal is already very happy";
				}
				else {
					happiness = 100;
					playerFarm.actionsRemaining -= 1;
					output = "You played with the animal";
				}
			}
		}
		else {
			output = "You have no actions remaining today";
		}
	}
		
	
	/**
	 * Tends to the animal, providing income for the farm.
	 * @param playerFarm
	 */
	public void tendTo(Farm playerFarm) {
		if (playerFarm.actionsRemaining > 0) {
			setEarningsBoost();
			playerFarm.money += (int) (baseEarnings * earningsBoost);
			playerFarm.actionsRemaining -= 1;
			}
		else {
			System.out.println("You have no remaining actions today");			
		}



		



}
}

