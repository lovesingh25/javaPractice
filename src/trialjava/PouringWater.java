package trialjava;

import java.util.Scanner;

/**
 * Created by losandhu on 05-Jul-16.
 */
class PouringWater {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(), a, b, c, swap, count;
        while (t > 0) {
            a = s.nextInt();
            b = s.nextInt();
            c = s.nextInt();
            if (a > b) {
                swap = a;
                a = b;
                b = swap;
            }
            if (c <= b && c >= 0) {
                if (c == 0) {
                    System.out.println(0);
                } else if (c == b || c == a) {
                    System.out.println(1);
                } else if (c % a == 0) {
                    System.out.println(2 * (c / a));
                } else {
                    count = 1;
                    while (b >= c) {
                        if (b - a == c) {
                            count++;
                            System.out.println(count);
                            break;
                        } else {
                            count += 2;
                            b -= a;
                        }
                        if (b < c) {
                            System.out.println(-1);
                        }
                    }
                }
            } else {
                System.out.println(-1);
            }
            t--;
        }
    }
}
