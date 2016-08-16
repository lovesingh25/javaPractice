package trialjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by losandhu on 09-Aug-16.
 */
public class totalDecodingMessages {
    public static void main(String[] args) {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int t = 0, n = 0, i = 0, count, k, temp;
        String d = "";
        try {
            t = Integer.parseInt(b.readLine().trim());
        } catch (Exception e) {
        }
        while (i < t) {
            try {
                n = Integer.parseInt(b.readLine().trim());
                d = b.readLine();
            } catch (Exception e) {
            }
            count = 1;
            if (d.contains("0"))
                count = 0;

            System.out.println(count);
            i++;
        }
    }
}
