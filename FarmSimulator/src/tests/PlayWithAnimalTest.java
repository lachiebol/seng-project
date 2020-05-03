package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import animal.*;
import farms.*;
import farmers.Farmer;

class PlayWithAnimalTest {
	
	private Cow testCow;
	private Farmer testFarmer;
	
	@BeforeEach
	public void init() {
	testCow = new Cow();
	testFarmer = new Farmer("Conor", 19);
	}
	
	@Test
	public void playWithCowTest() {
		DairyFarm testDairyFarm = new DairyFarm("My Farm", testFarmer);
		testCow.happiness = 20;
		testCow.health = 100;
		testCow.playWith(testDairyFarm);
		testCow.setEarningsBoost();
		
		assertEquals(40, testCow.happiness);
		assertEquals(1, testDairyFarm.actionsRemaining);
		assertEquals(1.4, testCow.earningsBoost);
	}
	
	@Test
	public void playWithCowTestMax() {
		DairyFarm testDairyFarm = new DairyFarm("My Farm", testFarmer);
		testCow.happiness = 90;
		testCow.health = 100;
		testCow.playWith(testDairyFarm);
		testCow.setEarningsBoost();
		
		assertEquals(100, testCow.happiness);
		assertEquals(1, testDairyFarm.actionsRemaining);
		assertEquals(2, testCow.earningsBoost);
	}
	
	@Test
	public void playWithCowTest2() {
		DairyFarm testDairyFarm = new DairyFarm("My Farm", testFarmer);
		testCow.happiness = 100;
		testCow.health = 100;
		testCow.playWith(testDairyFarm);
		testCow.setEarningsBoost();
		
		assertEquals(100, testCow.happiness);
		assertEquals(2, testDairyFarm.actionsRemaining);
		assertEquals(2, testCow.earningsBoost);
	}

}
