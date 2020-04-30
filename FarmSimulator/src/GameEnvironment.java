import animal.*;
import crops.*;
import Farms.*;
import Items.*;
import food.*;
import Farmers.Farmer;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GameEnvironment {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean running = true;
		boolean startGame = true;

		Farmer player = null;
		String playerName = "";
		int playerAge = 0;

		Farm playerFarm;
		String farmName = null;

		while (startGame) {

			boolean pickPlayerName = true;
			boolean pickPlayerAge = true;
			boolean pickFarmName = true;
			boolean pickFarmType = true;

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

			while (pickPlayerAge) {

				System.out.println("Welcome " + playerName + ", what is your age?");

				try { // If age is not an integer then catch the exception and print a message
					playerAge = in.nextInt();
					in.nextLine();
				} catch (InputMismatchException ex) {
					System.out.println("That isn't an age");
				}

				if (playerAge >= 100 || playerAge <= 0) {
					System.out.println("That doesn't make any sense");
				} else {
					player = new Farmer(playerName, playerAge); // create farmer object
					pickPlayerAge = false;

				}

			}

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
				
				System.out.println(""); //add space

			}

			while (pickFarmType) {
				System.out.println("Pick a Farm Type, each farm gives bonuses for owning things of the same type");
				System.out.println("");
				System.out.println("1. Chicken Farm");
				System.out.println("2. Crop Farm");
				System.out.println("3. Sheep Farm");
				System.out.println("4. Dairy Farm");

				String farmType = in.nextLine();

				if (farmType.equals("1")){
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
				}else {
					System.out.println(farmType + " is not a valid answer");
				}
				
			System.out.println("");
			
			startGame = false;

			}

		}

	}

}
