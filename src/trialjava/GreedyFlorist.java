package trialjava;

import java.util.Scanner;

/**
 * Created by losandhu on 14-Jun-16.
 */
public class GreedyFlorist {
    public static void main(String args[]) {

// helpers for input/output

        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();

        int C[] = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = in.nextInt();
        }

        int result = calculateMin(K, C);
        System.out.println(result);

    }

    private static int calculateMin(int K, int[] c) {
        int n = c.length, result = 0;
        if (K == n) {
            for (int i = 0; i < n; i++) {
                result += c[i];
            }
        } else {
            int vl = n - 1, j = 0, count = 0;
            sort(c);
            for (int a : c) {
                //System.out.print(a+" ");
            }
            while (vl >= 0) {
                result += (1 + j) * c[vl];
                vl--;
                count++;
                if (count == K) {
                    j++;
                    count = 0;
                }
                System.out.println(result);
            }
        }
        return result;
    }

    private static void sort(int[] a) {
        int n = a.length;
        //create a heap.
        for (int i = (n / 2) - 1; i >= 0; i--)
            heapify(a, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int swap = a[0];
            a[0] = a[i];
            a[i] = swap;
            heapify(a, i, 0);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] > a[largest]) {
            largest = l;
        }
        if (r < n && a[r] > a[largest]) {
            largest = r;
        }
        if (i != largest) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            heapify(a, n, largest);
        }
    }
}
