Paper Scissors Rock
-------------------

Paper-Scissors-Rock is a game for two players. Each player simultaneously opens his/her hand to display a symbol:

* Fist equals rock
* Open hand equals paper, Showing the index 
* middle finger equals scissors.

The winner is determined by the following schema:

• paper beats (wraps) rock, 
• rock beats (blunts) scissors, 
• scissors beats (cuts) paper.

Write a Program that plays PaperScissorsRock between the computer and a real player. 

You should be able to play the game n times before the program exits.

Solution
--------

I implemented a thin Main class to proces ARGV for number of hands (default: 5).

The main logic is in Game class which manages turns and dispatches moves to two IPlayer
interfaces with a move() method. These are `Computer` and `Human`. The reason for this
architecture is to ease up a new class (Martian) with a different move algorithm.

More interestingly, I designed the Main class to be able to cope with different kind of
players. By default, player1 is human and player2 is computer. This might be changed
quite easily allowing 2 humans or 2 computers to play aginst each other. I dont feel that
changing the number of players would be possible, given the nature of the game.

All the scissor/paper/rock logic is embedded in a `Symbol` class which wraps an Enum for it
(it would have been nice to wrap all the logic around the Enum itself, as Enum types are 
Classes in java, I found it out too late in my project to refactor thie effectively). In the
Symbol logic, I tried to privilege readability against conciseness (I could have optimized the
code using integers and using a shift register like S > P > R > S, for instance). That would
have probably been the choice given C as a programming language. I also wrapped the
victory/losing/tie into an Enum for readability.

Again, no testing due to lack of time although Symbol would be very easy/intresting to Unit Test.

A very easy refactor would be to call the Game constructor with something like:

    ''public Game(int nTurns, IPlayer player1, IPlayer player2)'' ,

letting the Main to decide the 'race' (human vs computer) of players.

Install
-------

* `cd src/`
* `javac *.java`
* `java Main 42       # plays a 42-hands game`
