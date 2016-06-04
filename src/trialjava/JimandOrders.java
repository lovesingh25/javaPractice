package trialjava;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by losandhu on 03-Jun-16.
 */
public class JimandOrders {
    private static void modifiedMergeSort(int[] t, int s, int e) {
        int mid = (s + e) / 2;

        if (s < e) {
            modifiedMergeSort(t, s, mid);
            modifiedMergeSort(t, mid + 1, e);
            merge(t, s, mid, e);
        }
    }

    private static void merge(int[] t, int s, int mid, int e) {
        int n1 = mid - s + 1, n2 = e - mid;
        int[] t1 = new int[n1];
        int[] t2 = new int[n2];
        int k = s;
        for (int i = 0; i < n1; i++, k++) {
            t1[i] = t[k];
        }
        k = mid + 1;
        for (int i = 0; i < n2; i++, k++) {
            t2[i] = t[k];
        }
        int i = 0, j = 0;
        k = s;
        while (i < n1 && j < n2) {
            if (t1[i] <= t2[j]) {
                t[k] = t1[i];
                i++;
            } else {
                t[k] = t2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            t[k] = t1[i];
            i++;
            k++;
        }
        while (j < n2) {
            t[k] = t2[j];
            j++;
            k++;
        }
    }

    private static HashMap<Integer, LinkedList> makeHashMap(int[] t) {
        HashMap<Integer, LinkedList> h = new HashMap<Integer, LinkedList>();
        for (int i = 0; i < t.length; i++) {
            if (h.containsKey(t[i])) {
                LinkedList temp = h.get(t[i]);
                temp.addLast(i);
                h.put(t[i], temp);
            } else {
                LinkedList temp = new LinkedList();
                temp.addFirst(i);
                h.put(t[i], temp);
            }
        }
        return h;
    }

    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] t = new int[n];
        int i = 0;
        while (i < n) {
            t[i] = s.nextInt();
            int temp = s.nextInt();
            t[i] += temp;
            i++;
        }
        HashMap<Integer, LinkedList> h = makeHashMap(t);
        modifiedMergeSort(t, 0, n - 1);
        i = 0;
        while (i < n) {
            if (h.containsKey(t[i])) {
                LinkedList temp = h.get(t[i]);
                int a = (int) temp.poll();
                System.out.print(a + 1 + " ");
                h.put(t[i], temp);
            }
            i++;
        }

    }
}
