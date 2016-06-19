package trialjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by losandhu on 19-Jun-16.
 */
class SerejaAndVotes {
    public static void main(String[] arg) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0, i = 0, sum, zeros, z;
        int[][] b = null;
        SerejaAndVotes sv = new SerejaAndVotes();
        try {
            t = Integer.parseInt(br.readLine().trim());
            b = new int[t][];
            int n, j;
            String[] temp;
            while (i < t) {
                n = Integer.parseInt(br.readLine().trim());
                b[i] = new int[n];
                j = 0;
                temp = br.readLine().trim().split(" ");
                while (j < n) {
                    b[i][j] = Integer.parseInt(temp[j]);
                    j++;
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error in input");
        }
        i = 0;
        while (i < t) {
            zeros = 0;
            sum = 0;
            for (int k : b[i]) {
                if (k != 0)
                    sum += k;
                else
                    zeros++;
            }
            z = b[i].length - zeros;
            if (sum >= 100 && (((sum - 100) / z) < 1))
                System.out.println("YES");
            else
                System.out.println("NO");
            i++;
        }
    }
}
