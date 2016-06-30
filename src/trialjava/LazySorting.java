package trialjava;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by losandhu on 28-Jun-16.
 */
public class LazySorting {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        LazySorting l = new LazySorting();
        int n = s.nextInt(), i = 0, temp, count;
        long permutations = 1;
        int[] p = new int[n];
        HashMap h = new HashMap();
        DecimalFormat df = new DecimalFormat("#.000000");
        double sum = 0;
        while (i < n) {
            temp = s.nextInt();
            if (h.containsKey(temp)) {
                count = (int) h.get(temp);
                count++;
                h.put(temp, count);
            } else {
                h.put(temp, 1);
            }
            i++;
        }
        if (h.keySet().size() > 1) {
            for (Object a : h.values()) {
                permutations *= l.calFac((int) a);
            }
            sum = l.calFac(n) / permutations;
        }
        System.out.println(df.format(sum));
    }

    private long calFac(int n) {
        long fact = 1;
        while (n > 1) {
            fact *= n;
            n--;
        }
        return fact;
    }
}
