package GUI;

import Farmers.Farmer;
import Farms.ChickenFarm;
import Farms.CropFarm;
import Farms.DairyFarm;
import Farms.Farm;
import Farms.SheepFarm;

public class GameManager {
	
	CreateFarm setupWindow;
	FarmScreen farmWindow;
	FarmStatus farmStatusWindow;
	
	String name;
	String farmName;
	int age;
	String farmType;
	
	Farm playerFarm;
	Farmer player;
	
	
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setFarmName(String newFarmName) {
		farmName = newFarmName;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public void setFarmType(String newFarmType) {
		farmType = newFarmType;
	}
	
	public void launchSetupScreen() {
		setupWindow = new CreateFarm(this);
	}
	
	public void closeSetupScreen(CreateFarm setupWindow) {
		setupWindow.closeWindow();
		
		createFarm(name, farmName, age, farmType);
		launchFarmScreen();
		
	}
	
	public void createFarm(String name, String farmName, int age, String farmType) {
		
		player = new Farmer(name, age);
		
		if (farmType.equals("Chicken Farm")) {
			playerFarm = new ChickenFarm(farmName, player);
		} else if (farmType.equals("Crop Farm")) {
			playerFarm = new CropFarm(farmName, player);
		} else if (farmType.equals("Sheep Farm")) {
			playerFarm = new SheepFarm(farmName, player);
		} else if (farmType.equals("Dairy Farm")) {
			playerFarm = new DairyFarm(farmName, player);
		} 
	}
	

	
	public void launchFarmScreen() {
		farmWindow = new FarmScreen(this);
	}
	
	public void closeFarmScreen(FarmScreen farmWindow) {
		farmWindow.closeWindow();
		launchFarmStatusScreen();
	}
	
	
	public void launchFarmStatusScreen() {
		farmStatusWindow = new FarmStatus(this);
	}
	
	public void closeFarmStatusScreen(FarmStatus farmWindow) {
		farmWindow.closeWindow();
		launchFarmScreen();
	}
	
	
	
	
	public static void main(String[] args) {
		GameManager manager = new GameManager();
		
		manager.launchSetupScreen();
	}

}
