package trialjava;

import java.util.Scanner;

/**
 * Created by losandhu on 07-Jun-16.
 */
public class MarkAndToys {

    private static void sortHeap(int[] p) {
        int n = p.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(p, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int swap = p[0];
            p[0] = p[i];
            p[i] = swap;
            heapify(p, i, 0);
        }
    }

    private static void heapify(int[] p, int n, int i) {
        int largest = i;
        int lchild = 2 * i + 1;
        int rchild = 2 * i + 2;
        if (lchild < n && p[largest] < p[lchild]) {
            largest = lchild;
        }
        if (rchild < n && p[largest] < p[rchild]) {
            largest = rchild;
        }
        if (i != largest) {
            int temp = p[i];
            p[i] = p[largest];
            p[largest] = temp;
            heapify(p, n, largest);
        }
    }

    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int i = 0;
        int[] p = new int[n];
        while (i < n) {
            p[i] = s.nextInt();
            i++;
        }
        sortHeap(p);
        int sum = 0;
        i = 0;
        for (i = 0; i < p.length; i++) {
            if (sum <= k)
                sum += p[i];
            else
                break;
        }
        System.out.println(i - 1);
    }
}
