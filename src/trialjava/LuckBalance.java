package trialjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by losandhu on 27-Jun-16.
 */
public class LuckBalance {
    public static void main(String[] arg) {
        LuckBalance d = new LuckBalance();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(),
                k = s.nextInt(),
                i = 0,
                total = 0;
        LuckBalance.Game[] z = new LuckBalance.Game[n];
        while (i < n) {
            z[i] = d.new Game();
            z[i].Luck = s.nextInt();
            z[i].imp = s.nextInt();
            i++;
        }
        Arrays.sort(z);
        for (LuckBalance.Game j : z) {
            if (j.imp == 0 || k > 0) {
                total += j.Luck;
                if (j.imp == 1)
                    k--;
            } else {
                total -= j.Luck;
            }
        }
        System.out.println(total);
    }

    class Game implements Comparable<LuckBalance.Game> {
        int Luck;
        int imp;

        public int compareTo(LuckBalance.Game k) {
            if (k.Luck > Luck)
                return 1;
            else
                return -1;
        }
    }
}
