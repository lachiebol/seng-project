import animal.*;
import crops.*;
import Farms.*;
import Items.*;
import food.*;
import Farmers.Farmer;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class GameEnvironment {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean running = true;
		boolean startGame = true;
		boolean mainGame = false;
		boolean endGame = false;

		Farmer player = null;
		String playerName = "";
		int playerAge = 0;

		Farm playerFarm = null;
		String farmName = null;
		
		//Farm creation loop
		while (startGame) {

			boolean pickPlayerName = true;
			boolean pickPlayerAge = true;
			boolean pickFarmName = true;
			boolean pickFarmType = true;
			
			//player age loop
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
			
			//player age loop
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
			
			//farm name loop
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

			//farm type loop
			while (pickFarmType) {
				System.out.println("Pick a Farm Type, each farm gives bonuses for owning things of the same type");
				System.out.println("");
				System.out.println("1. Chicken Farm");
				System.out.println("2. Crop Farm");
				System.out.println("3. Sheep Farm");
				System.out.println("4. Dairy Farm");

				String farmType = in.nextLine();

				if (farmType.equals("1")) {
					playerFarm = new ChickenFarm(farmType, player);
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
		
		//Main game loop
		while (mainGame) {
			System.out.println("-".repeat(50));

			System.out.println("Welcome to your farm " + player.name + ". What would you like to do?");
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
						System.out.println("2. Tend to animals");
						System.out.println("3. Feed animals");
						System.out.println("4. Use item on crops");

						String choice = in.nextLine();

						if (choice.equals("1")) { // Harvesting crop
							if (playerFarm.listOfCrops.isEmpty() == false) { // if crops not empty
								boolean harvesting = true;

								while (harvesting) {
									playerFarm.printCrops();
									System.out.println("What crops would you like to harvest?");

									try { // get index of crop then run harvest crop method of Farm to harvest using the

										// get crop index;
										int cropIndex = (in.nextInt() - 1); // index
										in.nextLine();

										// harvest crop at cropIndex;
										Crop currentCrop = playerFarm.listOfCrops.get(cropIndex);
										System.out.println("You harvested a " + currentCrop.name.toLowerCase()
												+ " and sold it for " + currentCrop.sellingPrice + " dollars \n");

									} catch (InputMismatchException | IndexOutOfBoundsException ex) { // if not a
																										// correct crop
																										// print message
										System.out.println("That isn't a crop");
									}
								}
							} else {
								System.out.println("You have no crops to harvest");
							}

						} else if (choice.equals("2")) {

						}

						viewCrops = false;
					}

				}

			}

		}

	}
}
