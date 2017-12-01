package search;

public class RecursionExercises {

	public static void main(String[] args){
		int value = 9;
		System.out.println(value+"! is equal to "+factorial(value));
		System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
	}

	public static int countPrimeFactors(int value, int testPrime) {
		int test = testPrime;
		if(value == 1) {
			return 0;
		}
		else if(value%test == 0) {
			return countPrimeFactors(value/test, test) + 1;
		}
		else {
			test++;
			return countPrimeFactors(value, test);
		}
	}

	public static int factorial(int value) {
		if(value == 1) {
			return 1;
		}
		else {
			return value*factorial(value - 1);
		}
	}

}
