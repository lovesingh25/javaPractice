package trialjava;

import java.util.Scanner;

/**
 * Created by losandhu on 28-May-16.
 */
public class sumMaxSubArray {

    private static int nonConsum(int[] a) {
        int sum = 0;
        int negSum = Integer.MIN_VALUE;
        Boolean hasPositive = false;
        for (int i : a) {
            if (i >= 0) {
                sum += i;
                hasPositive = true;
            } else if (!hasPositive && negSum < i) {
                negSum = i;
            }
        }
        if (hasPositive) {
            return sum;
        } else {
            return negSum;
        }
    }

    private static int Consum(int[] a) {
        int sum = a[0];
        int[] temp = new int[a.length];
        temp[0] = a[0];
        int k;
        for (int i = 1; i < a.length; i++) {
            k = temp[i - 1] + a[i];
            temp[i] = (k > a[i]) ? k : a[i];
            if (sum < temp[i]) {
                sum = temp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[][] a = new int[t][];
        int i = 0;
        int n;
        int j;
        while (i < t && s.hasNext()) {
            n = s.nextInt();
            a[i] = new int[n];
            j = 0;
            while (j < n && s.hasNext()) {
                a[i][j] = s.nextInt();
                j++;
            }
            i++;
        }
        i = 0;
        while (i < t) {
            System.out.println(Consum(a[i]) + " " + nonConsum(a[i]));
            i++;
        }
    }
}
