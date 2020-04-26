/**
 * 
 */

/**
 * @author multi
 * 
 * This class implements an animal that is able to do actions
 *
 */
public class Animal {
	
	public int health = 100;
	public int happiness = 100;
	public int tendingEarnings = 50;
	public int purchasePrice = 200;
	public double playWithBoost = 1.5;
	
	private String favouriteFood;
	
	public void feed(String foodItem) {
		if(foodItem == favouriteFood) {
			health += 20;
		}else {
			System.out.println("This animal does not eat " + foodItem);
		}
	}
	
	public void tendTo() {
		happiness += 20;
	}


	public void setFavouriteFood(String favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
