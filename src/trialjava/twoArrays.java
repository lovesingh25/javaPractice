package trialjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by losandhu on 10-Jun-16.
 */
public class twoArrays {
    private static Boolean ansMe(int[] a, int[] b, int k) {
        sort(a);
        sort(b);
        int i = 0, j = a.length - 1;
        while (i < a.length && j >= 0) {
            if (a[i] + b[j] < k) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] n = new int[t];
        int[] k = new int[t];
        int[][] a = new int[t][];
        int[][] b = new int[t][];
        int i = 0;
        while (i < t) {
            n[i] = s.nextInt();
            k[i] = s.nextInt();
            int j = 0;
            a[i] = new int[n[i]];
            b[i] = new int[n[i]];
            while (j < n[i]) {
                a[i][j] = s.nextInt();
                j++;
            }
            j = 0;
            while (j < n[i]) {
                b[i][j] = s.nextInt();
                j++;
            }
            i++;
        }
        i = 0;
        while (i < t) {
            if (ansMe(a[i], b[i], k[i]))
                System.out.println("YES");
            else {
                System.out.println("NO");
            }
            i++;
        }

    }
}
