/**
 * @author Riccardo_Carlesso
 *
 *  I will assume the number of 'games' equals the number of turns to decide
 *  who won in the end. This is the main method.
 * 
 * Usage
 */
public class Main {
	public static final String ProgramVersion = "1.2a" ;
	public static final int DefaultHands = 5 ;
	
	/**
	 * @param args: ARGV[1] might override the default number of hands
	 */
	public static void main(String[] args) {
		int numberOfTurns = DefaultHands ; 
		try {
			if (args.length == 1 ) {
				if (Integer.parseInt(args[0]) > 0) {
					numberOfTurns = Integer.parseInt(args[0]);
				}
			}
		} catch (java.lang.NumberFormatException e) {
			System.err.println("Couldnt parse '"+args[0]+"' as an integer: just using default.");
		}
		System.out.print("Starting a game of '"+numberOfTurns+"' hands (you can change this thru ARGV[1])\n");
		Game game = new Game(numberOfTurns);
		game.play();
	}

}
