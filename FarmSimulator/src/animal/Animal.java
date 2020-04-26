package animal;
/**
 * 
 */

/**
 * @author Lachlan Reynolds, Conor Ansell
 * 
 * This class implements an animal that is able to do actions
 *
 */
public class Animal {
	
	public int health = 100;
	public int happiness = 100;
	public int purchasePrice = 200;
	public int bonusEarnings = 50;
	public double tendToBoost = 1;
	
	public String favouriteFood;
	
	/**
	* Feeds animal if food is favourite, or else prints message
	* 
	* @param foodItem food that will be fed to Animal
	*
	*/	
	public void feed(String foodItem) {
		if (health + 20 <= 100)
			if(foodItem == favouriteFood) {
				health += 20;
			}else {
				System.out.println("This animal does not eat " + foodItem);
			}
		else {
			System.out.println("This animal does not need to eat");
		}
	}
	
	/**
	* Tends to animal, increasing their happiness
	*
	*/
	public void tendTo() {
		if (happiness + 20 <= 100)
		happiness += 20;
		else {
			happiness = 100;
		}
		
		tendToBoost = 1.5;
	}
	
	
	/**
	* Calculates and sets bonusEarnings
	* 
	*/	
	public void setBonusEarnings() {		
		bonusEarnings = (int) (((health + happiness) * tendToBoost) * 0.167);		
	}
	
	public static void main(String args[]) {

		
	}
}
