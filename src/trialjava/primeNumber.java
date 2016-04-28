package trialjava;

public class primeNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		          // Write your print statements here!! 
		          // Template: System.out.println("what you want to print");
		printPrimNumbers(100);
		   }

	public static void printPrimNumbers(int n) {
		Boolean isPrime;
		for (int i = 2; i <= n; i++) {
			isPrime = true;
			for (int j = 2; j < i / 2; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i);
			}
		}
	}
}

