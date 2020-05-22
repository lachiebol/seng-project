package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import animal.*;
import Farms.*;
import Farmers.Farmer;


class TendToAnimalTest {
	private Animal testAnimal;
	private Farmer testFarmer;
	private Farm testFarm;
	
	@BeforeEach
	public void init() {
		testFarmer = new Farmer("Conor", 19);
	}
	
	
	@Test
	public void testChickenTendTo() {
		testAnimal = new Chicken();
		testFarm = new ChickenFarm("Farm", testFarmer);
		
		testAnimal.happiness = 100;
		testAnimal.health = 100;
		
		testAnimal.tendTo(testFarm);
		
		assertEquals(620, testFarm.money);
	}
	
	
	@Test
	public void testChickenTendTo2() {
		testAnimal = new Chicken();
		testFarm = new ChickenFarm("Farm", testFarmer);

		
		testAnimal.happiness = 0;
		testAnimal.health = 10;
		
		testAnimal.tendTo(testFarm);
		
		assertEquals(506, testFarm.money);
	}
	
	@Test
	public void testCowTendTo() {
		testAnimal = new Cow();
		testFarm = new DairyFarm("Farm", testFarmer);

		
		testAnimal.happiness = 100;
		testAnimal.health = 100;
		
		testAnimal.tendTo(testFarm);
		
		assertEquals(610, testFarm.money);
	}
	
	@Test
	public void testCowTendTo2() {
		testAnimal = new Cow();
		testFarm = new DairyFarm("Farm", testFarmer);

		
		testAnimal.happiness = 0;
		testAnimal.health = 1;
		
		testAnimal.tendTo(testFarm);
		
		assertEquals(510, testFarm.money);
	}
	
	@Test
	public void testSheepTendTo() {
		testAnimal = new Sheep();
		testFarm = new SheepFarm("Farm", testFarmer);

		
		testAnimal.happiness = 100;
		testAnimal.health = 100;
		
		testAnimal.tendTo(testFarm);
		
		assertEquals(590, testFarm.money);
	}
	
	@Test
	public void testSheepTendTo2() {
		testAnimal = new Sheep();
		testFarm = new SheepFarm("Farm", testFarmer);

		
		testAnimal.happiness = 0;
		testAnimal.health = 1;
		
		testAnimal.tendTo(testFarm);
		
		assertEquals(510, testFarm.money);
	}
	
	@Test
	public void testCropFarm() {
		testAnimal = new Sheep();
		testFarm = new CropFarm("Farm", testFarmer);

		
		testAnimal.happiness = 100;
		testAnimal.health = 100;
		
		testAnimal.tendTo(testFarm);
		
		assertEquals(580, testFarm.money);
	}
	
	
}
