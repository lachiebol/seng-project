package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import animal.*;
import Farms.*;
import food.*;
import Farmers.Farmer;


class FeedAnimalTest {
	
	private Chicken testChicken;
	private Farmer testFarmer;
	
	@BeforeEach
	public void init() {
	testChicken = new Chicken();
	testFarmer = new Farmer("Conor", 19);
	}
	
	@Test
	public void feedChickenSeedsTest() {
		Seeds seedFood = new Seeds();
		ChickenFarm testChickenFarm = new ChickenFarm("My Farm", testFarmer);
		testChicken.health = 20;
		testChicken.feed(seedFood, testChickenFarm);
		
		assertEquals(50, testChicken.health);
		assertEquals(1, testChickenFarm.actionsRemaining);
	}
	
	@Test
	public void feedChickenSeedsTest2() {
		Seeds seedFood = new Seeds();
		ChickenFarm testChickenFarm = new ChickenFarm("My Farm", testFarmer);
		testChicken.health = 90;
		testChicken.feed(seedFood, testChickenFarm);
		
		assertEquals(100, testChicken.health);
		assertEquals(1, testChickenFarm.actionsRemaining);
	}
	
	@Test
	public void feedChickenOtherTest() {
		Hay hayFood = new Hay();
		ChickenFarm testChickenFarm = new ChickenFarm("My Farm", testFarmer);
		testChicken.health = 20;
		testChicken.feed(hayFood, testChickenFarm);
		
		assertEquals(40, testChicken.health);
		assertEquals(1, testChickenFarm.actionsRemaining);
	}
	
	@Test
	public void feedChickenOtherTest2() {
		Hay hayFood = new Hay();
		ChickenFarm testChickenFarm = new ChickenFarm("My Farm", testFarmer);
		testChicken.health = 90;
		testChicken.feed(hayFood, testChickenFarm);
		
		assertEquals(100, testChicken.health);
		assertEquals(1, testChickenFarm.actionsRemaining);
	}
	
	@Test
	public void testActionsRemainingFeedingChicking() {
		Hay hayFood = new Hay();
		ChickenFarm testChickenFarm = new ChickenFarm("My Farm", testFarmer);
		testChickenFarm.actionsRemaining = 0;
		testChicken.health = 90;
		testChicken.feed(hayFood, testChickenFarm);
		
		
		assertEquals("You have no actions remaining today", testChickenFarm.output);
	}
	
	@Test
	public void testAnimalNotHungy() {
		Hay hayFood = new Hay();
		ChickenFarm testChickenFarm = new ChickenFarm("My Farm", testFarmer);
		testChicken.feed(hayFood, testChickenFarm);
		
		assertEquals("This animal does not need to eat", testChickenFarm.output);
	}
	
	
}
