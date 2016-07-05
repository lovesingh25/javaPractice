package trialjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by losandhu on 03-Jul-16.
 */
class AndOperation {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), i = 0, temp, andproduct = Integer.MIN_VALUE;
        int[] a = new int[n];
        while (i < n) {
            temp = s.nextInt();
            a[i] = temp;
            i++;
        }
        Arrays.sort(a);
        for (i = n - 2; i >= 0; i--) {
            for (int j = i; j < n - 1; j++) {
                temp = (a[j] & a[j + 1]);
                if (temp > andproduct) {
                    andproduct = temp;
                }
                if (andproduct >= a[j]) {
                    i = -1;
                    break;
                }
            }
        }
        System.out.println(andproduct);
    }
}
