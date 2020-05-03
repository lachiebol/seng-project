package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import animal.*;
import farms.*;
import food.*;
import crops.*;
import farmers.Farmer;
import items.*;

class FarmTests {
	private DairyFarm testDairyFarm;
	private Farmer testFarmer;
	
	@BeforeEach
	public void init() {
		testFarmer = new Farmer("Conor", 19);
		testDairyFarm = new DairyFarm("My Farm", testFarmer);
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
	public void buyCropItemTest() {
		testDairyFarm.buyCropItem(new Fertilizer());
		testDairyFarm.buyCropItem(new ScareCrow());
		testDairyFarm.buyCropItem(new AutomaticSprinkler());
		
		assertTrue(((testDairyFarm.listOfItems.get(0)) instanceof Fertilizer));
		assertTrue(((testDairyFarm.listOfItems.get(1)) instanceof ScareCrow));
		assertTrue(((testDairyFarm.listOfItems.get(2)) instanceof AutomaticSprinkler));
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
	public void tendToLandTest() {
		testDairyFarm.buyAnimal(new Cow());
		testDairyFarm.buyAnimal(new Sheep());
		testDairyFarm.buyAnimal(new Chicken());
		testDairyFarm.buyAnimal(new Cow());
		
		testDairyFarm.tendToLand();
		
		assertEquals(5, testDairyFarm.freeSpace);
	}
	
	public void nextDayTest() {
		testDairyFarm.buyAnimal(new Cow());
		testDairyFarm.buyAnimal(new Sheep());
		testDairyFarm.buyAnimal(new Chicken());
		testDairyFarm.buyAnimal(new Cow());
		
		testDairyFarm.nextDay();
		testDairyFarm.nextDay();
		
		assertEquals(2, testDairyFarm.dayCounter);
		assertEquals(60, testDairyFarm.listOfAnimals.get(0).happiness);
		assertEquals(60, testDairyFarm.listOfAnimals.get(1).happiness);
		assertEquals(60, testDairyFarm.listOfAnimals.get(2).happiness);
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
