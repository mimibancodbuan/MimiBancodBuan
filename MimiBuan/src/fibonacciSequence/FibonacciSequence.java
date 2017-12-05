package fibonacciSequence;

public class FibonacciSequence {
	
	public int fibonacci(int n) {
		if(n == 0) {
			return 1;
		}
		else if(n > 0) {
			int num = fibonacci(n - 1) + fibonacci(n - 2);
			return num;
		}
	
	}
}
