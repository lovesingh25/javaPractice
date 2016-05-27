package trialjava;

public class longestIncreasingSubsequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = a.length;
        int[] b = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                b[i] = 1;
            } else {
                if (a[i] <= a[i + 1]) {
                    b[i] = 1 + b[i + 1];
                } else {
                    int j = i + 2;
                    while (j < n) {
                        if (a[i] < a[j]) {
                            break;
                        }
                        j++;
                    }
                    if (j < n && a[i] < a[j]) {
                        b[i] = 1 + b[j];
                    } else {
                        b[i] = 1;
                    }
                }
            }
        }
        int k = 0;
        while (k < n) {
            System.out.print(" " + b[k]);
            k++;
        }

    }

}
