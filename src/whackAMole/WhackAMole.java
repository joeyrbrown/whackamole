package whackAMole;

import java.util.Scanner;

public class WhackAMole {
	// Instances variables for WhackAMole class
	int score;
	int molesLeft;
	static int attemptsLeft;
	static char moleGrid[][];
	
	// Constructor for the WhackAMole class
	WhackAMole(int numAttempts, int gridDimension) {
		int whacksAllowed;
		whacksAllowed = numAttempts;
		score = 0;
		// molesLeft = 10;
		attemptsLeft = whacksAllowed;
		
//		// Print out to confirm passed parameters.
//		System.out.println("You have " + whacksAllowed + " attempts to find 10 moles.");

		// Initialize the moleGrid.
		moleGrid = new char[gridDimension][gridDimension];	
		
		// Build initial moleGrid and print visual to the console.
		for (int row = 0; row < moleGrid.length; row++) {
			for (int col = 0; col < moleGrid[row].length; col++) {
				
				moleGrid[row][col] = '*';
			}
		}
	}
		
	// Methods for class WhackAMole
	boolean place (int x, int y) {
		int row = x;
		int col = y;
		moleGrid[row][col] = 'M';
		molesLeft++;

		if (moleGrid[row][col] == 'M') {
			// System.out.println("You have successfully placed a mole at coordinates.");
			return true;
		} else {
			// System.out.println("Error: A mole was NOT placed at the coordinates.");
			return false;

		}
		
	}
	
	void whack (int x, int y) {
		// Set coordinate grid variables.
		int row = x;
		int col = y;
		
		// Check the value of the moleGrid coordinates and update score, number of attemptsLeft, and
		// molesLeft to find.
		if (moleGrid[row][col] == 'M') {
			// Moles was found so mark location as Whacked.
			moleGrid[row][col] = 'W';
			
			// Increase the users score by an increment of one.
			score++;
			
			// Reduce the molesLeft to find by an increment of one.
			molesLeft--;
			
			// Reduce the number of attempts left to find moles by one.
			attemptsLeft--;
			
			// Post feedback to the user on successfully finding mole and inform them of the score and 
			// the number of attempts left.
			System.out.println("Success, you found a mole. Your updated score is: " + score + ". "
					+ "You have " + attemptsLeft + " attempts left to find " + molesLeft + " moles.");
			
		} else if (moleGrid[row][col] == 'W') {
			// Post feedback to the user that a mole was already found at this location and inform 
			// them of the number of attempts left.
			System.out.println("A mole was already found at this location.");
			attemptsLeft--;
			// Print Attempts left to the console.
			System.out.println("You have " + attemptsLeft + " attempts left to find " + molesLeft + 
					" moles.");
			
		
		} else {
			// Post feedback to the user that NO mole was found at this location and inform 
			// them of the number of attempts left.
			System.out.println("Sorry, NO mole was found at this location.");
			
			// Reduce the number of attempts left to find moles by one.
			attemptsLeft--;
			
			// Print Attempts left to the console.
			System.out.println("You have " + attemptsLeft + " attempts left to find " + molesLeft + 
					" moles.");

		}
	}
		
		
	
	void printGridToUser() {
		// Print moleGrid to user in the the console.
		System.out.println();
		for (int row = 0; row < moleGrid.length; row++) {
			for (int col = 0; col < moleGrid[row].length; col++) {
				System.out.print(moleGrid[row][col] + "\t");
			}
			System.out.println();
		}
	}
	
	void printGrid() {
		// Print moleGrid to user in the the console.
		System.out.println();
		for (int row = 0; row < moleGrid.length; row++) {
			for (int col = 0; col < moleGrid[row].length; col++) {
				System.out.print(moleGrid[row][col] + "\t");
			}
			System.out.println();
		}
	}

	
	// Main method
	public static void main(String[] args) {
		
		
		WhackAMole myGame = new WhackAMole(50,10);
		
		// Randomly place 10 moles in the moleGrid
		int[] x_coor = new int[10];
		int[] y_coor = new int[10];
		
		// Using the Math.random method create x and y coordinates for the mole location array. 
		for (int i = 0; i < 10; i++) {
			x_coor[i] = (int)(Math.random() * 9 + 1);
			y_coor[i] = (int)(Math.random() * 9 + 1);
			myGame.place(x_coor[i], y_coor[i]);
		}
		// Print Grid for verification of moles.
		myGame.printGridToUser();
		
		// Request user input using Scanner
		System.out.println("Welcome to the Whack-A-Mole game!");
		System.out.println();
		System.out.println("To play this game you will be given 50 Whacks attempts to find 10 moles within a 10 x 10 grid.");
		System.out.println();
		System.out.println("Let's begin by entering your first Whack coordinates for where you think a mole is placed.");

		
		while ((attemptsLeft > 0)) {
			System.out.println();
			System.out.println("Enter a numeric value 0-9 as x,y coordinates attempt a Whack (e.g. 2,9):");
			
			// Declare the object and initialize
			Scanner coordinates = new Scanner(System.in);
		
			// TBD
			int x_input = coordinates.nextInt();
			int y_input = coordinates.nextInt();
			
			System.out.println();
			System.out.println("You entered " + x_input + "," + y_input + ".");
			
			myGame.whack(x_input, y_input);
		}
		
	}

}
