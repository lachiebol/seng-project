package Farms;
import java.util.ArrayList;
import animal.Animal;
import Farmers.Farmer;
import crops.Crop;

/**
 *
 */

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
	public int money = 500;
	public static int freeSpace = 5;
	public String type;
	public int actionsRemaining = 2;
	public int dayCounter = 0;

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
		for (int i = 0; i < listOfAnimals.size(); i++) {
			Animal currentAnimal = listOfAnimals.get(i);
			System.out.println((i + 1) + ". " + currentAnimal.name + ", <3: " + currentAnimal.health + ", :): " + currentAnimal.happiness);
			
		}
	}
	
	public void printCrops() {
		for (int i = 0; i < listOfCrops.size(); i++) {
			Crop currentCrop = listOfCrops.get(i);
			System.out.println((i + 1) + ". " + currentCrop.name + ", Days to Harvest: " + currentCrop.daysToHarvest);
		}
	}
	
	
	/**
	 * Buys a crop to be planted in the farm.
	 * @param crop
	 */
	public void buyCrop(Crop crop) {
		if ((money >= crop.purchasePrice) & (freeSpace > 0)) {
			listOfCrops.add(crop);
			money -= crop.purchasePrice;
		}
		if (money < crop.purchasePrice) {
			System.out.println("You do not have enough money to buy that");
			}
		if (freeSpace == 0) {
			System.out.println("You do not have enough space to plant that");
			}
	}

	public void harvestCrop(Crop crop) {
		if (actionsRemaining > 0) {
		listOfCrops.remove(crop);
		money -= crop.sellingPrice;
		}
		else {
			System.out.println("You have no actions remaining today");
		}
	}

	/**
	 * Buys an animal for the farm
	 * @param animal
	 */
	public void buyAnimal(Animal animal) {
		if (money >= animal.purchasePrice) {
			listOfAnimals.add(animal);
			money -= animal.purchasePrice;
		}
		else {
			System.out.println("You do not have enough money to buy that");
			}
	}

	/**
	 * Tidies the farm so that more animals and crops can utilize the space.
	 */
	public void tendToLand() {
		if(freeSpace < 5) {
			freeSpace = 5;
		}
		else {
			System.out.println("The farm is already completely tidy");
		}
	}

	/**
	*Advances to the next day and resets actionsRemaining to 2
	*/
	public void nextDay() {
		dayCounter += 1;
		actionsRemaining = 2;
	}

}
