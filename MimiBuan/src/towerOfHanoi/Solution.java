package towerOfHanoi;

public class Solution {
	
	private int n;
	private String start;
	private String helper;
	private String end;
	
	public Solution(){
		int n = 0;
		this.start = "";
		this.helper = "";
		this.end = "";
	}

	public void towerSolution(int n, String start, String helper, String end){
		if(n == 1)
			System.out.println(start + "->" + end);
		else if(n > 1) {
			towerSolution(n-1, start, end, helper);
			towerSolution(1, start, helper, end);
			towerSolution(n-1, helper, start, end);
		}
	}
	
}
