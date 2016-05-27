package trialjava;


import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.IntegerExpression;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sandhu on 22-05-2016.
 */
public class absolutePermutations {
    /*
    private static Boolean calPerm(int n, int k) {
        int temp[] = new int[n + 1];
        for (int i = 1; i < temp.length; i++) {
            temp[i] = i;
        }
       if (absDifference(temp, k)) {
            printArray(temp);
        } else {
            while (findNextPer(temp)) {
                if (absDifference(temp, k)) {
                    printArray(temp);
                    return null;
                }
                //System.out.println();
            }
            System.out.print("-1");
        }
        return null;
    }

    private static Boolean findNextPer(int[] temp) {
        int i = temp.length - 1;
        while (i > 1) {
            if (temp[i] > temp[i - 1]) {
                int swap = temp[i - 1];
                temp[i - 1] = temp[i];
                temp[i] = swap;
                int[] sortArray = new int[temp.length - i];
                int k = i;
                int j;
                for (j = 0; j < sortArray.length || k < temp.length; j++, k++) {
                    sortArray[j] = temp[k];
                }
                Arrays.sort(sortArray);
                k = i;
                j = 0;
                while (j < sortArray.length && k < temp.length) {
                    temp[k] = sortArray[j];
                    k++;
                    j++;
                }
                // printArray(temp);
                return true;
            }
            i--;
        }
        return false;
    }

    private static void printArray(int[] temp) {
        for (int i = 1; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
*/
    private static Boolean absDifference(char[] temp, int k) {
        for (int i = 0; i < temp.length; i++) {
            if (Math.abs(Integer.valueOf(String.valueOf(temp[i])) - (i + 1)) != k) {
                return false;
            }
        }
        return true;
    }

    private static Boolean calPerm2(int n, int k) {
        String temp = "0";
        for (int i = 1; i <= n; i++) {
            temp = temp + i;
        }
        int p = Integer.valueOf(temp);
        Boolean isIt = false;
        while (String.valueOf(p).toCharArray().length <= n) {
            isIt = absDifference(String.valueOf(p).toCharArray(), k);

            if (isIt) {
                char[] c = String.valueOf(p).toCharArray();
                int i = 0;
                while (i < c.length) {
                    System.out.print(c[i] + " ");
                    i++;
                }
                break;
            }
            p = p + 9;
            while (!containsN(String.valueOf(p).toCharArray(), n)) {
                p = p + 9;
            }
        }
        if (!isIt) {
            System.out.print("-1");
        }
        return null;
    }

    private static Boolean containsN(char[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (Integer.valueOf(String.valueOf(a[i])) > n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        int[] n = new int[t];
        int[] k = new int[t];
        int i = 0;
        while (i < t) {
            n[i] = in.nextInt();
            k[i] = in.nextInt();
            i++;
        }
        i = 0;
        while (t > 0) {
            calPerm2(n[i], k[i]);
            System.out.println();
            i++;
            t--;
        }
    }
}
