/**
 * @author Riccardo_Carlesso
 *
 *  I will assume the number of 'games' equals the number of turns to decide
 *  who won in the end. This is the main method.
 * 
 * Usage
 */
public class Main {
	public static final String ProgramVersion = "1.0a" ;
	
	/**
	 * @param args: ARGV[1] might override the default number of hands
	 */
	public static void main(String[] args) {
		int numberOfTurns = 5; 
		if (args.length == 1 ) {
			if (Integer.parseInt(args[0]) > 0) {
				numberOfTurns = Integer.parseInt(args[0]);
			}
		}
		System.out.print("Starting a game of "+numberOfTurns+" hands (you can change this thru ARGV[1])\n");
		Game game = new Game(numberOfTurns);
		game.play();
	}

}
