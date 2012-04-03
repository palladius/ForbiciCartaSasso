/**
 * @author Riccardo_Carlesso
 *
 *  I will assume the number of 'games' equals the number of turns to decide
 *  who won in the end. This is the main method.
 * 
 */
public class Main {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberOfTurns = 5; 
		// TODO Take it from Argv(1)
		if (args.length == 1 ) {
			if (Integer.parseInt(args[1]) > 0) {
				numberOfTurns = Integer.parseInt(args[1]);
			}
		}
		System.out.print("Starting a game of "+numberOfTurns+" hands\n");
		Game game = new Game(numberOfTurns);
		game.play();
	}

}
