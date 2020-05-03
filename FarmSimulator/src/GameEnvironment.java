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


	public void harvest(Farm playerFarm) {
		if (playerFarm.listOfCrops.isEmpty() == false) { // if crops not empty
			boolean harvesting = true;

			while (harvesting) {
				int lastElement = playerFarm.listOfCrops.size();

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
					System.out.println("That isn't a crop");
				}
			}
		} else {
			System.out.println("You have no crops to harvest");
		}

	}

	public void playWithAnimals(Farm playerFarm) {
		if (playerFarm.listOfAnimals.isEmpty() == false) { // if crops not empty
			boolean playing = true;

			while (playing) {
				int lastElement = playerFarm.listOfAnimals.size();
				
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
					System.out.println("That isn't an animal");
				}
			}
		} else {
			System.out.println("You have no animals to play with");
		}

	}

	public void feedAnimals(Farm playerFarm) {
		// not yet implemented
	}

	public void tendToCrops(Farm playerFarm) {
		// not yet implemented
	}
	
	public void purchase(Farm playerFarm) {
		// not yet implemented
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GameEnvironment game = new GameEnvironment();

		boolean running = true;
		boolean startGame = true;
		boolean mainGame = false;
		boolean endGame = false;

		Farmer player = null;
		String playerName = "";
		int playerAge = 0;

		Farm playerFarm = null;
		String farmName = null;
		
		//SHOP ITEMS
		
		ArrayList<Object> shopCropItems = new ArrayList<>(
				Arrays.asList(new Fertilizer(), new ScareCrow(), new AutomaticSprinkler()));
		
		ArrayList<Object> shopFood = new ArrayList<>(Arrays.asList(new Carrots(), new Hay(), new Seeds()));
		ArrayList<Object> shopAnimals = new ArrayList<>(Arrays.asList(new Sheep(), new Cow(), new Chicken()));
		
		ArrayList<Object> shopCrops = new ArrayList<>(
				Arrays.asList(new Beetroot(), new Carrot(), new Corn(), new Parsnip(), new Wheat(), new Potato()));
		

		// Farm creation loop
		while (startGame) {

			boolean pickPlayerName = true;
			boolean pickPlayerAge = true;
			boolean pickFarmName = true;
			boolean pickFarmType = true;

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
					System.out.println("-".repeat(80));
					// Print a list of animals
					playerFarm.printAnimals();
					// Print a list of crops
					playerFarm.printCrops();

					boolean choosing = true;

					while (choosing) {
						System.out.println("-".repeat(80));
						System.out.println("What would you like to do?");
						System.out.println("1. Harvest crops");
						System.out.println("2. Play with animals");
						System.out.println("3. Feed animals");
						System.out.println("4. Tend to crops");
						System.out.println("5. Go back to farm");
						
						String choice = in.nextLine();

						if (choice.equals("1")) { // Harvesting crop
							game.harvest(playerFarm);
						} else if (choice.equals("2")) {					
							game.playWithAnimals(playerFarm);
						} else if (choice.equals("3")) {
							game.feedAnimals(playerFarm);
						} else if (choice.equals("4")) {
							game.tendToCrops(playerFarm);
						} else if (choice.equals("5")) {
							choosing = false;
						}

						viewCrops = false;
					}

				}

			} else if (input.equals("2")) {
	
				System.out.println("-".repeat(80));
				System.out.println("(" + playerFarm.name + ", " + playerFarm.type + ") (" + player.name + ", Age: " + player.age + ")");
				System.out.println("Money: " + playerFarm.money + "\n");
				
				playerFarm.printAnimals();
				playerFarm.printCrops();
				
				
			} else if (input.equals("3")) {
				boolean inStore = true;

				while (inStore) {

					System.out.println("-".repeat(80));
					System.out.println("Welcome to the general store, what would you like to look at?");
					System.out.println("1. View Animals");
					System.out.println("2. View Crops");
					System.out.println("3. View Food");
					System.out.println("4. View Crop Items");
					System.out.println("5. Go back to farm");

					String choice = in.nextLine();

					if (choice.equals("1")) {
						boolean viewAnimals = true;

						while (viewAnimals) {
							System.out.println("-".repeat(80));
							System.out.println("Animals:");
							for (int i = 0; i < shopAnimals.size(); i++) {
								Animal currentAnimal = (Animal) shopAnimals.get(i);
								System.out.println("\t" + (i + 1) + ". " + currentAnimal.name + ", Cost: "
										+ currentAnimal.purchasePrice);
							}
							

							try { // get index of crop then run harvest crop method of Farm to harvest using the
								System.out.println("Enter what animal you would like to buy, or hit 4 to go back");

								// get crop index;
								int animalInput = (in.nextInt() - 1); // index
								in.nextLine();

								if ((animalInput + 1) == 4) {
									viewAnimals = false;

								} else {
									Animal currentAnimal = (Animal) shopAnimals.get(animalInput);
									System.out.println("How many would you like to purchase?");
									
									int amount = in.nextInt();
									in.nextLine();
									
									for(int i = 0; i < amount; i++) {									
										playerFarm.buyAnimal(currentAnimal);
									}
									
									System.out.println("You bought " + amount + " " + currentAnimal.name +  " for $"
											+ (currentAnimal.purchasePrice * amount));
								}
								// harvest crop at cropIndex;

							} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct crop print message
								System.out.println("That isn't a crop");
							}
							
							
							
						}

					}else if (choice.equals("2")){
						boolean viewCrops = true;

						while (viewCrops) {
							System.out.println("-".repeat(80));
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
									viewCrops = false;

								} else {
									Crop currentCrop = (Crop) shopCrops.get(CropInput);
									System.out.println("How many would you like to purchase?");
									
									int amount = in.nextInt();
									in.nextLine();
									
									for(int i = 0; i < amount; i++) {									
										playerFarm.buyCrop(currentCrop);
									}
									
									System.out.println("You bought " + amount + " " + currentCrop.name +  " for $"
											+ (currentCrop.purchasePrice * amount));
								}
								// harvest crop at cropIndex;

							} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a correct crop print message
								System.out.println("That isn't a crop");
							}
							
							
							
						}
						
						
					}else if (choice.equals("5")) {
						inStore = false;
					}
//
//					System.out.println("Crops:");
//					for (int i = 0; i < shopCrops.size(); i++) {
//						Crop currentCrop = (Crop) shopCrops.get(i);
//						System.out.println("\t" + currentCrop.name + ", Cost: " + currentCrop.purchasePrice
//								+ ", Time to grow: " + currentCrop.daysToHarvest);
//					}

				}
			}
		}

	}
}
