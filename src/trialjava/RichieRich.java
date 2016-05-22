package trialjava;

import java.util.Scanner;

/**
 * Created by Sandhu on 22-05-2016.
 */
public class RichieRich {
    private static Boolean checkEven(int c) {
        return (c & 1) != 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        char[] a = number.toCharArray();
        int i, j;
        if (a.length > 1) {
            if (checkEven(a.length)) {
                i = (a.length / 2) - 1;
                j = i + 1;
            } else {
                i = (a.length / 2) - 1;
                j = i + 2;
            }
            while (i > 0 && j < a.length - 1 && k > 0) {
                if (a[i] != a[j]) {
                    a[i] = (a[j] > a[i]) ? a[j] : a[i];
                    a[j] = (a[j] > a[i]) ? a[j] : a[i];
                    k--;
                }
                i--;
                j++;
            }
            if (i >= 0 && j <= a.length - 1) {
                if (k == 1 && a[i] != a[j]) {
                    a[i] = (a[j] > a[i]) ? a[j] : a[i];
                    a[j] = (a[j] > a[i]) ? a[j] : a[i];
                    k--;
                    number = String.valueOf(a);
                    System.out.println(number);
                } else if (k == 0) {
                    if (a[i] == a[j]) {
                        number = String.valueOf(a);
                        System.out.println(number);
                    } else {
                        System.out.println("-1");
                    }
                }
                if (k > 0) {
                    i = 0;
                    j = a.length - 1;
                    while (k > 1 && (i >= 0 && j < a.length)) {
                        a[i] = '9';
                        a[j] = a[i];
                        i++;
                        j--;
                        k = k - 2;
                    }
                    number = String.valueOf(a);
                    System.out.println(number);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}
