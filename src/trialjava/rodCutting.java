package trialjava;

public class rodCutting {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] l = {1, 2, 3, 4};
        int[] p = {2, 5, 7, 8};
        int[][] cost = new int[p.length][l.length + 1];
        for (int i = 1; i < p.length; i++) {
            for (int j = 1; j <= l.length; j++) {
                if (i == 1 && j == 1) {
                    cost[i][j] = p[i - 1];
                } else {
                    if (j - i >= 0) {
                        cost[i][j] = ((cost[i - 1][j]) > (p[i - 1] + cost[i][j - i])) ? cost[i - 1][j] : (p[i - 1] + cost[i][j - i]);
                    } else {
                        cost[i][j] = cost[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i <= p.length; i++) {
            for (int j = 0; j <= l.length; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }

}
