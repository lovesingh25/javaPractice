package trialjava;

/**
 * Created by Sandhu on 28-Apr-16.
 */
public class fibonacciSeries {
    public static void main(String[] args) {
        printFibonacci(20);
    }

    public static void printFibonacci(int n) {
        int i = 0, j = 1, sum = 0;
        if (n > 0) {
            System.out.println(i);
        }
        if (n > 1) {
            System.out.println(j);
        }
        if (n > 2) {
            for (int k = 0; k < n - 2; k++) {
                sum = i + j;
                System.out.println(sum);
                i = j;
                j = sum;
            }
        }
    }
}
