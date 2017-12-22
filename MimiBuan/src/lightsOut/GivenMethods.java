package lightsOut;

public class GivenMethods {
	
	private boolean[][] grid;

	public void switchRow(boolean[] row, int x) {
		row[x]=!row[x];
		if(x-1 >= 0)
			row[x-1] = !row[x-1];
		if(x+1 < row.length)
			row[x+1] = !row[x+1];
	}
	
	public void switchColumn(boolean[][] grid, int r, int c) {
		if(r-1 >= 0)
			grid[r-1][c] = !grid[r-1][c];
		if(r+1 < grid.length)
			grid[r+1][c] = !grid[r+1][c];
	}
	
	public void buttonClick(int r, int c) {
		switchRow(grid[r], c);
		switchColumn(grid, r, c);
		
		for(boolean[] arr: grid) {
			for(boolean b: arr) {
				if(b)
					return;
			}
		}
		
		System.out.println("You have solved the puzzzle!");
	}

}
