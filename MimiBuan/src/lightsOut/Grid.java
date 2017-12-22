package lightsOut;

public class Grid {
    
	private LOgrid [][] grid;
	
	public Grid() {
		LOgrid = new grid[5][5];
		for (int row=0;row<10;row++) {
			for (int col=0;col<10;col++) {
				MineField[row][col] = new JessiMines();
			}
		}
		createMines();
	}
}