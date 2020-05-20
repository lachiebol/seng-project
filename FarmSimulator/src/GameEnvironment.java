import animal.*;
import crops.*;
import Farms.*;
import Items.*;
import food.*;
import Farmers.Farmer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class GameEnvironment {
	Scanner in = new Scanner(System.in);
	
	
	/**
	 * Prompts player to pick what crops to harvest then harvests and sells the item
	 * 
	 * @param playerFarm Current Farm object used to get farm's inventory
	 */
	
	public void harvest(Farm playerFarm) {
		if (playerFarm.listOfCrops.isEmpty() == false) { // if crops not empty
			boolean harvesting = true;

			while (harvesting) {
				int lastElement = playerFarm.listOfCrops.size();
				System.out.println("You have " + playerFarm.actionsRemaining + " actions remaining");
				playerFarm.printCrops();
				System.out.println("Enter " + lastElement + " to go back");
				System.out.println("What crops would you like to harvest?");

				try { // get index of crop then run harvest crop method of Farm to harvest using the

					// get crop index;
					int input = (in.nextInt() - 1); // index
					in.nextLine();

					if (input + 1 == lastElement) {
						harvesting = false;

					} else {
						Crop currentCrop = playerFarm.listOfCrops.get(input);

						playerFarm.harvestCrop(currentCrop);

						System.out.println("You harvested a " + currentCrop.name.toLowerCase() + " and sold it for "
								+ currentCrop.sellingPrice + " dollars \n");
					}
					// harvest crop at cropIndex;

				} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct crop print message
					System.out.println("-".repeat(80));
					System.out.println("That isn't a crop");
					System.out.println("-".repeat(80));
				}
			}
		} else {
			System.out.println("-".repeat(80));
			System.out.println("You have no crops to harvest");
			System.out.println("-".repeat(80));
		}

	}
	
	/**
	 * Prompts player to pick what animal to play with then plays with animal
	 * 
	 * @param playerFarm Current Farm object used to get farm's inventory
	 */

	public void playWithAnimals(Farm playerFarm) {
		if (playerFarm.listOfAnimals.isEmpty() == false) { // if crops not empty
			boolean playing = true;

			while (playing) {
				int lastElement = playerFarm.listOfAnimals.size();
				System.out.println("You have " + playerFarm.actionsRemaining + " actions remaining");
				playerFarm.printAnimals();
				System.out.println("Enter " + lastElement + " to go back");
				System.out.println("What animal would you like to play with?");

				try { // get index of animal then run playWith method of Farm to harvest using the

					// get crop index;
					int input = (in.nextInt() - 1); // index
					in.nextLine();

					if (input + 1 == lastElement) {
						playing = false;
					} else {
						// harvest crop at cropIndex;
						Animal currentAnimal = playerFarm.listOfAnimals.get(input);

						currentAnimal.playWith(playerFarm);
					}

				} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct crop print message
					System.out.println("-".repeat(80));
					System.out.println("That isn't an animal");
					System.out.println("-".repeat(80));
				}
			}
		} else {
			System.out.println("-".repeat(80));
			System.out.println("You have no animals to play with");
			System.out.println("-".repeat(80));
		}

	}
	
	/**
	 * Prompts player to pick what animal to play with then feeds the animal
	 * 
	 * @param playerFarm Current Farm object used to get farm's inventory
	 */

	public void feedAnimals(Farm playerFarm) {
		if (playerFarm.listOfAnimals.isEmpty() == false) { // if crops not empty
			boolean feeding = true;

			while (feeding) {
				int lastElement = playerFarm.listOfAnimals.size();
				System.out.println("You have " + playerFarm.actionsRemaining + " actions remaining");
				playerFarm.printAnimals();
				System.out.println("Enter " + lastElement + " to go back");
				System.out.println("What animal would you like to feed?");

				try { // get index of animal then run playWith method of Farm to harvest using the

					// get crop index;
					int input = (in.nextInt() - 1); // index
					in.nextLine();

					if (input + 1 == lastElement) {
						feeding = false;
					} else {
						
						Animal currentAnimal = playerFarm.listOfAnimals.get(input);
						
						boolean pickingFood = true;
						
						while (pickingFood) {
							int foodSize = playerFarm.listOfFood.size();
							playerFarm.printFood();
							System.out.println("Enter what food you would like to feed this animal, or hit " + foodSize + " to go back.");
							
							try {
								int foodIndex = (in.nextInt() - 1);
								in.nextLine();
								
								if (foodIndex + 1 == foodSize) {
									pickingFood = false;
								} else {
									Food currentFood = playerFarm.listOfFood.get(foodIndex);
									
									currentAnimal.feed(currentFood, playerFarm);
								}
								
							} catch (InputMismatchException | IndexOutOfBoundsException ex) {
								System.out.println("That isn't food");
							}
						}
						
					}

				} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct crop print message
					System.out.println("-".repeat(80));
					System.out.println("That isn't an animal");
					System.out.println("-".repeat(80));
				}
			}
		} else {
			System.out.println("You have no animals to feed");
		}
	}
	
	/**
	 * Prompts player to pick what crop to tend to, then tends to that crop
	 * 
	 * @param playerFarm Current Farm object used to get farm's inventory
	 */

	public void tendToCrops(Farm playerFarm) {
		// not yet implemented
		if (playerFarm.listOfCrops.isEmpty() == false) { // if crops not empty
			boolean tending = true;

			while (tending) {
				int lastElement = playerFarm.listOfCrops.size();
				System.out.println("You have " + playerFarm.actionsRemaining + " actions remaining");
				playerFarm.printCrops();
				System.out.println("Enter " + lastElement + " to go back");
				System.out.println("What crop would you like to tend to");

				try { // get index of crop then run tendToCrop method of Farm to tend to the crop

					// get crop index;
					int input = (in.nextInt() - 1); // index
					in.nextLine();

					if (input + 1 == lastElement) {
						tending = false;
					} else {
						
						Crop currentCrop = (Crop) playerFarm.listOfCrops.get(input);
						
						boolean pickingItem = true;
						
						while (pickingItem) {
							int itemSize = playerFarm.listOfItems.size();
							playerFarm.printItems();
							System.out.println("Enter what item you would like to use on this crop, or hit " + itemSize + " to go back.");
							
							try {
								int itemIndex = (in.nextInt() - 1);
								in.nextLine();
								
								if (itemIndex + 1 == itemSize) {
									pickingItem = false;
								} else {
									CropItem currentItem = playerFarm.listOfItems.get(itemIndex);
									
									currentCrop.useItem(currentItem, playerFarm);
								}
								
							} catch (InputMismatchException | IndexOutOfBoundsException ex) {
								System.out.println("-".repeat(80));
								System.out.println("That isn't an item");
								System.out.println("-".repeat(80));
							}
						}
						
					}

				} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct crop print message
					System.out.println("That isn't an animal");
				}
			}
		} else {
			System.out.println("You have no crops to tend to");
		}
	}
	
	/**
	 * Prompts the player to pick an animal, then purchases the animal
	 * 
	 * @param playerFarm Current Farm object used for the buyAnimal method
	 * @param shopAnimals Array of Animals that the shop owns
	 */
	
	public void purchaseAnimals(Farm playerFarm, ArrayList<Object> shopAnimals) {
		boolean viewItem = true;

		while (viewItem) {
			System.out.println("-".repeat(80));
			System.out.println("You have $" + playerFarm.money);
			System.out.println("Animals:");
			for (int i = 0; i < shopAnimals.size(); i++) {
				Animal currentAnimal = (Animal) shopAnimals.get(i);
				System.out
						.println("\t" + (i + 1) + ". " + currentAnimal.name + ", Cost: " + currentAnimal.purchasePrice);
			}

			try { // get index of crop then run harvest crop method of Farm to harvest using the
				System.out.println("Enter what animal you would like to buy, or hit 4 to go back");

				// get crop index;
				int animalInput = (in.nextInt() - 1); // index
				in.nextLine();

				if ((animalInput + 1) == 4) {
					viewItem = false;

				} else {
					Animal currentAnimal = (Animal) shopAnimals.get(animalInput);
					
					System.out.println("How many would you like to purchase?");

					int amount = in.nextInt();
					in.nextLine();

					for (int i = 0; i < amount; i++) {
						//creates clone of currentAnimal so attributes are individual
						Animal purchasedAnimal = (Animal) currentAnimal.clone();
						playerFarm.buyAnimal(purchasedAnimal);
					}

					System.out.println("You bought " + amount + " " + currentAnimal.name + " for $"
							+ (currentAnimal.purchasePrice * amount));
				}
				

			} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct animal print message
				System.out.println("That isn't an animal");
			}

		}
	}
	
	/**
	 * Prompts the player to pick a crop, then purchases the crop
	 * 
	 * @param playerFarm Current Farm object used for the buyAnimal method
	 * @param shopCrops Array of Crops that the shop owns
	 */
	
	public void purchaseCrops(Farm playerFarm, ArrayList<Object> shopCrops) {
		boolean viewItem = true;

		while (viewItem) {
			System.out.println("-".repeat(80));
			System.out.println("You have $" + playerFarm.money);
			System.out.println("Crops:");
			for (int i = 0; i < shopCrops.size(); i++) {
				Crop currentCrop = (Crop) shopCrops.get(i);
				System.out.println("\t" + (i + 1) + ". " + currentCrop.name + ", Cost: "
						+ currentCrop.purchasePrice);
			}
			

			try { // get index of crop then run harvest crop method of Farm to harvest using the
				System.out.println("Enter what Crop you would like to buy, or hit " + (shopCrops.size() + 1) + " to go back");

				// get crop index;
				int CropInput = (in.nextInt() - 1); // index
				in.nextLine();

				if ((CropInput + 1) == (shopCrops.size() + 1)) {
					viewItem = false;

				} else {
					Crop currentCrop = (Crop) shopCrops.get(CropInput);
					
					
					System.out.println("How many would you like to purchase?");
					
					int amount = in.nextInt();
					in.nextLine();
					
					for(int i = 0; i < amount; i++) {	
						//creates clone of currentCrop so attributes are individual
						Crop purchasedCrop = (Crop) currentCrop.clone();
						playerFarm.buyCrop(purchasedCrop);
					}
					
					System.out.println("You bought " + amount + " " + currentCrop.name +  " for $"
							+ (currentCrop.purchasePrice * amount));
				}
				// harvest crop at cropIndex;

			} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct crop print message
				System.out.println("That isn't a crop");
			}
			
			
			
		}
	}
	
	/**
	 * Prompts the player to pick a food item, then purchases the food item
	 * 
	 * @param playerFarm Current Farm object used for the buyAnimal method
	 * @param shopFood Array of Food that the shop owns
	 */
	
	public void purchaseFood(Farm playerFarm, ArrayList<Object> shopFood) {
		boolean viewItem = true;

		while (viewItem) {
			System.out.println("-".repeat(80));
			System.out.println("You have $" + playerFarm.money);
			System.out.println("Food:");
			for (int i = 0; i < shopFood.size(); i++) {
				Food currentCrop = (Food) shopFood.get(i);
				System.out.println("\t" + (i + 1) + ". " + currentCrop.name + ", Cost: "
						+ currentCrop.price);
			}
			

			try { // get index of crop then run harvest crop method of Farm to harvest using the
				System.out.println("Enter what Food you would like to buy, or hit " + (shopFood.size() + 1) + " to go back");

				// get crop index;
				int foodInput = (in.nextInt() - 1); // index
				in.nextLine();

				if ((foodInput + 1) == (shopFood.size() + 1)) {
					viewItem = false;

				} else {
					Food currentFood = (Food) shopFood.get(foodInput);
					System.out.println("How many would you like to purchase?");
					
					int amount = in.nextInt();
					in.nextLine();
					
					for(int i = 0; i < amount; i++) {									
						playerFarm.buyFood(currentFood);
					}
					
					System.out.println("You bought " + amount + " " + currentFood.name +  " for $"
							+ (currentFood.price * amount));
				}
				// harvest crop at cropIndex;

			} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct food print message
				System.out.println("That isn't a food");
			}
			
			
			
		}
		
	}
	
	/**
	 * Prompts the player to pick a crop item, then purchases the food item
	 * 
	 * @param playerFarm Current Farm object used for the buyAnimal method
	 * @param shopFood Array of CropItem that the shop owns
	 */
	
	public void purchaseCropItem(Farm playerFarm, ArrayList<Object> shopCropItems) {
		boolean viewItem = true;

		while (viewItem) {
			System.out.println("-".repeat(80));
			System.out.println("You have $" + playerFarm.money);
			System.out.println("Crop Items:");
			for (int i = 0; i < shopCropItems.size(); i++) {
				CropItem currentCropItem = (CropItem) shopCropItems.get(i);
				System.out.println("\t" + (i + 1) + ". " + currentCropItem.name + ", Cost: "
						+ currentCropItem.price);
			}
			

			try { // get index of crop then run harvest crop method of Farm to harvest using the
				System.out.println("Enter what crop item you would like to buy, or hit " + (shopCropItems.size() + 1) + " to go back");

				// get crop index;
				int cropItemInput = (in.nextInt() - 1); // index
				in.nextLine();

				if ((cropItemInput + 1) == (shopCropItems.size() + 1)) {
					viewItem = false;

				} else {
					CropItem currentCropItem = (CropItem) shopCropItems.get(cropItemInput);
					System.out.println("How many would you like to purchase?");
					
					int amount = in.nextInt();
					in.nextLine();
					
					for(int i = 0; i < amount; i++) {									
						playerFarm.buyCropItem(currentCropItem);
					}
					
					System.out.println("You bought " + amount + " " + currentCropItem.name +  " for $"
							+ (currentCropItem.price * amount));
				}
				

			} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct Crop Item print message
				System.out.println("That isn't a Crop Item");
			}
			
			
			
		}
		
	}
	

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		GameEnvironment game = new GameEnvironment();

		boolean running = true;
		boolean startGame = true;
		boolean mainGame = false;
		boolean endGame = false;

		Farmer player = null;
		String playerName = "";
		int playerAge = 0;
		int gameLength = 0;
		

		Farm playerFarm = null;
		String farmName = null;
		
		

		// Farm creation loop
		while (startGame) {

			boolean pickPlayerName = true;
			boolean pickPlayerAge = true;
			boolean pickFarmName = true;
			boolean pickFarmType = true;
			boolean pickGameLength = true;

			// player age loop
			while (pickPlayerName) {

				System.out.println("Pick a name for your farmer, it must be between 3 and 15 characters");

				playerName = in.nextLine();

				int length = playerName.length();

				if (length <= 15 && length >= 3) {
					pickPlayerName = false;
				} else {
					System.out.println("That isn't a valid name,");
				}
			}

			// player age loop
			while (pickPlayerAge) {
				System.out.println("Welcome " + playerName + ", what is your age?");

				try { // If age is not an integer then catch the exception and print a message
					playerAge = in.nextInt();

					if (playerAge >= 100 || playerAge <= 0) {
						System.out.println("That doesn't make any sense");
					} else {
						player = new Farmer(playerName, playerAge); // create farmer object
						pickPlayerAge = false;

					}

				} catch (InputMismatchException ex) {
					System.out.println("That isn't an age");
				} finally {
					in.nextLine();
				}

			}

			// farm name loop
			while (pickFarmName) {
				System.out.println("Pick a Farm Name, it must be between 3 and 30 characters");
				farmName = in.nextLine();

				int length = farmName.length();

				if (length >= 3 && length <= 30) {
					System.out.println("Your farm name is " + farmName);
					pickFarmName = false;
				} else {
					System.out.println(farmName + " isn't a valid farm name");
				}

				System.out.println(""); // add space

			}

			// farm type loop
			while (pickFarmType) {
				System.out.println("Pick a Farm Type, each farm gives bonuses for owning things of the same type");
				System.out.println("");
				System.out.println("1. Chicken Farm");
				System.out.println("2. Crop Farm");
				System.out.println("3. Sheep Farm");
				System.out.println("4. Dairy Farm");

				String farmType = in.nextLine();

				if (farmType.equals("1")) {
					playerFarm = new ChickenFarm(farmName, player);
					pickFarmType = false;
				} else if (farmType.equals("2")) {
					playerFarm = new CropFarm(farmName, player);
					pickFarmType = false;
				} else if (farmType.equals("3")) {
					playerFarm = new SheepFarm(farmName, player);
					pickFarmType = false;
				} else if (farmType.equals("4")) {
					playerFarm = new DairyFarm(farmName, player);
					pickFarmType = false;
				} else {
					System.out.println(farmType + " is not a valid answer");
				}

				System.out.println("");

				

			}
			
			while(pickGameLength) {
				System.out.println("Pick how many days you want to play for");
				System.out.println("");
				System.out.println("1. 5 days");
				System.out.println("2. 10 days");


				String farmType = in.nextLine();

				if (farmType.equals("1")) {
					gameLength = 5;
					pickGameLength = false;
				} else if (farmType.equals("2")) {
					gameLength = 10;
					pickGameLength = false;
				}else {
					System.out.println("Please enter a valid number");
				}
				
				System.out.println("You have picked " + gameLength + " days");
				System.out.println("");
				
				startGame = false;
				mainGame = true;
			}

		}

		// Main game loop
		while (mainGame) {
			System.out.println("-".repeat(90));

			System.out.println("Welcome to your farm " + player.name + ", you have " + playerFarm.actionsRemaining + " actions remaining."
					 + " What would you like to do?");
			System.out.println("1. View crop and animal status");
			System.out.println("2. View farm status");
			System.out.println("3. Visit general store");
			System.out.println("4. Move on to next day");

			String input = in.nextLine();

			if (input.equals("1")) {
				boolean viewCrops = true;

				while (viewCrops) {


					boolean choosing = true;

					while (choosing) {
						System.out.println("-".repeat(80));
						// Print a list of animals
						playerFarm.printAnimals();
						// Print a list of crops
						playerFarm.printCrops();
						
						System.out.println("-".repeat(80));
						System.out.println("What would you like to do?");
						System.out.println("1. Harvest crops");
						System.out.println("2. Play with animals");
						System.out.println("3. Feed animals");
						System.out.println("4. Tend to crops");
						System.out.println("5. Go back to farm");
						
						String choice = in.nextLine();
						
						if (choice.equals("1")) { // Harvesting crop
							System.out.println("-".repeat(80));
							game.harvest(playerFarm);
						} else if (choice.equals("2")) {
							System.out.println("-".repeat(80));
							game.playWithAnimals(playerFarm);
						} else if (choice.equals("3")) {
							System.out.println("-".repeat(80));
							game.feedAnimals(playerFarm);
						} else if (choice.equals("4")) {
							System.out.println("-".repeat(80));
							game.tendToCrops(playerFarm);
						} else if (choice.equals("5")) {
							choosing = false;
						}

						viewCrops = false;
					}

				}

			} else if (input.equals("2")) { //View farm status code
				
				boolean viewFarm = true;
				
				while (viewFarm) {
					System.out.println("-".repeat(80));
					System.out.println("(" + playerFarm.name + ", " + playerFarm.type + ") (" + player.name + ", Age: "
							+ player.age + ")");
					
					System.out.println("Money: " + playerFarm.money + "   Current Day: " + playerFarm.dayCounter + "/" + gameLength
							+ "   Free space: " + playerFarm.freeSpace);
					
					System.out.println(" ");
	
					playerFarm.printAnimals();
					playerFarm.printCrops();
					playerFarm.printFood();
					playerFarm.printItems();
					
					System.out.println("1. Tend to farm (Free up space)");
					System.out.println("2. Go back to farm");
					
					String choice = in.nextLine();
					
					if (choice.equals("1")) {
						playerFarm.tendToLand();
					}else if (choice.equals("2")) {
						viewFarm = false;
					}else {
						System.out.println("Please enter a valid number");
					}
				}
			
				
				
			} else if (input.equals("3")) { //General store code
				boolean inStore = true;

				while (inStore) {
					//SHOP ITEMS					
					ArrayList<Object> shopCropItems = new ArrayList<>(
							Arrays.asList(new Fertilizer(), new ScareCrow(), new AutomaticSprinkler()));
					
					ArrayList<Object> shopFood = new ArrayList<>(Arrays.asList(new Carrots(), new Hay(), new Seeds()));
					ArrayList<Object> shopAnimals = new ArrayList<>(Arrays.asList(new Sheep(), new Cow(), new Chicken()));
					
					ArrayList<Object> shopCrops = new ArrayList<>(
							Arrays.asList(new Beetroot(), new Carrot(), new Corn(), new Parsnip(), new Wheat(), new Potato()));

					System.out.println("-".repeat(80));
					System.out.println("Welcome to the general store, what would you like to look at?");
					System.out.println("You have $" + playerFarm.money);
					System.out.println("1. View Animals");
					System.out.println("2. View Crops");
					System.out.println("3. View Food");
					System.out.println("4. View Crop Items");
					System.out.println("5. Go back to farm");

					String choice = in.nextLine();

					if (choice.equals("1")) {						
						game.purchaseAnimals(playerFarm, shopAnimals);														
					}else if (choice.equals("2")){
						game.purchaseCrops(playerFarm, shopCrops);
					}else if (choice.equals("3")) {
						game.purchaseFood(playerFarm, shopFood);
					}else if (choice.equals("4")){
						game.purchaseCropItem(playerFarm, shopCropItems);
					}else if (choice.equals("5")) {
						inStore = false;
					}


				}
			}else if (input.equals("4")) { //End day code
				boolean endDay = true;

				while (endDay) {
					System.out.println("\nAre you sure you want to continue to the next day? You have "
							+ playerFarm.actionsRemaining + " actions remaining\n");
					System.out.println("1: Yes, 2: No");

					String choice = in.nextLine();

					if (choice.equals("1")) {
						if(playerFarm.dayCounter == gameLength) {
							mainGame = false;
						}
												
						System.out.println("Day " + playerFarm.dayCounter + " completed");
						playerFarm.nextDay();
						endDay = false;
					}else if (choice.equals("2")) {
						endDay = false;
					}else {
						System.out.println("Enter a valid option");
					}
				}
			}
		}
		
		//end game text
		System.out.println("-".repeat(40));
		System.out.println("");
		System.out.println("Game Completed!");
		System.out.println("");
		System.out.println("-".repeat(40));



	}
}
