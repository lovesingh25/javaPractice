package trialjava;

public class primeNumber {
    public static void main(String[] args) {
        printPrimNumbers(2);
    }

    public static void printPrimNumbers(int n) {
        Boolean isPrime;
        for (int i = 2; i <= n; i++) {
            isPrime = true;
            for (int j = 2; j <= java.lang.Math.sqrt(i); j++) {
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

