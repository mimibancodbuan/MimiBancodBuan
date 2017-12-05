package towerOfHanoi;

public class Solution {
	
	public static void main(String[] args){
		int n = 5;
		String start = "A";
		String helper = "B";
		String end = "C";
		towerSolution(n, start, helper, end);
	}

	public static void towerSolution(int n, String start, String helper, String end){
		if(n == 1)
			System.out.println(start + " -> " + end);
		else if(n > 1) {
			// move everything above the bottom disc
			towerSolution(n-1, start, end, helper);
			System.out.println(start + " -> " + end);
			towerSolution(n-1, helper, start, end);
		}
	}
	
}
