package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import animal.*;
import Farms.*;
import Farmers.Farmer;


class TendToAnmialTest {
	private Sheep testSheep;
	private Farmer testFarmer;
	private DairyFarm testDairyFarm;
	
	@BeforeEach
	public void init() {
		testSheep = new Sheep();
		testFarmer = new Farmer("Conor", 19);
		testDairyFarm = new DairyFarm("My Farm", testFarmer);
	}
	
	@Test
	public void tendToSheepTest() {
		testSheep.happiness = 50;
		testSheep.health = 50;
		testDairyFarm.money = 100;
		
		testSheep.tendTo(testDairyFarm);
		
		assertEquals(140, testDairyFarm.money);
		assertEquals(1, testDairyFarm.actionsRemaining);
	}
	
	@Test	
	public void tendToSheepTest2() {
		testSheep.happiness = 29;
		testSheep.health = 50;
		testDairyFarm.money = 100;
			
		testSheep.tendTo(testDairyFarm);
			
		assertEquals(131, testDairyFarm.money);
		assertEquals(1, testDairyFarm.actionsRemaining);
	}
		
	@Test
	public void tendToSheepTest3() {
		testSheep.happiness = 70;
		testSheep.health = 80;
		testDairyFarm.money = 100;
			
		testSheep.tendTo(testDairyFarm);
			
		assertEquals(160, testDairyFarm.money);
		assertEquals(1, testDairyFarm.actionsRemaining);
	}
		
	@Test
	public void tendToSheepTest4() {
		testSheep.happiness = 50;
		testSheep.health = 50;
		testDairyFarm.money = 100;
		testDairyFarm.actionsRemaining = 0;
			
		testSheep.tendTo(testDairyFarm);
			
		assertEquals(100, testDairyFarm.money);
		assertEquals(0, testDairyFarm.actionsRemaining);
	}
		
	@Test
	public void tendToSheepTest5() {
		testSheep.happiness = 0;
		testSheep.health = 0;
		testDairyFarm.money = 100;
		testDairyFarm.actionsRemaining = 1;
			
		testSheep.tendTo(testDairyFarm);
			
		assertEquals(100, testDairyFarm.money);
		assertEquals(0, testDairyFarm.actionsRemaining);
	}
}
