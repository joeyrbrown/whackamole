package whackAMole;

import java.util.Scanner;

public class WhackAMole {
	// Instances variables for WhackAMole class
	int score;
	int molesLeft;
	int attemptsLeft;
	static char moleGrid[][];
	
	// Constructor for the WhackAMole class
	WhackAMole(int numAttempts, int gridDimension) {
		int whacksAllowed;
		whacksAllowed = numAttempts;
		score = 0;
		// molesLeft = 10;
		attemptsLeft = whacksAllowed;
		
		// Print out to confirm passed parameters.
		System.out.println("You have " + whacksAllowed + " attempts to find 10 moles.");

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
			System.out.println("You have successfully placed a mole at coordinates.");
			return true;
		} else {
			System.out.println("Error: A mole was NOT placed at the coordinates.");
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
		
		
//		for ( int row = 0; row < moleGrid.length; row++) {
//			for (int col = 0; col < moleGrid[row].length; col++) {
//				moleGrid[row][col] = 'M';	
//			}
//		}
		
//		for (int row = 0; row < moleGrid.length; row++) {
//			for (int col = 0; col < moleGrid[row].length; col++) {
//				
//				moleGrid[row][col] = '*';
//				System.out.print(moleGrid[row][col] + "\t");
//			}
//			System.out.println();
//		}
	
	
	// Methods
	// public static void 
	
	
	public static void main(String[] args) {
		
		
		WhackAMole myGame = new WhackAMole(50,10);
		
		// Randomly place 10 moles in the moleGrid
		
		// Initialize an integer array for the random coordinates to be used for mole placement.
		int[][] moleLocation = new int[10][10];
		
		// Using the Math.random method create x and y coordinates for the mole location array. 
		int number = 1;
		int[] x_coor = new int[10];
		int[] y_coor = new int[10];
		
		for (int i = 0; i < 10; i++) {
			x_coor[i] = (int)(Math.random() * 9 + 1);
			y_coor[i] = (int)(Math.random() * 9 + 1);
			myGame.place(x_coor[i], y_coor[i]);
		}
		
		
		myGame.printGridToUser();
		System.out.println("Please enter a x and y coordinate at number 0-9:");
		Scanner inputFromUser = new Scanner(System.in);
		int input = inputFromUser.nextInt();
		
//		char[][] moleLocation = new char[10][10];
//		
//		// x Coordinates Randomization 
//		int[] x_coor = new int[10];
//		int[] y_coor = new int[10];
//		// Generates 10 Random Numbers in the range 1-10
//		for (int i = 0; i < x_coor.length; i++) {
//			x_coor[i] = (int)(Math.random()*10 + 1);
//			y_coor[i] = (int)(Math.random()*10 + 1);
//			moleLocation[x_coor[i]][y_coor[i]] = 'M';
//			System.out.println("You will have a " + moleLocation[x_coor[i]][y_coor[i]] + " at each of the following coordinates: " + x_coor[i] + ", " + y_coor[i]);
//		} // end for loop
//		System.out.println();	
		
		
	}

}
