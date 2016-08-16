package trialjava;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by losandhu on 08-Aug-16.
 */
public class LongestPrefixSuffix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(), i = 0, k, count, start, z;
        char[] j;
        LinkedList<Integer> pos;
        while (i < t) {
            count = 0;
            start = 0;
            j = s.next().trim().toCharArray();
            pos = new LinkedList<Integer>();
            for (k = 1; k < j.length; k++) {
                if (j[0] == j[k]) {
                    pos.add(k);
                }
            }
            if (j.length == 1) {
                count = 1;
            }
            //System.out.println(pos.size());
            if (pos.size() > 0) {
                z = pos.poll();
                while (start < j.length && z < j.length) {
                    if (j[start] == j[z]) {
                        count++;
                        start++;
                        z++;
                    } else {
                        count = 0;
                        start = 0;
                        if (pos.size() > 0)
                            z = pos.poll();
                        else
                            break;
                    }
                }
            }
            System.out.println(count);
            i++;
        }

    }
}
