/**
 * 
 * 
 * @author Riccardo_Carlesso
 *
 * This is a TWO player game, and never will be more (or less) than two.
 * It can be played by 2 computers or two humans, though.
 * I projected the code in such a way that this might be changed easily.
 *
 * Semantic note: if player1 plays against player 2, I consider a "win" always in favour
 * of the first one, whichever he or it may be.
 */

import java.util.Scanner;

public class Game {
	public static final boolean confPrintSingleHandOutcome = true;
	
	public enum Outcome { WIN, LOSE, TIE };  // final outcome of any one hand
	Human    player1;
	Computer player2;
	
	final int NumberOfTurns ;
	Outcome[]     victories;


	/** constructor: semantically, I just initialize the vars,
	 * although Im tempted to do more
	 * 
	 * TODO put the class Human/Computer in the constructor => Very elegant!
	 */
	public Game(int nTurns) {
		this.NumberOfTurns = nTurns;
		player1   = new Human();
		player2   = new Computer();
		victories = new Outcome[nTurns]; // initializing array of victories
	}
	
	// from victories it infers the winner (or tie)
	public String getWinnerName() {
		int i,victories1,victories2;
		for (i=0,victories1=0,victories2=0; i < NumberOfTurns; i++) {
			switch(victories[i]) {
				case WIN:  victories1++; break;
				case LOSE: victories2++; break;
				//case TIE; break;
				//default:  break; // nothing happens
			}
		}
		if (victories1 == victories2)
			return "Tie";
		if (victories1 > victories2)
			return "Player1 ("+player1.getClass()+")";
		if (victories1 < victories2)
			return "Player2 ("+player2.getClass()+")";
		return "Exception: this should never happen!";
	}
	
	// turns code
	public void play() {
		// play N hands
		for (int i=0; i < NumberOfTurns; i++) {
			victories[i] = playSingleHand();
			if (confPrintSingleHandOutcome) {
				System.out.println("Final outcome for hand #"+(i+1)+" for player 1: "+victories[i]);
			}
		}
		// prints final winner
		System.out.println(".. And the winner is: " + getWinnerName() );
	}
	
	// plays a hand between man and computer
	public Outcome playSingleHand() {
		Symbol move1,move2;
		move1 = player1.move();
		move2 = player2.move();
		if (confPrintSingleHandOutcome) {
			System.out.println("Players played: (1) "+move1+" vs (2) "+move2);
		}
		return move1.winsAgainst(move2);
	}

}
