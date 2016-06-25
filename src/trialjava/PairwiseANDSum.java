package trialjava;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by losandhu on 20-Jun-16.
 */
class PairwiseANDSum {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a;
        HashMap h = new HashMap();
        int i = 0, temp, j, cal;
        long sum = 0;
        while (i < n) {
            temp = s.nextInt();
            if (h.containsKey(temp)) {
                j = (int) h.get(temp);
                h.put(temp, j + 1);
            } else
                h.put(temp, 1);
            i++;
        }
        i = 0;
        a = new int[h.keySet().size()];
        for (Object z : h.keySet()) {
            cal = (int) h.get(z);
            if (cal > 1)
                sum += ((cal * (cal - 1)) / 2) * (int) z;
            a[i] = (int) z;
            i++;
        }
        for (i = 0; i < a.length; i++) {
            for (j = i + 1; j < a.length; j++) {
                sum += (a[i] & a[j]);
            }
        }

        System.out.println(sum);
    }
}
