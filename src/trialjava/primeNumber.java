package trialjava;

import java.io.InputStreamReader;
import java.io.BufferedReader;

class primeNumber {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1, i = 0;
        int[] n = null, m = null;
        try {
            t = Integer.parseInt(br.readLine());
            n = new int[t];
            m = new int[t];
            i = 0;
            while (i < t) {
                String[] intValues = br.readLine().split(" ");
                m[i] = Integer.parseInt(intValues[0]);
                n[i] = Integer.parseInt(intValues[1]);
                i++;
            }
        } catch (Exception e) {

        }
        i = 0;
        while (i < t) {
            printPrimNumbers(m[i], n[i]);
            i++;
            System.out.println();
        }
    }

    private static Boolean isoddCheck(int n) {
        if ((n & 1) == 1) {
            return true;
        }
        return false;
    }

    private static void printPrimNumbers(int m, int n) {
        Boolean isPrime;
        if (m == 1 || m == 2) {
            System.out.println(2);
            m = 3;
        } else if (!isoddCheck(m)) {
            m++;
        }
        for (int i = m; i <= n; i = i + 2) {
            isPrime = true;
            for (int j = 3; j * j <= i; j = j + 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;

                }
                }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}

