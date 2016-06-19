package trialjava;

import java.util.Scanner;

/**
 * Created by losandhu on 19-Jun-16.
 */
public class CavityMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String grid[] = new String[n];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            grid[grid_i] = in.next();
        }
        for (int i = 1; i < grid.length - 1; i++)
            grid[i] = findCavity(i, grid);
        for (String a : grid) {
            System.out.println(a);
        }
    }

    private static String findCavity(int i, String[] a) {
        char[] c1, c2, c3;
        c1 = a[i - 1].toCharArray();
        c2 = a[i].toCharArray();
        c3 = a[i + 1].toCharArray();
        for (int z = 1; z < a[i].length() - 1; z++) {
            if (c1[z] < c2[z] &&
                    c2[z - 1] < c2[z] &&
                    c2[z + 1] < c2[z] &&
                    c3[z] < c2[z]) {
                c2[z] = 'X';
            }
        }
        String t = new String(c2);
        return t;
    }
}
