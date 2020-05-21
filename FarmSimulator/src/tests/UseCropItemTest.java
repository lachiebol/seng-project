package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Farms.*;
import crops.*;
import Farmers.Farmer;
import Items.*;

class UseCropItemTest {
	
	private Farmer testFarmer;
	private Farm testSheepFarm;
	
	@BeforeEach
	public void init() {
		testFarmer = new Farmer("Conor", 19);
		testSheepFarm = new SheepFarm("My Farm", testFarmer);
	}
	
	
	@Test
	public void useCropItemTest() {
		testSheepFarm.buyCrop(new Potato());
		testSheepFarm.buyCropItem(new AutomaticSprinkler());
		testSheepFarm.listOfCrops.get(0).useItem(testSheepFarm.listOfItems.get(0), testSheepFarm);
		
		assertEquals(7, testSheepFarm.listOfCrops.get(0).daysToHarvest);
		assertEquals(1, testSheepFarm.actionsRemaining);
	}
	
	@Test
	public void useCropItemTest2() {
		testSheepFarm.buyCrop(new Potato());
		testSheepFarm.buyCropItem(new AutomaticSprinkler());
		testSheepFarm.listOfCrops.get(0).daysToHarvest = 1;
		testSheepFarm.listOfCrops.get(0).useItem(testSheepFarm.listOfItems.get(0), testSheepFarm);
		
		assertEquals(0, testSheepFarm.listOfCrops.get(0).daysToHarvest);
		assertEquals(1, testSheepFarm.actionsRemaining);
	}
}
