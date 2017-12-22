package lightsOut;

import java.util.Random;
import java.util.Scanner;

public class LightsOut {
	
	int[][] grid;
	
	public LightsOut(){
		grid = new int[5][5];
	}
	
	public static void main(String args[]) {
		LightsOut game = new LightsOut();
		game.setLights();
		System.out.println("Welcome to Lights Out!");
		game.display();
		System.out.println(" ");
		game.isWin();
	}
	
	public void display() {
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public void setLights() {
		Random randomNum = new Random();
		int numLights = grid.length*grid[0].length;
		int numTurnedOn = 1 + randomNum.nextInt(numLights);
		for (int i = 0; i < numTurnedOn; i++) { 
			int randRow = randomNum.nextInt(grid.length);
			int randCol = randomNum.nextInt(grid[0].length);
			grid[randRow][randCol] = 1;
		}
	}
	
	public void switchRow(int row, int col) {
		if(col-1 >= 0) {
			if (grid[row][col-1] == 1)
				grid[row][col-1] = 0;
			else if(grid[row][col-1] == 0)
				grid[row][col-1] = 1;
		}
		
		if(col+1 < grid[0].length) {
			if (grid[row][col+1] == 1)
				grid[row][col+1] = 0;
			else if(grid[row][col+1] == 0)
				grid[row][col+1] = 1;
		}
	}
	
	public void switchColumn(int row, int col) {
		if(row-1 >= 0) {
			if (grid[row-1][col] == 1)
				grid[row-1][col] = 0;
			else if(grid[row-1][col] == 0)
				grid[row-1][col] = 1;
		}
			
		if(row+1 < grid.length) {
			if (grid[row+1][col] == 1)
				grid[row+1][col] = 0;
			else if(grid[row+1][col] == 0)
				grid[row+1][col] = 1;
		}
	}
	
	public void switchIndex(int row, int col) {
		if (grid[row][col] == 1)
			grid[row][col] = 0;
		else if(grid[row][col] == 0)
			grid[row][col] = 1;
	}
	
	public void isWin() {
		boolean win = false;
		while(!win) {
			getUserInput();
			win = checkWin();
			System.out.println(" ");
			display();
		}
		System.out.println("You solved the puzzle!");
	}
	
	private boolean checkWin() {
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == 1)
					return false;
			}
		}
		return true;
	}

	public void getUserInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose a row!");

		int inputRow =0;

		boolean isValid = false;
		while(!isValid) {

			boolean isNumber;

			do {
				if(input.hasNextInt()) {
					inputRow = input.nextInt();
					isNumber = true;
				}else {
					System.out.println("Please enter valid input.");
					isNumber = false;
					input.next();
				}
			}while (!isNumber);
			if(inputRow < 0 || inputRow >= grid.length) {
				System.out.println("Please enter valid input.");
			}
			else {
				isValid = true;
			}

		}
		System.out.println("Choose a column!");
		int inputCol = 0;

		isValid = false;
		while(!isValid) {

			boolean isNumber;

			do {
				if(input.hasNextInt()) {
					inputCol = input.nextInt();
					isNumber = true;
				}else {
					System.out.println("Please enter valid input.");
					isNumber = false;
					input.next();
				}
			}while (!isNumber);
			if(inputCol < 0 || inputCol >= grid[0].length) {
				System.out.println("Please enter valid input.");
			}
			else {
				isValid = true;
			}

		}
		toggleCoordinate(inputRow, inputCol);
	}

	public void toggleCoordinate(int row, int col) {
		switchRow(row, col);
		switchColumn(row, col);
		switchIndex(row, col);
	}
	
}
