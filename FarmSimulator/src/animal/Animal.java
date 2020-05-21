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
	private double favouriteBoost = 1.5;
	
	public String favouriteFood;
	
	public int baseEarnings;
	public String name;
	
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
	* Feeds animal, gives bonus of favouriteBoost if food is animals favourite
	*
	* @param Food foodItem, food that will be fed to Animal
	* @param Farm playerFarm, Current farm used to get actions remaining 
	*
	*/
	public void feed(Food foodItem, Farm playerFarm) {

		if (playerFarm.actionsRemaining <= 0) {
			playerFarm.output = ("You have no actions remaining today");
		} else {

			if (health < 100) {
				if (foodItem.name == favouriteFood) {
					health += (foodItem.healthBoost * favouriteBoost);			
					playerFarm.output = "The animal loved that";
				} else{
					health += foodItem.healthBoost;
					playerFarm.output = "The animal ate that begrudgingly";
				}

				
				if (health > 100) {
					health -= health % 100; // 110 mod 100 = 10 (difference)
				}
				
				playerFarm.listOfFood.remove(foodItem);
				playerFarm.actionsRemaining -= 1;
				
				
			} else {
				playerFarm.output = "This animal does not need to eat";
			}

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
					output = "You played with the " + name;
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
			setEarningsBoost();
			if ((playerFarm.type == "Dairy Farm") && (this.name == "Cow")) {
				playerFarm.money += ((int) (baseEarnings * earningsBoost)) + 10;
			}
			else if ((playerFarm.type == "Chicken Farm") && (this.name == "Chicken") && (playerFarm.freeSpace == 5)) {
				playerFarm.money += (((int) (baseEarnings * earningsBoost)) * 2);
			}
			else if ((playerFarm.type == "Sheep Farm") && (this.name == "Sheep") && (playerFarm.farmer.name.equals("Max Watson"))) {
				playerFarm.money += (((int) (baseEarnings * earningsBoost)) * 1000);
			}
			else {
				playerFarm.money += (int) (baseEarnings * earningsBoost);
			}

	}



		



}


