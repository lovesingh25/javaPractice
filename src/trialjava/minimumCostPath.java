package trialjava;

/**
 * Created by Sandhu on 14-05-2016.
 */
public class minimumCostPath {
    public static void main(String[] arg) {
        int cost[][] = new int[][]{
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.println(calMinPath(cost));
    }

    private static int calMinPath(int[][] a) {
        int tempCost[][] = new int[a[0].length][a[0].length];
        //calculating first row
        tempCost[0][0] = a[0][0];
        for (int i = 1; i < a[0].length; i++) {
            tempCost[i][0] = tempCost[i - 1][0] + a[i][0];
        }
        for (int j = 1; j < a[0].length; j++) {
            tempCost[0][j] = tempCost[0][j - 1] + a[0][j];
        }
        for (int i = 1; i < a[0].length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                try {
                    tempCost[i][j] = a[i][j] + Integer.min(Integer.min(tempCost[i - 1][j], tempCost[i][j - 1]), tempCost[i - 1][j - 1]);
                } catch (Exception e) {
                    System.out.println("somethings wrong");
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(tempCost[i][j] + " ");
            }
            System.out.println();
        }
        return tempCost[a.length - 1][a.length - 1];
    }
}
