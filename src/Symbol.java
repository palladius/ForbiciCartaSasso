
public class Symbol {
	public enum EnumSymbol { SCISSOR , PAPER , ROCK };

	//enum MySymbol  { SCISSOR , PAPER , ROCK }; // game symbols
	private EnumSymbol mySymbol;
	
	public Symbol(EnumSymbol s) {
		this.mySymbol = s;
	}
	
	// tells if I win against another symbol
	// Given more time, Id use more checking for unknown symbols
	// (btw, doesnt Java guarantee that my field only belongs
	// in the available symbols?!?
	public Game.Outcome winsAgainst(Symbol symbol2) {
		EnumSymbol s2 = symbol2.getSymbol();
		switch(mySymbol) { // symbol 1
		case SCISSOR:
			switch (s2) { // symbol 2
				case SCISSOR: 	return Game.Outcome.TIE;
				case PAPER: 	return Game.Outcome.WIN;
				case ROCK: 		return Game.Outcome.LOSE;
				default:        return null; // unknown symbol for player2 
			}
		case PAPER:			
			switch (s2) { // symbol 2
				case SCISSOR: 	return Game.Outcome.LOSE;
				case PAPER: 	return Game.Outcome.TIE;
				case ROCK: 		return Game.Outcome.WIN;
				default:        return null; // unknown symbol for player2 
			}
		case ROCK:
			switch (s2) { // symbol 2
				case SCISSOR: 	return Game.Outcome.WIN;
				case PAPER: 	return Game.Outcome.LOSE;
				case ROCK: 		return Game.Outcome.TIE;
				default:        return null; // unknown symbol for player2 
		}
		default: 		return null ; // unknown symbol for player1 (this)
		}
	}
	
	// getter
	public EnumSymbol getSymbol() {
		return mySymbol;
	}
	
	//@overrides
	public String toString() {
		return mySymbol.toString();
		/**
		switch(mySymbol) {
			case SCISSOR: return "V";
			case PAPER:   return "#";
			case ROCK:    return "O";
			default:      return "(Error)";
		}
		*/
	}
	
}
