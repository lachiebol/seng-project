package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import animal.*;
import Farms.*;
import food.*;
import crops.*;
import Farmers.Farmer;
import Items.*;

class FarmTests {
	private CropFarm testCropFarm;
	private DairyFarm testDairyFarm;
	private Farmer testFarmer;
	
	@BeforeEach
	public void init() {
		testFarmer = new Farmer("Conor", 19);
		testDairyFarm = new DairyFarm("My Farm", testFarmer);
		testCropFarm = new CropFarm("My Farm", testFarmer);
	}
	
	@Test
	public void buyCropTest() {
		testDairyFarm.buyCrop(new Beetroot());
		testDairyFarm.buyCrop(new Carrot());
		testDairyFarm.buyCrop(new Wheat());
		testDairyFarm.buyCrop(new Beetroot());
		
		assertTrue(((testDairyFarm.listOfCrops.get(0)) instanceof Beetroot));
		assertTrue(((testDairyFarm.listOfCrops.get(1)) instanceof Carrot));
		assertTrue(((testDairyFarm.listOfCrops.get(2)) instanceof Wheat));
		assertTrue(((testDairyFarm.listOfCrops.get(3)) instanceof Beetroot));
		assertEquals(1, testDairyFarm.freeSpace);
	}
	
	
	@Test
	public void buyCropTest2() {
		testDairyFarm.money = new Beetroot().purchasePrice - 1;
		
		testDairyFarm.buyCrop(new Beetroot());
		
		testCropFarm.freeSpace = 1;
		
		testCropFarm.buyCrop(new Beetroot());
		testCropFarm.buyCrop(new Beetroot());
				
			
		
		assertEquals("Insufficient funds for purchase", testDairyFarm.output);
		assertEquals("Insufficient space for purchase", testCropFarm.output);
	}
	
	@Test
	public void buyAnimalTest() {
		testDairyFarm.buyAnimal(new Cow());
		testDairyFarm.buyAnimal(new Sheep());
		testDairyFarm.buyAnimal(new Chicken());
		
		
		assertTrue(((testDairyFarm.listOfAnimals.get(0)) instanceof Cow));
		assertTrue(((testDairyFarm.listOfAnimals.get(1)) instanceof Sheep));
		assertTrue(((testDairyFarm.listOfAnimals.get(2)) instanceof Chicken));
		assertEquals(2, testDairyFarm.freeSpace);
	}
	
	@Test
	public void buyAnimalTest2() {
		testDairyFarm.money = new Cow().purchasePrice - 1;
		
		testDairyFarm.buyAnimal(new Cow());
		
		testCropFarm.freeSpace = 1;
		
		testCropFarm.buyAnimal(new Cow());
		testCropFarm.buyAnimal(new Cow());
				
			
		
		assertEquals("Insufficient funds for purchase", testDairyFarm.output);
		assertEquals("Insufficient space for purchase", testCropFarm.output);
	}
	
	@Test
	public void buyCropItemTest() {
		testDairyFarm.buyCropItem(new Fertilizer());
		testDairyFarm.buyCropItem(new ScareCrow());
		testDairyFarm.buyCropItem(new AutomaticSprinkler());
		testCropFarm.money = 0;
		
		testCropFarm.buyCropItem(new Fertilizer());
		
		
		
		//listOfItems[0] is Watering Can
		assertTrue(((testDairyFarm.listOfItems.get(1)) instanceof Fertilizer));
		assertTrue(((testDairyFarm.listOfItems.get(2)) instanceof ScareCrow));
		assertTrue(((testDairyFarm.listOfItems.get(3)) instanceof AutomaticSprinkler));
		
		//assertEquals("Insufficient funds for purchase", testCropFarm.output);
	}
	
	@Test
	public void buyFoodTest() {
		testDairyFarm.buyFood(new Seeds());
		testDairyFarm.buyFood(new Hay());
		testDairyFarm.buyFood(new Carrots());
		
		assertTrue(((testDairyFarm.listOfFood.get(0)) instanceof Seeds));
		assertTrue(((testDairyFarm.listOfFood.get(1)) instanceof Hay));
		assertTrue(((testDairyFarm.listOfFood.get(2)) instanceof Carrots));
	}
	
	@Test
	public void buyFoodTest2() {
		testDairyFarm.money = 0;
		
		testDairyFarm.buyFood(new Seeds());
		
		assertEquals("Insufficient funds for purchase", testDairyFarm.output);

		
	}
	
	
	@Test
	public void tendToLandTest() {
		testDairyFarm.buyAnimal(new Cow());
		testDairyFarm.buyAnimal(new Sheep());
		testDairyFarm.buyAnimal(new Chicken());
		testDairyFarm.buyAnimal(new Cow());
		
		testDairyFarm.tendToLand();
		
		assertEquals(5, testDairyFarm.freeSpace);
	}
	
	@Test
	public void tendToLandTest2() {	
		testCropFarm.actionsRemaining = 0;
		testCropFarm.freeSpace = 0;
		testCropFarm.tendToLand();
		testDairyFarm.tendToLand();
		
		assertEquals("The farm is already tidy", testDairyFarm.output);
		assertEquals("You have no actions remaining", testCropFarm.output);
		
	}
	
	
	@Test
	public void nextDayTest() {
		testDairyFarm.buyAnimal(new Cow());
		testDairyFarm.buyAnimal(new Sheep());
		testDairyFarm.buyAnimal(new Chicken());
		testDairyFarm.buyCrop(new Wheat());
		testDairyFarm.nextDay();
		
		assertEquals(2, testDairyFarm.dayCounter);
		assertEquals(9, testDairyFarm.listOfCrops.get(0).daysToHarvest);
		assertEquals(80, testDairyFarm.listOfAnimals.get(0).health);

	}
	
	@Test
	public void nextDayTest2() {
		testCropFarm.buyCrop(new Wheat());
		testCropFarm.buyCrop(new Beetroot());
		testCropFarm.listOfCrops.get(1).daysToHarvest = 1;
		
		testCropFarm.nextDay();
		
		assertEquals(8, testCropFarm.listOfCrops.get(0).daysToHarvest);
		assertTrue(testCropFarm.listOfCrops.get(1).daysToHarvest >= 0);
		
	}
	
	@Test
	public void nextDayTestAnimalDeathTest() {
		testDairyFarm.buyAnimal(new Cow());
		testDairyFarm.buyAnimal(new Sheep());
		testDairyFarm.buyAnimal(new Chicken());
		
		testDairyFarm.listOfAnimals.get(0).health = 10;
		testDairyFarm.listOfAnimals.get(1).health = 10;
		
		testDairyFarm.nextDay();
		
		assertTrue(testDairyFarm.listOfAnimals.size() == 1);

	}
	
	@Test
	public void nextDayAnimalHappinessTest() {
		testDairyFarm.buyAnimal(new Cow());
	
		testDairyFarm.listOfAnimals.get(0).happiness = 10;
		
		testDairyFarm.nextDay();
		
		assertTrue(testDairyFarm.listOfAnimals.get(0).happiness == 0);

	}
	
	
	
	@Test
	public void harvestCropTest() {
		testDairyFarm.buyCrop(new Beetroot());
		testDairyFarm.buyCropItem(new Fertilizer());
		testDairyFarm.buyCropItem(new Fertilizer());
		testDairyFarm.money = 100;
		
		testDairyFarm.listOfCrops.get(0).useItem(testDairyFarm.listOfItems.get(0), testDairyFarm);
		testDairyFarm.listOfCrops.get(0).useItem(testDairyFarm.listOfItems.get(0), testDairyFarm);
		testDairyFarm.nextDay();
		testDairyFarm.nextDay();
		testDairyFarm.harvestCrop(testDairyFarm.listOfCrops.get(0));
		
		assertEquals(150, testDairyFarm.money);
		assertTrue(testDairyFarm.listOfCrops.isEmpty());
	}
	
}		
