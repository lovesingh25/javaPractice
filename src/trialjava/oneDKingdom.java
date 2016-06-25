package trialjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by losandhu on 24-Jun-16.
 */
class oneDKingdom {
    public static void main(String[] arg) {
        oneDKingdom d = new oneDKingdom();
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(), n;
        kingdom[] z;
        int i = 0, j, count = 1, k;
        while (i < t) {
            n = s.nextInt();
            z = new kingdom[n];
            j = 0;
            while (j < n) {
                z[j] = d.new kingdom();
                z[j].start = s.nextInt();
                ;
                z[j].end = s.nextInt();
                ;
                j++;
            }
            Arrays.sort(z);
            k = z[0].end;
            for (j = 1; j < n; j++) {
                if (k < z[j].start) {
                    count++;
                    k = z[j].end;
                } else {
                    k = z[j].end < k ? z[j].end : k;
                }
            }
            System.out.println(count);
            i++;
        }
    }

    class kingdom implements Comparable<kingdom> {
        int start;
        int end;

        public int compareTo(kingdom k) {
            if (k.start < start)
                return 1;
            if (k.start > start)
                return -1;
            if (k.end > end)
                return -1;
            else
                return 1;
        }
    }
}
