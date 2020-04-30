package animal;
import food.Hay;

/** 
 * 
 * @author Lachlan Reynolds, Conor Ansell.
 * This class implements a Cow, which is an Animal
 * with specific attributes.
 *
 */

public class Cow extends Animal {	
	public Cow() {
		super(new Hay(), 40); //favourite food
	}
}
