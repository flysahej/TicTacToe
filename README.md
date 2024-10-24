Tic-Tac-Toe Game with HashDictionary Implementation

Overview

This project implements a Tic-Tac-Toe game where a human player competes against a computer AI. The AI evaluates possible moves using a recursive algorithm and a custom HashDictionary to optimize decision-making. The program assigns scores to different configurations of the board to choose the best moves, ensuring a challenging game against the computer.

The game uses a dynamic board size and winning length, making it customizable for various game difficulties.

Features

	•	Dynamic Game Board: You can specify the size of the board and the length of the sequence required to win.
	•	Human vs. Computer: The human always plays first, using blue tiles (X), while the computer uses red tiles (O).
	•	AI with Recursive Game Tree: The computer AI computes scores using a recursive algorithm that explores possible game configurations.
	•	HashDictionary for Optimization: To improve performance, the program stores and retrieves board configurations from a custom HashDictionary to avoid recalculating scores for repeated configurations.
	•	Game Status Detection: The game evaluates board states to detect whether the game is won, drawn, or undecided.

Classes

	1.	Data.java: Represents a record stored in the HashDictionary, consisting of a board configuration and its associated score.
	2.	HashDictionary.java: Implements a dictionary using a hash table with separate chaining for collision resolution. The hash function is designed to minimize collisions.
	3.	Configurations.java: Manages the game board, saves moves, and checks game conditions (win/draw).
	4.	Play.java: Main class that manages gameplay, including move selection by both players and scoring moves using the recursive AI.

Setup and Usage

	1.	Clone the Repository

git clone https://github.com/yourusername/tic-tac-toe-game.git
cd tic-tac-toe-game


	2.	Compile the Java Files

javac *.java


	3.	Run the Game

java Play [size] [length to win] [max levels]

Example:

java Play 3 3 5

This command will start a Tic-Tac-Toe game with a 3x3 board, where a sequence of 3 tiles is needed to win, and the game tree will explore up to 5 levels.

How the AI Works

The computer AI examines all possible moves on the board and evaluates them using a recursive algorithm. It builds a game tree to explore all configurations and assigns one of four possible scores:

	•	HUMAN WINS = 0
	•	UNDECIDED = 1
	•	DRAW = 2
	•	COMPUTER WINS = 3

To speed up the decision process, the AI uses a HashDictionary that stores previously evaluated configurations. When a configuration is encountered again, its score is retrieved from the dictionary, reducing computation time.

Testing

	•	TestDict: This test ensures the correct functionality of the HashDictionary by simulating various insertions and lookups.
	•	TestPlay: Tests the game logic and AI move selection process. Make sure to test thoroughly for edge cases (e.g., nearly full boards).

Notes

	•	The program does not use Java’s built-in Hashtable, HashMap, or HashSet. Instead, a custom HashDictionary is implemented.
	•	All public methods specified in the project are implemented.
	•	You can adjust the size of the hash table used in the HashDictionary by modifying the prime number used in its initialization.

License

This project is licensed under the MIT License. See the LICENSE file for details.
