package trialjava;

import java.util.Scanner;

/**
 * Created by losandhu on 11-Jun-16.
 */
class NextPalindrome {

    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int t = 0;
        if (s.hasNextInt())
            t = s.nextInt();
        int[] n = new int[t];
        int i = 0;
        while (i < t) {
            if (s.hasNextInt())
                n[i] = s.nextInt();
            i++;
        }
        i = 0;
        NextPalindrome ne = new NextPalindrome();
        while (i < t) {
            ne.findPali(n[i]);
            i++;
        }
    }

    private void findPali(int num) {
        num++;
        char[] c = String.valueOf(num).toCharArray();
        int last = c.length - 1;
        while (!isPallidrom(c)) {
            if (c[0] != c[last]) {
                num += 10 - java.lang.Math.abs(Integer.valueOf(c[0]) - Integer.valueOf(c[last]));
            } else
                num++;
            c = String.valueOf(num).toCharArray();
        }
        System.out.println(num);
    }

    private Boolean isPallidrom(char[] c) {
        int start = 0, end = c.length - 1;
        while (start < end) {
            if (c[start] != c[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
