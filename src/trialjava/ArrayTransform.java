package trialjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by losandhu on 14-Jun-16.
 */
class ArrayTransform {
    public static void main(String[] arg) {
        ArrayTransform at = new ArrayTransform();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        int[][] n = null;
        int[] k = null;
        try {
            t = Integer.parseInt(br.readLine());
            n = new int[t][];
            k = new int[t];
        } catch (Exception e) {

        }
        int i = 0, j = 0;
        while (i < t) {
            try {
                String[] tempIn = br.readLine().split(" ");
                n[i] = new int[Integer.parseInt(tempIn[0].trim())];
                k[i] = Integer.parseInt(tempIn[1].trim());
                j = 0;
                for (String s : br.readLine().split(" ")) {
                    n[i][j] = Integer.parseInt(s.trim());
                    j++;
                }
            } catch (Exception e) {
            }
            i++;
        }
        i = 0;
        while (i < t) {
            if (!at.checkEqual(n[i])) {
                if (at.checkConsistant(n[i], k[i])) {
                    System.out.println("YES");
                } else
                    System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            i++;
        }
    }

    private Boolean checkConsistant(int[] n, int k) {
        HashMap h = new HashMap();
        for (int a : n) {
            if (h.size() == 3) {
                return false;
            }
            int temp = a % (k + 1);
            if (!h.containsKey(temp))
                h.put(temp, 1);
            else {
                int z = (int) h.get(temp);
                h.put(temp, ++z);
            }
        }
        if (h.containsValue(n.length - 1) || h.containsValue(n.length)) {
            return true;
        }
        return false;
    }

    private Boolean checkEqual(int[] n) {
        HashMap h = new HashMap();
        for (int a : n) {
            if (h.size() == 3) {
                return false;
            }
            if (!h.containsKey(a))
                h.put(a, 1);
            else {
                int temp = (int) h.get(a);
                h.put(a, ++temp);
            }
        }
        if (h.containsValue(n.length - 1) || h.containsValue(n.length)) {
            return true;
        }
        return false;
    }
}
