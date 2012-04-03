
import java.util.Scanner; // to scan STDIN

public class Human implements IPlayer {

	/**
	 * Ask for Scissors/Paper/Rock from stdin
	 * 
	 * @return the symbol
	 */
	@Override
	public Symbol move() {
		System.out.print("What is your move: (S)cissors/(P)aper/(R)ock ? ");
		Scanner cscan = new Scanner (System.in);
		String input = cscan.next();
		char firstChar = input.charAt(0);
		switch(firstChar) {
			case 'S':	return new Symbol(Symbol.EnumSymbol.SCISSOR);
			case 'P':	return new Symbol(Symbol.EnumSymbol.PAPER);
			case 'R':	return new Symbol(Symbol.EnumSymbol.ROCK);
			default:    
				System.out.println("Move '"+firstChar+"' unknown: please Try again\n");
				return move(); // asks again
		}
	}

}
