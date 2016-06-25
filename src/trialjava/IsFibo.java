package trialjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by losandhu on 24-Jun-16.
 */
public class IsFibo {
    private static long h1 = 0;
    private static long h2 = 1;

    public static void main(String[] arg) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, i = 0, index;
        long temp;
        long[] k = null;
        Boolean[] ans = null;
        HashSet tempList;
        HashMap n = new HashMap();
        try {
            t = Integer.parseInt(br.readLine().trim());
            k = new long[t];
            ans = new Boolean[t];
            while (i < t) {
                temp = Long.parseLong(br.readLine().trim());
                k[i] = temp;
                if (n.containsKey(temp)) {
                    tempList = (HashSet) n.get(temp);
                    tempList.add(i);
                    n.put(temp, tempList);
                } else {
                    tempList = new HashSet();
                    tempList.add(i);
                    n.put(temp, tempList);
                }
                i++;
            }
        } catch (Exception e) {
        }
        i = 0;
        sort(k);
        Iterator it;
        while (i < k.length) {
            tempList = (HashSet) n.get(k[i]);
            it = tempList.iterator();
            if (it.hasNext()) {
                index = (int) it.next();
                tempList.remove(index);
                n.put(k[i], tempList);
                if (isFi(k[i])) {
                    ans[index] = true;
                } else {
                    ans[index] = false;
                }
            }
            i++;
        }
        for (Boolean b : ans) {
            if (b)
                System.out.println("IsFibo");
            else
                System.out.println("IsNotFibo");
        }
    }

    private static Boolean isFi(long a) {
        Boolean ansMe = false;
        long sum = h1 + h2;
        while (sum <= a) {
            if (sum == a) {
                ansMe = true;
                break;
            }
            h1 = h2;
            h2 = sum;
            sum = h1 + h2;
        }
        return ansMe;
    }

    private static void sort(long[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            long swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(long[] arr, int n, int i) {
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
            long swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            heapify(arr, n, largest);
        }
    }
}
