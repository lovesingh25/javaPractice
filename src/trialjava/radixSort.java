package trialjava;

import java.util.Arrays;

/**
 * Created by Sandhu on 21-Apr-16.
 */
public class radixSort {
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

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] arg) {
        int[] a = {56, 4, 7, 8, 92, 1, 88, 762, 982, 1000, 111111};
        sort(a);
        printArray(a);
    }
}
