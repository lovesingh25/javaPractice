package trialjava;

/**
 * Created by losandhu on 20-Apr-16.
 */
public class quickSort {
    public static void doit(int s, int e, int[] arr) {
        //  int pivoit = e;
        int i = s - 1, j = s;
        while (j < e) {
            if (arr[j] < arr[e]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            } else {
                j++;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[e];
        arr[e] = temp;
        for (int k = 0; k < arr.length; k++)
            System.out.print(arr[k] + " ");
        System.out.println();
        if (i < e && i > s) {
            doit(i + 1, e, arr);
            doit(s, i - 1, arr);
        }
    }

    public static void main(String[] arg) {
        int[] arr = {9, 4, 3, 75, 7, 8, 5};
        doit(0, arr.length - 1, arr);
    }
}
