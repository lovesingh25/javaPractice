package trialjava;

/**
 * Created by Sandhu on 17-05-2016.
 */
public class matrixMultiplication {
    public static void main(String[] arg) {
        int[] p = {40, 20, 30, 10, 30};
        System.out.println(calOptimizedSolution(p));
    }

    private static int calOptimizedSolution(int[] p) {
        int[][] cost = new int[p.length][p.length];
        int j, k, q;
     /*   //one @ a time not needed in java as default value is zero
        for (int i = 1; i < p.length; i++) {
            cost[i][i] = 0;
        }
        */
        for (int l = 2; l < p.length; l++) {
            for (int i = 1; i <= p.length - l; i++) {
                j = i + l - 1;
                cost[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    q = cost[i][k] + cost[k + 1][j] + p[i - 1] * p[k] * p[j];
                    //  System.out.println(q);
                    if (q < cost[i][j])
                        cost[i][j] = q;
                }
            }
        }
        return cost[1][p.length - 1];
    }
}
