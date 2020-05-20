package Farms;
import java.util.ArrayList;
import animal.Animal;
import crops.Crop;
import Farmers.Farmer;
import Items.CropItem;
import food.Food;



/**
 * @author Lachlan Reynolds, Conor Ansell
 *
 * This class implements a farm that is able to do actions.
 *
 */

public class Farm {

	public String name;
	public Farmer farmer;
	public ArrayList<Crop> listOfCrops = new ArrayList<Crop>();
	public ArrayList<Animal> listOfAnimals = new ArrayList<Animal>();
	public ArrayList<CropItem> listOfItems = new ArrayList<CropItem>();
	public ArrayList<Food> listOfFood = new ArrayList<Food>();
	public int money = 500;
	public int freeSpace = 5;
	public String type;
	public int actionsRemaining = 2;
	public int dayCounter = 1;
	public String output;
	

	/**
	 * Initiates a Farm Object.
	 */

	public Farm(String newName, Farmer newFarmer, String newType) {
		name = newName;
		farmer = newFarmer;
		type = newType;
	}
	
	/**
	*Prints a list of owned animals
	*/
		
	public void printAnimals() {
		System.out.println("These are your animals:");
		
		if(listOfAnimals.size() == 0) {
			System.out.println("You currently have no animals, visit the general store to buy some \n");
		}
		
		for (int i = 0; i < listOfAnimals.size(); i++) {
			Animal currentAnimal = listOfAnimals.get(i);
			System.out.println("\t" + (i + 1) + ". " + currentAnimal.name + ", <3: " + currentAnimal.health + ", :): " + currentAnimal.happiness);
			
		}
	}
	
	
	/**
	 * Prints a list of owned crops
	 */	
	public void printCrops() {
		System.out.println("These are your crops:");
		
		if(listOfCrops.size() == 0) {
			System.out.println("You currently have no crops, visit the general store to buy some \n");
		}
		
		for (int i = 0; i < listOfCrops.size(); i++) {
			Crop currentCrop = listOfCrops.get(i);
			System.out.println("\t" +(i + 1) + ". " + currentCrop.name + ", Days to Harvest: " + currentCrop.daysToHarvest);
		}
	}
	
	
	/**
	 * Prints a list of owned items
	 */
	public void printItems() {
		System.out.println("These are your items:");
		
		if(listOfItems.size() == 0) {
			System.out.println("You currently have no items, visit the general store to buy some \n");
		}
		
		for (int i = 0; i < listOfItems.size(); i++) {
			CropItem currentItem = listOfItems.get(i);
			System.out.println("\t" +(i + 1) + ". " + currentItem.name + ", -" + currentItem.timeBoost + "days to harvest for a crop");
		}
		
	}
	
	
	/**
	 * Prints a list of owned items
	 */
	public void printFood() {
		System.out.println("These are your food items:");
		
		if(listOfFood.size() == 0) {
			System.out.println("You currently have no food, visit the general store to buy some \n");
		}
		
		for (int i = 0; i < listOfFood.size(); i++) {
			Food currentFood = listOfFood.get(i);
			System.out.println("\t" +(i + 1) + ". " + currentFood.name + ", +" + currentFood.healthBoost + " health to animals");
		}
		
	}
	
	
	/**
	 * Buys a crop to be planted in the farm.
	 * @param crop current Crop that will be purchased
	 */
	public void buyCrop(Crop crop) {
		if ((money >= crop.purchasePrice) & (freeSpace > 0)) {
			listOfCrops.add(crop);
			money -= crop.purchasePrice;
			freeSpace -= 1;
			output = "Successful purchase";
		}
		else {
			if (money < crop.purchasePrice) {
				output = "You do not have enough money to buy that";
			}
			if (freeSpace == 0) {
				output = "You do not have enough space to plant that";
			}
		}
	}
	
	
	/**
	 * Harvests the crop, removing it from the farm and giving the player money.
	 * @param crop current Crop that will be harvested
	 */
	public void harvestCrop(Crop crop) {
		if (actionsRemaining > 0) {
			listOfCrops.remove(crop);
			money += crop.sellingPrice;
			freeSpace += 1;
		}
		else {
			System.out.println("You have no actions remaining today");
		}
	}

	/**
	 * Buys an animal for the farm
	 * @param animal current Animal that will be purchased
	 */
	public void buyAnimal(Animal animal) {
		if ((money >= animal.purchasePrice) & (freeSpace > 0)) {
			listOfAnimals.add(animal);
			money -= animal.purchasePrice;
			freeSpace -= 1;
			output = "Successful purchase";
			}
		else {
			if (money < animal.purchasePrice) {
				output = "Insufficient funds for purchase";
			}
			else {
			output = "Insufficient space for purchase";
			}
		}
	}
	
	/**
	 * Buys a crop item to use on crops.
	 * @param item current CropItem that will be purchased
	 */
	
	public void buyCropItem(CropItem item) {
		if (money >= item.price) {
			listOfItems.add(item);
			money -= item.price;
			output = "Successful purchase";
		}
		else {
			output = "Insufficient funds for purchase";
		}
	}
	
	/**
	 * Buys food that can be fed to animals.
	 * @param food current Food that will be purchased
	 */
	
	public void buyFood(Food food) {
		if (money >= food.price) {
			listOfFood.add(food);
			money -= food.price;
			output = "Successful purchase";
		}
		else {
			output = "Insufficient funds for purchase";
		}
	}
	
	

	/**
	 * Tidies the farm so that more animals and crops can utilize the space.
	 */
	public void tendToLand() {
		if(freeSpace < 5) {
			if (actionsRemaining > 0) {
				freeSpace = 5;
				output = "You tidied the farm";
				actionsRemaining -= 1;
			}
			else {
				output = "You have no actions remaining";
			}
		}
		else {
			output = "The farm is already tidy";
		}
	}
	

	/**
	*Advances to the next day and resets actionsRemaining to 2. Animal's happiness decreases
	*if they don't have much free space. Animal's health decreases. Crop's time to harvest decreases.
	*Crop farm has double growth rate.
	*/
	public void nextDay() {
		
		dayCounter += 1;
		actionsRemaining = 2;
		for (Animal theAnimal: listOfAnimals) {
			theAnimal.tendTo(this);
			theAnimal.happiness -= 5 + ((5 - freeSpace) * 5);
			theAnimal.health -= 20;
		}
		for (Crop crop: listOfCrops) {
			if (this.type == "Crop Farm") {
				if (crop.daysToHarvest >= 2) {
					crop.daysToHarvest -= 2;
				}
				else {
					crop.daysToHarvest = 0;
				}
				
			}
			else {
				if (crop.daysToHarvest > 0) {
					crop.daysToHarvest -= 1;
				}
			}
		}
	}
}
