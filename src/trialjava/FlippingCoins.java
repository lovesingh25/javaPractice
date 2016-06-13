package trialjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by losandhu on 12-Jun-16.
 */
class FlippingCoins {
    public static void main(String[] arg) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] intp = null;
        try {
            intp = br.readLine().split(" ");
        } catch (Exception e) {
            System.out.println("Input is wrong for n and q");
        }
        int n = Integer.valueOf(intp[0]);
        int q = Integer.valueOf(intp[1]);
        int[] c = new int[q];
        int[] s = new int[q];
        int[] e = new int[q];
        Boolean[] b = new Boolean[n];
        Arrays.fill(b, false);
        int i = 0;
        intp = null;
        while (i < q) {
            try {
                intp = br.readLine().split(" ");
            } catch (Exception e1) {
                System.out.println("Input is wrong");
            }
            c[i] = Integer.valueOf(intp[0]);
            s[i] = Integer.valueOf(intp[1]);
            e[i] = Integer.valueOf(intp[2]);
            i++;
        }
        FlippingCoins f = new FlippingCoins();
        i = 0;
        while (i < q) {
            f.obeyCommad(c[i], s[i], e[i], b);
            i++;
        }
    }

    private void obeyCommad(int c, int s, int e, Boolean[] b) {
        if (c == 0) {
            flip(s, e, b);
        } else if (c == 1) {
            System.out.println(answerCall(s, e, b));
        }
    }

    private void flip(int s, int e, Boolean[] b) {
        for (int i = s; i <= e; i++) {
            if (!b[i])
                b[i] = true;
            else
                b[i] = false;
        }
    }

    private int answerCall(int s, int e, Boolean[] b) {
        int count = 0;
        for (int i = s; i <= e; i++) {
            if (b[i]) {
                count++;
            }
        }
        return count;
    }
}
