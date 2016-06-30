package trialjava;

import java.util.*;

/**
 * Created by losandhu on 29-Jun-16.
 */
public class DemandingMoney {
    DemandingMoney.House[] h;

    public static void main(String[] arg) {
        DemandingMoney d = new DemandingMoney();
        Scanner s = new Scanner(System.in);
        LinkedList<HashSet> hash = null;
        HashSet adder;
        Boolean add = true, includeZero = false;
        int n = s.nextInt(),
                m = s.nextInt(),
                i = 0, j, temp1, temp2,
                tempsum, sum = -1, stop = 0;
        d.h = new House[n];
        while (i < n) {
            d.h[i] = d.new House(s.nextInt());
            i++;
        }
        i = 0;
        while (i < m) {
            temp1 = s.nextInt();
            temp2 = s.nextInt();
            d.h[temp1 - 1].addPath(temp1 - 1, temp2 - 1);
            i++;
        }
        i = 0;
        while (i < n) {
            adder = new HashSet();
            j = i;
            tempsum = 0;
            stop = 0;
            if (i != 0) {
                for (DemandingMoney.House z : d.h) {
                    z.eligible = false;
                }
            }
            while (stop < n) {
                if ((d.h[j].eligible == false && !includeZero) ||
                        (d.h[j].eligible == false && d.h[j].value != 0 && includeZero)) {
                    adder.add(j);
                    tempsum += d.h[j].value;
                    for (Object k : d.h[j].a) {
                        d.h[(int) k].
                                eligible = true;
                    }
                }
                stop++;
                j++;
                if (j > n - 1)
                    j = 0;
            }
            if (sum < tempsum) {
                hash = new LinkedList<HashSet>();
                hash.add(adder);
                sum = tempsum;
            } else if (tempsum == sum) {
                if (hash != null) {
                    for (HashSet temp : hash) {
                        if (temp.equals(adder))
                            add = false;
                    }
                    if (add) {
                        hash.add(adder);
                    }
                }
            }
            i++;
            if (i == n - 1 && !includeZero) {
                includeZero = true;
                i = 0;
            }
        }
        int count = sum == 0 ? hash.size() + 1 : hash.size();
        if (sum == 0) {
            for (DemandingMoney.House k : d.h) {
                count = k.value == 0 ? count + 1 : count;
            }
        }
        System.out.println(sum + " " + count);
    }

    class House {
        int value;
        Boolean eligible;
        LinkedList a = new LinkedList();

        House(int v) {
            this.value = v;
            this.eligible = false;
        }

        void addPath(int i, int j) {
            h[i].a.add(j);
            h[j].a.add(i);
        }
    }
}
