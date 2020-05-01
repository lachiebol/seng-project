package animal;
import food.Hay;

/** 
 * 
 * @author Lachlan Reynolds, Conor Ansell.
 * This class implements a Sheep, which is a 
 * with specific attributes.
 *
 */

public class Sheep extends Animal {
	
	public Sheep() {
		super(new Hay(), 40, "Sheep"); //favourite food
	}

}
