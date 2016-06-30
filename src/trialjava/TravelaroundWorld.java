package trialjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by losandhu on 27-Jun-16.
 */
public class TravelaroundWorld {
    public static void main(String[] arg) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TravelaroundWorld tw = new TravelaroundWorld();
        String[] temp;
        int n = 0, i = 0, j, count = 0, m;
        Boolean full;
        long c = 0, fuel;
        int[] a = null, b = null;
        try {
            temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0].trim());
            c = Long.parseLong(temp[1].trim());
            a = new int[n];
            b = new int[n];
            tw.getInput(a, br);
            tw.getInput(b, br);
        } catch (Exception e) {
        }
        while (i < n) {
            full = true;
            fuel = ((long) a[i] > c ? c : (long) a[i]);
            j = i;
            m = 0;
            while (m <= n) {
                //System.out.println("the number = "+j+" fuel value = "+fuel);
                if (fuel - b[j] >= 0) {
                    j++;
                    if (j > n - 1) {
                        j = 0;
                    }
                    fuel = (fuel - b[j] + a[j]) > c ? c : (fuel - b[j] + a[j]);
                } else {
                    full = false;
                    break;
                }
                m++;
            }
            if (full)
                count++;
            i++;
        }
        System.out.println(count);
    }

    private void getInput(int[] a, BufferedReader br) {
        int i = 0;
        String[] temp;
        try {
            temp = br.readLine().split(" ");
            for (String s : temp) {
                a[i] = Integer.parseInt(s.trim());
                i++;
            }
        } catch (Exception e) {

        }
    }
}
