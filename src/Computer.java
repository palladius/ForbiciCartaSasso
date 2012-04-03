
/**
 * @author Riccardo_Carlesso
 *
 */
import java.util.Random;

public class Computer implements  IPlayer {
	private static Random random = new Random(); // initializes only once

	/**
	 * Plays a random symbol between the three available
	 */
	public Symbol move() {
		int randomPosition = random.nextInt( Symbol.EnumSymbol.values().length );   // random position within Enum
		return new Symbol(Symbol.EnumSymbol.values()[randomPosition]) ;
	}

}
