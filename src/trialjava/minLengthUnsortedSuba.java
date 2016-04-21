package trialjava;

import java.util.Arrays;

/**
 * Created by Sandhu on 21-Apr-16.
 */
public class minLengthUnsortedSuba {
    public static void main(String[] arg) {
        int[] a = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        heapSort hs = new heapSort();
        hs.sort(temp);
        int start = -1, end = -1;
        for (int i = 0; i < temp.length; i++) {
            if (a[i] != temp[i]) {
                start = i;
                break;
            }
        }
        if (start != -1) {
            for (int i = start + 1; i < temp.length; i++) {
                if (a[i] != temp[i]) {
                    end = i;
                }
            }
        }
        System.out.print(start + " " + end);
    }
}
