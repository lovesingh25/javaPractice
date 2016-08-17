package trialjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by losandhu on 09-Aug-16.
 */
public class kSmallestElement {
    public static void main(String[] args) {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int t = 0, n, i = 0, j, k;
        int[] d;
        try {
            t = Integer.parseInt(b.readLine().trim());
        } catch (Exception e) {
        }
        while (i < t) {
            j = 0;
            try {
                n = Integer.parseInt(b.readLine().trim());
                d = new int[n];
                for (String a : b.readLine().split(" ")) {
                    d[j] = Integer.parseInt(a.trim());
                    j++;
                }
                k = Integer.parseInt(b.readLine().trim());
                sort(d);
                System.out.println(d[k - 1]);
            } catch (Exception e) {
            }
            i++;
        }
    }

    public static void sort(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

    private static void countSort(int[] a, int exp) {
        int[] count = new int[10];
        int[] temp = new int[a.length];
        Arrays.fill(count, 0);
        for (int i = 0; i < a.length; i++) {
            count[(a[i] / exp) % 10] += 1;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            temp[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10] -= 1;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = temp[i];
        }
    }
}
