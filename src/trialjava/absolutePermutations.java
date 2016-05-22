package trialjava;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sandhu on 22-05-2016.
 */
public class absolutePermutations {
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

    private static Boolean absDifference(int[] temp, int k) {
        for (int i = 1; i < temp.length; i++) {
            if (Math.abs(temp[i] - i) != k) {
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
            calPerm(n[i], k[i]);
            System.out.println();
            i++;
            t--;
        }
    }
}
