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
	GeneralStore generalStoreWindow;
	GeneralStoreAnimals generalStoreAnimalsWindow;
	GeneralStoreCrops generalStoreCropsWindow;
	GeneralStoreFood generalStoreFoodWindow;
	GeneralStoreCropItems generalStoreCropItemsWindow;
	CropAndAnimalStatus cropAndAnimalStatusWindow;
	FeedAnimal feedAnimalWindow;
	FeedAnimal2 feedAnimal2Window;
	HarvestCrop harvestCropWindow;
	PlayWithAnimal playWithAnimalWindow;
	TendToCrop tendToCropWindow;
	int feedAnimalIndex;
	
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
	}
	
	
	public void launchFarmStatusScreen() {
		farmStatusWindow = new FarmStatus(this);
	}
	
	public void closeFarmStatusScreen(FarmStatus farmWindow) {
		farmWindow.closeWindow();
	}
	
	public void launchGeneralStore() {
		generalStoreWindow = new GeneralStore(this);
	}
	
	public void closeGeneralStore(GeneralStore gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchGeneralStoreAnimals() {
		generalStoreAnimalsWindow = new GeneralStoreAnimals(this);
	}
	
	public void closeGeneralStoreAnimals(GeneralStoreAnimals gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchGeneralStoreCrops() {
		generalStoreCropsWindow = new GeneralStoreCrops(this);
	}
	
	public void closeGeneralStoreCrops(GeneralStoreCrops gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchGeneralStoreFood() {
		generalStoreFoodWindow = new GeneralStoreFood(this);
	}
	
	public void closeGeneralStoreFood(GeneralStoreFood gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchGeneralStoreCropItems() {
		generalStoreCropItemsWindow = new GeneralStoreCropItems(this);
	}
	
	public void closeGeneralStoreCropItems(GeneralStoreCropItems gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchCropAndAnimalStatus() {
		cropAndAnimalStatusWindow = new CropAndAnimalStatus(this);
	}
	
	public void closeCropAndAnimalStatus(CropAndAnimalStatus gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchFeedAnimal() {
		feedAnimalWindow = new FeedAnimal(this);
	}
	
	public void closeFeedAnimal(FeedAnimal gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchFeedAnimal2() {
		feedAnimal2Window = new FeedAnimal2(this);
	}
	
	public void closeFeedAnimal2(FeedAnimal2 gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchHarvestCrop() {
		harvestCropWindow = new HarvestCrop(this);
	}
	
	public void closeHarvestCrop(HarvestCrop gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchPlayWithAnimal() {
		playWithAnimalWindow = new PlayWithAnimal(this);
	}
	
	public void closePlayWithAnimal(PlayWithAnimal gameWindow) {
		gameWindow.closeWindow();
	}
	
	public void launchTendToCrop() {
		tendToCropWindow = new TendToCrop(this);
	}
	
	public void closeTendToCrop(TendToCrop gameWindow) {
		gameWindow.closeWindow();
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		GameManager manager = new GameManager();
		
		manager.launchSetupScreen();
	}

}
